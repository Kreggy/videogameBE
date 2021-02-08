package cz.educanet.videogame;

import javax.inject.Inject;
import javax.swing.*;
import javax.ws.rs.*;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("videogames")
@Produces(MediaType.APPLICATION_JSON)
public class VideogameResource {
    @Inject
    VideogameManager videogameManager;
    @GET
    public Response getVideogames(){
        return Response.ok(videogameManager.getVideogames()).build();
    }

    @GET
    @Path("{id}")
    public Response getOneVideogame(@PathParam("id") int id) {
        return Response.ok(videogameManager.getVideogameById(id)).build();
    }

    @POST
    public Response addVideogame(Videogame videogame){
        videogameManager.addVideogame(videogame);
        return Response.ok().build();
    }
    @PUT
    @Path("{id}")
    public Response editVideogame(@PathParam("id") int id, Videogame videogame) {
        if(videogameManager.editVideogame(id, videogame)) {
            return Response.ok().build();
        }
        else return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteVideogame(@PathParam("id") int id) {
        if(videogameManager.deleteVideogame(id)) {
            return Response.ok().build();
        }
        else return Response.status(Response.Status.BAD_REQUEST).build();
    }
}