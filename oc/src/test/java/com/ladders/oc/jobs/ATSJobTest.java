package com.ladders.oc.jobs;

import static org.junit.Assert.*;

import org.junit.Test;

public class ATSJobTest
{

  @Test
  public void testATSJobConstructor()
  {
    ATSJob job = new ATSJob(new JobTitle("Developer"));
    assertNotNull(job);
  }

  @Test
  public void testATSJobDisplay()
  {
    ATSJob job = new ATSJob(new JobTitle("Developer"));
    job.Display();
  }

}
