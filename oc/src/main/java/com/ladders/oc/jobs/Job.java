package com.ladders.oc.jobs;

import java.util.UUID;
import com.ladders.oc.Recruiter;

/**
 * Abstract base class for all job types.
 */
public abstract class Job
{
  protected UUID uId;
  protected JobTitle title;
  
  /**
   * Base class constructor 
   * @param _title    a JobTitle object
   */
  Job(JobTitle _title)
  {
    title = _title;
    // create a unique ID
    uId = UUID.randomUUID();
  }
  
  @Override
  public boolean equals(Object o)
  {
    if (o == this)
      return true;
    if (o.getClass() != this.getClass())
      return false;
    Job job = (Job) o;
    return job.uId == uId;
  }
  
  @Override
  public int hashCode()
  {
    return (int)(uId.getLeastSignificantBits());
  }
  
}