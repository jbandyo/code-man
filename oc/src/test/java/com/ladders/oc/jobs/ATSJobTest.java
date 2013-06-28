package com.ladders.oc.jobs;

import static org.junit.Assert.*;

import org.junit.Test;

public class ATSJobTest
{

  @Test
  public void testATSJobConstructor()
  {
    JobTitle title = new JobTitle("Developer");
    ATSJob job = new ATSJob(title);
    assertNotNull(job);
  }

}
