package com.ladders.oc.jobs;

import static org.junit.Assert.*;

import org.junit.Test;

public class JobFactoryTest
{

  @Test
  public void testCreateATSJob()
  {
    ATSJob job = JobFactory.createATSJob(new JobTitle("Developer"));
    assertNotNull("CreateATSJob must create the object", job);
  }

  @Test
  public void testCreateJReqJob()
  {
    JobTitle title = new JobTitle("Developer");
    JReqJob job = JobFactory.createJReqJob(new JobTitle("Developer"));
    assertNotNull("CreateJReqJob must create the object", job);
  }

}
