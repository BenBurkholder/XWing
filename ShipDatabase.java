
/**
 * Write a description of class ShipDatabase here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;

public class ShipDatabase
{
    // instance variables - replace the example below with your own
    public static ArrayList<ShipObject> shipList;
    public static ArrayList<coor> coorList;
    private int t = 0;
    private double STEPS = 100.0;
    private final double CM = 7;
    //11.81
    private ShipObject undoShip = null;
    private String curShipName;
    private String curMessage;
    // private GameBoard boardOne; 

    /**
     * Constructor for objects of class ShipDatabase
     */
    public ShipDatabase()
    {
        shipList  = new ArrayList<ShipObject>();
        coorList = new ArrayList<coor>();
        curShipName = null;
        curMessage = null;        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    // public GameBoard getGameBoard() {
        // return this.boardOne;
    // }
    
    public void print()
    {
        for(ShipObject ship : shipList) {
            System.out.println(ship.getName()+ "\t\t" + ship.getXLoc() + 
            "\t\t" + ship.getYLoc() + "\t\t" + ship.getBearing());
        }
    }
    
    public int listLength()
    {
        return shipList.size();
    }
    
    public double curX()
    {
        return shipList.get(t).getXLoc();
    }
    
    public double curY()
    {
        return shipList.get(t).getYLoc();
    }
    
    public void addShip(ShipObject e)
    {
        // put your code here
        shipList.add(e);
    }
    
    public void addCoor(coor e)
    {
        coorList.add(e);
    }
    
    public void nextShip()
    {
        t++;
        undoShip = shipList.get(t);
        curShipName = shipList.get(t).getName();
    }
    
    public void removeShip()
    {
        shipList.remove(t);
    }
    
    public void nextTurn()
    {
        t = 0;
        curShipName = shipList.get(t).getName();
    }
    
    public ArrayList<ShipObject> getAL()
    {
        return shipList;
    }
    
    public ArrayList<coor> getCL()
    {
        return coorList;
    }
    
    public String getMessage()
    {
        return curMessage;
    }
    
    public String getShip()
    {
        return curShipName;
    }
    
    // public void updateCoor()
    // {
        // double x1 = 0, x2 = 0, x3 = 0, x4 = 0, x5 = 0;
        // double y1 = 0, y2 = 0, y3 = 0, y4 = 0, y5 = 0;
        // for(ShipObject s : shipList) {
            // if (s.getSize() == 0) {
                // x1 = s.getXLoc();
                // x2 = s.getXLoc() + .5 * 4 * Math.sin(d2R(s.getBearing()));
                // x3 = s.getXLoc() - .5 * 4 * Math.cos(d2R(s.getBearing()));
                // x4 = s.getXLoc() - .5 * 4 * Math.sin(d2R(s.getBearing()));
                // x5 = s.getXLoc() + .5 * 4 * Math.cos(d2R(s.getBearing()));
                // y1 = s.getYLoc();
                // y2 = s.getYLoc() + .5 * 4 * Math.cos(d2R(s.getBearing()));
                // y3 = s.getYLoc() + .5 * 4 * Math.sin(d2R(s.getBearing()));
                // y4 = s.getYLoc() - .5 * 4 * Math.cos(d2R(s.getBearing()));
                // y5 = s.getYLoc() - .5 * 4 * Math.sin(d2R(s.getBearing()));
            // } else if (s.getSize() == 1) {
                // x1 = s.getXLoc();
                // x2 = s.getXLoc() + .5 * 8 * Math.sin(d2R(s.getBearing()));
                // x3 = s.getXLoc() - .5 * 8 * Math.cos(d2R(s.getBearing()));
                // x4 = s.getXLoc() - .5 * 8 * Math.sin(d2R(s.getBearing()));
                // x5 = s.getXLoc() + .5 * 8 * Math.cos(d2R(s.getBearing()));
                // y1 = s.getYLoc();
                // y2 = s.getYLoc() + .5 * 8 * Math.cos(d2R(s.getBearing()));
                // y3 = s.getYLoc() + .5 * 8 * Math.sin(d2R(s.getBearing()));
                // y4 = s.getYLoc() - .5 * 8 * Math.cos(d2R(s.getBearing()));
                // y5 = s.getYLoc() - .5 * 8 * Math.sin(d2R(s.getBearing()));
            // }
        // }
        // coor c1 = new coor (x1, y1);
        // coor c2 = new coor (x2, y2);
        // coor c3 = new coor (x3, y3);
        // coor c4 = new coor (x4, y4);
        // coor c5 = new coor (x5, y5);
        // coorList.add(c1);
        // coorList.add(c2);
        // coorList.add(c3);
        // coorList.add(c4);
        // coorList.add(c5);
    // }
        
    
    public void readSheet(String filename) 
    {
        Scanner inFS = null;
        FileInputStream fileByteStream = null;
        
        try{
            fileByteStream = new FileInputStream(filename);
            inFS = new Scanner(fileByteStream);
            inFS.useDelimiter ("[,\r\n]+");
            String unused = inFS.nextLine();
            while(inFS.hasNext()) {                                
                String SN = inFS.next();
                double XL = inFS.nextDouble();
                double YL = inFS.nextDouble();
                double B = inFS.nextDouble();
                int S = inFS.nextInt();
                int T = inFS.nextInt();
                ShipObject currentShip = new ShipObject(SN, XL, YL, B, S, T);
                shipList.add(currentShip);
                            }
            fileByteStream.close();
            
        } catch(IOException error1) {
            System.out.println("Oops! Error related to: " + filename);
        }
    }
        
    public String getGameText()
    {
        String x = "Game prompts will go here";
        return x;
    }
    
    public String turn()
    {
        String x = "Active Ship";
        return x;
    }
        
    public void updateShip(ShipObject ship, double xl, double yl, double b)
    {
        ship.setXLoc(xl);
        ship.setYLoc(yl);
        ship.setBearing(b);
    }
    
    
    
    //movetype = { Straight = 0, bank left = 1, bank right = 2, turn left = 3, turn right = 4 }
    //distance = {1, 2, 3, 4, 5}
    
    public void stepMoveShip( int moveType, int distance) 
    {
        int m_shipIndex;
        ShipObject l_curShip = shipList.get(t);//GetCurrentShip();
        for (int i = 0; i < STEPS; ++i)
        {
            // Start at the last / final position, and work backwards
            int l_curStep =(int) STEPS - i;
            ShipObject perposedMove;
            if(moveType == 0) {
                perposedMove = l_curShip.straight(distance, l_curStep);
            } else if(moveType == 1) {
                perposedMove = l_curShip.bank(distance, 0, l_curStep);
            } else if(moveType == 2) {
                perposedMove = l_curShip.bank(distance, 1, l_curStep);
            } else if(moveType == 3) {
                perposedMove = l_curShip.turn(distance, 0, l_curStep);
            } else if(moveType == 4) {
                perposedMove = l_curShip.turn(distance, 1, l_curStep);
            } else{
                perposedMove = l_curShip;
            }
            
            // if(proxCheck(perposedMove) == true) {
                // shipList.get(t).updateShipLocation(perposedMove);
                // break;
            // } else 
            if (collisionCheck(perposedMove) == true) {
                shipList.get(t).updateShipLocation(perposedMove);
                break;
            }            
        }        
    }
    
    public boolean proxCheck(ShipObject testShip) {
        double X = testShip.getXLoc();
        double Y = testShip.getYLoc();
        double S = testShip.getBase();
        
        for(int i = 0; i < shipList.size(); i++) {
            if(i != t) {
                if(S == 4 && shipList.get(i).getBase() == 4) {
                   if( Math.abs(X - shipList.get(i).getXLoc()) + 
                   Math.abs(Y - shipList.get(i).getYLoc()) < 5.657) {
                       return false;
                   }
                }
                if(S == 4 && shipList.get(i).getBase() == 8) {
                   if( Math.abs(X - shipList.get(i).getXLoc()) + 
                   Math.abs(Y - shipList.get(i).getYLoc()) < 8.485) {
                       return false;
                   }
                }
                if(S == 8 && shipList.get(i).getBase() == 4) {
                   if( Math.abs(X - shipList.get(i).getXLoc()) + 
                   Math.abs(Y - shipList.get(i).getYLoc()) < 8.485) {
                       return false;
                   }
                }
                if(S == 8 && shipList.get(i).getBase() == 8) {
                   if( Math.abs(X - shipList.get(i).getXLoc()) + 
                   Math.abs(Y - shipList.get(i).getYLoc()) < 11.314) {
                       return false;
                   }
                }
            }
        }
        return true;
    }
    
    public boolean collisionCheck(ShipObject testShip) {
        //get corners of attempeted move
        double l_x1 = testShip.getCorner1X();
        double l_x2 = testShip.getCorner2X();
        double l_x3 = testShip.getCorner3X();
        double l_x4 = testShip.getCorner4X();
        double l_y1 = testShip.getCorner1Y();
        double l_y2 = testShip.getCorner2Y();
        double l_y3 = testShip.getCorner3Y();
        double l_y4 = testShip.getCorner4Y();
        double l_b = testShip.getBearing();
        
        //rotate around (0,0) for new corners with bearing 0
        l_x1 = l_x1 * Math.cos(d2R(l_b)) - l_y1 * Math.sin(d2R(l_b));
        l_x1 = l_x1 * Math.cos(d2R(l_b)) - l_y1 * Math.sin(d2R(l_b));
        l_x1 = l_x1 * Math.cos(d2R(l_b)) - l_y1 * Math.sin(d2R(l_b));
        l_x1 = l_x1 * Math.cos(d2R(l_b)) - l_y1 * Math.sin(d2R(l_b));
        l_y1 = l_y1 * Math.cos(d2R(l_b)) + l_x1 * Math.sin(d2R(l_b));
        l_y1 = l_y1 * Math.cos(d2R(l_b)) + l_x1 * Math.sin(d2R(l_b));
        l_y1 = l_y1 * Math.cos(d2R(l_b)) + l_x1 * Math.sin(d2R(l_b));
        l_y1 = l_y1 * Math.cos(d2R(l_b)) + l_x1 * Math.sin(d2R(l_b));
        
        //get collision area
        double upperX = l_x1;
        if(l_x2 > upperX) {
            upperX = l_x2;
        }
        if (l_x3 > upperX) {
            upperX = l_x3;
        }
        if (l_x4 > upperX) {
            upperX = l_x4;
        }
        double lowerX = l_x1;
        if(l_x2 < lowerX) {
            lowerX = l_x2;
        }
        if (l_x3 < lowerX) {
            lowerX = l_x3;
        }
        if (l_x4 < lowerX) {
            lowerX = l_x4;
        }
        
        double upperY = l_y1;
        if(l_y2 > upperY) {
            upperY = l_y2;
        }
        if (l_y3 > upperY) {
            upperY = l_y3;
        }
        if (l_y4 > upperY) {
            upperY = l_y4;
        }
        double lowerY = l_y1;
        if(l_y2 < lowerY) {
            lowerY = l_y2;
        }
        if (l_y3 < lowerY) {
            lowerY = l_y3;
        }
        if (l_y4 < lowerY) {
            lowerY = l_y4;
        }
        //transform all ships corners the same amount as attempted moves bearing, check for corners
        //within transformed attempted move.
        for(int i = 0; i < shipList.size(); i++) {
            if (i != t) {
                ShipObject l_ship = shipList.get(i);
                l_x1 = l_ship.getCorner1X();
                l_x2 = l_ship.getCorner2X();
                l_x3 = l_ship.getCorner3X();
                l_x4 = l_ship.getCorner4X();
                l_y1 = l_ship.getCorner1Y();
                l_y2 = l_ship.getCorner2Y();
                l_y3 = l_ship.getCorner3Y();
                l_y4 = l_ship.getCorner4Y();
                //l_b = l_ship.getBearing();
                
                l_x1 = l_x1 * Math.cos(d2R(l_b)) - l_y1 * Math.sin(d2R(l_b));
                l_x1 = l_x1 * Math.cos(d2R(l_b)) - l_y1 * Math.sin(d2R(l_b));
                l_x1 = l_x1 * Math.cos(d2R(l_b)) - l_y1 * Math.sin(d2R(l_b));
                l_x1 = l_x1 * Math.cos(d2R(l_b)) - l_y1 * Math.sin(d2R(l_b));
                l_y1 = l_y1 * Math.cos(d2R(l_b)) + l_x1 * Math.sin(d2R(l_b));
                l_y1 = l_y1 * Math.cos(d2R(l_b)) + l_x1 * Math.sin(d2R(l_b));
                l_y1 = l_y1 * Math.cos(d2R(l_b)) + l_x1 * Math.sin(d2R(l_b));
                l_y1 = l_y1 * Math.cos(d2R(l_b)) + l_x1 * Math.sin(d2R(l_b));
                
                if(l_x1 > lowerX && l_x1 < upperX && l_y1 > lowerY && l_y1 < upperY) {
                    return false;
                }
                if(l_x2 > lowerX && l_x2 < upperX && l_y2 > lowerY && l_y2 < upperY) {
                    return false;
                }
                if(l_x3 > lowerX && l_x3 < upperX && l_y3 > lowerY && l_y3 < upperY) {
                    return false;
                }
                if(l_x4 > lowerX && l_x4 < upperX && l_y4 > lowerY && l_y4 < upperY) {
                    return false;
                }
            }
        }
        // check if any corners of attempted move are in other ships.
        for(int i = 0; i < shipList.size(); i++) {
            if(i != t) {
                ShipObject l_newTestShip = shipList.get(i);
                
                l_x1 = l_newTestShip.getCorner1X();
                l_x2 = l_newTestShip.getCorner2X();
                l_x3 = l_newTestShip.getCorner3X();
                l_x4 = l_newTestShip.getCorner4X();
                l_y1 = l_newTestShip.getCorner1Y();
                l_y2 = l_newTestShip.getCorner2Y();
                l_y3 = l_newTestShip.getCorner3Y();
                l_y4 = l_newTestShip.getCorner4Y();
                l_b = l_newTestShip.getBearing();
                
                l_x1 = l_x1 * Math.cos(d2R(l_b)) - l_y1 * Math.sin(d2R(l_b));
                l_x1 = l_x1 * Math.cos(d2R(l_b)) - l_y1 * Math.sin(d2R(l_b));
                l_x1 = l_x1 * Math.cos(d2R(l_b)) - l_y1 * Math.sin(d2R(l_b));
                l_x1 = l_x1 * Math.cos(d2R(l_b)) - l_y1 * Math.sin(d2R(l_b));
                l_y1 = l_y1 * Math.cos(d2R(l_b)) + l_x1 * Math.sin(d2R(l_b));
                l_y1 = l_y1 * Math.cos(d2R(l_b)) + l_x1 * Math.sin(d2R(l_b));
                l_y1 = l_y1 * Math.cos(d2R(l_b)) + l_x1 * Math.sin(d2R(l_b));
                l_y1 = l_y1 * Math.cos(d2R(l_b)) + l_x1 * Math.sin(d2R(l_b));
                
                
                
                upperX = l_x1;
                if(l_x2 > upperX) {
                    upperX = l_x2;
                }
                if (l_x3 > upperX) {
                    upperX = l_x3;
                }
                if (l_x4 > upperX) {
                    upperX = l_x4;
                }
                lowerX = l_x1;
                if(l_x2 < lowerX) {
                    lowerX = l_x2;
                }
                if (l_x3 < lowerX) {
                    lowerX = l_x3;
                }
                if (l_x4 < lowerX) {
                    lowerX = l_x4;
                }
                
                upperY = l_y1;
                if(l_y2 > upperY) {
                    upperY = l_y2;
                }
                if (l_y3 > upperY) {
                    upperY = l_y3;
                }
                if (l_y4 > upperY) {
                    upperY = l_y4;
                }
                lowerY = l_y1;
                if(l_y2 < lowerY) {
                    lowerY = l_y2;
                }
                if (l_y3 < lowerY) {
                    lowerY = l_y3;
                }
                if (l_y4 < lowerY) {
                    lowerY = l_y4;
                }
                
                ShipObject l_ship = testShip;
                l_x1 = l_ship.getCorner1X();
                l_x2 = l_ship.getCorner2X();
                l_x3 = l_ship.getCorner3X();
                l_x4 = l_ship.getCorner4X();
                l_y1 = l_ship.getCorner1Y();
                l_y2 = l_ship.getCorner2Y();
                l_y3 = l_ship.getCorner3Y();
                l_y4 = l_ship.getCorner4Y();
                //l_b = l_ship.getBearing();
                
                l_x1 = l_x1 * Math.cos(d2R(l_b)) - l_y1 * Math.sin(d2R(l_b));
                l_x1 = l_x1 * Math.cos(d2R(l_b)) - l_y1 * Math.sin(d2R(l_b));
                l_x1 = l_x1 * Math.cos(d2R(l_b)) - l_y1 * Math.sin(d2R(l_b));
                l_x1 = l_x1 * Math.cos(d2R(l_b)) - l_y1 * Math.sin(d2R(l_b));
                l_y1 = l_y1 * Math.cos(d2R(l_b)) + l_x1 * Math.sin(d2R(l_b));
                l_y1 = l_y1 * Math.cos(d2R(l_b)) + l_x1 * Math.sin(d2R(l_b));
                l_y1 = l_y1 * Math.cos(d2R(l_b)) + l_x1 * Math.sin(d2R(l_b));
                l_y1 = l_y1 * Math.cos(d2R(l_b)) + l_x1 * Math.sin(d2R(l_b));
                
                if(l_x1 > lowerX && l_x1 < upperX && l_y1 > lowerY && l_y1 < upperY) {
                    return false;
                }
                if(l_x2 > lowerX && l_x2 < upperX && l_y2 > lowerY && l_y2 < upperY) {
                    return false;
                }
                if(l_x3 > lowerX && l_x3 < upperX && l_y3 > lowerY && l_y3 < upperY) {
                    return false;
                }
                if(l_x4 > lowerX && l_x4 < upperX && l_y4 > lowerY && l_y4 < upperY) {
                    return false;
                }
                
            }
        }
        return true;      
    }
            
    public double d2R(double deg)
    {
        double rad = deg * Math.PI/180;
        return rad;
    }
}
