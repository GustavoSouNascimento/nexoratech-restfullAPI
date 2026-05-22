package br.com.nexora;

import br.com.nexora.bo.TriagemBo;
import br.com.nexora.entities.Triagem;
import br.com.nexora.excecoes.EntidadeNaoEncontradaException;
import br.com.nexora.excecoes.OperacaoNaoPermitidaException;
import br.com.nexora.excecoes.RegraDeNegocioException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/triagem")
public class TriagemResource {
    private TriagemBo triagemBo = new TriagemBo();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Triagem> selecionarRs() throws ClassNotFoundException, SQLException, SQLException {
        return  (ArrayList<Triagem>)  triagemBo.selecionarBo();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Triagem buscarIdRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException, SQLException {
        return  (Triagem)  triagemBo.buscarIdBo(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Triagem triagem, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException, RegraDeNegocioException {
        triagemBo.inserirBo(triagem);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(triagem.getId()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Triagem triagem, @PathParam("id") int id) throws ClassNotFoundException, SQLException, RegraDeNegocioException {
        triagemBo.atualizarBo(triagem);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException, EntidadeNaoEncontradaException, OperacaoNaoPermitidaException{
        triagemBo.deletarBo(id);
        return Response.ok().build();
    }
}
