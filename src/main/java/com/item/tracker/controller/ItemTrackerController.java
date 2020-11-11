package com.item.tracker.controller;

import com.item.tracker.api.model.Item;
import com.item.tracker.api.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RestController
@Path("/item")
public class ItemTrackerController {

    @Autowired
    private ItemService itemService;


    @POST
    @Path("/updateItem")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createItemMessage(Item item) {
        boolean isProcessed = itemService.processItemRequest(item);

        if(isProcessed) {
            return Response.ok().build();
        } else
            return Response.serverError().build();
    }

    /**
     * Method returns all the items in database.
     * @return returns all items response.
     */
    @GET
    @Path("/getItem")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItems() {
        return Response.ok().status(200).entity(itemService.getItems()).build();
    }

    /**
     * Method returns all the items in database.
     * @return items response
     */
    @GET
    @Path("/getItem/{itemId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItems(@PathParam("itemId") String itemId) {
       return Response.ok().status(200).entity(itemService.getItem(itemId)).build();
    }
}
