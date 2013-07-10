package com.ladders.oc.application;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ladders.oc.Name;
import com.ladders.oc.jobs.Job;
import com.ladders.oc.jobs.JobFactory;
import com.ladders.oc.jobs.JobTitle;
import com.ladders.oc.jobseekers.JobSeeker;
import com.ladders.oc.recruiters.Recruiter;

public class ApplicationsTest
{
  static Recruiter recruiter1 = null;
  static Recruiter recruiter2 = null;
  static JobSeeker seeker1 = null;
  static JobSeeker seeker2 = null;
  static Job job1 = null;
  static Job job2 = null;
  static Application app1 = null;

  static Applications apps = null;
  
  @BeforeClass
  public static void setUpBeforeClass() throws Exception
  {
    apps = new Applications();
    recruiter1 = new Recruiter(new Name("John"));
    recruiter2 = new Recruiter(new Name("Henry"));
    seeker1 = new JobSeeker(new Name("David"));
    seeker2 = new JobSeeker(new Name("Adam"));
    job1 = JobFactory.createATSJob(new JobTitle("Developer"));
    job2 = JobFactory.createATSJob(new JobTitle("Architect"));
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception
  {}

  @Before
  public void setUp() throws Exception
  {}

  @After
  public void tearDown() throws Exception
  {}

  @Test
  public void testConstructor()
  {
    assertNotNull("Applications constructor must create the object", apps);
    assertEquals("Newly constructed Applications instance should have zero size", apps.getCount(), 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddWithNullArgument()
  {
    apps.add(null);
  }

  @Test
  public void testAdd()
  {
    app1 = new Application(job1, recruiter1, seeker1);
    apps.add(app1);
    assertEquals("Application count should go up by one after add", apps.getCount(), 1); // assuming single-threaded testing
    apps.deleteAll();
    assertEquals("Application count should be zero after deleteAll", apps.getCount(), 0);
  }


}
