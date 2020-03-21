package com.github.piotrczyszczon.simpleworkset.ejb.remote;

import javax.ejb.Remote;
import java.util.concurrent.BlockingQueue;

@Remote
public interface ListAppendingRemote
{
  void appendNextValue(BlockingQueue<String> someList);
}
