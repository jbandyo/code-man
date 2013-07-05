package com.ladders.oc.recruiters;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ladders.oc.Name;
import com.ladders.oc.jobs.Job;
import com.ladders.oc.jobs.JobFactory;
import com.ladders.oc.jobs.JobTitle;

public class PostedJobsTest
{
  static PostedJobs jobs = null;
  static Date now = null;
  static Job job1 = null;
  static Job job2 = null;
  static JobPosting posting1 = null;
  static JobPosting posting2 = null;
  static Recruiter recruiter1 = null;
  static Recruiter recruiter2 = null;
  static PostedJob postedJob1 = null;
  static PostedJob postedJob2 = null;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception
  {
    jobs = new PostedJobs();
    Date now = new Date();
    job1 = JobFactory.createATSJob(new JobTitle("Developer"));
    job2 = JobFactory.createJReqJob(new JobTitle("Architect"));
    posting1 = new JobPosting(job1, now);
    posting2 = new JobPosting(job2, now);
    recruiter1 = new Recruiter(new Name("John"));
    recruiter2 = new Recruiter(new Name("Henry"));
    postedJob1 = new PostedJob(recruiter1, posting1);
    postedJob2 = new PostedJob(recruiter2, posting2);
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
    jobs.deleteAll();
  }

  @Test
  public void testConstructor()
  {
    assertNotNull("PostedJobs constructor must create the object", jobs);
    assertEquals("Newly constructed PostedJobs instance should have zero size", jobs.getCount(), 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddWithNullArgument()
  {
    jobs.add(null);
  }

  @Test
  public void testAdd()
  {
    jobs.add(postedJob1);
    assertEquals("Job count should go up by one after add", jobs.getCount(), 1); // assuming single-threaded testing
    //jobs.add(postedJob2);
    //List<String> titles = jobs.getDisplayTextList();
    //assertTrue("add must enter job posting correcty", titles.contains("Developer"));
    //assertTrue("add must enter job posting correcty", titles.contains("Architect"));
    jobs.deleteAll();
    assertEquals("Job count should be zero after deleteAll", jobs.getCount(), 0);
  }

  @Test
  public void testIterator()
  {
    Iterator<PostedJob> iterator = jobs.getIterator();
    assertFalse("Iterator should have zero items in an empty PostedJobs", iterator.hasNext());      
    jobs.add(postedJob1);
    jobs.add(postedJob2);
    iterator = jobs.getIterator();
    assertEquals("Iterator should iterate in the same order as insertions", iterator.next(), postedJob1);
    assertEquals("Iterator should iterate in the same order as insertions", iterator.next(), postedJob2);      
  }

}
