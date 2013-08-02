package com.ladders.oc.recruiters;

import java.util.UUID;

import com.ladders.oc.Name;
import com.ladders.oc.displayables.DisplayableRecruiter;
import com.ladders.oc.displayers.RecruiterDisplayer;

/**
 * Represents a Recruiter.
 */
public class Recruiter implements DisplayableRecruiter
{
  private final UUID uId;
  private final Name name;

  /**
   * Constructor.
   * @param _name    a Name object
   */
  public Recruiter(Name _name) throws IllegalArgumentException
  {
    if (_name == null)
      throw new IllegalArgumentException();
    
    name = _name;
    // create a unique ID
    uId = UUID.randomUUID();
  }
  
  @Override
  public boolean equals(Object o)
  {
    if (o == this)
      return true;
    if (!(o instanceof Recruiter))
      return false;
    Recruiter rec = (Recruiter) o;
    return rec.uId.equals(uId);
  }
  
  @Override
  public int hashCode()
  {
    return (int)(uId.hashCode());
  }

  // interface method implementation
  @Override
  public void displayInstance(RecruiterDisplayer displayer)
  {
    // TODO Auto-generated method stub
    displayer.displayRecruiter(name);

  }

}
