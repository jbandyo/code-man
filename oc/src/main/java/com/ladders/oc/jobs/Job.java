package com.ladders.oc.jobs;

import java.util.UUID;

public abstract class Job
{
  protected UUID uId;
  protected JobTitle title;
  
  /**
   * Base class constructor 
   * @param _title    a JobTitle object
   */
  public Job(JobTitle _title)
  {
    title = _title;
    // create a unique ID
    uId = UUID.randomUUID();
  }

}
