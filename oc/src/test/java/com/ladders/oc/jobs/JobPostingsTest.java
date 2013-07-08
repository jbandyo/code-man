package com.ladders.oc.jobs;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ladders.oc.jobs.*;
import com.ladders.oc.recruiters.JobPosting;

public class JobPostingsTest
{
  static JobPostings jobs = null;
  static Date now = null;
  static Job job1 = null;
  static Job job2 = null;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception
  {
    jobs = new JobPostings();
    Date now = new Date();
    job1 = JobFactory.createATSJob(new JobTitle("Developer"));
    job2 = JobFactory.createJReqJob(new JobTitle("Architect"));
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
    jobs.add(job1);
    assertEquals("Posting count should go up by one after add", jobs.getCount(), 1); // assuming single-threaded testing
    jobs.add(job2);
    List<String> titles = jobs.getDisplayTextList();
    assertTrue("add must enter job posting correcty", titles.contains("Developer"));
    assertTrue("add must enter job posting correcty", titles.contains("Architect"));
    jobs.deleteAll();
    assertEquals("Posting count should be zero after deleteAll", jobs.getCount(), 0);
  }

  @Test
  public void testIterator()
  {
    Iterator<Job> iterator = jobs.getIterator();
    assertFalse("Iterator should have zero items in an empty JobPostings", iterator.hasNext());      
    jobs.add(job1);
    jobs.add(job2);
    iterator = jobs.getIterator();
    assertEquals("Iterator should iterate in the same order as insertions", iterator.next(), job1);
    assertEquals("Iterator should iterate in the same order as insertions", iterator.next(), job2);      
  }
  
}
