
package br.edu.ifsul.converter;

import br.edu.ifsul.modelo.Pessoas;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author V_M_FT
 */
@FacesConverter (value = "converterPessoas")
public class ConverterPessoas implements Serializable, Converter{
    
    @PersistenceContext(unitName =  "TRABALHO-FINAL-TA-2018-1-6N1-WebPU")
    private EntityManager em;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
       if ( string == null || string.equals("Selecione um Registro")){
           return null;
       }
       return em.find(Pessoas.class,Integer.parseInt(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
    if(o == null){
        return null;
    } 
    Pessoas obj = (Pessoas) o;
    return obj.getId().toString();
    }
    
}

