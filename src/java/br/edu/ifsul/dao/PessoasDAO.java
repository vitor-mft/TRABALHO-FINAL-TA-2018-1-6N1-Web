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

    public PessoasDAO() {
        super();
        classePersistente = Pessoas.class;
        ordem = "id";
    }

    public Pessoas getObjectById(Object id) throws Exception {
        Pessoas obj = em.find(Pessoas.class, id);
        /**
         * A linha obj.getPermissao().size(); é necessária para inicializar a
         * coleção para quando ela for exibida na tela não gerar um erro de
         * lazyInicializationException
         */
        obj.getTipo().size();
        return obj;
    }
}
