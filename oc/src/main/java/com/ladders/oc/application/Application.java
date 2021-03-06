package com.ladders.oc.application;

import java.util.*;

import com.ladders.oc.jobs.*;
import com.ladders.oc.jobseekers.*;
import com.ladders.oc.recruiters.*;
import com.ladders.oc.displayables.*;
import com.ladders.oc.displayers.ApplicationDisplayer;

/**
 * Represents a job application.
 */
public class Application implements DisplayableApplication
{
  private final Job   job;
  private final Recruiter recruiter;
  private final Jobseeker  seeker;
  private final Date  date;

  Application(Job job, Recruiter recruiter, Jobseeker seeker)
  {
    this.job = job;
    this.recruiter = recruiter;
    this.seeker = seeker;
    date = new Date();
  }

  /**
   * Returns whether a job is part of the object.
   * @param   job  Job object
   * @return  true if the job is part of the object.
   */
  boolean containsJob(Job job)
  {
    return this.job == job;
  }

  /**
   * Returns whether a recruiter is part of the object.
   * @param   recruiter  Recruiter object
   * @return  true if the recruiter is part of the object.
   */
  boolean containsRecruiter(Recruiter recruiter)
  {
    return this.recruiter == recruiter;
  }

  /**
   * Returns whether a jobseeker is part of the object.
   * @param   seeker  JobSeeker object
   * @return  true if the jobseeker is part of the object.
   */
   boolean containsJobSeeker(Jobseeker seeker)
  {
    return this.seeker == seeker;
  }

   /**
    * Returns whether a date is part of the object.
    * @param   queryDate  Date object
    * @return  true if the date is part of the object.
    */
  boolean containsDate(Date queryDate)
  {
    return AppDateComparator.isEqual(date, queryDate);
  }
  
  /**
   * Retrieves set of unique jobseekers from the set of applications.
   * @param   apps  Set of Application.
   * @return  set of jobseekers
   */
  public static Jobseekers retrieveJobSeekers(Applications apps)
  {
    Iterator<Application> iter = apps.getIterator();
    Jobseekers seekers = new Jobseekers();
    while (iter.hasNext())
    {
      Application app = iter.next();
      if (!seekers.contains(app.seeker))
        seekers.add(app.seeker);   
    }
    return seekers;
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

  @Override
  public void displayInstance(ApplicationDisplayer displayer)
  { 
    displayer.displayApplication(job, recruiter, seeker, date);
  }

}
