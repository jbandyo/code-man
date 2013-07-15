package com.ladders.oc.display;

import java.util.*;

import com.ladders.oc.jobs.Job;
import com.ladders.oc.jobseekers.JobSeeker;
import com.ladders.oc.recruiters.Recruiter;
import com.ladders.oc.application.*;

public interface ApplicationDisplayer
{
  void displayApplicationFields(Job job, Recruiter recruiter, JobSeeker seeker, Date date);
}
