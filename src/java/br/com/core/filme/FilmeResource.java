package br.com.core.filme;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;

@Path("movies")
public class FilmeResource {

  @Context
  private UriInfo context;

  @EJB
  private SessionFilme repositorioFilme;

  public FilmeResource() {
  }

  @GET
  @Produces("application/json")
  public List<Filme> getFilmes() {
    return repositorioFilme.findAll();
  }

  @GET
  @Path("/{codigo}")
  @Produces("application/json")
  public Filme getFilmePorId(@PathParam("codigo") String codigo) {
    return repositorioFilme.findById(codigo);
  }

  @GET
  @Path("/delete/{codigo}")
  @Produces("application/json")
  public void remover(@PathParam("codigo") String codigo) {
    repositorioFilme.remover(repositorioFilme.findById(codigo));
  }

  @POST
  @Path("/put")
  @Consumes("text/plain")
  @Produces("application/json")
  public void alterar(Filme filme) {
    repositorioFilme.alterar(filme);
  }
}
