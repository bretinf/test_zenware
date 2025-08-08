package org.zenware;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Path("/productos")
public class ProductoResource {

    private Map<Long, Producto> productos = Collections.synchronizedMap(new LinkedHashMap<>());

    public ProductoResource() {
    }

    @GET
    public Collection<Producto> list() {
        return productos.values();
    }

    @GET
    @Path("/{id}")
    public Producto get(@PathParam("id") Long id) {
        Producto producto = productos.get(id);
        if (producto == null) {
            throw new NotFoundException(
                Response.status(Response.Status.NOT_FOUND)
                .entity("No encontrado")
                .type("application/json")
                .build()
            );
        }
        return producto;
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Producto> add(@Valid Producto producto) {
        productos.put(producto.id, producto);
        return productos.values();
    }

    @PUT
    @Path("/{id}")
    public Producto put(@PathParam("id") Long id,@Valid Producto producto) {
        if (!productos.containsKey(id)) {
            throw new NotFoundException(
                Response.status(Response.Status.NOT_FOUND)
                        .entity("No encontrado")
                        .type("application/json")
                .build()
            );
        }
        producto.id = id;
        productos.put(id, producto);
        return producto;
    }

    @DELETE
    public Collection<Producto> delete(Producto producto) {
        if (!productos.containsKey(producto.id)) {
            throw new NotFoundException(
                Response.status(Response.Status.NOT_FOUND)
                        .entity("No encontrado")
                        .type("application/json")
                .build()
            );
        }
        productos.remove(producto.id);
        return productos.values();
    }


}
