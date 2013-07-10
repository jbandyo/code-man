package com.ladders.oc.recruiters;

import java.util.*;

/**
 * Wrapper class for a set of posted jobs (recruiter and posting details information).
 * Note: Not thread-safe.
 */
public class PostedJobs
{

  private Set<PostedJob> jobSet = new LinkedHashSet<PostedJob>();

  public int getCount()
  {
    return jobSet.size();
  }

  public boolean add(PostedJob job) throws IllegalArgumentException
  {
    // validate
    if (job == null)
      throw new IllegalArgumentException();
    
    return jobSet.add(job);   
  }

  public void deleteAll()
  {
    jobSet.clear();
  }

  public Iterator<PostedJob> getIterator()
  {
    return jobSet.iterator();
  }
  
  public boolean contains(PostedJob job)
  {
    return jobSet.contains(job);
  }

}
