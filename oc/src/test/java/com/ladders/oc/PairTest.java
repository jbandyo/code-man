package com.ladders.oc;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PairTest
{

  @BeforeClass
  public static void setUpBeforeClass() throws Exception
  {}

  @AfterClass
  public static void tearDownAfterClass() throws Exception
  {}

  @Before
  public void setUp() throws Exception
  {}

  @After
  public void tearDown() throws Exception
  {}

  @Test
  public void testConstructor()
  {
    Integer obj1 = new Integer(42);
    String obj2 = new String("What is the question");
    Pair<Integer, String> pair = new Pair<Integer, String>(obj1, obj2);
    Integer first = pair.first;
    String second = pair.second;
    assertEquals("Pair must preserve the first object", first, obj1);
    assertEquals("Pair must preserve the second object", second, obj2);
  }

}
