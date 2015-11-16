package br.com.core.filme;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "filmeConverter")
public class FilmeConverter implements Converter {

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String string = null;
        if (value instanceof Filme){
            string = ((Filme) value).getCodigo();
        }
        return string;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null){
            return null;
        }
        FilmeMB bean = context.getApplication().evaluateExpressionGet(context, "#{filmeMB}", FilmeMB.class);
        Filme filme = bean.findFilmeByCodigo(value);
        return filme;
    }
 
}