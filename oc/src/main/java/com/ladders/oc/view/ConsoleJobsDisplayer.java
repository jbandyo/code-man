package com.ladders.oc.view;

import java.util.Set;

import com.ladders.oc.displayers.JobDisplayer;
import com.ladders.oc.displayers.JobsDisplayer;
import com.ladders.oc.jobs.Job;

public class ConsoleJobsDisplayer implements JobsDisplayer
{

  @Override
  public void displayJobs(Set<Job> jobs)
  {
    JobDisplayer displayer = new ConsoleJobDisplayer();
    for (Job job : jobs)
    {
      System.out.print("- ");
      job.displayInstance(displayer);
      System.out.println();
    }
  }

}
