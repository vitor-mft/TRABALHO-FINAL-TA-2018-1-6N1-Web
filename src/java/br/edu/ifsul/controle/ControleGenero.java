package br.edu.ifsul.controle;

import br.edu.ifsul.dao.GeneroDAO;
import br.edu.ifsul.modelo.Genero;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;



/**
 *
 * @author V_M_FT
 */

@Named (value = "controleGenero")
@ViewScoped
public class ControleGenero implements Serializable{
    
     @EJB
    private GeneroDAO<Genero> dao;
    private Genero objeto;
    private Boolean editando;
    
     public ControleGenero(){
        editando = false;
    }
    
    public String listar(){
        editando = false;
        return "/privado/genero/listar?faces-redirect=true";
    }
    
    public void novo(){
        editando = true;
        objeto = new Genero();
    }
    
    public void alterar(Object id){
        try {
            objeto = dao.getObjectById(id);
            editando = true;
        } catch (Exception e){
            Util.mensagemErro("Erro ao recuperar objeto: " + 
                    Util.getMensagemErro(e));
        } 
    }
    
    public void excluir(Object id){
        try {
            objeto = dao.getObjectById(id);
            dao.remover(objeto);
            Util.mensagemInformacao("Genero removido com sucesso!");
        } catch (Exception e){
            Util.mensagemErro("Erro ao remover objeto: " + 
                    Util.getMensagemErro(e));
        }
    }
    
    public void salvar(){
        try {
            if (objeto.getId() == null){
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Genero persistido com sucesso!");
            editando = false;
        } catch(Exception e){
            Util.mensagemErro("Erro ao persistir objeto: " + 
                    Util.getMensagemErro(e));
        }
    }

    public GeneroDAO<Genero> getDao() {
        return dao;
    }

    public void setDao(GeneroDAO<Genero> dao) {
        this.dao = dao;
    }

    public Genero getObjeto() {
        return objeto;
    }

    public void setObjeto(Genero objeto) {
        this.objeto = objeto;
    }

    public Boolean getEditando() {
        return editando;
    }

    public void setEditando(Boolean editando) {
        this.editando = editando;
    }
    
    
}
