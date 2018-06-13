package br.edu.ifsul.dao;


import br.edu.ifsul.modelo.Pessoas;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * 
 * @author V_M_FT
 * 
 */
@Stateful
public class PessoasDAO<TIPO> extends DAOGenerico<Pessoas> implements Serializable {
    
     public PessoasDAO(){
        super();
        classePersistente = Pessoas.class;
        ordem = "id";
    }
    
}
