package com.ladders.oc.display;

public interface DisplayHandler
{
  void displayObject(Displayable item);
  void displayObjectLF(Displayable item);
  void displayList(DisplayableCollection col);
}
