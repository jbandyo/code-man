package com.ladders.oc.jobs;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JobsTest
{
  static Jobs jobs = null;
  static Date now = null;
  static Job job1 = null;
  static Job job2 = null;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception
  {
    jobs = new Jobs();
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

  @Test
  public void testAdd()
  {
    assertEquals("Posting count should be zero before test", jobs.getCount(), 0);
    jobs.add(job1);
    assertEquals("Posting count should go up by one after add", jobs.getCount(), 1);
    jobs.add(job2);
    assertTrue("Add must enter job posting correcty", jobs.contains(job1));
    assertTrue("Add must enter job posting correcty", jobs.contains(job2));
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
    Set<Job> jobset = new HashSet<Job>();
    jobset.add(job1);
    jobset.add(job2);
    assertTrue("Iterator should iterate through all items", jobset.contains(iterator.next()));
    assertTrue("Iterator should iterate through all items", jobset.contains(iterator.next()));      
    assertFalse("Iterator should return same number of items as inserted", iterator.hasNext());      
  }

}
