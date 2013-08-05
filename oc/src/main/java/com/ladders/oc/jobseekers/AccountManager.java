package com.ladders.oc.jobseekers;

import java.util.*;

import com.ladders.oc.jobs.*;

/**
 * Maintains job seekers' data.
 */
public class AccountManager
{
  private final Map<Jobseeker, Jobs> savedJobs = Collections.synchronizedMap(new HashMap<Jobseeker, Jobs>());
  
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
  
  /**
   * Saves job posting along with jobseeker reference.
   * @param seeker Jobseeker instance.
   * @param job    Job instance.
   * @return true if the job was not saved before
   */
  public boolean saveViewedJob(Jobseeker seeker,
                               Job job)
  {
    Jobs jobs = savedJobs.get(seeker);
    
    if (jobs == null)
    {
      jobs = new Jobs();
      savedJobs.put(seeker, jobs);
    }
    
    // add posting to seeker's list
    return jobs.add(job);
  }

   /**
   * Retrieves job postings for a jobseeker.
   * @param seeker   Jobseeker instance.
   */
   public Jobs getViewedJobs(Jobseeker seeker)
  {
     return savedJobs.get(seeker);
  }

   void deleteAllViewedJobs()
   {
     savedJobs.clear();
   }

}
