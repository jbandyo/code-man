package com.ladders.oc.view;

import java.util.Date;

import com.ladders.oc.dispinterface.ApplicationDisplayer;
import com.ladders.oc.jobs.Job;
import com.ladders.oc.jobseekers.JobSeeker;
import com.ladders.oc.recruiters.Recruiter;

public class JobsAppliedToView implements ApplicationDisplayer
{  
  @Override
  public void displayApplicationFields(Job job, Recruiter recruiter, JobSeeker seeker, Date date)
  {
    System.out.print(job.getDisplayText());
    System.out.print(" posted by ");
    System.out.print(recruiter.getDisplayText());
    System.out.println();
  }

}
