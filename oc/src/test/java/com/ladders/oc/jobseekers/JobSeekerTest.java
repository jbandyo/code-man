package com.ladders.oc.jobseekers;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ladders.oc.Name;
import com.ladders.oc.jobseekers.JobSeeker;

public class JobSeekerTest
{

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithNullArgument()
  {
    JobSeeker seeker = new JobSeeker(null);
  }

  @Test
  public void testConstructor()
  {
    JobSeeker seeker = new JobSeeker(new Name("David"));
    assertNotNull("JobSeeker constructor must create the object", seeker); 
  }

}
