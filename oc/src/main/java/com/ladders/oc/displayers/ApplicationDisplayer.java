package com.ladders.oc.displayers;

import java.util.*;

import com.ladders.oc.jobs.Job;
import com.ladders.oc.jobseekers.Jobseeker;
import com.ladders.oc.recruiters.Recruiter;

public interface ApplicationDisplayer
{
  void displayApplication(Job job, Recruiter recruiter, Jobseeker seeker, Date date);
}
