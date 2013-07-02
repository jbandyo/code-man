package com.ladders.oc.jobs;

import static org.junit.Assert.*;

import org.junit.Test;

public class JobTitleTest
{

  @Test
  public void testJobTitleConstructor()
  {
    JobTitle title = new JobTitle("Developers");
    assertNotNull(title);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testJobTitleConstructorWithNullArgument()
  {
    JobTitle title = new JobTitle(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testJobTitleConstructorWithBlankArgument()
  {
    JobTitle title = new JobTitle("");
  }
  
}
