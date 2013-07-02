package com.ladders.oc;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ladders.oc.jobs.ATSJob;
import com.ladders.oc.jobs.JobTitle;

public class RecruiterTest
{

  @Test
  public void testRecruiterConstructor()
  {
    Recruiter recruiter = new Recruiter(new Name("John"));
    assertNotNull(recruiter); 
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRecruiterConstructorWithNullArgument()
  {
    Recruiter recruiter = new Recruiter(null);
  }
  
}
