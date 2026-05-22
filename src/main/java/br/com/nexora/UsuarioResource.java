package br.com.nexora;

import br.com.nexora.bo.UsuarioBo;
import br.com.nexora.entities.Usuario;
import br.com.nexora.excecoes.EntidadeNaoEncontradaException;
import br.com.nexora.excecoes.RegistroDuplicadoException;
import br.com.nexora.excecoes.RegraDeNegocioException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/usuario")
public class UsuarioResource {
    private UsuarioBo usuarioBo = new UsuarioBo();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Usuario> selecionarRs() throws ClassNotFoundException, SQLException, SQLException {
        return  (ArrayList<Usuario>)  usuarioBo.selecionarBo();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario buscarIdRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException, SQLException {
        return  (Usuario)  usuarioBo.buscarIdBo(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Usuario usuario, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException, RegraDeNegocioException, RegistroDuplicadoException {
        usuarioBo.inserirBo(usuario);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(usuario.getId()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Usuario usuario, @PathParam("id") int id) throws ClassNotFoundException, SQLException, RegraDeNegocioException, EntidadeNaoEncontradaException {
        usuarioBo.atualizarBo(usuario);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException, EntidadeNaoEncontradaException {
        usuarioBo.deletarBo(id);
        return Response.ok().build();
    }
}
