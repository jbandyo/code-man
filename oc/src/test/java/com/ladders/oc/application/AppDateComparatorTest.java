package com.ladders.oc.application;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.Test;

public class AppDateComparatorTest
{

  @AfterClass
  public static void tearDownAfterClass() throws Exception
  {}

  @Test
  public void testWhenEqual()
  {
    Date date1 = new Date();
    Date date2 = date1;
    boolean result = AppDateComparator.isEqual(date1, date2);
    assertTrue(result);
  }

  @Test
  public void testWhenNotEqual()
  {
    Calendar cal = Calendar.getInstance();
    Date date1 = new Date();
    cal.setTime(date1);
    cal.add(Calendar.DAY_OF_MONTH, 1);
    Date date2 = cal.getTime();
    boolean result = AppDateComparator.isEqual(date1, date2);
    assertFalse(result);
  }

}
