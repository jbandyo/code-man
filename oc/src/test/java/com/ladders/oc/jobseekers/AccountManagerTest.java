package com.ladders.oc.jobseekers;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ladders.oc.Name;
import com.ladders.oc.jobs.*;
import com.ladders.oc.recruiters.*;

public class AccountManagerTest
{
  static AccountManager manager = null;
  static Jobseeker seeker1 = null;
  static Jobseeker seeker2 = null;
  static Recruiter recruiter1 = null;
  static Recruiter recruiter2 = null;
  static Job job1 = null;
  static Job job2 = null;
  static Job job3 = null;
  
  @BeforeClass
  public static void setUpBeforeClass() throws Exception
  {
    manager = AccountManager.getInstance();
    seeker1 = new Jobseeker(new Name("David"));
    seeker2 = new Jobseeker(new Name("Adam"));
    job1 = JobFactory.createATSJob(new JobTitle("Developer"));
    job2 = JobFactory.createATSJob(new JobTitle("Architect"));
    job3 = JobFactory.createATSJob(new JobTitle("Programmer"));
    recruiter1 = new Recruiter(new Name("John"));
    recruiter2 = new Recruiter(new Name("Henry"));
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
    result = manager.saveViewedJob(seeker1, job1);
    assertTrue("SaveViewedJob must return true when successful", result);
    // same job by same jobseeker - can not be saved again
    result = manager.saveViewedJob(seeker1, job1);
    assertFalse("Same job can not be saved more than once", result);
    // different jobseeker can save the same job
    result = manager.saveViewedJob(seeker2, job1);
    assertTrue("AddJob must return true when successful", result);
  }
  
  @Test
  public void testGetViewedJobs()
  {
    Jobs jobs = manager.getViewedJobs(seeker1);
    assertNull("GetViewedJobs must return null for a jobseeker who has not saved any job ", jobs);    
    manager.saveViewedJob(seeker1, job1);
    manager.saveViewedJob(seeker1, job2);
    manager.saveViewedJob(seeker2, job3);
    jobs = manager.getViewedJobs(seeker1);
    assertNotNull("GetViewedJobs must not return null when the repository is not empty", jobs);
    assertEquals("GetViewedJobs for a job seeker must return all jobs saved by the job seeker", jobs.getCount(), 2);
    assertTrue("GetViewedJobs must contain posted job", jobs.contains(job1));
    assertTrue("GetViewedJobs must contain posted job", jobs.contains(job2));
    jobs = manager.getViewedJobs(seeker2);
    assertEquals("GetViewedJobs for a job seeker must return all jobs saved by the job seeker", jobs.getCount(), 1);
    assertTrue("GetViewedJobs must contain posted job", jobs.contains(job3));
  }


}
