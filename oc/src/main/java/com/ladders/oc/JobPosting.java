package com.ladders.oc;

import java.util.Date;
import com.ladders.oc.jobs.Job;

/**
 * Represents a single job posting consisting of the job and posting time.
 */
public class JobPosting
{
  private Job job;
  private Date postTime;
  
  public JobPosting(Job _job,
                    Date _postTime) throws IllegalArgumentException
  {
    if ((_job == null) || (_postTime == null))
      throw new IllegalArgumentException();
    job = _job;
    postTime = _postTime;
  }
}

