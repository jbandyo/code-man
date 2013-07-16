package com.ladders.oc.jobs;

import static org.junit.Assert.*;

import org.junit.Test;

public class JobTitleTest
{
  
  @Test
  public void testConstructor()
  {
    JobTitle title = new JobTitle("Developer");
    assertNotNull("JobTitle constructor must create the object", title);
    assertEquals("JobTitle must initialize the title correctly", title.getDisplayText(), "Developer");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testJobTitleConstructorWithNullArgument()
  {
    JobTitle title = new JobTitle(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithBlankArgument()
  {
    JobTitle title = new JobTitle("");
  }
 
}
