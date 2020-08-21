
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.*;
import java.text.*;
/**
 * Write a description of class XWingGUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class XWingGUI extends JFrame implements ActionListener
{
    GameBoard gb;
    private ShipDatabase game;
    
    private JPanel panel;
    private JTextField textField;
    private JButton s1;
    private JButton s2;
    private JButton s3;
    private JButton s4;
    private JButton s5;
    private JButton rt1;
    private JButton rt2;
    private JButton rt3;
    private JButton lt1;
    private JButton lt2;
    private JButton lt3;
    private JButton rb1;
    private JButton rb2;
    private JButton rb3;
    private JButton lb1;
    private JButton lb2;
    private JButton lb3;
    private JButton stop;
    private JButton removeShip;
    private JButton nextTurn;
    private JButton nextShip;
    private JButton drawMap;
    private JButton PS;
    
    private double CM = 11.81;
    //11.81
    private int BUTTON_COL_1; // = (int)(10 * CM);
    private final int BUTTON_COL_2 = (int)(21 * CM);
    private final int BUTTON_COL_3 = (int)(32 * CM);
    private final int BUTTON_COL_4 = (int)(43 * CM);
    private final int BUTTON_COL_5 = (int)(54 * CM);
    private final int BUTTON_COL_6 = (int)(65 * CM);
    private final int BUTTON_COL_7 = (int)(76 * CM);
    
    private final int BUTTON_ROW_1 = (int)(144 * CM);
    private final int BUTTON_ROW_2 = (int)(139 * CM);
    private final int BUTTON_ROW_3 = (int)(134* CM);
    private final int BUTTON_ROW_4 = (int)(129 * CM);
    private final int BUTTON_ROW_5 = (int)(124 * CM);
    private final int BUTTON_ROW_6 = (int)(119 * CM);
    
    
    private final int BUTTON_HIGHT = (int)(4 * CM);
    private final int BUTTON_WIDTH = (int)(10 * CM);
    
    
    
    private JLabel message;
    private JLabel turn;
        
    private JMenuBar menus;
    private JMenu fileMenu;
    private JMenuItem open;
    private JMenuItem exit;
    
    
    //private ShipObject moves;
    
    //private ShipDatabase SD;
    // private JLayeredPane lpane = new JLayeredPane();
    // private JPanel board = new JPanel();
    // private JPanel control = new JPanel();
    
    
    
    
    public static void main(String args[]) {
        XWingGUI gui = new XWingGUI();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setTitle("Benjamin Burkholder's Board");
        gui.pack();
        gui.setSize((int)( 91 * 11.81), (int)(162 * 11.81));
    
    }
    
    public XWingGUI(){
        // SD = new ShipDatabase();
        // game.readSheet("ship_list.csv");
        
        setSize((int)( 91 * CM), (int)(162 * CM));
        setLocationRelativeTo(null);
        panel = new JPanel();
        add(panel);
        panel.setLayout(null);
                
        game = new ShipDatabase();
        // game.readSheet("ship_list.csv");
        // game.print();
        
        gb = new GameBoard();
        //CM = gb.getPixelToCM();
        gb.setBounds((int)(1 * CM),(int)(1 * CM), (int)( 91 * CM), (int)( 91 * CM));
        panel.add(gb);
        //moves = new ShipObject;
        
        
        
        
        // setLayout(new GridBagLayout());
        // GridBagConstraints position = new GridBagConstraints();
        
        JMenuBar menus = new JMenuBar();
        setJMenuBar(menus);
        
        JMenu fileMenu = new JMenu("File");
        menus.add(fileMenu);
        open = new JMenuItem("Open");
        open.addActionListener(this);
        fileMenu.add(open);
        exit = new JMenuItem("Exit");        
        exit.addActionListener(this);
        fileMenu.add(exit);
        
        
        
        message = new JLabel(game.getGameText());
        message.setBounds((int)(17 * CM), (int)(102 * CM), (int)(57.5 * CM), (int)(4 * CM));
        panel.add(message);
        
        turn = new JLabel(game.turn());
        turn.setBounds((int)(17 * CM), (int)( 92 * CM), (int)(91 * CM), (int)(4 * CM));
        panel.add(turn);
        
        JButton PS = new JButton("Print");
        PS.setBounds(BUTTON_COL_1, BUTTON_ROW_4, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(PS);
        PS.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
               game.print();
            }
        });
        
        JButton drawMap = new JButton("Draw Map");
        drawMap.setBounds(BUTTON_COL_1, BUTTON_ROW_5, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(drawMap);
        drawMap.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
               plot();
            }
        });
        
        JButton s1 = new JButton("Straight 1");
        s1.setBounds(BUTTON_COL_3, BUTTON_ROW_1, BUTTON_WIDTH, BUTTON_HIGHT);
        s1.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {                
                game.stepMoveShip(0, 1);
            }
        });
        panel.add(s1);
        
        JButton s2 = new JButton("Straight 2");
        s2.setBounds(BUTTON_COL_3, BUTTON_ROW_2, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(s2); 
        s2.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                game.stepMoveShip(0, 2);
            }
        });
        
        JButton s3 = new JButton("Straight 3");
        s3.setBounds(BUTTON_COL_3, BUTTON_ROW_3, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(s3);
        s3.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                game.stepMoveShip(0, 3);
            }
        });
        JButton s4 = new JButton("Straight 4");
        s4.setBounds(BUTTON_COL_3, BUTTON_ROW_4, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(s4); 
        s4.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                game.stepMoveShip(0, 4);;
            }
        });
        JButton s5 = new JButton("Straight 5");
        s5.setBounds(BUTTON_COL_3, BUTTON_ROW_5, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(s5);
        s5.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                game.stepMoveShip(0, 5);
            }
        });
        JButton rb1 = new JButton("Bank R 1");
        rb1.setBounds(BUTTON_COL_4, BUTTON_ROW_1, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(rb1);
        rb1.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
               game.stepMoveShip(2, 1);
            }
        });
        JButton rb2 = new JButton("Bank R 2");
        rb2.setBounds(BUTTON_COL_4, BUTTON_ROW_2, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(rb2); 
        rb2.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
               game.stepMoveShip(2, 2);
            }
        });
        JButton rb3 = new JButton("Bank R 3");
        rb3.setBounds(BUTTON_COL_4, BUTTON_ROW_3, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(rb3);
        rb3.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
               game.stepMoveShip(2, 2);
            }
        });
        JButton lb1 = new JButton("Bank L 1");
        lb1.setBounds(BUTTON_COL_2, BUTTON_ROW_1, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(lb1);
        lb1.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
               game.stepMoveShip(1, 1);
            }
        });
        JButton lb2 = new JButton("Bank L 2");
        lb2.setBounds(BUTTON_COL_2, BUTTON_ROW_2, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(lb2); 
        lb2.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
               game.stepMoveShip(1, 2);
            }
        });
        JButton lb3 = new JButton("Bank L 3");
        lb3.setBounds(BUTTON_COL_2, BUTTON_ROW_3, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(lb3);
        lb3.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
               game.stepMoveShip(1, 3);
            }
        });
        JButton rt1 = new JButton("Turn R 1");
        rt1.setBounds(BUTTON_COL_5, BUTTON_ROW_1, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(rt1);
        rt1.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
               game.stepMoveShip(4, 1);
            }
        });
        JButton rt2 = new JButton("Turn R 2");
        rt2.setBounds(BUTTON_COL_5, BUTTON_ROW_2, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(rt2); 
        rt2.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
               game.stepMoveShip(4, 2);
            }
        });
        JButton rt3 = new JButton("Turn R 3");
        rt3.setBounds(BUTTON_COL_5, BUTTON_ROW_3, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(rt3);
        rt3.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
               game.stepMoveShip(4, 3);
            }
        });
        JButton lt1 = new JButton("Turn L 1");
        lt1.setBounds(BUTTON_COL_1, BUTTON_ROW_1, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(lt1);
        lt1.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
               game.stepMoveShip(3, 1);
            }
        });
        JButton lt2 = new JButton("Turn L 2");
        lt2.setBounds(BUTTON_COL_1, BUTTON_ROW_2, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(lt2); 
        lt2.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
               game.stepMoveShip(3, 2);
            }
        });
        JButton lt3 = new JButton("Turn L 3");
        lt3.setBounds(BUTTON_COL_1, BUTTON_ROW_3, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(lt3);
        lt3.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
               game.stepMoveShip(3, 3);
            }
        });
        JButton nextTurn = new JButton("Next Turn");
        nextTurn.setBounds(BUTTON_COL_7, BUTTON_ROW_2, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(nextTurn);
        nextTurn.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
               game.nextTurn();
            }
        });
        
        JButton nextShip = new JButton("Next Ship");
        nextShip.setBounds(BUTTON_COL_7, BUTTON_ROW_4, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(nextShip);
        nextShip.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
               game.nextShip();
            }
        });
        
        JButton removeShip = new JButton("Remove Ship");
        removeShip.setBounds(BUTTON_COL_7, BUTTON_ROW_1, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(removeShip);
        removeShip.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
               game.removeShip();
            }
        });
        
    }
    private void openFile(){

        // create File Chooser so that it starts at the current directory
        String userDir = System.getProperty("user.dir");
        JFileChooser fc = new JFileChooser(userDir);

        // show File Chooser and wait for user selection
        int returnVal = fc.showOpenDialog(this);

        // did the user select a file?
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String filename = fc.getSelectedFile().getName();
            // FIX ME: use your database object
            game.readSheet(filename);          
        }
    }
    
    private void plot()
    {
        gb.drawMap(game.getAL());
    }
        
        
    
    public void actionPerformed(ActionEvent event){
        System.out.println("this works a little");
        if (event.getSource() == exit) {
            System.exit(0);
        }
        if (event.getSource() == PS) {
            game.print();
        }
        if (event.getSource() == open) {
            openFile();
        }
        // if (event.getSource() == drawMap) {
            // gb.drawMap(game.getAL());
            // gb.repaint();
        // }
        // if (event.getSource() == s1) {
            // System.out.println("yay");
            // game.straight1();
        // }
        // if(event.getSource() == s2) {
            // game.straight2();
        // }
        // if(event.getSource() == s3) {
            // game.straight3();
        // }
        // if(event.getSource() == s4) {
            // game.straight4();
        // }
        // if(event.getSource() == s5) {
            // game.straight5();
        // }
        // if(event.getSource() == rb1) {
            // game.bankRight1();
        // }
        // if(event.getSource() == rb2) {
            // game.bankRight2();
        // }
        // if(event.getSource() == rb3) {
            // game.bankRight3();
        // }
        // if(event.getSource() == lb1) {
            // game.bankLeft1();
        // }
        // if(event.getSource() == lb2) {
            // game.bankLeft2();
        // }
        // if(event.getSource() == lb3) {
            // game.bankLeft3();
        // }
        // if(event.getSource() == rt1) {
            // game.turnRight1();
        // }
        // if(event.getSource() == rt2) {
            // game.turnRight2();
        // }
        // if(event.getSource() == rt3) {
            // game.turnRight3();
        // }
        // if(event.getSource() == lt1) {
            // game.turnLeft1();
        // }
        // if(event.getSource() == lt2) {
            // game.turnLeft2();
        // }
        // if(event.getSource() == lt3) {
            // game.turnLeft3();
            // System.out.print("Now a lot");
        // }
        if(event.getSource() == removeShip) {
            game.removeShip();
        }
        if(event.getSource() == nextShip) {
            game.nextShip();
        }
        if(event.getSource() == nextTurn) {
            game.nextTurn();
        }
        turn.setText("Current Ship: " + game.getShip());
        message.setText(game.getMessage());        
    }
    
    
}
