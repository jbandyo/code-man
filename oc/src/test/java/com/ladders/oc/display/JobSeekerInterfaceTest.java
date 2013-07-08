package com.ladders.oc.display;

//manual display verification only

import static org.junit.Assert.*;

import java.util.*;
import org.junit.AfterClass;
import org.junit.Test;

import com.ladders.oc.*;
import com.ladders.oc.jobs.*;
import com.ladders.oc.recruiters.*;

public class JobSeekerInterfaceTest
{

  @Test
  public void test()
  {
    Recruiter recruiter1 = new Recruiter(new Name("John"));
    Recruiter recruiter2 = new Recruiter(new Name("Henry"));
    Job job1 = JobFactory.createATSJob(new JobTitle("Developer"));
    Job job2 = JobFactory.createATSJob(new JobTitle("Architect"));
    Job job3 = JobFactory.createATSJob(new JobTitle("Programmer"));
    JobRepository repo = JobRepository.getInstance();
    repo.postJob(recruiter1, job1);
    repo.postJob(recruiter1, job2);
    repo.postJob(recruiter2, job3);
    PostedJobs jobs = repo.getJobs();
    Iterator<PostedJob> iterator = jobs.getIterator();
    int i = 0;
    View view = View.getInstance();
    PostedJobs mySavedJobs = new PostedJobs();
    //JobArchive savedList = JobArchive.getInstance();
    System.out.println("List of all jobs");
    while (iterator.hasNext())
    {
      PostedJob job = iterator.next();
      view.displayObject(job.getPosting());
      System.out.print(" posted by ");
      view.displayObjectLF(job.getRecruiter());
      if (i % 2 == 0)
      {
        
      }

    }

  }

}
