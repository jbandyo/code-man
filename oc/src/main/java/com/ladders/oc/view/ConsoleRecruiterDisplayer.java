package com.ladders.oc.view;

import com.ladders.oc.Name;
import com.ladders.oc.displayers.NameDisplayer;
import com.ladders.oc.displayers.RecruiterDisplayer;

public class ConsoleRecruiterDisplayer implements RecruiterDisplayer
{

  @Override
  public void displayRecruiter(Name name)
  {
    NameDisplayer nameDisplayer = new ConsoleNameDisplayer();
    name.displayInstance(nameDisplayer);

  }

}
