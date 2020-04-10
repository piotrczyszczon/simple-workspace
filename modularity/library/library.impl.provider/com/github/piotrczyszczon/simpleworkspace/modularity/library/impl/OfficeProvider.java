package com.github.piotrczyszczon.simpleworkspace.modularity.library.impl;

import com.github.piotrczyszczon.simpleworkspace.modularity.library.*;
import com.github.piotrczyszczon.simpleworkspace.modularity.library.impl.*;

public class OfficeProvider
{
  public Office provide()
  {
    return new OfficeImpl();
  }
}