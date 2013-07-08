package com.ladders.oc.recruiters;

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

public class PostedJobTest
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
  public void testConstructor()
  {
    Job job = JobFactory.createATSJob(new JobTitle("Developer"));
    Recruiter recruiter = new Recruiter(new Name("John"));
    PostedJob postedJob = new PostedJob(recruiter, job);
    assertNotNull("PostedJob constructor must create the object", postedJob);
    assertEquals("PostedJob must preserve the recruiter", postedJob.getRecruiter(), recruiter); 
    assertEquals("PostedJob must preserve the job posting", postedJob.getPosting(), job); 
  }

}
