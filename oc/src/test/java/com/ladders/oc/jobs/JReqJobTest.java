package com.ladders.oc.jobs;

import static org.junit.Assert.*;

import org.junit.Test;

public class JReqJobTest
{

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithNullArgument()
  {
    JReqJob job = new JReqJob(null);
  }

  @Test
  public void testConstructor()
  {
    JReqJob job = new JReqJob(new JobTitle("Architect"));
    assertNotNull("JReqJob constructor must create the object", job);
    assertEquals("JReqJob must initialize the job title correctly", job.getDisplayText(), "Architect");    
    assertTrue("JReqJob requires a resume", job.RequiresResume());
  }

}
