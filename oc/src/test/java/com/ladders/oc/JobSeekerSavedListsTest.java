package com.ladders.oc;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ladders.oc.jobs.Job;
import com.ladders.oc.jobs.JobFactory;
import com.ladders.oc.jobs.JobTitle;

public class JobSeekerSavedListsTest
{
  static JobSeekerSavedLists savedList = null;
  static JobSeeker seeker1 = null;
  static Job job1 = null;
  static Job job2 = null;
  static Job job3 = null;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception
  {
    savedList = JobSeekerSavedLists.getInstance();
    seeker1 = new JobSeeker(new Name("David"));
    job1 = JobFactory.createATSJob(new JobTitle("Developer"));
    job2 = JobFactory.createATSJob(new JobTitle("Architect"));
    job3 = JobFactory.createATSJob(new JobTitle("Programmer"));
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
  {}

  @Test
  public void testJobSeekerSavedListsInstance()
  {
    assertNotNull("getInstnace must return the object", savedList);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSaveJobsWithNullArgument()
  {
    savedList.SaveJob(null, null);
    savedList.SaveJob(seeker1, null);
    savedList.SaveJob(null, job1);
  }

}
