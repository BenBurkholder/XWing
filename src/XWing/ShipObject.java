package XWing;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import java.util.ArrayList;
import java.text.*;
/**
 * Write a description of class shipObject here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ShipObject
{
    // instance variables - replace the example below with your own
    private String shipName;
    private double xLoc;
    private double yLoc;
    private int base;
    private double bearing;
    private int team;
    private double halfBase;
    private double corner1X, corner2X, corner3X, corner4X, corner1Y, corner2Y, corner3Y, corner4Y;
    private int STEPS = 100;
    
    
    /**
     * Constructor for objects of class shipObject
     */
    public ShipObject(String n, double x, double y, double b, int s, int t)
    {
        shipName = n;
        xLoc = x;
        yLoc = y;
        bearing = b;
        base = s;
        team = t;
        halfBase = base / 2.0;
        corner1X = xLoc - halfBase * Math.cos(d2R(bearing)) + halfBase * Math.sin(d2R(bearing));
        corner1Y = yLoc + halfBase * Math.sin(d2R(bearing)) + halfBase * Math.cos(d2R(bearing));
        corner2X = xLoc + halfBase * Math.cos(d2R(bearing)) + halfBase * Math.sin(d2R(bearing));
        corner2Y = yLoc - halfBase * Math.sin(d2R(bearing)) + halfBase * Math.cos(d2R(bearing));
        corner3X = xLoc + halfBase * Math.cos(d2R(bearing)) - halfBase * Math.sin(d2R(bearing));
        corner3Y = yLoc - halfBase * Math.sin(d2R(bearing)) - halfBase * Math.cos(d2R(bearing));
        corner4X = xLoc - halfBase * Math.cos(d2R(bearing)) - halfBase * Math.sin(d2R(bearing));
        corner4Y = yLoc + halfBase * Math.sin(d2R(bearing)) - halfBase * Math.cos(d2R(bearing));
        
    }
    
    public void updateShipLocation(double X, double Y, double B) 
    {
        xLoc = X;
        yLoc = Y;
        bearing = B;
        corner1X = xLoc + halfBase * Math.cos(d2R(bearing)) - halfBase * Math.sin(d2R(bearing));
        corner1Y = yLoc + halfBase * Math.sin(d2R(bearing)) + halfBase * Math.cos(d2R(bearing));
        corner2X = xLoc - halfBase * Math.cos(d2R(bearing)) - halfBase * Math.sin(d2R(bearing));
        corner2Y = yLoc - halfBase * Math.sin(d2R(bearing)) + halfBase * Math.cos(d2R(bearing));
        corner3X = xLoc - halfBase * Math.cos(d2R(bearing)) + halfBase * Math.sin(d2R(bearing));
        corner3Y = yLoc - halfBase * Math.sin(d2R(bearing)) - halfBase * Math.cos(d2R(bearing));
        corner4X = xLoc + halfBase * Math.cos(d2R(bearing)) + halfBase * Math.sin(d2R(bearing));
        corner4Y = yLoc + halfBase * Math.sin(d2R(bearing)) - halfBase * Math.cos(d2R(bearing));
    }
    
    public void updateShipLocation(ShipObject change)
    {
        xLoc = change.getXLoc();
        yLoc = change.getYLoc();
        bearing = change.getBearing();
        halfBase = change.getBase() / 2;
        corner1X = xLoc - halfBase * Math.cos(d2R(bearing)) + halfBase * Math.sin(d2R(bearing));
        corner1Y = yLoc + halfBase * Math.sin(d2R(bearing)) + halfBase * Math.cos(d2R(bearing));
        corner2X = xLoc + halfBase * Math.cos(d2R(bearing)) + halfBase * Math.sin(d2R(bearing));
        corner2Y = yLoc - halfBase * Math.sin(d2R(bearing)) + halfBase * Math.cos(d2R(bearing));
        corner3X = xLoc + halfBase * Math.cos(d2R(bearing)) - halfBase * Math.sin(d2R(bearing));
        corner3Y = yLoc - halfBase * Math.sin(d2R(bearing)) - halfBase * Math.cos(d2R(bearing));
        corner4X = xLoc - halfBase * Math.cos(d2R(bearing)) - halfBase * Math.sin(d2R(bearing));
        corner4Y = yLoc + halfBase * Math.sin(d2R(bearing)) - halfBase * Math.cos(d2R(bearing));
    }
        
    // if this were in the ShipObject class
    public ShipObject straight(int distance, int numSteps)
    {
        double l_testX = xLoc;
        double l_testY = yLoc;
        double l_bearing = bearing;       
        //don't know why both variables to be set to doubles, but it was doing int math
        double l_fractionMove = (double) numSteps / (double) STEPS;        
        double l_totalDist = (double) l_fractionMove * (double) ((distance * 4) + base);
        
        l_testX = l_testX + (double) l_totalDist * (double) (Math.sin(d2R(l_bearing)));
        l_testY = l_testY + (double) l_totalDist * (double) (Math.cos(d2R(l_bearing)));
        
        ShipObject testShip = new ShipObject("Test", l_testX, l_testY, l_bearing, base, team);
        return testShip;             
    }
    
    public ShipObject bank(int distance, int LR, int numSteps)
    {
        double l_testX = xLoc;
        double l_testY = yLoc;
        double l_bearing = bearing;
        double l_totalDist = 0;        
        //double l_fractionMove = numSteps/STEPS;
        
        if(base == 4 && distance == 1) {
            l_totalDist = 10.07;
        } else if(base == 4 && distance == 2) {
            l_totalDist = 14.00;
        } else if(base == 4 && distance == 3) {
            l_totalDist = 17.93;
        } else if(base == 8 && distance == 1) {
            l_totalDist = 13.87;
        } else if(base == 8 && distance == 2) {
            l_totalDist = 17.79;
        } else if(base == 8 && distance == 3) {
            l_totalDist = 21.72;
        }
        
        for(int i = 0; i < numSteps; i++) {
            l_testX = l_testX + l_totalDist * (Math.sin(d2R(l_bearing))) / STEPS;
            l_testY = l_testY + l_totalDist * (Math.cos(d2R(l_bearing))) / STEPS;
            if(LR == 0) {
                l_bearing = l_bearing - (double) 45.0 / (double) STEPS;
            } else if (LR == 1) {
                l_bearing = l_bearing + (double) 45.0 / (double) STEPS;
            }
        }
        
        ShipObject testShip = new ShipObject("Test", l_testX, l_testY, l_bearing, base, team);
        return testShip;
            
            
    }
    
    public ShipObject turn(int distance, int LR, int numSteps)
    {
        double l_testX = xLoc;
        double l_testY = yLoc;
        double l_bearing = bearing;
        double l_totalDist = 0;     
        
        
        
        if(base == 4 && distance == 1) {
            l_totalDist = 8.64;
        } else if(base == 4 && distance == 2) {
            l_totalDist = 12.96;
        } else if(base == 4 && distance == 3) {
            l_totalDist = 17.28;
        } else if(base == 8 && distance == 1) {
            l_totalDist = 11.78;
        } else if(base == 8 && distance == 2) {
            l_totalDist = 16.10;
        } else if(base == 8 && distance == 3) {
            l_totalDist = 20.42;
        }
        
        for(int i = 0; i < numSteps; i++) {
            l_testX = l_testX + (double) l_totalDist * (double) (Math.sin(d2R(l_bearing))) / STEPS;
            l_testY = l_testY + (double) l_totalDist * (double) (Math.cos(d2R(l_bearing))) / STEPS;
            if(LR == 0) {
                l_bearing = l_bearing - (double) 90.0 / (double) STEPS;
            } else if (LR == 1) {
                l_bearing = l_bearing + (double) 90.0 / (double) STEPS;
            }
        }
        
        ShipObject testShip = new ShipObject("Test", l_testX, l_testY, l_bearing, base, team);
        return testShip;
            
            
    }
    
    public String getName()
    {
        return shipName;
    }
    
    public double getXLoc()
    {
        return xLoc;
    }
    
    public double getYLoc()
    {
        return yLoc;
    }
    
    public double getBearing()
    {
        return bearing;
    }
    
    public int getBase()
    {
        return base;
    }
    
    public int getTeam()
    {
        return team;
    }
    
    public double getCorner1X()
    {
        return corner1X;
    }
    
    public double getCorner2X()
    {
        return corner2X;
    }
     
    public double getCorner3X()
    {
        return corner3X;
    }
     
    public double getCorner4X()
    {
        return corner4X;
    }
     
    public double getCorner1Y()
    {
        return corner1Y;
    }
     
    public double getCorner2Y()
    {
        return corner2Y;
    }
     
    public double getCorner3Y()
    {
        return corner3Y;
    }
     
    public double getCorner4Y()
    {
        return corner4Y;
    }
     
    public void setXLoc(double x)
    {
        xLoc = x; 
    }
    
    public void setYLoc(double y)
    {
        yLoc = y;
    }
    
    public void setBearing(double b)
    {
        bearing = b;
    }
        
    public double d2R(double deg)
    {
        double rad = deg * Math.PI/180;
        return rad;
    }

  
}
