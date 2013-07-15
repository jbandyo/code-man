package com.ladders.oc.view;

import java.util.*;

import com.ladders.oc.application.Application;
import com.ladders.oc.display.*;

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
  public void displayItem(Displayable item)
  {
    System.out.print(item.getDisplayText());
  }

  @Override
  public void displayItemLF(Displayable item)
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

  @Override
  public void displayObjectLF(DisplayableObject obj)
  {
    String[] texts = obj.getDisplayTextArray();
    System.out.print(texts[0]);
    System.out.print(":");
    System.out.print(texts[1]);
    System.out.print(":");
    System.out.print(texts[2]);
    System.out.print(":");
    System.out.print(texts[3]);
    System.out.println();
  }
  
  @Override
  public void displayJobSeekerJob(Application app)
  {
    ApplicationDisplayer appview = new JobsAppliedToView();
    app.displayInstance(appview);
  }
  
  @Override
  public void displayRecruiterInfoByDate(Application app)
  {
    ApplicationDisplayer appview = new RecriterInfoByDateView();
    app.displayInstance(appview);  
  }

}
