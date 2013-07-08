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
    assertNotNull("getInstnace must return the object", savedList);
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
    savedList.addJob(seeker1, postedJob1);
    assertEquals("List count should go up by one after saveJob", savedList.getNumberOfLists(), 1); // assuming single-threaded testing
    savedList.deleteAllLists();
    assertEquals("List count should be zero after deleteAllLists", savedList.getNumberOfLists(), 0);
  }

  @Test
  public void testGetJobList()
  {
    PostedJobs jobs = savedList.getJobList(seeker1);
    assertEquals("List count for a job seeker who did not save jobs must be zero", savedList.getNumberOfLists(), 0);    
    savedList.addJob(seeker1, postedJob1);
    savedList.addJob(seeker1, postedJob2);
    savedList.addJob(seeker2, postedJob3);
    jobs = savedList.getJobList(seeker1);
    assertEquals("getJobList for a job seeker must return all jobs saved by the job seeker", jobs.getCount(), 2);
  }
  
}
