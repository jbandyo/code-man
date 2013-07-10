package com.ladders.oc.resume;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ladders.oc.Name;
import com.ladders.oc.jobseekers.JobSeeker;

public class ResumeCreatorTest
{

  @Test
  public void testCreateResume()
  {
    JobSeeker seeker = new JobSeeker(new Name("David"));
    Resume resume = ResumeCreator.createResume(seeker);
    assertNotNull("CreateResume must create the object", resume);
    boolean result = resume.OwnedBy(seeker);
    assertTrue("Resume must validate the correct JobSeeker", result);
  }

}
