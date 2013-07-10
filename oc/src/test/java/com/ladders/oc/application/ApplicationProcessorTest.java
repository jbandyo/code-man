package com.ladders.oc.application;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ladders.oc.*;
import com.ladders.oc.jobs.*;
import com.ladders.oc.jobseekers.*;
import com.ladders.oc.recruiters.*;
import com.ladders.oc.resume.*;

public class ApplicationProcessorTest
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
  public void testApplyToJob()
  {
    // ATS Job
    JobSeeker seeker1 = new JobSeeker(new Name("David"));
    Recruiter recruiter1 = new Recruiter(new Name("John"));
    Job job1 = JobFactory.createATSJob(new JobTitle("Developer"));
    PostedJob postedJob1 = new PostedJob(recruiter1, job1);
    ApplicationProcessor.applyToJob(seeker1, postedJob1, null);
    Job job2 = JobFactory.createJReqJob(new JobTitle("Programmer"));
    Resume resume2 = ResumeCreator.createResume(seeker1);
    PostedJob postedJob2 = new PostedJob(recruiter1, job2);
    ApplicationProcessor.applyToJob(seeker1, postedJob2, resume2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testApplyToJobWithWrongInput()
  {
    JobSeeker seeker1 = new JobSeeker(new Name("David"));
    Recruiter recruiter1 = new Recruiter(new Name("John"));
    Job job1 = JobFactory.createJReqJob(new JobTitle("Developer"));
    PostedJob postedJob1 = new PostedJob(recruiter1, job1);
    Resume resume1 = ResumeCreator.createResume(seeker1);
    ApplicationProcessor.applyToJob(null, postedJob1, resume1);
    ApplicationProcessor.applyToJob(seeker1, null, resume1);
    ApplicationProcessor.applyToJob(seeker1, postedJob1, null);
  }
}
  