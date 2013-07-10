package com.ladders.oc.jobs;

/**
 * Represents a ATS Job.
 */
public class ATSJob extends Job
{
  /**
   * Constructor.
   * @param _title    a JobTitle object
   */
  ATSJob(JobTitle _title) throws IllegalArgumentException
  {
    super(_title);
  }

  public boolean RequiresResume()
  {
    return false;
  }

}
