package com.ladders.oc;

import com.ladders.oc.jobs.*;

/**
 * Manages job lists saved by job-seekers.
 */
public class JobSeekerSavedLists
{
  // singleton pattern implementation
  private static final class SingletonHolder 
  {
    static final JobSeekerSavedLists singleton = new JobSeekerSavedLists();
  }
  public static JobSeekerSavedLists getInstance()
  {
    return SingletonHolder.singleton;
  }
  
  public void SaveJob(JobSeeker seeker,
                      Job job) throws IllegalArgumentException
  {
    // validate
    if ((seeker == null) || (job == null))
      throw new IllegalArgumentException();
    
  }

}
