package com.item.tracker.config;


import com.item.tracker.controller.ItemTrackerController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("itemtracker")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(ItemTrackerController.class);
    }

}
