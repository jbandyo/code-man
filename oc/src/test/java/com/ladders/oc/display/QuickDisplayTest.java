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
import com.ladders.oc.view.*;

public class QuickDisplayTest
{

  @Test
  public void test()
  {
    ConsoleView view = View.getInstance();

    // recruiter postings
    Recruiter recruiter1 = new Recruiter(new Name("John"));
    Recruiter recruiter2 = new Recruiter(new Name("Henry"));
    Jobseeker seeker1 = new Jobseeker(new Name("David"));
    Jobseeker seeker2 = new Jobseeker(new Name("Adam"));
    Job job1 = JobFactory.createATSJob(new JobTitle("Developer"));
    Job job2 = JobFactory.createATSJob(new JobTitle("Architect"));
    Job job3 = JobFactory.createATSJob(new JobTitle("Programmer"));
    JobRepository repo = JobRepository.getInstance();
    repo.deleteAllPostings();
    repo.postJob(recruiter1, job1);
    repo.postJob(recruiter1, job2);
    repo.postJob(recruiter2, job3);
    // get back from repo
    Jobs jobs = repo.getJobsPostedBy(recruiter1);
    view.displayRecruiterJobs(recruiter1, jobs);
    
    jobs = repo.getPostedJobs();
    Iterator<Job> iterator = jobs.getIterator();
    int i = 0;
    view.displayAllJobsStart();
    AccountManager manager = AccountManager.getInstance();
    while (iterator.hasNext())
    {
      Job job = iterator.next();
      view.displayAllJobsItem(job, repo.GetRecruiterByJob(job));
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
    view.displayAllJobsEnd();

    view.displaySavedJobsStart(seeker1);
    jobs = manager.getViewedJobs(seeker1);
    iterator = jobs.getIterator();
    while (iterator.hasNext())
    {
      Job jobx = iterator.next();
      Recruiter recruiterx = repo.GetRecruiterByJob(jobx);
      Resume resumex = ResumeCreator.createResume(seeker1);
      ApplicationProcessor.applyToJob(seeker1, jobx, recruiterx, resumex);
      view.displaySavedJobsItem(jobx);
    }
    view.displaySavedJobsEnd();

    view.displaySavedJobsStart(seeker2);
    jobs = manager.getViewedJobs(seeker2);
    iterator = jobs.getIterator();
    while (iterator.hasNext())
    {
      Job jobx = iterator.next();
      view.displaySavedJobsItem(jobx);
    }
    view.displaySavedJobsEnd();

    ApplicationProcessor.applyToJob(seeker2, job2, recruiter1, null);
    ApplicationProcessor.applyToJob(seeker2, job3, recruiter2, null);
    ApplicationRepository apprepo = ApplicationRepository.getInstance();
    
    view.displayAppliedToJobsStart(seeker1);
    ApplicationRepository.Filter filter = apprepo.createFilter(null, null, seeker1, null);
    Applications apps = apprepo.getApplications(filter);
    Iterator<Application> appiter = apps.getIterator();
    while (appiter.hasNext())
    {
      Application appx = appiter.next();
      view.displayAppliedToJobsItem(appx);
    }
    view.displayAppliedToJobsEnd();

    view.displayAppliedToJobsStart(seeker2);
    filter = apprepo.createFilter(null, null, seeker2, null);
    apps = apprepo.getApplications(filter);
    appiter = apps.getIterator();
    while (appiter.hasNext())
    {
      Application appx = appiter.next();
      view.displayAppliedToJobsItem(appx);
    }
    view.displayAppliedToJobsEnd();

    Date date = new Date();
    filter = apprepo.createFilter(null, recruiter1, null, date);
    apps = apprepo.getApplications(filter);
    appiter = apps.getIterator();
    Jobseekers seekers = Application.retrieveJobSeekers(apps);
    view.displayJobSeekersByDate(recruiter1, date, seekers);
    
    filter = apprepo.createFilter(job1, recruiter1, null, null);
    apps = apprepo.getApplications(filter);
    seekers = Application.retrieveJobSeekers(apps);
    view.displayJobSeekersByJob(recruiter1, job1, seekers);

    filter = apprepo.createFilter(job2, recruiter1, null, date);
    apps = apprepo.getApplications(filter);
    seekers = Application.retrieveJobSeekers(apps);
    view.displayJobSeekersByJobDate(recruiter1, job1, date, seekers);

    filter = apprepo.createFilter(job3, recruiter2, null, date);
    apps = apprepo.getApplications(filter);
    seekers = Application.retrieveJobSeekers(apps);
    view.displayJobSeekersByJobDate(recruiter1, job1, date, seekers);

    filter = apprepo.createFilter(job3, null, null, null);
    apps = apprepo.getApplications(filter);
    view.displayAggregateApplicationsByJob(job3, apps.getCount());

    filter = apprepo.createFilter(null, recruiter1, null, null);
    apps = apprepo.getApplications(filter);
    view.displayAggregateApplicationsByJob(job3, apps.getCount());

    view.reportByCSVStart();
    apps = apprepo.getApplications(null);
    appiter = apps.getIterator();
    while (appiter.hasNext())
    {
      Application appx = appiter.next();
      view.reportByCSVItem(appx);
    }
    view.reportByCSVEnd();

    view.reportByHtmlStart();
    appiter = apps.getIterator();
    while (appiter.hasNext())
    {
      Application appx = appiter.next();
      view.reportByHtmlItem(appx);
    }
    view.reportByHtmlEnd();

  }

}
