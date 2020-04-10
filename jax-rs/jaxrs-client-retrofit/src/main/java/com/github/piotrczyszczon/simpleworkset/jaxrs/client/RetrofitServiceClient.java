package com.github.piotrczyszczon.simpleworkset.jaxrs.client;

import com.github.piotrczyszczon.simpleworkset.jaxrs.InformationService;
import com.github.piotrczyszczon.simpleworkset.jaxrs.path.ServicePathProvider;
import retrofit.converter.JacksonConverter;

public class RetrofitServiceClient
{
  private final ServicePathProvider servicePathProvider;

  public RetrofitServiceClient(ServicePathProvider servicePathProvider)
  {
    this.servicePathProvider = servicePathProvider;
  }

  public InformationService openService()
  {
    Retro
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("https://api.github.com")
        .addConverterFactory(new JacksonConverter())
        .build();

    GitHubService service = retrofit.create(GitHubService.class);
  }
}
