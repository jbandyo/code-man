package com.ladders.oc.application;

import java.util.*;


import com.ladders.oc.jobs.*;
import com.ladders.oc.jobseekers.*;
import com.ladders.oc.recruiters.*;
import com.ladders.oc.view.JobsAppliedToView;
import com.ladders.oc.display.*;

/**
 * Represents a job application.
 */
public class Application implements DisplayableObject
{
  private final Job   job;
  private final Recruiter recruiter;
  private final JobSeeker  seeker;
  private final Date  date;

  public static enum Fields
  {
    JOB, RECRUITER, JOBSEEKER, DATE
  }

  Application(Job _job, Recruiter _recruiter, JobSeeker _seeker)
  {
    job = _job;
    recruiter = _recruiter;
    seeker = _seeker;
    date = new Date();
  }

  /**
   * Returns whether a job is part of the object.
   * @param   _job  Job object
   * @return  true if the job is part of the object.
   */
  boolean containsJob(Job _job)
  {
    return job == _job;
  }

  /**
   * Returns whether a recruiter is part of the object.
   * @param   _recruiter  Recruiter object
   * @return  true if the recruiter is part of the object.
   */
  boolean containsRecruiter(Recruiter _recruiter)
  {
    return recruiter == _recruiter;
  }

  /**
   * Returns whether a jobseeker is part of the object.
   * @param   _seeker  JobSeeker object
   * @return  true if the jobseeker is part of the object.
   */
   boolean containsJobSeeker(JobSeeker _seeker)
  {
    return seeker == _seeker;
  }

   /**
    * Returns whether a date is part of the object.
    * @param   _date  Date object
    * @return  true if the date is part of the object.
    */
  boolean containsDate(Date _date)
  {
    return AppDateComparator.compare(date, _date);
  }
  
  /**
   * Retrieves set of unique jobseekers from the set of applications.
   * @param   apps  Set of Application.
   * @return  set of jobseekers
   * @throws IllegalArgumentException if input applications object is null.
   */
  public static JobSeekers retrieveJobSeekers(Applications apps)
  {
    if (apps == null)
      throw new IllegalArgumentException();
    Iterator<Application> iter = apps.getIterator();
    JobSeekers seekers = new JobSeekers();
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

  // interface method implementation
  public String[] getDisplayTextArray()
  {
    String[] texts = new String[4];
    texts[0] = job.getDisplayText();
    texts[1] = recruiter.getDisplayText();
    texts[2] = seeker.getDisplayText();
    texts[3] = date.toString();
    return texts;
  }
  
  public void displayInstance(ApplicationDisplayer viewObj)
  { 
    viewObj.displayApplicationFields(job, recruiter, seeker, date);
  }

}
