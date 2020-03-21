package com.github.piotrczyszczon.simpleworkset.ejb.remote;

import javax.ejb.Remote;

@Remote
public interface CounterRemote
{
  int incrementCounter();
}
