package com.ladders.oc.jobs;

public final class Jobs
{
  private static final class SingletonHolder 
  {
    static final Jobs singleton = new Jobs();
  }

  private Jobs() {}

  public static Jobs getInstance()
  {
    return SingletonHolder.singleton;
  }

  public void AddJob(Job _job)
  {
    // TODO Auto-generated method stub
    
  }

  public int GetNumberOfJobs()
  {
    // TODO Auto-generated method stub
    return 0;
  }

}
