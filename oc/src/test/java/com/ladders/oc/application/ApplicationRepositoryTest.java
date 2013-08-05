package com.ladders.oc.application;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ladders.oc.*;
import com.ladders.oc.jobs.*;
import com.ladders.oc.jobseekers.*;
import com.ladders.oc.recruiters.*;

public class ApplicationRepositoryTest
{
  static ApplicationRepository repo = null;
  static Recruiter recruiter1 = null;
  static Recruiter recruiter2 = null;
  static Jobseeker seeker1 = null;
  static Jobseeker seeker2 = null;
  static Job job1 = null;
  static Job job2 = null;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception
  {
    repo = ApplicationRepository.getInstance();
    repo.deleteAllApplications();
    recruiter1 = new Recruiter(new Name("John"));
    recruiter2 = new Recruiter(new Name("Henry"));
    seeker1 = new Jobseeker(new Name("David"));
    seeker2 = new Jobseeker(new Name("Adam"));
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
  {
    repo.deleteAllApplications();
  }

  @Test
  public void testInstance()
  {
    assertNotNull("GetInstnace must return the object", repo);
    assertEquals("Newly constructed JobRepository instance should have zero size", repo.getNumberOfApplications(), 0);
  }
  
  @Test
  public void testAddApplcation()
  {
    boolean result;
    Application app1 = new Application(job1, recruiter1, seeker1);
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

  @Test
  public void testCreateFilter()
  {
    Date date1 = new Date();
    ApplicationRepository.Filter filter = repo.createFilter(job1, recruiter1, seeker1, date1);
    assertNotNull("GetInstnace must return the object", filter);
    assertEquals("Filter field should be set correctly with set methods", filter.job, job1);
    assertEquals("Filter field should be set correctly with set methods", filter.recruiter, recruiter1);
    assertEquals("Filter field should be set correctly with set methods", filter.seeker, seeker1);
    assertEquals("Filter field should be set correctly with set methods", filter.date, date1);    
  }
  
  @Test
  public void testGetApplications()
  {
    Application app1 = new Application(job1, recruiter1, seeker1);
    repo.addApplication(app1);
    Date date1 = new Date();
    ApplicationRepository.Filter filter = repo.createFilter(job1, recruiter1, seeker1, date1);
    assertNotNull("GetInstnace must return the object", filter);
    Applications apps = repo.getApplications(filter);
    assertEquals("GetApplications should return correct number of Applications", apps.getCount(), 1);
    Application app2 = new Application(job1, recruiter2, seeker2);
    repo.addApplication(app2);
    filter = repo.createFilter(job1, null, null, null);
    apps = repo.getApplications(filter);
    assertEquals("GetApplications should return correct number of Applications", apps.getCount(), 2);
    filter = repo.createFilter(null, recruiter1, null, null);
    apps = repo.getApplications(filter);
    assertEquals("GetApplications should return correct number of Applications", apps.getCount(), 1);
    filter = repo.createFilter(null, null, seeker1, null);
    apps = repo.getApplications(filter);
    assertEquals("GetApplications should return correct number of Applications", apps.getCount(), 1);
    filter = repo.createFilter(null, null, null, date1);
    apps = repo.getApplications(filter);
    assertEquals("GetApplications should return correct number of Applications", apps.getCount(), 2);
  }
  
  @Test
  public void testGetAllApplications()
  {
    Application app1 = new Application(job1, recruiter1, seeker1);
    repo.addApplication(app1);
    Application app2 = new Application(job1, recruiter1, seeker2);
    repo.addApplication(app2);
    Application app3 = new Application(job2, recruiter2, seeker2);
    repo.addApplication(app3);
    Applications apps = repo.getAllApplications();
    assertEquals("GetApplications should return correct number of Applications", apps.getCount(), 3);   
  }
}
