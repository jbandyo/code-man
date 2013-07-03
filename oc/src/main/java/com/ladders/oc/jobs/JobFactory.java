package com.ladders.oc.jobs;

/**
 * Factor class for all job types.
 */
public class JobFactory
{

  /**
   * Factory method that creates a ATS job.
   * @param   title    a JobTitle object
   * @return           a newly created ATS Job
   */
  public static ATSJob createATSJob(JobTitle title) throws IllegalArgumentException
  {
    // validate
    if (title == null)
      throw new IllegalArgumentException();

    ATSJob job = new ATSJob(title);
    return job;
  }

  /**
   * Factory method that creates a jReq job.
   * @param   title    a JobTitle object
   * @return           a newly created jReq Job
   */
  public static JReqJob createJReqJob(JobTitle title) throws IllegalArgumentException
  {
    // validate
    if (title == null)
      throw new IllegalArgumentException();

    JReqJob job = new JReqJob(title);
    return job;
  }

}
