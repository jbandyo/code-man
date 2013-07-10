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

public class ApplicationRepositoryTest
{
  static ApplicationRepository repo = null;
  static Recruiter recruiter1 = null;
  static Recruiter recruiter2 = null;
  static JobSeeker seeker1 = null;
  static JobSeeker seeker2 = null;
  static Job job1 = null;
  static Job job2 = null;
  static Application app1 = null;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception
  {
    repo = ApplicationRepository.getInstance();
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
  public void testInstance()
  {
    assertNotNull("getInstnace must return the object", repo);
    assertEquals("Newly constructed JobRepository instance should have zero size", repo.getNumberOfApplications(), 0);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testPostJobWithNullArgument()
  {
    repo.addApplication(null);
  }

  @Test
  public void testAddApplcation()
  {
    boolean result;
    app1 = new Application(job1, recruiter1, seeker1);
    result = repo.addApplication(app1);
    assertTrue("AddApplication must return true when successful", result);
    assertEquals("Application count should go up by one after adding a new application", repo.getNumberOfApplications(), 1); // assuming single-threaded testing
    // same application can not be added again
    result = repo.addApplication(app1);
    assertFalse("Same application can not be added more than once", result);
    // same job by different jobseeker is ok
    app1 = new Application(job1, recruiter1, seeker2);
    result = repo.addApplication(app1);
    assertTrue("Same job different jobseeker is OK", result);
    // different job by same jobseeker is OK
    app1 = new Application(job2, recruiter1, seeker1);
    result = repo.addApplication(app1);
    assertTrue("Different job by same jobseeker is OK", result);    
    repo.deleteAllApplications();
    assertEquals("Application count should be zero after deleteAllApplications", repo.getNumberOfApplications(), 0);
  }


}
