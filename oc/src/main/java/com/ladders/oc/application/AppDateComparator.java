package com.ladders.oc.application;

import java.util.*;

/**
 * Helper class to compare two dates using day part only.
 */
public class AppDateComparator
{
  private AppDateComparator() {}

  private static Date getNormalizedDate(Date _date) 
  {
    Date date = _date;
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    date = calendar.getTime();
    return date;
  }
  
  public static boolean isEqual(Date date1,
                                Date date2)
  {
    return (getNormalizedDate(date1).compareTo(getNormalizedDate(date2)) == 0);
  }

}
