package com.ladders.oc.display;

public class View implements DisplayHandler
{
  // singleton pattern implementation
  private static final class SingletonHolder 
  {
    static final View singleton = new View();
  }
  public static View getInstance()
  {
    return SingletonHolder.singleton;
  }

  @Override
  public void displayObject(Displayable item)
  {
    System.out.println(item.getDisplayText());
  }

}
