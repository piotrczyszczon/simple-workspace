package com.github.piotrczyszczon.simpleworkset.jaxrs;

import com.github.piotrczyszczon.simpleworkset.jaxrs.ds.Article;

import java.util.ArrayList;
import java.util.List;

public class InformationServiceImpl implements InformationService
{
  private static List<Article> articleList = new ArrayList<Article>();

  public Article getArticle(int id)
  {
    return articleList.get(id);
  }

  public List<Article> getnews()
  {
    return articleList;
  }

  public void addArticle(Article article)
  {
    articleList.add(article);
  }

  public void updateArticle(int id, Article article)
  {
    articleList.set(id, article);
  }

  public void deleteArticle(int id)
  {
    articleList.remove(id);
  }
}
