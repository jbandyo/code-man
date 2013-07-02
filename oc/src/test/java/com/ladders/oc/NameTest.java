package com.ladders.oc;

import static org.junit.Assert.*;

import org.junit.Test;

public class NameTest
{

  @Test
  public void testNameConstructor()
  {
    Name name = new Name("John");
    assertNotNull(name);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNameConstructorWithNullArgument()
  {
    Name name = new Name(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNameConstructorWithBlankArgument()
  {
    Name name = new Name("");
  }

}
