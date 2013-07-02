package com.ladders.oc.display;

public class DisplayDevice implements DisplayHandler
{
  // singleton pattern implementation
  private static final class SingletonHolder 
  {
    static final DisplayDevice singleton = new DisplayDevice();
  }
  public static DisplayDevice getInstance()
  {
    return SingletonHolder.singleton;
  }

  @Override
  public void displayLine(String line)
  {
    System.out.println(line);
  }

}
