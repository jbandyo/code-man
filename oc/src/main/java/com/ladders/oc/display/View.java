package com.ladders.oc.display;

import java.util.*;

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
    System.out.print(item.getDisplayText());
  }

  @Override
  public void displayObjectLF(Displayable item)
  {
    System.out.println(item.getDisplayText());
  }

  @Override 
  public void displayList(DisplayableCollection col)
  {
    List<String> strings = col.getDisplayTextList();
    for (String text : strings)
      System.out.println(text);
  }

}
