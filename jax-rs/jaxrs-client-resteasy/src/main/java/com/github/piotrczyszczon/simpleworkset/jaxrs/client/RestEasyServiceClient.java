package com.github.piotrczyszczon.simpleworkset.jaxrs.client;

import com.github.piotrczyszczon.simpleworkset.jaxrs.InformationService;
import com.github.piotrczyszczon.simpleworkset.jaxrs.path.ServicePathProvider;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;

import javax.ws.rs.core.UriBuilder;

public class RestEasyServiceClient
{
  public InformationService openService(ServicePathProvider servicePathProvider)
  {
    ResteasyClient client = new ResteasyClientBuilderImpl().build();

    ResteasyWebTarget target = client.target(UriBuilder.fromPath(servicePathProvider.getServicePath()));

    return target.proxy(InformationService.class);
  }
}
