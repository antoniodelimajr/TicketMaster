package br.com.core.sala;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "salaConverter")
public class SalaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null){
            return null;
        }        
        SalaMB bean = context.getApplication().evaluateExpressionGet(context, "#{salaMB}", SalaMB.class);
        Sala sala = bean.findSalaByNumero(value);
        return sala;
    }
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String string = null;
        if (value instanceof Sala){
            string = ((Sala) value).getNumero();
        }
        return string;
    }
}