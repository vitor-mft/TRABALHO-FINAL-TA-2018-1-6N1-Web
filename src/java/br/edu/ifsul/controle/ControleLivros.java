package br.edu.ifsul.controle;

import br.edu.ifsul.dao.AutoresDAO;
import br.edu.ifsul.dao.LivrosDAO;
import br.edu.ifsul.dao.PessoasDAO;
import br.edu.ifsul.modelo.Autores;
import br.edu.ifsul.modelo.Livros;
import br.edu.ifsul.modelo.Pessoas;
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
@Named(value = "controleLivros")
@ViewScoped
public class ControleLivros implements Serializable {

    @EJB
    private LivrosDAO<Livros> dao;
    private Livros objeto;
    private Boolean editando;

    @EJB
    private AutoresDAO<Autores> daoAutores;
    
    @EJB
    private PessoasDAO<Pessoas> daoPessoas;


    public ControleLivros() {
        editando = false;
    }

    public String listar() {
        editando = false;
        return "/privado/livros/listar?faces-redirect=true";
    }

    public void novo() {
        editando = true;
        objeto = new Livros();
        
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

    public LivrosDAO<Livros> getDao() {
        return dao;
    }

    public void setDao(LivrosDAO<Livros> dao) {
        this.dao = dao;
    }

    public Livros getObjeto() {
        return objeto;
    }

    public void setObjeto(Livros objeto) {
        this.objeto = objeto;
    }

    public Boolean getEditando() {
        return editando;
    }

    public void setEditando(Boolean editando) {
        this.editando = editando;
    }

    public AutoresDAO<Autores> getDaoAutores() {
        return daoAutores;
    }

    public void setDaoAutores(AutoresDAO<Autores> daoAutores) {
        this.daoAutores = daoAutores;
    }

    public PessoasDAO<Pessoas> getDaoPessoas() {
        return daoPessoas;
    }

    public void setDaoPessoas(PessoasDAO<Pessoas> daoPessoas) {
        this.daoPessoas = daoPessoas;
    }

 

  

}
