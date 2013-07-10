package com.ladders.oc.application;

import java.util.*;

public class ApplicationRepository
{
  private final Set<Application> appSet;

  private ApplicationRepository()
  {
    appSet = Collections.synchronizedSet(new HashSet<Application>());  
  }
  
  // singleton pattern implementation
  private static final class SingletonHolder 
  {
    static final ApplicationRepository singleton = new ApplicationRepository();
  }
  public static ApplicationRepository getInstance()
  {
    return SingletonHolder.singleton;
  }

  /**
   * Adds an application to repository
   * @param  app    a valid application
   * @return true if the application was not added before
   */
  public boolean addApplication(Application app)
  {
    if (app == null)
      throw new IllegalArgumentException();
    return appSet.add(app);
  }

  public int getNumberOfApplications()
  {
    return appSet.size();
  }

  public void deleteAllApplications()
  {
    appSet.clear();
  }

}
