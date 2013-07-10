package com.ladders.oc.application;

import java.util.*;

/**
 * Wrapper class for a set of Job Applications.
 * Note: Not thread-safe.
 */
public class Applications
{
  private Set<Application> appSet = new LinkedHashSet<Application>();

  public int getCount()
  {
    return appSet.size();
  }

  public void add(Application app)
  {
    if (app == null)
      throw new IllegalArgumentException();
    appSet.add(app);
  }

  public void deleteAll()
  {
    appSet.clear();
  }

}
