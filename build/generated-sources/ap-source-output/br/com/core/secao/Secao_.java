package br.com.core.secao;

import br.com.core.filme.Filme;
import br.com.core.sala.Sala;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-16T00:12:40")
@StaticMetamodel(Secao.class)
public class Secao_ { 

    public static volatile SingularAttribute<Secao, String> codigo;
    public static volatile SingularAttribute<Secao, Date> horario;
    public static volatile SingularAttribute<Secao, Sala> sala;
    public static volatile SingularAttribute<Secao, Filme> filme;

}