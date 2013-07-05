package com.ladders.oc.jobseekers;

import static org.junit.Assert.*;

import java.util.Date;

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
import com.ladders.oc.jobseekers.JobSeekerSavedLists;
import com.ladders.oc.recruiters.JobPosting;
import com.ladders.oc.recruiters.JobPostings;

public class JobSeekerSavedListsTest
{
  static JobSeekerSavedLists savedList = null;
  static JobSeeker seeker1 = null;
  static JobSeeker seeker2 = null;
  static JobPosting posting1 = null;
  static JobPosting posting2 = null;
  static JobPosting posting3 = null;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception
  {
    savedList = JobSeekerSavedLists.getInstance();
    seeker1 = new JobSeeker(new Name("David"));
    seeker2 = new JobSeeker(new Name("Adam"));
    Date now = new Date();
    Job job1 = JobFactory.createATSJob(new JobTitle("Developer"));
    posting1 = new JobPosting(job1, now);
    Job job2 = JobFactory.createATSJob(new JobTitle("Architect"));
    posting2 = new JobPosting(job2, now);
    Job job3 = JobFactory.createATSJob(new JobTitle("Programmer"));
    posting3 = new JobPosting(job3, now);
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
    savedList.saveJob(null, null);
    savedList.saveJob(seeker1, null);
    savedList.saveJob(null, posting1);
  }

  @Test
  public void testSaveJob()
  {
    savedList.saveJob(seeker1, posting1);
    assertEquals("List count should go up by one after saveJob", savedList.getNumberOfLists(), 1); // assuming single-threaded testing
    savedList.deleteAllLists();
    assertEquals("List count should be zero after deleteAllLists", savedList.getNumberOfLists(), 0);
  }

  @Test
  public void testGetJobList()
  {
    JobPostings jobs = savedList.getJobList(seeker1);
    assertEquals("List count for a job seeker who did not save jobs must be zero", savedList.getNumberOfLists(), 0);    
    savedList.saveJob(seeker1, posting1);
    savedList.saveJob(seeker1, posting2);
    savedList.saveJob(seeker2, posting3);
    jobs = savedList.getJobList(seeker1);
    assertEquals("getJobList for a job seeker must return all jobs saved by the job seeker", jobs.getCount(), 2);
  }
  
}
