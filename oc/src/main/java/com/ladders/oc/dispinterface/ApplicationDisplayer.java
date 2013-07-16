package com.ladders.oc.dispinterface;

import java.util.*;

import com.ladders.oc.jobs.Job;
import com.ladders.oc.jobseekers.JobSeeker;
import com.ladders.oc.recruiters.Recruiter;

public interface ApplicationDisplayer
{
  void displayApplicationFields(Job job, Recruiter recruiter, JobSeeker seeker, Date date);
}
