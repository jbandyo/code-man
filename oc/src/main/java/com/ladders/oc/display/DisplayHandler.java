package com.ladders.oc.display;

import com.ladders.oc.application.Application;

public interface DisplayHandler
{
  void displayItem(Displayable item);
  void displayItemLF(Displayable item);
  void displayList(DisplayableCollection col);
  void displayObjectLF(DisplayableObject obj);
  void displayJobSeekerJob(Application app);
  void reportByCSVItem(Application app);
  void reportByHtmlItem(Application app);
}
