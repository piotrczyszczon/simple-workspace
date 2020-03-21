package com.github.piotrczyszczon.simpleworkset.jaxrs;

import com.github.piotrczyszczon.simpleworkset.jaxrs.ds.Article;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/information-service")
public interface InformationService
{
  @GET
  @Path("/get-article")
  @Produces(MediaType.APPLICATION_JSON)
  Article getArticle(@QueryParam("id") int id);

  @GET
  @Path("/news")
  @Produces(MediaType.APPLICATION_JSON)
  List<Article> getnews();

  @POST
  @Path("/post-article")
  @Consumes(MediaType.APPLICATION_JSON)
  void addArticle(Article article);

  @PUT
  @Path("/update-article")
  @Consumes(MediaType.APPLICATION_JSON)
  void updateArticle(@QueryParam("id") int id, Article article);

  @DELETE
  @Path("/delete-article")
  void deleteArticle(@QueryParam("id") int id);
}
