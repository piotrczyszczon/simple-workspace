package com.github.piotrczyszczon.simpleworkset.jaxrs.client;

import com.github.piotrczyszczon.simpleworkset.jaxrs.InformationService;
import com.github.piotrczyszczon.simpleworkset.jaxrs.path.ServicePathProvider;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;

public class OpenFeignServiceClient
{
  private final ServicePathProvider servicePathProvider;

  public OpenFeignServiceClient(ServicePathProvider servicePathProvider)
  {
    this.servicePathProvider = servicePathProvider;
  }

  public InformationService openService()
  {
    return Feign.builder()
        .contract(new JAXRSContract())
        .encoder(new JacksonEncoder())
        .decoder(new JacksonDecoder())
        .target(InformationService.class, servicePathProvider.getServicePath());
  }
}
