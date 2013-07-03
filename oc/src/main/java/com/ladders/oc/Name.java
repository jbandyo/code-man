package com.ladders.oc;

/**
 * Creates a wrapper object for a name.
 */
public class Name
{
  private String name;
  
  /**
   * Constructor
   * @param _name    a string that describes the name
   * @throws IllegalArgumentException if the input argument is null or of length zero
   */
  public Name(String _name) throws IllegalArgumentException
  {
    // validate
    if ((_name == null) || (_name.length() == 0))
      throw new IllegalArgumentException();
    // check for max length ???
    name = _name;
  }

}
