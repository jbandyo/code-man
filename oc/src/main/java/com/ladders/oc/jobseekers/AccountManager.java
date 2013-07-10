package com.ladders.oc.jobseekers;

import com.ladders.oc.*;
import com.ladders.oc.jobseekers.*;
import com.ladders.oc.recruiters.*;

public class AccountManager
{
  private final JobArchive<JobSeeker> savedJobs = new JobArchive<JobSeeker>();
  
  private AccountManager()
  {    
  }
  
  // singleton pattern implementation
  private static final class SingletonHolder 
  {
    static final AccountManager singleton = new AccountManager();
  }
  public static AccountManager getInstance()
  {
    return SingletonHolder.singleton;
  }
  
  public boolean saveViewedJob(JobSeeker seeker,
                            PostedJob job)
  {
    return savedJobs.addJob(seeker, job);
  }

  public void deleteAllViewedJobs()
  {
    savedJobs.deleteAllLists();
  }

  public PostedJobs getViewedJobs(JobSeeker seeker)
  {
    return savedJobs.getJobs(seeker);
  }

}
