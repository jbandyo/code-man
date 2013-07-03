package com.ladders.oc;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ladders.oc.jobs.Job;
import com.ladders.oc.jobs.JobFactory;
import com.ladders.oc.jobs.JobTitle;

public class JobPostingsTest
{

  @BeforeClass
  public static void setUpBeforeClass() throws Exception
  {}

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
  public void testJobPostingsConstructor()
  {
    JobPostings jobs = new JobPostings();
    assertNotNull("JobPostings constructor must create the object", jobs);
    assertEquals("Newly constructed JobPostings instance should have zero size", jobs.getCount(), 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddWithNullArgument()
  {
    JobPostings jobs = new JobPostings();
    jobs.add(null);
  }

  @Test
  public void testAdd()
  {
    JobPostings jobs = new JobPostings();
    Job job = JobFactory.createATSJob(new JobTitle("Developer"));
    Date now = new Date();
    JobPosting posting = new JobPosting(job, now);
    jobs.add(posting);
    assertEquals("Posting count should go up by one after add", jobs.getCount(), 1); // assuming single-threaded testing
    Job job2 = JobFactory.createJReqJob(new JobTitle("Architect"));
    JobPosting posting2 = new JobPosting(job2, now);
    jobs.add(posting2);
    List<String> titles = jobs.getDisplayTextList();
    assertTrue("add must enter job posting correcty", titles.contains("Developer"));
    assertTrue("add must enter job posting correcty", titles.contains("Architect"));
    jobs.deleteAll();
    assertEquals("Posting count should be zero after deleteAll", jobs.getCount(), 0);
  }

}
