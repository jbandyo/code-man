package com.ladders.oc.recruiters;

import java.util.*;

/**
 * Wrapper class for a list of posted jobs (recruiter and posting details information).
 * Note: Not thread-safe.
 */
public class PostedJobs
{

  private List<PostedJob> jobList = new ArrayList<PostedJob>();

  public int getCount()
  {
    return jobList.size();
  }

  public void add(PostedJob job) throws IllegalArgumentException
  {
    // validate
    if (job == null)
      throw new IllegalArgumentException();
    
    jobList.add(job);   
  }

  public void deleteAll()
  {
    jobList.clear();
  }

  public Iterator<PostedJob> getIterator()
  {
    return jobList.iterator();
  }

}
