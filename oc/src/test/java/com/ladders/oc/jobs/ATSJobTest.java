package com.ladders.oc.jobs;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ladders.oc.display.View;

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
    assertEquals("ATSJob must initialize the job title correctly", job.getDisplayText(), "Developer");
  }

}
