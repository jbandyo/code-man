package com.ladders.oc.recruiters;

import java.util.Date;

import com.ladders.oc.display.Displayable;
import com.ladders.oc.jobs.Job;

/**
 * Represents a single job posting consisting of the job and posting time.
 */
public class JobPosting implements Displayable
{
  private Job job;
  private Date postTime;
  
  /**
   * @param _job
   * @param _postTime
   * @throws IllegalArgumentException
   */
  public JobPosting(Job _job,
                    Date _postTime) throws IllegalArgumentException
  {
    if ((_job == null) || (_postTime == null))
      throw new IllegalArgumentException();
    job = _job;
    postTime = _postTime;
  }

  // interface method implementation
  public String getDisplayText()
  {
    return job.getDisplayText();    
  }

}

