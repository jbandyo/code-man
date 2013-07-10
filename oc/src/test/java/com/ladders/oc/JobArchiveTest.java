package com.ladders.oc;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ladders.oc.jobs.*;
import com.ladders.oc.jobseekers.*;
import com.ladders.oc.recruiters.*;

public class JobArchiveTest
{
  static JobArchive<JobSeeker> savedList = null;
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
    savedList = new JobArchive<JobSeeker>();
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
  {
    savedList = null;
  }

  @Before
  public void setUp() throws Exception
  {}

  @After
  public void tearDown() throws Exception
  {
    savedList.deleteAllLists();
  }

  @Test
  public void testInstance()
  {
    assertNotNull("GetInstnace must return the object", savedList);
    assertEquals("Newly constructed JobSeekerSavedLists instance should have zero size", savedList.getNumberOfLists(), 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSaveJobWithNullArgument()
  {
    savedList.addJob(null, null);
    savedList.addJob(seeker1, null);
    savedList.addJob(null, postedJob1);
  }

  @Test
  public void testAddJob()
  {
    boolean result;
    result = savedList.addJob(seeker1, postedJob1);
    assertTrue("AddJob must return true when successful", result);
    assertEquals("List count should go up by one after a new jobseeker's addJob", savedList.getNumberOfLists(), 1); // assuming single-threaded testing
    // same job by same jobseeker - can not be saved again
    result = savedList.addJob(seeker1, postedJob1);
    assertFalse("Same job can not be saved more than once", result);
    // different jobseeker can save the same job
    result = savedList.addJob(seeker2, postedJob1);
    assertTrue("AddJob must return true when successful", result);
   
    savedList.deleteAllLists();
    assertEquals("List count should be zero after deleteAllLists", savedList.getNumberOfLists(), 0);
  }

  @Test
  public void testGetJobList()
  {
    PostedJobs jobs = savedList.getJobs(seeker1);
    assertNull("GetJobs must return null for a job seeker who did not save job", jobs);    
    savedList.addJob(seeker1, postedJob1);
    savedList.addJob(seeker1, postedJob2);
    savedList.addJob(seeker2, postedJob3);
    jobs = savedList.getJobs(seeker1);
    assertNotNull("GetJobs must not return null when the repository is not empty", jobs);
    assertEquals("GetJobs for a job seeker must return all jobs saved by the job seeker", jobs.getCount(), 2);
    assertTrue("GetJobs must contain posted job", jobs.contains(postedJob1));
    assertTrue("GetJobs must contain posted job", jobs.contains(postedJob2));
    jobs = savedList.getJobs(seeker2);
    assertEquals("GetJobs for a job seeker must return all jobs saved by the job seeker", jobs.getCount(), 1);
    assertTrue("GetJobs must contain posted job", jobs.contains(postedJob3));
  }
  
}
