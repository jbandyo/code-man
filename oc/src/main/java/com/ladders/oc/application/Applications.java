package com.ladders.oc.application;

import java.util.*;

/**
 * Wrapper class for a set of Job Applications.
 * Note: Not thread-safe.
 */
public class Applications
{
  private final Set<Application> appSet = new HashSet<Application>();

  /**
   * Adds an application to the set.
   * @param  app  Application object.
   * @return true if the application was not added before.
   */
  public void add(Application app)
  {
    appSet.add(app);
  }

  /**
   * Returns an iterator for the application set.
   * @return iterator.
   */
  public Iterator<Application> getIterator()
  {
    return appSet.iterator();
  }

  /**
   * Returns count of applications in the set.
   * @return count.
   */
  public int getCount()
  {
    return appSet.size();
  }

  void deleteAll()
  {
    appSet.clear();
  }

}
