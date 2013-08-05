package com.ladders.oc.jobs;

/**
 * Represents a jReq Job.
 */
public class JReqJob extends Job
{
  /**
   * Constructor.
   * @param _title    a JobTitle object
   * @throws IllegalArgumentException if title is null
   */
  JReqJob(JobTitle title) 
  {
    super(title);
  }

  /**
   * Returns whether resume is needed.
   * @return true if resume is required.
   */
  @Override
  public boolean RequiresResume()
  {
    return true;
  }

}
