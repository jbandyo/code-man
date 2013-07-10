package com.ladders.oc.jobseekers;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ladders.oc.Name;
import com.ladders.oc.jobs.*;
import com.ladders.oc.jobseekers.*;
import com.ladders.oc.recruiters.*;

public class AccountManagerTest
{
  static AccountManager manager = null;
  static JobSeeker seeker1 = null;
  static JobSeeker seeker2 = null;
  static Recruiter recruiter1 = null;
  static Recruiter recruiter2 = null;
  static PostedJob postedJob1 = null;
  static PostedJob postedJob2 = null;
  static PostedJob postedJob3 = null;
  
  @BeforeClass
  public static void setUpBeforeClass() throws Exception
  {
    manager = AccountManager.getInstance();
    seeker1 = new JobSeeker(new Name("David"));
    seeker2 = new JobSeeker(new Name("Adam"));
    Job job1 = JobFactory.createATSJob(new JobTitle("Developer"));
    Job job2 = JobFactory.createATSJob(new JobTitle("Architect"));
    Job job3 = JobFactory.createATSJob(new JobTitle("Programmer"));
    recruiter1 = new Recruiter(new Name("John"));
    recruiter2 = new Recruiter(new Name("Henry"));
    postedJob1 = new PostedJob(recruiter1, job1);
    postedJob2 = new PostedJob(recruiter2, job2);
    postedJob3 = new PostedJob(recruiter2, job3);
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception
  {}

  @Before
  public void setUp() throws Exception
  {}

  @After
  public void tearDown() throws Exception
  {
    manager.deleteAllViewedJobs();
  }

  @Test
  public void testInstance()
  {
    assertNotNull("getInstnace must return the object", manager);
  }

  @Test
  public void testSaveViewedJob()
  {
    boolean result;
    result = manager.saveViewedJob(seeker1, postedJob1);
    assertTrue("SaveViewedJob must return true when successful", result);
    // same job by same jobseeker - can not be saved again
    result = manager.saveViewedJob(seeker1, postedJob1);
    assertFalse("Same job can not be saved more than once", result);
    // different jobseeker can save the same job
    result = manager.saveViewedJob(seeker2, postedJob1);
    assertTrue("AddJob must return true when successful", result);
  }
  
  @Test
  public void testGetViewedJobs()
  {
    PostedJobs jobs = manager.getViewedJobs(seeker1);
    assertNull("GetViewedJobs must return null for a jobseeker who has not saved any job ", jobs);    
    manager.saveViewedJob(seeker1, postedJob1);
    manager.saveViewedJob(seeker1, postedJob2);
    manager.saveViewedJob(seeker2, postedJob3);
    jobs = manager.getViewedJobs(seeker1);
    assertNotNull("GetViewedJobs must not return null when the repository is not empty", jobs);
    assertEquals("GetViewedJobs for a job seeker must return all jobs saved by the job seeker", jobs.getCount(), 2);
    assertTrue("GetViewedJobs must contain posted job", jobs.contains(postedJob1));
    assertTrue("GetViewedJobs must contain posted job", jobs.contains(postedJob2));
    jobs = manager.getViewedJobs(seeker2);
    assertEquals("GetViewedJobs for a job seeker must return all jobs saved by the job seeker", jobs.getCount(), 1);
    assertTrue("GetViewedJobs must contain posted job", jobs.contains(postedJob3));
  }


}