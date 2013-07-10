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

  @Test
  public void testEquality()
  {
    Job job1 = JobFactory.createATSJob(new JobTitle("Developer"));
    Recruiter recruiter1 = new Recruiter(new Name("John"));
    Job job2 = JobFactory.createATSJob(new JobTitle("Programmer"));
    Recruiter recruiter2 = new Recruiter(new Name("Henry"));
    PostedJob postedJob1 = new PostedJob(recruiter1, job1);
    assertEquals("PostedJob must be equal to itself", postedJob1, postedJob1); 
    PostedJob postedJob2 = new PostedJob(recruiter1, job1);
    assertEquals("Same Job and same Recruiter means same PostedJob", postedJob1, postedJob2);
    postedJob2 = new PostedJob(recruiter1, job2);
    assertNotEquals("Different Job means different PostedJob", postedJob1, postedJob2);
    postedJob2 = new PostedJob(recruiter2, job1);
    assertEquals("Same Job means same PostedJob", postedJob1, postedJob2);  
  }
}
