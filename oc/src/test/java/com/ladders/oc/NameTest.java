package com.ladders.oc;

import static org.junit.Assert.*;

import org.junit.Test;

public class NameTest
{

  @Test
  public void testConstructor()
  {
    Name name = new Name("John");
    assertNotNull("Name constructor must create the object", name);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithNullArgument()
  {
    Name name = new Name(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithBlankArgument()
  {
    Name name = new Name("");
  }

}
