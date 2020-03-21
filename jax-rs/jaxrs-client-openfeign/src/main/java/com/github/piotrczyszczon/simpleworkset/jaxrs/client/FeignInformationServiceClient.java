package com.github.piotrczyszczon.simpleworkset.jaxrs.client;

import com.github.piotrczyszczon.simpleworkset.jaxrs.InformationService;
import com.github.piotrczyszczon.simpleworkset.jaxrs.ds.Article;
import com.github.piotrczyszczon.simpleworkset.jaxrs.path.AnnotationServicePathProvider;
import com.github.piotrczyszczon.simpleworkset.jaxrs.path.ConfigurationServicePathProvider;

public class FeignInformationServiceClient
{
  public static void main(String[] args)
  {
    new FeignInformationServiceClient().run();
  }

  private void run()
  {
    System.out.println("Testing [ANNOTATION] BASED Service!");
    InformationService annotationBasedService = new OpenFeignServiceClient(new AnnotationServicePathProvider()).openService();
    testService(annotationBasedService);

    System.out.println("Testing [CONFIGURATION] BASED Service!");
    InformationService configurationBasedService = new OpenFeignServiceClient(new ConfigurationServicePathProvider()).openService();
    testService(configurationBasedService);
  }

  public void testService(InformationService informationService)
  {
    informationService.addArticle(new Article("Free Article", "Some very important Information"));
    informationService.addArticle(new Article("Paid Article", "Some very expensive Information"));
    System.out.println(informationService.getnews());
    informationService.updateArticle(1, new Article("[DEPRECATED] Well paid Article", "This article will be removed!!!"));
    System.out.println(informationService.getnews());
    informationService.deleteArticle(1);
    System.out.println(informationService.getnews());
  }
}
