package com.ladders.oc.recruiters;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.ladders.oc.display.View;
import com.ladders.oc.jobs.*;
import com.ladders.oc.recruiters.JobPosting;

public class JobPostingTest
{

  @Test
  public void testConstructor()
  {
    Job job = JobFactory.createATSJob(new JobTitle("Developer"));
    Date now = new Date();
    JobPosting posting = new JobPosting(job, now);
    assertNotNull("JobPosting constructor must create the object", posting);
    assertEquals("JobPosting must initialize the job title correctly", posting.getDisplayText(), "Developer");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithNullArgument()
  {
    Job job = JobFactory.createATSJob(new JobTitle("Developer"));
    Date now = new Date();
    JobPosting posting1 = new JobPosting(null, now);
    JobPosting posting2 = new JobPosting(job, null);
    JobPosting posting3 = new JobPosting(null, null);
  }

}
