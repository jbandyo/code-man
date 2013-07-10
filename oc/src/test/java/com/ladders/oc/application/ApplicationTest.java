package com.ladders.oc.application;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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


}


