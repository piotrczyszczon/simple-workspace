package com.github.piotrczyszczon.simpleworkset.ejb.remote;

import javax.ejb.Stateless;

@Stateless(name = "TextProcessorBean")
public class TextProcessorBean implements TextToLowerRemote, TextToUpperRemote
{
  @Override
  public String convertTextToLower(String text)
  {
    return text.toLowerCase();
  }

  @Override
  public String convertTextToUpper(String text)
  {
    return text.toUpperCase();
  }
}
