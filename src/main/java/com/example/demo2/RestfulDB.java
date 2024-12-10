package com.example.demo2;


import com.example.demo2.models.User;
import com.example.demo2.models.UserDAO;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestfulDB {

    @PersistenceContext
    private EntityManager em;

    @GET
    @Path("/{id}")
    public User getUser(@PathParam("id") int id){
        return em.find(User.class, id);
    }

    @GET
    public List<User> getUsers(){
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    @GET
    @Path("/searchName")
    public List<User> findSimilarName(@QueryParam("name") String name){
        return em.createQuery("SELECT u FROM User u WHERE u.name LIKE :name", User.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();
    }
    @GET
    @Path("/searchEmail")
    public List<User> findSimilarEmail(@QueryParam("email") String email){
        return em.createQuery("SELECT u FROM User u WHERE u.email LIKE :email", User.class)
                .setParameter("email", "%" + email + "%")
                .getResultList();
    }
    @Transactional
    @POST
    public Response createUser(User user){
        em.persist(user);
        return Response.status(Response.Status.CREATED).entity(user).build();
    }

    @Transactional
    @PUT
    @Path("/{id}")
    public Response updateUser(@PathParam("id") int id,User newUser){
        User user = em.find(User.class,id);
        user.setName(newUser.getName());
        user.setEmail(newUser.getEmail());
        user.setPasswd(newUser.getPasswd());
        em.merge(user);
        return Response.status(Response.Status.OK).entity(user).build();
    }
    @Transactional
    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") int id){
        User user = em.find(User.class, id);
        em.remove(user);
        return Response.status(Response.Status.OK).entity(user).build();
    }
}
