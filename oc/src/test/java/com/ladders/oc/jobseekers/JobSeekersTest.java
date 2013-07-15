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
  static JobSeekers seekers = null;
  static JobSeeker seeker1 = null;
  static JobSeeker seeker2 = null;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception
  {
    seekers = new JobSeekers();
    seeker1 = new JobSeeker(new Name("David"));
    seeker2 = new JobSeeker(new Name("Adam"));
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

  @Test(expected = IllegalArgumentException.class)
  public void testAddWithNullArgument()
  {
    seekers.add(null);
  }

  @Test
  public void testAdd()
  {
    seekers.add(seeker1);
    assertEquals("JobSeekers count should go up by one after add", seekers.getCount(), 1); // assuming single-threaded testing
    seekers.add(seeker2);
    assertTrue("Add must enter jobseeker correcty", seekers.contains(seeker1));
    assertTrue("Add must enter jobseeker correcty", seekers.contains(seeker2));
    seekers.deleteAll();
    assertEquals("JobSeekers count should be zero after deleteAll", seekers.getCount(), 0);
  }
  

}
