package com.ladders.oc;

import com.ladders.oc.displayables.DisplayableName;
import com.ladders.oc.displayers.NameDisplayer;

/**
 * Creates a wrapper object for a name.
 */
public class Name implements DisplayableName
{
  private final String name;
  
  /**
   * Constructor
   * @param name    a string that describes the name
   * @throws IllegalArgumentException if the input argument is null or of length zero
   */
  public Name(String name)
  {
    // validate
    if (name == null)
      throw new IllegalArgumentException("Name is null");

    if (name.length() == 0)
      throw new IllegalArgumentException("Name is of zero length");

    this.name = name;
  }
  
  // interface method implementation
  @Override
  public void displayInstance(NameDisplayer displayer)
  {
    displayer.displayName(name);
    
  }

}
