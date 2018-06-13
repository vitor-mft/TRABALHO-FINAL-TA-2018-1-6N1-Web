package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Autores;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * 
 * @author V_M_FT
 * 
 */
@Stateful
public class AutoresDAO<TIPO> extends DAOGenerico<Autores> implements Serializable {
    
     public AutoresDAO(){
        super();
        classePersistente = Autores.class;
        ordem = "nome";
    }
    
}
