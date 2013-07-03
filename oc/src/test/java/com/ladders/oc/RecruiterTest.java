package com.ladders.oc;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ladders.oc.jobs.ATSJob;
import com.ladders.oc.jobs.JobTitle;

public class RecruiterTest
{

  @Test
  public void testConstructor()
  {
    Recruiter recruiter = new Recruiter(new Name("John"));
    assertNotNull("Recruiter constructor must create the object", recruiter); 
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithNullArgument()
  {
    Recruiter recruiter = new Recruiter(null);
  }
  
}
