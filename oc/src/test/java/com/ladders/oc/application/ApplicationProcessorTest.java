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
import com.ladders.oc.postedjobs.JobRepository;
import com.ladders.oc.recruiters.*;
import com.ladders.oc.resume.*;

public class ApplicationProcessorTest
{
  private static Job jobA;
  private static Job jobR;
  private static Jobseeker seeker1;
  private static Jobseeker seeker2;
  private static JobRepository jobRepo = null;
  private static Recruiter recruiter1 = null;
 
  @BeforeClass
  public static void setUpBeforeClass() throws Exception
  {
    jobRepo = JobRepository.getInstance();
    recruiter1 = new Recruiter(new Name("John"));
    jobA = JobFactory.createATSJob(new JobTitle("Developer"));
    jobR = JobFactory.createJReqJob(new JobTitle("Programmer"));
    jobRepo.postJob(recruiter1, jobA);
    jobRepo.postJob(recruiter1, jobR);
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
    jobRepo.deleteAllPostings();
  }

  @Test
  public void testApplyToJob()
  {
    // ATS Job
    ApplicationProcessor.applyToJob(seeker1, jobA, null);
    // jReq job
    Resume resume2 = ResumeCreator.createResume(seeker1);
    ApplicationProcessor.applyToJob(seeker1, jobR, resume2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testApplyToJobWithWrongInput()
  {
    Jobseeker seeker1 = new Jobseeker(new Name("David"));
    Resume resume1 = ResumeCreator.createResume(seeker1);
    // no resume
    ApplicationProcessor.applyToJob(seeker1, jobR, null);
    // wrong resume
    ApplicationProcessor.applyToJob(seeker2, jobR, resume1);
  }
}
  