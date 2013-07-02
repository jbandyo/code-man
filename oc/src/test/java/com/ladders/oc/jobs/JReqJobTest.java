package com.ladders.oc.jobs;

import static org.junit.Assert.*;

import org.junit.Test;

public class JReqJobTest
{

  @Test
  public void testJReqJobConstructor()
  {
    JReqJob job = new JReqJob(new JobTitle("Architect"));
    assertNotNull("JReqJob constructor must create the object", job);
  }

  @Test
  public void testJReqJobDisplay()
  {
    JReqJob job = new JReqJob(new JobTitle("Architect"));
    job.display();
  }

}
