package com.ladders.oc;

import static org.junit.Assert.*;

import org.junit.Test;

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
