package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Tipo;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
@Stateful
public class TipoDAO<TIPO> extends DAOGenerico<Tipo> implements Serializable {

    public TipoDAO(){
        super();
        classePersistente = Tipo.class;
        ordem = "titulo"; // define a ordem padrão do DAO
        maximoObjetos = 3;
    }
}
