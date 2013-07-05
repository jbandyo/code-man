package com.ladders.oc;

/**
 * Generic class that keeps an ordered pair of objects..
 */
public class Pair<T1, T2>
{
  public final T1 first;
  public final T2 second;

  public Pair(T1 obj1, T2 obj2)
  {
    first = obj1;
    second = obj2;
  }
}
