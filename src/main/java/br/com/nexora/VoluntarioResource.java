package br.com.nexora;

import br.com.nexora.bo.VoluntarioBo;
import br.com.nexora.entities.Voluntario;
import br.com.nexora.excecoes.EntidadeNaoEncontradaException;
import br.com.nexora.excecoes.RegistroDuplicadoException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/voluntario")
public class VoluntarioResource {
    
    private VoluntarioBo voluntarioBo = new VoluntarioBo();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Voluntario> selecionarRs() throws ClassNotFoundException, SQLException, SQLException {
        return  (ArrayList<Voluntario>)  voluntarioBo.selecionarBo();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Voluntario buscarIdRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException, SQLException {
        return  (Voluntario)  voluntarioBo.buscarIdBo(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Voluntario voluntario, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException, RegistroDuplicadoException {
        voluntarioBo.inserirBo(voluntario);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(voluntario.getId()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Voluntario voluntario, @PathParam("id") int id) throws ClassNotFoundException, SQLException {
        voluntarioBo.atualizarBo(voluntario);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException, EntidadeNaoEncontradaException{
        voluntarioBo.deletarBo(id);
        return Response.ok().build();
    }
}
