package br.com.nexora;

import br.com.nexora.bo.AgendamentoBo;
import br.com.nexora.entities.Agendamento;
import br.com.nexora.excecoes.EntidadeNaoEncontradaException;
import br.com.nexora.excecoes.OperacaoNaoPermitidaException;
import br.com.nexora.excecoes.RegraDeNegocioException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/agendamento")
public class AgendamentoResource {
    
    private AgendamentoBo agendamentoBo = new AgendamentoBo();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Agendamento> selecionarRs() throws ClassNotFoundException, SQLException, SQLException {
        return  (ArrayList<Agendamento>)  agendamentoBo.selecionarBo();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Agendamento buscarIdRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException, SQLException {
        return  (Agendamento)  agendamentoBo.buscarIdBo(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Agendamento agendamento, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException, RegraDeNegocioException {
        agendamentoBo.inserirBo(agendamento);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(agendamento.getId()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Agendamento agendamento, @PathParam("id") int id) throws ClassNotFoundException, SQLException, RegraDeNegocioException, EntidadeNaoEncontradaException {
        agendamentoBo.atualizarBo(agendamento);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException, EntidadeNaoEncontradaException, OperacaoNaoPermitidaException{
        agendamentoBo.deletarBo(id);
        return Response.ok().build();
    }
}
