package XWing;
/**
 * Write a description of class GameBoard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.util.ArrayList;
import java.awt.event.*;
import java.awt.geom.*;

public class GameBoard extends JPanel
{
    // instance variables - replace the example below with your own
    private final double CM = 7.0;
    //11.81
    ArrayList<ShipObject> currentBoard = new ArrayList<ShipObject>();
    ArrayList<coor> CL;
    int x = 5;
    int y = 5;
    
    // private ShipDatabase SL = new ShipDatabase();
    // private int y = (int) SL.getY(1);

    public static void main(String[] args) {
        JFrame f = new JFrame();
        GameBoard l_game = new GameBoard();
        f.setContentPane(l_game);
        f.setSize((int)(91 * 7), (int)(91 * 7));
        f.setVisible(true);    
        l_game.currentBoard = new ArrayList <ShipObject>();
        ShipObject sample = new ShipObject("Sample", 12.0, 10.0, 180.0, 0 , 1);
        l_game.currentBoard.add(sample);
        sample = new ShipObject("X-Wing", 15.5, 5.0, 0.0, 0 , 0);
        l_game.currentBoard.add(sample);
        ArrayList<coor> CL = new ArrayList <coor>();
        
        
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void paintComponent(Graphics g)    
    {
        
        super.paintComponent(g);
        
        setBackground(Color.BLACK);
        
        // if(currentBoard.size() > 0) {
            // for(ShipObject ship : currentBoard) {
                // if(ship.getBase() == 4 && ship.getTeam() == 0) {
                    // // Graphics2D g2d = (Graphics2D)g;
                    // // g2d.setColor(Color.RED);
                    // // Rectangle ("rect" +i) = new Rectangle ((int)((ship.getXLoc() - 2)* CM), 
                     // // (int)((ship.getYLoc() + 2) * CM), (int)(4 * CM), (int)(4 * CM));
                     // // g2d.rotate(Math.toRadians(ship.getBearing()));
                     // // g2d.draw(rect2);
                     // // g2d.fill(rect2);
                     
                    // g.setColor(Color.RED);
                    // g.fillRect((int)((ship.getXLoc() - 2)* CM), 
                    // (int)((ship.getYLoc() + 2) * CM), (int)(4 * CM), (int)(4 * CM));
                    
                // }
                // if(ship.getBase() == 8 && ship.getTeam() == 0) {
                    // g.setColor(Color.RED);
                    // g.fillRect((int)((ship.getXLoc() - 4)* CM), 
                    // (int)((ship.getYLoc() + 4) * CM), (int)(8 * CM), (int)(8 * CM));
                // }
                // if(ship.getBase() == 4 && ship.getTeam() == 1) {
                    // g.setColor(Color.BLUE);
                    // g.fillRect((int)((ship.getXLoc() - 2)* CM), 
                    // (int)((ship.getYLoc() + 2) * CM), (int)(4 * CM), (int)(4 * CM));
                // }
                // if(ship.getBase() == 8 && ship.getTeam() == 1) {
                    // g.setColor(Color.BLUE);
                    // g.fillRect((int)((ship.getXLoc() - 4)* CM), 
                    // (int)((ship.getYLoc() + 4) * CM), (int)(8 * CM), (int)(8 * CM));
                // }
            // }
        // }
        
        if(currentBoard.size() > 0) {
            for(ShipObject ship : currentBoard) {
                if(ship.getTeam() == 0) {
                    g.setColor(Color.RED);
                } else {
                    g.setColor(Color.BLUE);
                }
                int l_x1 = (int) (ship.getCorner1X() * CM);
                int l_x2 = (int) (ship.getCorner2X() * CM);
                int l_x3 = (int) (ship.getCorner3X() * CM);
                int l_x4 = (int) (ship.getCorner4X() * CM);
                int l_y1 = (int) (ship.getCorner1Y() * CM);
                int l_y2 = (int) (ship.getCorner2Y() * CM);
                int l_y3 = (int) (ship.getCorner3Y() * CM);
                int l_y4 = (int) (ship.getCorner4Y() * CM);
                int l_xc = (int) (ship.getXLoc() * CM);
                int l_yc = (int) (ship.getYLoc() * CM);
                int l_ydist = 637;
                g.fillOval(l_xc - 5, l_ydist -l_yc + 5, 10, 10);
                g.fillOval(l_x1 - 5, l_ydist - l_y1 + 5, 10, 10);
                g.fillOval(l_x2 - 5, l_ydist - l_y2 + 5, 10, 10);
                g.fillOval(l_x3 - 5, l_ydist - l_y3 + 5, 10, 10);
                g.fillOval(l_x4 - 5, l_ydist - l_y4 + 5, 10, 10);
            }
        }
                    
        // for(int i = 0; i < game.listLength(); i++) {
            // g.setColor(Color.RED);
            // g.fillRect((int)((game.getX() - 2) * CM),
            // (int)((game.getY() + 2) * CM), (int)(4 * CM), (int)(4 * CM));
        // }
        
        // x = x+2;
        // y = y +2;
        
        // g.setColor(Color.RED);
        // g.fillRect((int)((x - 2)* CM), 
                // (int)((y + 2) * CM), (int)(4 * CM), (int)(4 * CM));
        // g.fillRect((int)(List.get(0).getXLoc() * CM), 
            // (int)(List.get(0).getYLoc() * CM), (int)(4 * CM), (int)(4 * CM));
        
        
            
            
    }
    public void drawMap(ArrayList<ShipObject> curMap)
    {
        currentBoard = curMap;        
        repaint();   
    }
    // public void paintShips(ArrayList<ShipObject> list)
    // {
        // super.paintComponent(g);
        
        
        // for(ShipObject ship : list) {
            // if(ship.getSize() == 0 && ship.getTeam() == 0) {
                // g.setColor(Color.RED);
                // g.fillRect((int)((ship.getXLoc() - 2)* CM), 
                // (int)((ship.getYLoc() + 2) * CM), (int)(4 * CM), (int)(4 * CM));
            // }
            // if(ship.getSize() == 1 && ship.getTeam() == 0) {
                // g.setColor(Color.RED);
                // g.fillRect((int)((ship.getXLoc() - 4)* CM), 
                // (int)((ship.getYLoc() + 4) * CM), (int)(8 * CM), (int)(8 * CM));
            // }
            // if(ship.getSize() == 0 && ship.getTeam() == 1) {
                // g.setColor(Color.BLUE);
                // g.fillRect((int)((ship.getXLoc() - 2)* CM), 
                // (int)((ship.getYLoc() + 2) * CM), (int)(4 * CM), (int)(4 * CM));
            // }
            // if(ship.getSize() == 1 && ship.getTeam() == 1) {
                // g.setColor(Color.BLUE);
                // g.fillRect((int)((ship.getXLoc() - 4)* CM), 
                // (int)((ship.getYLoc() + 4) * CM), (int)(8 * CM), (int)(8 * CM));
            // }
        // }
    //}
       
}
