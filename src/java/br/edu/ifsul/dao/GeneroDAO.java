package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Genero;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * 
 * @author V_M_FT
 * 
 */
@Stateful
public class GeneroDAO<TIPO> extends DAOGenerico<Genero> implements Serializable {
    
     public GeneroDAO(){
        super();
        classePersistente = Genero.class;
        ordem = "nome";
    }
    
}
