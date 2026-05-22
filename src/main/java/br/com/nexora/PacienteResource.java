package br.com.nexora;

import br.com.nexora.bo.PacienteBo;
import br.com.nexora.entities.Paciente;
import br.com.nexora.excecoes.EntidadeNaoEncontradaException;
import br.com.nexora.excecoes.OperacaoNaoPermitidaException;
import br.com.nexora.excecoes.RegistroDuplicadoException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/paciente")
public class PacienteResource {
    private PacienteBo pacienteBo = new PacienteBo();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Paciente> selecionarRs() throws ClassNotFoundException, SQLException, SQLException {
        return  (ArrayList<Paciente>)  pacienteBo.selecionarBo();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Paciente buscarIdRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException, SQLException {
        return  (Paciente)  pacienteBo.buscarIdBo(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Paciente paciente, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException, RegistroDuplicadoException {
        pacienteBo.inserirBo(paciente);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(paciente.getId()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Paciente paciente, @PathParam("id") int id) throws ClassNotFoundException, SQLException, EntidadeNaoEncontradaException {
        pacienteBo.atualizarBo(paciente);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException, EntidadeNaoEncontradaException, OperacaoNaoPermitidaException {
        pacienteBo.deletarBo(id);
        return Response.ok().build();
    }
}
