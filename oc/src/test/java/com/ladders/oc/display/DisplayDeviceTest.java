package com.ladders.oc.display;

import static org.junit.Assert.*;

import org.junit.Test;

public class DisplayDeviceTest
{

  @Test
  public void testDisplayDeviceConstructor()
  {
    DisplayDevice device = DisplayDevice.getInstance();
    assertNotNull(device);
  }
  
  @Test
  public void testDisplayLine()
  {
    DisplayDevice.getInstance().DisplayLine("Test line");
  }  

}
