package com.ladders.oc;

import static org.junit.Assert.*;

import org.junit.Test;

public class JobSeekerTest
{

  @Test
  public void testJobSeekerConstructor()
  {
    JobSeeker user = new JobSeeker(new Name("David"));
    assertNotNull("JobSeeker constructor must create the object", user); 
  }

  @Test(expected = IllegalArgumentException.class)
  public void testJobSeekerConstructorWithNullArgument()
  {
    JobSeeker user = new JobSeeker(null);
  }

}
