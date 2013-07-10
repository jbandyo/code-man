package com.ladders.oc.jobs;

import java.util.*;
import com.ladders.oc.display.*;

/**
 * Wrapper class for a set of jobs.
 * Note: Not thread-safe.
 */
public class Jobs implements DisplayableCollection
{
  private Set<Job> jobSet = new LinkedHashSet<Job>();

  public int getCount()
  {
    return jobSet.size();
  }

  public void add(Job job) throws IllegalArgumentException
  {
    // validate
    if (job == null)
      throw new IllegalArgumentException();
    
    if (!jobSet.add(job))
      throw new IllegalArgumentException();      
  }

  public void deleteAll()
  {
    jobSet.clear();
  }

  // interface method implementation
  public List<String> getDisplayTextList()
  {
    List<String> texts = new ArrayList<String>();
    for (Job job : jobSet)
    {
      texts.add(job.getDisplayText());
    }
    return texts;
  }

  public Iterator<Job> getIterator()
  {
    return jobSet.iterator();
  }
  
  public boolean contains(Job job)
  {
    return jobSet.contains(job);
  }

}
