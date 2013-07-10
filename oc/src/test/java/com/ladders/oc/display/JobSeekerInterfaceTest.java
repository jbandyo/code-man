package com.ladders.oc.display;

//manual display verification only

import static org.junit.Assert.*;

import java.util.*;
import org.junit.AfterClass;
import org.junit.Test;

import com.ladders.oc.*;
import com.ladders.oc.jobs.*;
import com.ladders.oc.jobseekers.AccountManager;
import com.ladders.oc.jobseekers.JobSeeker;
import com.ladders.oc.recruiters.*;

public class JobSeekerInterfaceTest
{

  @Test
  public void test()
  {
    Recruiter recruiter1 = new Recruiter(new Name("John"));
    Recruiter recruiter2 = new Recruiter(new Name("Henry"));
    JobSeeker seeker1 = new JobSeeker(new Name("David"));
    JobSeeker seeker2 = new JobSeeker(new Name("Adam"));
    Job job1 = JobFactory.createATSJob(new JobTitle("Developer"));
    Job job2 = JobFactory.createATSJob(new JobTitle("Architect"));
    Job job3 = JobFactory.createATSJob(new JobTitle("Programmer"));
    JobRepository repo = JobRepository.getInstance();
    repo.postJob(recruiter1, job1);
    repo.postJob(recruiter1, job2);
    repo.postJob(recruiter2, job3);
    PostedJobs jobs = repo.getPostedJobs();
    Iterator<PostedJob> iterator = jobs.getIterator();
    int i = 0;
    View view = View.getInstance();

    AccountManager manager = AccountManager.getInstance();
    System.out.println("List of all jobs");
    while (iterator.hasNext())
    {
      PostedJob job = iterator.next();
      view.displayObject(job.getPosting());
      System.out.print(" posted by ");
      view.displayObjectLF(job.getRecruiter());
      if (i % 2 == 0)
      {
        manager.saveViewedJob(seeker1, job);
      }
      else
      {
        manager.saveViewedJob(seeker2, job);
      }
      ++i;
    }
    
    System.out.println();
    System.out.print("Jobs Saved by ");
    view.displayObjectLF(seeker1);
    jobs = manager.getViewedJobs(seeker1);
    iterator = jobs.getIterator();
    while (iterator.hasNext())
    {
      view.displayObjectLF(iterator.next().getPosting());
    }

    System.out.println();
    System.out.print("Jobs Saved by ");
    view.displayObjectLF(seeker2);
    jobs = manager.getViewedJobs(seeker2);
    iterator = jobs.getIterator();
    while (iterator.hasNext())
    {
      view.displayObjectLF(iterator.next().getPosting());
    }
  
  }

}
