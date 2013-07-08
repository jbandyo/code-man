package com.ladders.oc;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ladders.oc.jobs.*;
import com.ladders.oc.recruiters.*;

public class JobRepositoryTest
{
  static JobRepository repo = null;
  static Recruiter recruiter1 = null;
  static Recruiter recruiter2 = null;
  static Job job1 = null;
  static Job job2 = null;
  static Job job3 = null;
  
  @BeforeClass
  public static void setUpBeforeClass() throws Exception
  {
    repo = JobRepository.getInstance();
    recruiter1 = new Recruiter(new Name("John"));
    recruiter2 = new Recruiter(new Name("Henry"));
    job1 = JobFactory.createATSJob(new JobTitle("Developer"));
    job2 = JobFactory.createATSJob(new JobTitle("Architect"));
    job3 = JobFactory.createATSJob(new JobTitle("Programmer"));
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception
  {
    repo = null;    
    recruiter1 = null;
    recruiter2 = null;
    job1 = null;
    job2 = null;
    job3 = null;
  }

  @Before
  public void setUp() throws Exception
  {
  }

  @After
  public void tearDown() throws Exception
  {
    repo.deleteAllPostings();
  }

  @Test
  public void testInstance()
  {
    assertNotNull("getInstnace must return the object", repo);
    assertEquals("Newly constructed JobRepository instance should have zero size", repo.getNumberOfPostings(), 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testPostJobWithNullArgument()
  {
    repo.postJob(null, null);
    repo.postJob(recruiter1, null);
    repo.postJob(null, job1);
  }

  @Test
  public void testPostJob()
  {
    int prevCount = repo.getNumberOfPostings();
    repo.postJob(recruiter1, job1);
    int curCount = repo.getNumberOfPostings();
    assertEquals("Posting count should go up by one after postJob", prevCount+1, curCount); // assuming single-threaded testing
    // job with same title can be posted again
    Job job11 = JobFactory.createATSJob(new JobTitle("Developer"));
    repo.postJob(recruiter1, job11);
    // same job by same recruiter - not allowed
    boolean gotException = false;
    try
    {
      repo.postJob(recruiter1, job1);
    }
    catch (IllegalArgumentException ex)
    {
      gotException = true;
    }
    assertTrue("Same job can not be posted more than once", gotException);
    
    // different recruiter, same job is OK ????
    repo.postJob(recruiter2, job11);
    
    repo.deleteAllPostings();
    curCount = repo.getNumberOfPostings();
    assertEquals("Posting count should be zero after deleteAllPostings", curCount, 0);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testListJobsWithNullArgument()
  {
    JobPostings joblist = repo.getJobs(null);
  }

  @Test
  public void testGetJobsAll()
  {
    PostedJobs joblist = repo.getJobs();
    assertEquals("GetJobs for a recruiter who did not post must return zero", joblist.getCount(), 0);    
    repo.postJob(recruiter1, job1);
    repo.postJob(recruiter1, job2);
    repo.postJob(recruiter2, job3);
    joblist = repo.getJobs();
    assertNotNull("GetJobs must not return null", joblist);
    assertEquals("GetJobs with no input must return all jobs", joblist.getCount(), 3);
  }
  
  @Test
  public void testGetJobsByRecruiter()
  {
    JobPostings joblist = repo.getJobs(recruiter1);
    assertEquals("GetJobs for a recruiter who did not post must be zero", joblist.getCount(), 0);    
    repo.postJob(recruiter1, job1);
    repo.postJob(recruiter1, job2);
    repo.postJob(recruiter2, job3);
    joblist = repo.getJobs(recruiter1);
    assertNotNull("GetJobs must not return null when the repository is not empty", joblist);
    assertEquals("GetJobs for a recruiter must return all jobs posted by the recruiter", joblist.getCount(), 2);
    List<String> titles = joblist.getDisplayTextList();
    assertTrue("GetJobs must contain posted job", titles.contains("Developer"));
    assertTrue("GetJobs must contain posted job", titles.contains("Architect"));
  }

}
