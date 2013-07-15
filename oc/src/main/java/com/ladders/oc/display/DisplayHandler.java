package com.ladders.oc.display;

import java.util.EnumSet;

import com.ladders.oc.application.Application;

public interface DisplayHandler
{
  void displayItem(Displayable item);
  void displayItemLF(Displayable item);
  void displayList(DisplayableCollection col);
  void displayObjectLF(DisplayableObject obj);
  void displayJobSeekerJob(Application app);
  void displayRecruiterInfoByDate(Application app);
}
