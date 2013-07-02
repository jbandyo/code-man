package com.ladders.oc;

import static org.junit.Assert.*;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import com.ladders.oc.jobs.*;

public class RecruiterPostingsTest
{
  @Test
  public void testJobRepositoryInstance()
  {
    RecruiterPostings repo = RecruiterPostings.getInstance();
    assertNotNull(repo);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testPostJobWithNullArgument()
  {
    RecruiterPostings repo = RecruiterPostings.getInstance();
    Recruiter recruiter = new Recruiter(new Name("John"));
    Job job = JobFactory.createATSJob(new JobTitle("Developer"));
    repo.postJob(null, null);
    repo.postJob(recruiter, null);
    repo.postJob(null, job);
  }

  @Test
  public void testPostJob()
  {
    RecruiterPostings repo = RecruiterPostings.getInstance();
    Recruiter recruiter = new Recruiter(new Name("John"));
    Job job = JobFactory.createATSJob(new JobTitle("Developer"));
    int prevCount = repo.getNumberOfPostings();
    repo.postJob(recruiter, job);
    int curCount = repo.getNumberOfPostings();
    assertEquals(prevCount+1, curCount);
    repo.deleteAllPostings();
    curCount = repo.getNumberOfPostings();
    assertEquals(curCount, 0);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testListJobsWithNullArgument()
  {
    RecruiterPostings repo = RecruiterPostings.getInstance();
    List<JobPosting> joblist = repo.listJobs(null);
  }

  @Test
  public void testListJobs()
  {
    RecruiterPostings repo = RecruiterPostings.getInstance();
    Recruiter recruiter = new Recruiter(new Name("John"));
    Job job1 = JobFactory.createATSJob(new JobTitle("Developer"));
    repo.postJob(recruiter, job1);
    Job job2 = JobFactory.createATSJob(new JobTitle("Architect"));
    repo.postJob(recruiter, job2);
    List<JobPosting> joblist = repo.listJobs(recruiter);
  }
  

}
