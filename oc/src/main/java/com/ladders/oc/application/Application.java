package com.ladders.oc.application;

import java.util.*;

import com.ladders.oc.jobs.*;
import com.ladders.oc.jobseekers.*;
import com.ladders.oc.recruiters.*;

public class Application
{
  private final Job   job;
  private final Recruiter recruiter;
  private final JobSeeker  seeker;
  private final Date  date;
  
  Application(Job _job, Recruiter _recruiter, JobSeeker _seeker)
  {
    job = _job;
    recruiter = _recruiter;
    seeker = _seeker;
    date = new Date();
  }

  public boolean containsJob(Job _job)
  {
    return job == _job;
  }

  public boolean containsRecruiter(Recruiter _recruiter)
  {
    return recruiter == _recruiter;
  }

  public boolean containsJobSeeker(JobSeeker _seeker)
  {
    return seeker == _seeker;
  }

  public boolean containsDate(Date _date)
  {
    return AppDateComparator.compare(date, _date);
  }

  @Override
  public boolean equals(Object o)
  {
    if (o == this)
      return true;
    if (!(o instanceof Application))
      return false;
    Application app = (Application) o;
    return (app.job.equals(job) && app.seeker.equals(seeker));   // compare only job and jobseeker parts
  }

  @Override
  public int hashCode()
  {
    int hcode = job.hashCode() << 16;
    hcode |= ((seeker.hashCode() >> 16) & 0x0000FFFF);
    return hcode;
  }

}

