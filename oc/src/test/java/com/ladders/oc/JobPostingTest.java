package com.ladders.oc;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import com.ladders.oc.jobs.*;

public class JobPostingTest
{

  @Test
  public void testJobPostingConstructor()
  {
    ATSJob job = JobFactory.createATSJob(new JobTitle("Developer"));
    Date now = new Date();
    JobPosting posting = new JobPosting(job, now);
    assertNotNull(posting);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testJobPostingConstructorWithNullArgument()
  {
    ATSJob job = JobFactory.createATSJob(new JobTitle("Developer"));
    Date now = new Date();
    JobPosting posting1 = new JobPosting(null, now);
    JobPosting posting2 = new JobPosting(job, null);
  }

}
