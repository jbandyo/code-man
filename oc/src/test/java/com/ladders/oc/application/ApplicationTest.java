package com.ladders.oc.application;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import com.ladders.oc.*;
import com.ladders.oc.jobs.*;
import com.ladders.oc.jobseekers.*;
import com.ladders.oc.recruiters.*;

public class ApplicationTest
{

  @Test
  public void testConstructor()
  {
    Job job = JobFactory.createATSJob(new JobTitle("Developer"));
    Recruiter recruiter = new Recruiter(new Name("John"));
    JobSeeker seeker = new JobSeeker(new Name("David"));
    Application app = new Application(job, recruiter, seeker);
    assertNotNull("Application constructor must create the object", app);
  }

  @Test
  public void testEquality()
  {
    Recruiter recruiter1 = new Recruiter(new Name("John"));
    Recruiter recruiter2 = new Recruiter(new Name("Henry"));
    JobSeeker seeker1 = new JobSeeker(new Name("David"));
    JobSeeker seeker2 = new JobSeeker(new Name("Adam"));
    Job job1 = JobFactory.createATSJob(new JobTitle("Developer"));
    Job job2 = JobFactory.createATSJob(new JobTitle("Architect"));
    Application app1 = new Application(job1, recruiter1, seeker1);
    assertEquals("Application must be equal to itself", app1, app1); 
    Application app2 = new Application(job1, recruiter1, seeker1);
    assertEquals("Same Job and same JobSeeker means same Application", app1, app2);
    app2 = new Application(job1, recruiter2, seeker1);
    assertEquals("Same Job and same JobSeeker means same Application", app1, app2);
    app2 = new Application(job1, recruiter1, seeker2);
    assertNotEquals("Different Job and JobSeeker means different Application", app1, app2);
    app2 = new Application(job2, recruiter1, seeker1);
    assertNotEquals("Different Job and JobSeeker means different Application", app1, app2);
  }

  @Test
  public void testFields()
  {
    Job job = JobFactory.createATSJob(new JobTitle("Developer"));
    Recruiter recruiter = new Recruiter(new Name("John"));
    JobSeeker seeker = new JobSeeker(new Name("David"));
    Application app = new Application(job, recruiter, seeker);
    assertTrue("Application field test should work correctly", app.containsJob(job));
    assertTrue("Application field test should work correctly", app.containsRecruiter(recruiter));
    assertTrue("Application field test should work correctly", app.containsJobSeeker(seeker));
    Date now = new Date();
    boolean result = app.containsDate(now);
    if (!result)
    {
      // take care of date rollover
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(now);
      calendar.add(Calendar.DATE, -1); // prev day
      result = app.containsDate(now);
    }
    assertTrue("Application field test should work correctly", app.containsDate(now));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRetrieveJobSeekerWithNullInput()
  {
    JobSeekers seekers = Application.retrieveJobSeekers(null);    
  }

  @Test
  public void testRetrieveJobSeeker()
  {
    Job job = JobFactory.createATSJob(new JobTitle("Developer"));
    Recruiter recruiter = new Recruiter(new Name("John"));
    JobSeeker seeker1 = new JobSeeker(new Name("Tom"));
    JobSeeker seeker2 = new JobSeeker(new Name("Dick"));
    JobSeeker seeker3 = new JobSeeker(new Name("Harry"));
    Applications apps = new Applications();
    Application app1 = new Application(job, recruiter, seeker1);
    apps.add(app1);
    Application app2 = new Application(job, recruiter, seeker2);
    apps.add(app2);
    Application app3 = new Application(job, recruiter, seeker3);
    apps.add(app3);
    JobSeekers seekers = Application.retrieveJobSeekers(apps);
    assertNotNull("RetrieveJobSeekers must return the JobSeekers object", seekers);
    assertEquals("RetrieveJobSeekers must return correct number of JobSeekers", seekers.getCount(), 3);
    assertTrue("JobSeeker set must contain the JobSeeker inserted", seekers.contains(seeker1));
    assertTrue("JobSeeker set must contain the JobSeeker inserted", seekers.contains(seeker2));
    assertTrue("JobSeeker set must contain the JobSeeker inserted", seekers.contains(seeker3));    
  }

}


