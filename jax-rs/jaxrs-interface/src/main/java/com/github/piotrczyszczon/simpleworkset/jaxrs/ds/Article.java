package com.github.piotrczyszczon.simpleworkset.jaxrs.ds;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Article
{
  private String title;
  private String content;

  public Article()
  {
  }

  public Article(String title, String content)
  {
    this.title = title;
    this.content = content;
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public String getContent()
  {
    return content;
  }

  public void setContent(String content)
  {
    this.content = content;
  }

  @Override
  public String toString()
  {
    return "Article{" + "title='" + title + '\'' + ", content='" + content + '\'' + '}';
  }
}
