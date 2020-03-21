package com.github.piotrczyszczon.simpleworkset.jaxrs.path;

public class ConfigurationServicePathProvider implements ServicePathProvider
{
  private static final String ADDRESS = "http://127.0.0.1:8080";
  private static final String SERVER_CONTEXT = "/jaxrs-server-configuration";

  public String getServicePath()
  {
    return ADDRESS + SERVER_CONTEXT;
  }
}
