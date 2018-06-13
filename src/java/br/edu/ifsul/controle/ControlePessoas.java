package br.edu.ifsul.controle;


import br.edu.ifsul.dao.PessoasDAO;
import br.edu.ifsul.modelo.Pessoas;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;



/**
 *
 * @author V_M_FT
 */

@Named (value = "controlePessoas")
@ViewScoped
public class ControlePessoas implements Serializable{
    
     @EJB
    private PessoasDAO<Pessoas> dao;
    private Pessoas objeto;
    private Boolean editando;
    
     public ControlePessoas(){
        editando = false;
    }
    
    public String listar(){
        editando = false;
        return "/privado/pessoas/listar?faces-redirect=true";
    }
    
    public void novo(){
        editando = true;
        objeto = new Pessoas();
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
            Util.mensagemInformacao("Pessoas removido com sucesso!");
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
            Util.mensagemInformacao("Pessoas persistido com sucesso!");
            editando = false;
        } catch(Exception e){
            Util.mensagemErro("Erro ao persistir objeto: " + 
                    Util.getMensagemErro(e));
        }
    }

    public PessoasDAO<Pessoas> getDao() {
        return dao;
    }

    public void setDao(PessoasDAO<Pessoas> dao) {
        this.dao = dao;
    }

    public Pessoas getObjeto() {
        return objeto;
    }

    public void setObjeto(Pessoas objeto) {
        this.objeto = objeto;
    }

    public Boolean getEditando() {
        return editando;
    }

    public void setEditando(Boolean editando) {
        this.editando = editando;
    }

    
    
}
