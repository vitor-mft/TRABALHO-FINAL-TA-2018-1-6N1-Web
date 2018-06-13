package br.edu.ifsul.controle;

import br.edu.ifsul.dao.AutoresDAO;
import br.edu.ifsul.dao.GeneroDAO;
import br.edu.ifsul.modelo.Autores;
import br.edu.ifsul.modelo.Genero;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
@Named(value = "controleAutores")
@ViewScoped
public class ControleAutores implements Serializable {

    @EJB
    private AutoresDAO<Autores> dao;
    private Autores objeto;
    private Boolean editando;

    @EJB
    private GeneroDAO<Genero> daoGenero;


    public ControleAutores() {
        editando = false;
    }

    public String listar() {
        editando = false;
        return "/privado/autores/listar?faces-redirect=true";
    }

    public void novo() {
        editando = true;
        objeto = new Autores();
        
    }

    public void alterar(Object id) {
        try {
            objeto = dao.getObjectById(id);
            editando = true;
           
        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar objeto: "
                    + Util.getMensagemErro(e));
        }
    }

    public void excluir(Object id) {
        try {
            objeto = dao.getObjectById(id);
            dao.remover(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao remover objeto: "
                    + Util.getMensagemErro(e));
        }
    }

    public void salvar() {
        try {
            if (objeto.getId() == null) {
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
            editando = false;
        } catch (Exception e) {
            Util.mensagemErro("Erro ao persistir objeto: "
                    + Util.getMensagemErro(e));
        }
    }

    public AutoresDAO<Autores> getDao() {
        return dao;
    }

    public void setDao(AutoresDAO<Autores> dao) {
        this.dao = dao;
    }

    public Autores getObjeto() {
        return objeto;
    }

    public void setObjeto(Autores objeto) {
        this.objeto = objeto;
    }

    public Boolean getEditando() {
        return editando;
    }

    public void setEditando(Boolean editando) {
        this.editando = editando;
    }

    public GeneroDAO<Genero> getDaoGenero() {
        return daoGenero;
    }

    public void setDaoGenero(GeneroDAO<Genero> daoGenero) {
        this.daoGenero = daoGenero;
    }

  

}
