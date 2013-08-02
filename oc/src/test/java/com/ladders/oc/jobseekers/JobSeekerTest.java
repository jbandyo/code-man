package com.ladders.oc.jobseekers;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ladders.oc.Name;
import com.ladders.oc.jobseekers.Jobseeker;

public class JobSeekerTest
{

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithNullArgument()
  {
    Jobseeker seeker = new Jobseeker(null);
  }

  @Test
  public void testConstructor()
  {
    Jobseeker seeker = new Jobseeker(new Name("David"));
    assertNotNull("JobSeeker constructor must create the object", seeker); 
  }

}
