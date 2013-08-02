package com.ladders.oc.view;

import java.util.Date;

import com.ladders.oc.displayers.ApplicationDisplayer;
import com.ladders.oc.displayers.JobDisplayer;
import com.ladders.oc.displayers.RecruiterDisplayer;
import com.ladders.oc.jobs.Job;
import com.ladders.oc.jobseekers.Jobseeker;
import com.ladders.oc.recruiters.Recruiter;

public class ConsoleApplicationDisplayer implements ApplicationDisplayer
{  
  @Override
  public void displayApplication(Job job, Recruiter recruiter, Jobseeker seeker, Date date)
  {
    JobDisplayer jobDisplayer = new ConsoleJobDisplayer();
    job.displayInstance(jobDisplayer);
    System.out.print(" posted by ");
    RecruiterDisplayer recDisplayer = new ConsoleRecruiterDisplayer();
    recruiter.displayInstance(recDisplayer);
  }

}
