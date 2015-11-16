package br.com.core.secao;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "secaoConverter")
public class SecaoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null){
            return null;
        }        
        SecaoMB bean = context.getApplication().evaluateExpressionGet(context, "#{secaoMB}", SecaoMB.class);
        Secao secao = bean.findSecaoByCodigo(value);
        return secao;
    }
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String string = null;
        if (value instanceof Secao){
            string = ((Secao) value).getCodigo();
        }
        return string;
    }
}