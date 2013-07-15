package com.ladders.oc.display;

// manual display verification only

import org.junit.Test;


import com.ladders.oc.*;
import com.ladders.oc.jobs.*;
import com.ladders.oc.postedjobs.*;
import com.ladders.oc.recruiters.*;
import com.ladders.oc.view.View;

public class RecruiterInterfaceTest
{

  @Test
  public void test()
  {
    Recruiter recruiter = new Recruiter(new Name("John"));
    Job job1 = JobFactory.createATSJob(new JobTitle("Developer"));
    Job job2 = JobFactory.createATSJob(new JobTitle("Architect"));
    Job job3 = JobFactory.createATSJob(new JobTitle("Programmer"));
    JobRepository repo = JobRepository.getInstance();
    repo.postJob(recruiter, job1);
    repo.postJob(recruiter, job2);
    repo.postJob(recruiter, job3);
    Jobs jobs = repo.getRecruiterJobs(recruiter);
    View view = View.getInstance();
    System.out.print("Jobs posted by: ");
    view.displayItemLF(recruiter);
    view.displayList(jobs);
  }
}
