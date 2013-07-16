package com.ladders.oc.jobseekers;

import java.util.*;

import com.ladders.oc.dispinterface.DisplayableCollection;

/**
 * Wrapper class for a set of jobseekers.
 * Note: Not thread-safe.
 */
public class JobSeekers implements DisplayableCollection
{
  private final Set<JobSeeker> seekerSet = new LinkedHashSet<JobSeeker>();

  /**
   * Adds a jobseeker to the set of jobseekers.
   * @param  seeker  JobSeeker object.
   * @return true if the seeker was not added before.
   * @throws IllegalArgumentException if input jobseeker object is null.
   */
  public boolean add(JobSeeker seeker)
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
  public boolean contains(JobSeeker seeker)
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
  public List<String> getDisplayTextList()
  {
    List<String> texts = new ArrayList<String>();
    for (JobSeeker seeker : seekerSet)
    {
      texts.add(seeker.getDisplayText());
    }
    return texts;
  }

}
