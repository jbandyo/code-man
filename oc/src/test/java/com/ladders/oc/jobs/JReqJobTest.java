package com.ladders.oc.jobs;

import static org.junit.Assert.*;

import org.junit.Test;

public class JReqJobTest
{

  @Test
  public void testJReqJobConstructor()
  {
    JobTitle title = new JobTitle("Developer");
    JReqJob job = new JReqJob(title);
    assertNotNull(job);
  }

}
