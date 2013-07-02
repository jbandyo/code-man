package com.ladders.oc.jobs;

import static org.junit.Assert.*;

import org.junit.Test;

public class JobsTest
{

  @Test
  public void testJobsInstance()
  {
    Jobs jobCol = Jobs.getInstance();
    assertNotNull(jobCol);
    assertEquals(jobCol.GetNumberOfJobs(), 0);
  }

  @Test
  public void testAddJob()
  {
    Jobs jobCol = Jobs.getInstance();
    JobTitle title1 = new JobTitle("Developer-1");
    ATSJob job1 = JobFactory.createATSJob(title1);
    jobCol.AddJob(job1);
    
  }
  
}
