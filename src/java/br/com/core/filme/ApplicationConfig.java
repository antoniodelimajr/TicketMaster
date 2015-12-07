package br.com.core.filme;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author antoniojr
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

  @Override
  public Set<Class<?>> getClasses() {
    Set<Class<?>> resources = new java.util.HashSet<>();
    addRestResourceClasses(resources);
    return resources;
  }

  private void addRestResourceClasses(Set<Class<?>> resources) {
    resources.add(br.com.core.filme.FilmeResource.class);
  }
  
}
