package com.item.tracker.controller;

import com.item.tracker.api.model.ItemMessage;
import com.item.tracker.api.service.ItemMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RestController
@Path("/item")
public class ItemTrackerController {

    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSomething() {
        return Response.ok("String").build();
    }

    @Autowired
    private Queue queue;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private ItemMessageService itemMessageService;

//    @GET
//    @Path("/message/{message}")
//    public Response publish(@PathParam("message") final String message) {
//
//        jmsTemplate.convertAndSend(queue, HttpStatus.OK);
//        return Response.status(Response.Status.OK).entity(message).build();
//    }

    @POST
    @Path("/updateItem")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createItemMessage(ItemMessage itemMessage) {
        boolean isProcessed = itemMessageService.processMessage(itemMessage);
        if(isProcessed) {
            return Response.ok().build();
        } else
            return Response.serverError().build();
    }
}
