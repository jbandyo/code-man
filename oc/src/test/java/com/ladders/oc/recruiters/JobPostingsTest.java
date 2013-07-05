package com.ladders.oc.recruiters;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ladders.oc.jobs.*;

public class JobPostingsTest
{
  static JobPostings jobs = null;
  static Date now = null;
  static Job job1 = null;
  static Job job2 = null;
  static JobPosting posting1 = null;
  static JobPosting posting2 = null;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception
  {
    jobs = new JobPostings();
    Date now = new Date();
    job1 = JobFactory.createATSJob(new JobTitle("Developer"));
    job2 = JobFactory.createJReqJob(new JobTitle("Architect"));
    posting1 = new JobPosting(job1, now);
    posting2 = new JobPosting(job2, now);
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
    assertNotNull("JobPostings constructor must create the object", jobs);
    assertEquals("Newly constructed JobPostings instance should have zero size", jobs.getCount(), 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddWithNullArgument()
  {
    jobs.add(null);
  }

  @Test
  public void testAdd()
  {
    jobs.add(posting1);
    assertEquals("Posting count should go up by one after add", jobs.getCount(), 1); // assuming single-threaded testing
    jobs.add(posting2);
    List<String> titles = jobs.getDisplayTextList();
    assertTrue("add must enter job posting correcty", titles.contains("Developer"));
    assertTrue("add must enter job posting correcty", titles.contains("Architect"));
    jobs.deleteAll();
    assertEquals("Posting count should be zero after deleteAll", jobs.getCount(), 0);
  }

  @Test
  public void testIterator()
  {
    Iterator<JobPosting> iterator = jobs.getIterator();
    assertFalse("Iterator should have zero items in an empty JobPostings", iterator.hasNext());      
    jobs.add(posting1);
    jobs.add(posting2);
    iterator = jobs.getIterator();
    assertEquals("Iterator should iterate in the same order as insertions", iterator.next(), posting1);
    assertEquals("Iterator should iterate in the same order as insertions", iterator.next(), posting2);      
  }
  
}
