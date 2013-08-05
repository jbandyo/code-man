package com.ladders.oc.jobs;

/**
 * Represents a ATS Job.
 */
public class ATSJob extends Job
{
  /**
   * Constructor.
   * @param _title    a JobTitle object
   * @throws IllegalArgumentException if title is null
   */
  ATSJob(JobTitle title) 
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
    return false;
  }

}
