package com.ladders.oc.view;

import java.util.Date;

import com.ladders.oc.display.ApplicationDisplayer;
import com.ladders.oc.jobs.Job;
import com.ladders.oc.jobseekers.JobSeeker;
import com.ladders.oc.recruiters.Recruiter;

public class RecriterInfoByDateView implements ApplicationDisplayer
{
  @Override
  public void displayApplicationFields(Job job, Recruiter recruiter, JobSeeker seeker, Date date)
  {
    System.out.println(seeker.getDisplayText());
  }

}
