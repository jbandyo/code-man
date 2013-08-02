package com.ladders.oc.jobs;

import java.util.*;

import com.ladders.oc.displayables.*;
import com.ladders.oc.displayers.JobsDisplayer;

/**
 * Wrapper class for a set of jobs.
 * Note: Not thread-safe.
 */
public class Jobs implements DisplayableJobs
{
  private final Set<Job> jobSet = new LinkedHashSet<Job>();

  /**
   * Adds a job to the set of jobs.
   * @param  job  Job object.
   * @return true if the job was not added before.
   * @throws IllegalArgumentException if input job object is null.
   */
  public boolean add(Job job)
  {
    // validate
    if (job == null)
      throw new IllegalArgumentException();  
    return jobSet.add(job);    
  }

  /**
   * Returns an iterator for the job set.
   * @return iterator.
   */
  public Iterator<Job> getIterator()
  {
    return jobSet.iterator();
  }

  /**
   * Returns whether a job is present in the job set.
   * @param   job  Job object
   * @return  true if the job is present in the set.
   */
  public boolean contains(Job job)
  {
    return jobSet.contains(job);
  }

  /**
   * Returns count of jobs in the set.
   * @return count.
   */
  public int getCount()
  {
    return jobSet.size();
  }

  void deleteAll()
  {
    jobSet.clear();
  }

  // interface method implementation
  @Override
  public void displayCollection(JobsDisplayer displayer)
  {
    Set<Job> jobs = new LinkedHashSet<Job>(jobSet);
    displayer.displayJobs(jobs);
    
  }

}
