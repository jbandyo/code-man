package com.ladders.oc.postedjobs;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ladders.oc.Name;
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
    repo.deleteAllPostings();
    recruiter1 = new Recruiter(new Name("John"));
    recruiter2 = new Recruiter(new Name("Henry"));
    job1 = JobFactory.createATSJob(new JobTitle("Developer"));
    job2 = JobFactory.createATSJob(new JobTitle("Architect"));
    job3 = JobFactory.createATSJob(new JobTitle("Programmer"));
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception
  {
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
    boolean result;
    result = repo.postJob(recruiter1, job1);
    assertTrue("PostJob must return true when successful", result);
    assertEquals("Posting count should go up by one after a new recruiter posting", repo.getNumberOfPostings(), 1); // assuming single-threaded testing
    // job with same title can be posted again
    Job job11 = JobFactory.createATSJob(new JobTitle("Developer"));
    repo.postJob(recruiter1, job11);
    // same job by same recruiter - not allowed
    result = repo.postJob(recruiter1, job1);
    assertFalse("Same job can not be posted more than once", result);
    // different recruiter, same job is not allowed also
    result = repo.postJob(recruiter2, job11);
    assertFalse("PostJob must return true when successful", result);
    
    repo.deleteAllPostings();
    assertEquals("Posting count should be zero after deleteAllPostings", repo.getNumberOfPostings(), 0);
  }
    
  @Test(expected = IllegalArgumentException.class)
  public void testListJobsWithNullArgument()
  {
    Jobs joblist = repo.getRecruiterJobs(null);
  }

  @Test
  public void testGetPostedJobs()
  {
    Jobs joblist = repo.getPostedJobs();
    assertEquals("GetJobs for a recruiter who did not post must return zero", joblist.getCount(), 0);    
    repo.postJob(recruiter1, job1);
    repo.postJob(recruiter1, job2);
    repo.postJob(recruiter2, job3);
    joblist = repo.getPostedJobs();
    assertNotNull("GetJobs must not return null", joblist);
    assertEquals("GetJobsAll must return all jobs", joblist.getCount(), 3);
    assertTrue("GetJobsAll must contain posted job", joblist.contains(job1));
    assertTrue("GetJobsAll must contain posted job", joblist.contains(job2));
    assertTrue("GetJobsAll must contain posted job", joblist.contains(job3));
  }
  
  @Test
  public void testGetJobsByRecruiter()
  {
    Jobs joblist = repo.getRecruiterJobs(recruiter1);
    assertNotNull("GetJobs must not return null", joblist);
    assertEquals("GetJobs for a recruiter who did not post must be zero", joblist.getCount(), 0);    
    repo.postJob(recruiter1, job1);
    repo.postJob(recruiter1, job2);
    repo.postJob(recruiter2, job3);
    joblist = repo.getRecruiterJobs(recruiter1);
    assertNotNull("GetJobs must not return null", joblist);
    assertEquals("GetJobs for a recruiter must return all jobs posted by the recruiter", joblist.getCount(), 2);
    assertTrue("GetJobs must contain posted job", joblist.contains(job1));
    assertTrue("GetJobs must contain posted job", joblist.contains(job1));
    joblist = repo.getRecruiterJobs(recruiter2);
    assertNotNull("GetJobs must not return null", joblist);
    assertEquals("GetJobs for a recruiter must return all jobs posted by the recruiter", joblist.getCount(), 1);
    assertTrue("GetJobs must enter job posting correcty", joblist.contains(job3));
  }

  @Test
  public void testGetRecruiterByJob()
  {
    repo.postJob(recruiter1, job1);
    repo.postJob(recruiter1, job2);
    repo.postJob(recruiter2, job3);
    assertEquals("GetRecruiterByJob must return correct recruiter instance", repo.GetRecruiterByJob(job1), recruiter1);
    assertEquals("GetRecruiterByJob must return correct recruiter instance", repo.GetRecruiterByJob(job2), recruiter1);
    assertEquals("GetRecruiterByJob must return correct recruiter instance", repo.GetRecruiterByJob(job3), recruiter2);
    
  }
}
