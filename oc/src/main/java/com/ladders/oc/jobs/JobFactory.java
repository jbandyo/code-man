package com.ladders.oc.jobs;

public class JobFactory
{

  /**
   * Factory method that creates a ATS job.
   * @param   title    a JobTitle object
   * @return           a newly created ATS Job
   */
  public static ATSJob createATSJob(JobTitle title)
  {
    ATSJob job = new ATSJob(title);
    return job;
  }

}
