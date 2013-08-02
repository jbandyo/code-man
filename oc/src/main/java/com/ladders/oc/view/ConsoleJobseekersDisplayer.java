package com.ladders.oc.view;

import java.util.Set;

import com.ladders.oc.displayers.JobseekerDisplayer;
import com.ladders.oc.displayers.JobseekersDisplayer;
import com.ladders.oc.jobseekers.Jobseeker;

public class ConsoleJobseekersDisplayer implements JobseekersDisplayer
{

  @Override
  public void displayJobseekers(Set<Jobseeker> jobseekers)
  {
    JobseekerDisplayer displayer = new ConsoleJobseekerDisplayer();
    for (Jobseeker seeker : jobseekers)
    {
      System.out.print("- ");
      seeker.displayInstance(displayer);
      System.out.println();
   }

  }

}
