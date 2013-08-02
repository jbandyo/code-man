package com.ladders.oc.jobseekers;

import java.util.*;

import com.ladders.oc.displayables.DisplayableJobseekers;
import com.ladders.oc.displayers.JobseekersDisplayer;

/**
 * Wrapper class for a set of jobseekers.
 * Note: Not thread-safe.
 */
public class Jobseekers implements DisplayableJobseekers
{
  private final Set<Jobseeker> seekerSet = new LinkedHashSet<Jobseeker>();

  /**
   * Adds a jobseeker to the set of jobseekers.
   * @param  seeker  JobSeeker object.
   * @return true if the seeker was not added before.
   * @throws IllegalArgumentException if input jobseeker object is null.
   */
  public boolean add(Jobseeker seeker)
  {
    // validate
    if (seeker == null)
      throw new IllegalArgumentException();  
    return seekerSet.add(seeker);    
  }

  /**
   * Returns whether a jobseeker is present in the jobseeker set.
   * @param   seeker  JobSeeker object
   * @return  true if the jobseeker is present in the set.
   */
  public boolean contains(Jobseeker seeker)
  {
    return seekerSet.contains(seeker);
  }

  /**
   * Returns count of jobseekers in the set.
   * @return count.
   */
  public int getCount()
  {
    return seekerSet.size();
  }

  void deleteAll()
  {
    seekerSet.clear();
  }

  // interface method implementation
  @Override
  public void displayCollection(JobseekersDisplayer displayer)
  {
    Set<Jobseeker> seekers = new LinkedHashSet<Jobseeker>(seekerSet);
    displayer.displayJobseekers(seekers);
    
  }


}
