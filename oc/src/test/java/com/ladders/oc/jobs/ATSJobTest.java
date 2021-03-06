package com.ladders.oc.jobs;

import static org.junit.Assert.*;

import org.junit.Test;

public class ATSJobTest
{

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithNullArgument()
  {
    ATSJob job = new ATSJob(null);
  }

  @Test
  public void testConstructor()
  {
    ATSJob job = new ATSJob(new JobTitle("Developer"));
    assertNotNull("ATSJob constructor must create the object", job);
    assertFalse("ATSJob does not require a resume", job.RequiresResume());
  }

}
