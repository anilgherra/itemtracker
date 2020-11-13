package com.item.tracker.controller;

import com.item.tracker.api.entity.Item;
import com.item.tracker.api.model.ItemDto;
import com.item.tracker.api.service.ItemService;
import com.item.tracker.config.GenericExceptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RestController
@Path("/api/v1")
public class ItemTrackerController {

    @Autowired
    private ItemService itemService;

    /**
     * Request to create item records.
     */
    @POST
    @Path("/item")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    public Response createItem(ItemDto itemDto) {
        try {
            itemService.processItemRequest(itemDto);
            return Response.ok().build();
        } catch(Exception e) {
            return new GenericExceptionMapper().toResponse(e);
        }
    }

    /**
     * Request to get all items.
     */
    @GET
    @Path("/item")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    public Response getItems() {
        try{
            return Response.ok().status(200).entity(itemService.getItems()).build();
        } catch(Exception e) {
            return new GenericExceptionMapper().toResponse(e);
        }
    }

    /**
     * Request to get an item based on its id.
     */
    @GET
    @Path("/item/{itemId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    public Response getItem(@PathParam("itemId") long itemId) {
        Item item;
        try {
            item = itemService.getItem(itemId);
            if(item == null) {
                return Response.status(Response.Status.NOT_FOUND).entity("Unable to find an item resource with item id: " + itemId).build();
            }
        } catch(Exception e) {
            return new GenericExceptionMapper().toResponse(e);
        }
       return Response.ok().status(200).entity(item).build();
    }
}
