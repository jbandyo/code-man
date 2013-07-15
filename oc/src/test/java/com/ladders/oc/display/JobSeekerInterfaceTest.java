package com.ladders.oc.display;

//manual display verification only

import static org.junit.Assert.*;

import java.util.*;

import org.junit.AfterClass;
import org.junit.Test;


import com.ladders.oc.*;
import com.ladders.oc.application.*;
import com.ladders.oc.jobs.*;
import com.ladders.oc.jobseekers.*;
import com.ladders.oc.postedjobs.*;
import com.ladders.oc.recruiters.*;
import com.ladders.oc.resume.*;
import com.ladders.oc.view.View;

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
    Jobs jobs = repo.getPostedJobs();
    Iterator<Job> iterator = jobs.getIterator();
    int i = 0;
    View view = View.getInstance();

    AccountManager manager = AccountManager.getInstance();
    System.out.println("List of all jobs");
    while (iterator.hasNext())
    {
      Job job = iterator.next();
      view.displayItem(job);
      System.out.print(" posted by ");
      view.displayItemLF(repo.GetRecruiterByJob(job));
      if (i % 2 == 0)
      {
        manager.saveViewedJob(seeker1, job);
      }
      else
      {
        manager.saveViewedJob(seeker1, job);
        manager.saveViewedJob(seeker2, job);
      }
      ++i;
    }

    System.out.println();
    System.out.print("Jobs Saved by ");
    view.displayItemLF(seeker1);
    jobs = manager.getViewedJobs(seeker1);
    iterator = jobs.getIterator();
    while (iterator.hasNext())
    {
      Job jobx = iterator.next();
      Recruiter recruiterx = repo.GetRecruiterByJob(jobx);
      Resume resumex = ResumeCreator.createResume(seeker1);
      ApplicationProcessor.applyToJob(seeker1, jobx, recruiterx, resumex);
      view.displayItemLF(jobx);
    }

    System.out.println();
    System.out.print("Jobs Saved by ");
    view.displayItemLF(seeker2);
    jobs = manager.getViewedJobs(seeker2);
    iterator = jobs.getIterator();
    while (iterator.hasNext())
    {
      Job jobx = iterator.next();
      Recruiter recruiterx = repo.GetRecruiterByJob(jobx);
      Resume resumex = ResumeCreator.createResume(seeker1);
      ApplicationProcessor.applyToJob(seeker2, jobx, recruiterx, resumex);
      view.displayItemLF(jobx);
    }
   
    ApplicationRepository apprepo = ApplicationRepository.getInstance();
    System.out.println();
    System.out.print("Jobs applied to by ");
    view.displayItemLF(seeker1);
    ApplicationRepository.Filter filter = apprepo.createFilter(null, null, seeker1, null);
    Applications apps = apprepo.getApplications(filter);
    Iterator<Application> appiter = apps.getIterator();
    while (appiter.hasNext())
    {
      Application appx = appiter.next();
      view.displayJobSeekerJob(appx);
    }

    System.out.println();
    System.out.println("Jobseekers list by date");
    System.out.print("Recruier: ");
    view.displayItemLF(recruiter1);
    Date date = new Date();
    System.out.print("Date:     ");
    System.out.println(date.toString());
    filter = apprepo.createFilter(null, recruiter1, null, date);
    apps = apprepo.getApplications(filter);
    appiter = apps.getIterator();
    JobSeekers seekers = Application.retrieveJobSeekers(apps);
    view.displayList(seekers);
    
    System.out.println();
    System.out.println("Jobseekers list by job");
    System.out.print("Recruier: ");
    view.displayItemLF(recruiter1);
    System.out.print("Job     : ");
    view.displayItemLF(job1);
    filter = apprepo.createFilter(null, recruiter1, null, null);
    apps = apprepo.getApplications(filter);
    seekers = Application.retrieveJobSeekers(apps);
    view.displayList(seekers);

  }

}
