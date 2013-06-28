package com.ladders.oc.jobs;

import static org.junit.Assert.*;

import org.junit.Test;

public class JobFactoryTest
{

  @Test
  public void testCreateATSJob()
  {
    JobTitle title = new JobTitle("Developer");
    ATSJob job = JobFactory.createATSJob(title);
    assertNotNull(job);
  }

}
