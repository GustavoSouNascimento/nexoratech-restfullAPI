package br.com.nexora;

import br.com.nexora.bo.TratamentoBo;
import br.com.nexora.entities.Tratamento;
import br.com.nexora.excecoes.EntidadeNaoEncontradaException;
import br.com.nexora.excecoes.OperacaoNaoPermitidaException;
import br.com.nexora.excecoes.RegraDeNegocioException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/tratamento")
public class TratamentoResource {
    
    private TratamentoBo tratamentoBo = new TratamentoBo();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Tratamento> selecionarRs() throws ClassNotFoundException, SQLException {
        return  (ArrayList<Tratamento>)  tratamentoBo.selecionarBo();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Tratamento buscarIdRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
        return  (Tratamento)  tratamentoBo.buscarIdBo(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Tratamento tratamento, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException, RegraDeNegocioException {
        tratamentoBo.inserirBo(tratamento);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(tratamento.getId()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Tratamento tratamento, @PathParam("id") int id) throws ClassNotFoundException, SQLException, RegraDeNegocioException {
        tratamentoBo.atualizarBo(tratamento);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException, EntidadeNaoEncontradaException, OperacaoNaoPermitidaException {
        tratamentoBo.deletarBo(id);
        return Response.ok().build();
    }
}
