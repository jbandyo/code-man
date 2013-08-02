package com.ladders.oc.view;

import com.ladders.oc.displayers.NameDisplayer;

public class ConsoleNameDisplayer implements NameDisplayer
{

  @Override
  public void displayName(String name)
  {
    System.out.print(name);

  }

}
