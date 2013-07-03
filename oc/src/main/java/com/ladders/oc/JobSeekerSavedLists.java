package com.ladders.oc;

import java.util.*;

/**
 * Manages job lists saved by job-seekers.
 * Note: Not thread-safe.
 */
public class JobSeekerSavedLists
{
  private Map<JobSeeker, JobPostings> seekerLists = new HashMap<JobSeeker, JobPostings>();
  
  private JobSeekerSavedLists() 
  {
  }

  // singleton pattern implementation
  private static final class SingletonHolder 
  {
    static final JobSeekerSavedLists singleton = new JobSeekerSavedLists();
  }
  public static JobSeekerSavedLists getInstance()
  {
    return SingletonHolder.singleton;
  }
  
  /**
   * Saves job posting along with job seeker reference to list.
   * @param seeker   JobSeeker instance.
   * @param posting  Job instance.
   * @throws IllegalArgumentException
   */
  public void saveJob(JobSeeker seeker,
                      JobPosting posting) throws IllegalArgumentException
  {
    // validate
    if ((seeker == null) || (posting == null))
      throw new IllegalArgumentException();

    JobPostings jobs = seekerLists.get(seeker);;
    
    if (jobs == null)
    {
      jobs = new JobPostings();
      seekerLists.put(seeker, jobs);
    }
    
    // add posting to seeker's list
    jobs.add(posting);
  }

  public JobPostings getJobList(JobSeeker seeker1)
  {
    return seekerLists.get(seeker1);
  }

  public int getNumberOfLists()
  {
    return seekerLists.size();
  }

  public void deleteAllLists()
  {
    seekerLists.clear();    
  }


}
