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
    Job job = JobFactory.createATSJob(new JobTitle("Developer"));
    Date now = new Date();
    JobPosting posting = new JobPosting(job, now);
    assertNotNull("JobPosting constructor must create the object", posting);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testJobPostingConstructorWithNullArgument()
  {
    Job job = JobFactory.createATSJob(new JobTitle("Developer"));
    Date now = new Date();
    JobPosting posting1 = new JobPosting(null, now);
    JobPosting posting2 = new JobPosting(job, null);
    JobPosting posting3 = new JobPosting(null, null);
  }

  @Test
  public void testJobPostingDisplay()
  {
    Job job = JobFactory.createATSJob(new JobTitle("Developer"));
    Date now = new Date();
    JobPosting posting = new JobPosting(job, now);
    posting.display();
  }
 
}
