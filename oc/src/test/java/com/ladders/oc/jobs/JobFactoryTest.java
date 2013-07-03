package com.ladders.oc.jobs;

import static org.junit.Assert.*;

import org.junit.Test;

public class JobFactoryTest
{

  @Test(expected = IllegalArgumentException.class)
  public void testCreateATSJobWithNullArgument()
  {
    ATSJob job = JobFactory.createATSJob(null);
  }

  @Test
  public void testCreateATSJob()
  {
    ATSJob job = JobFactory.createATSJob(new JobTitle("Developer"));
    assertNotNull("CreateATSJob must create the object", job);
    assertEquals("CreateATSJob must initialize the job title correctly", job.getDisplayText(), "Developer");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCreateJReqJobWithNullArgument()
  {
    JReqJob job = JobFactory.createJReqJob(null);
  }

  @Test
  public void testCreateJReqJob()
  {
    JobTitle title = new JobTitle("Developer");
    JReqJob job = JobFactory.createJReqJob(new JobTitle("Developer"));
    assertNotNull("CreateJReqJob must create the object", job);
    assertEquals("CreateJReqJob must initialize the job title correctly", job.getDisplayText(), "Developer");    
  }

}
