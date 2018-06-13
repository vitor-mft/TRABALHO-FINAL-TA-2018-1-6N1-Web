package br.edu.ifsul.dao;


import br.edu.ifsul.modelo.Livros;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * 
 * @author V_M_FT
 * 
 */
@Stateful
public class LivrosDAO<TIPO> extends DAOGenerico<Livros> implements Serializable {
    
     public LivrosDAO(){
        super();
        classePersistente = Livros.class;
        ordem = "nome";
    }
    
}
