package com.ladders.oc;

import java.util.*;
import com.ladders.oc.recruiters.*;

/**
 * Keeps job lists specific to a key object..
 * Note: Not thread-safe.
 */
public class JobArchive<T>
{
  private Map<T, PostedJobs> jobLists = new HashMap<T, PostedJobs>();
    
  /**
   * Saves job posting along with an object reference.
   * @param user   key object.
   * @param job    Job instance.
   * @return true if the job was not saved before
   * @throws IllegalArgumentException
   */
  public boolean addJob(T user,
                      PostedJob job) throws IllegalArgumentException
  {
    // validate
    if ((user == null) || (job == null))
      throw new IllegalArgumentException();

    PostedJobs jobs = jobLists.get(user);
    
    if (jobs == null)
    {
      jobs = new PostedJobs();
      jobLists.put(user, jobs);
    }
    
    // add posting to seeker's list
    return jobs.add(job);
  }

  /**
   * Retrieves job postings for a key object.
   * @param user   key object.
   */
  public PostedJobs getJobs(T user)
  {
    return jobLists.get(user);
  }

  public int getNumberOfLists()
  {
    return jobLists.size();
  }

  public void deleteAllLists()
  {
    jobLists.clear();    
  }

}
