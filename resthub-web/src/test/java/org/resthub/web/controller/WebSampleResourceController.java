package org.resthub.web.controller;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Path;

import org.resthub.web.model.WebSampleResource;
import org.resthub.web.service.WebSampleResourceService;

@Path("/resources")
@Named("webSampleResourceController")
public class WebSampleResourceController extends GenericResourceController<WebSampleResource, WebSampleResourceService> {
	
    @Inject
    @Named("webSampleResourceService")
    @Override
    public void setService(WebSampleResourceService service) {
        this.service = service;
    }
	
}
