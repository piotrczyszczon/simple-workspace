package com.github.piotrczyszczon.simpleworkset.ejb.remote;

import javax.ejb.Remote;

@Remote
public interface TextToLowerRemote
{
  String convertTextToLower(String text);
}
