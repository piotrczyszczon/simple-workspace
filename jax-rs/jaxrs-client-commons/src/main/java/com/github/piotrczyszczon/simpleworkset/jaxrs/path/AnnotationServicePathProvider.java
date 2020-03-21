package com.github.piotrczyszczon.simpleworkset.jaxrs.path;

public class AnnotationServicePathProvider implements ServicePathProvider
{
  private static final String ADDRESS = "http://127.0.0.1:8080";
  private static final String SERVER_CONTEXT = "/jaxrs-server-annotation";
  private static final String APPLICATION = "/jax-rs";

  public String getServicePath()
  {
    return ADDRESS + SERVER_CONTEXT + APPLICATION;
  }
}
