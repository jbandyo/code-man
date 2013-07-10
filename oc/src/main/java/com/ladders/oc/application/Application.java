package com.ladders.oc.application;

import java.util.*;
import com.ladders.oc.jobs.*;
import com.ladders.oc.jobseekers.*;
import com.ladders.oc.recruiters.*;

public class Application
{
  private final Job   job;
  private final Recruiter recruiter;
  private final JobSeeker  jobSeeker;
  private final Date  submitTime;
  
  Application(Job _job, Recruiter _recruiter, JobSeeker _seeker)
  {
    job = _job;
    recruiter = _recruiter;
    jobSeeker = _seeker;
    submitTime = new Date();
  }
  
  @Override
  public boolean equals(Object o)
  {
    if (o == this)
      return true;
    if (!(o instanceof Application))
      return false;
    Application app = (Application) o;
    return (app.job.equals(job) && app.jobSeeker.equals(jobSeeker));   // compare only job and jobseeker parts
  }

  @Override
  public int hashCode()
  {
    int hcode = job.hashCode() << 16;
    hcode |= ((jobSeeker.hashCode() >> 16) & 0x0000FFFF);
    return hcode;
  }

}

