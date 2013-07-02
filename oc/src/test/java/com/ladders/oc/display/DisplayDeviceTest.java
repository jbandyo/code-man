package com.ladders.oc.display;

import static org.junit.Assert.*;

import org.junit.Test;

public class DisplayDeviceTest
{

  @Test
  public void testDisplayDeviceConstructor()
  {
    DisplayDevice device = DisplayDevice.getInstance();
    assertNotNull("DisplayDevice constructor must create the object", device);
  }
  
  @Test
  public void testDisplayLine()
  {
    DisplayDevice.getInstance().displayLine("Test line");
  }  

}
