package com.ladders.oc.jobseekers;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ladders.oc.Name;

public class JobSeekersTest
{
  static Jobseekers seekers = null;
  static Jobseeker seeker1 = null;
  static Jobseeker seeker2 = null;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception
  {
    seekers = new Jobseekers();
    seeker1 = new Jobseeker(new Name("David"));
    seeker2 = new Jobseeker(new Name("Adam"));
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
    seekers.deleteAll();
  }

  @Test
  public void testConstructor()
  {
    assertNotNull("JobSeekers constructor must create the object", seekers);
    assertEquals("Newly constructed JobSeekers instance should have zero size", seekers.getCount(), 0);
  }

  @Test
  public void testAdd()
  {
    assertEquals("JobSeekers count should be zero before test", seekers.getCount(), 0);
    seekers.add(seeker1);
    assertEquals("JobSeekers count should go up by one after add", seekers.getCount(), 1);
    seekers.add(seeker2);
    assertTrue("Add must enter jobseeker correcty", seekers.contains(seeker1));
    assertTrue("Add must enter jobseeker correcty", seekers.contains(seeker2));
    seekers.deleteAll();
    assertEquals("JobSeekers count should be zero after deleteAll", seekers.getCount(), 0);
  }
  

}
