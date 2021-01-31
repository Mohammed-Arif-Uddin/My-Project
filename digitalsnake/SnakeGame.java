package digitalsnake;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.JLabel;

class SnakeGame extends JFrame implements KeyListener, ActionListener {

    private int[] sxl = new int[750];
    private int[] syl = new int[750];

    private boolean right = false;
    private boolean left = false;
    private boolean up = false;
    private boolean down = false;

    private ImageIcon rm;
    private ImageIcon um;
    private ImageIcon dm;
    private ImageIcon lm;

    private int lofsnake = 3;
    private int move = 0;
    private int score = 0;
    private int hs = 0;

    private Timer time;
    private int delay = 200;
    private ImageIcon si;

    private int[] exp = {
        25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450,
        475, 500, 525, 550, 575, 600, 625, 650, 675, 700, 725, 750, 775, 800, 825, 850};

    private int[] eyp = {
        77, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450,
        475, 500, 525, 550, 575, 600, 625};

    private ImageIcon ei;

    private Random random = new Random();

    private int xpos = random.nextInt(34);
    private int ypos = random.nextInt(23);

    private ImageIcon titleimage;
    //private JLabel j;

    private ImageIcon ti, windowIcon;
    //private int score = 0;

    SnakeGame() {

        //JFrame obj = new JFrame();
        //snake b = new snake();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowIcon = new ImageIcon(getClass().getResource("images.png"));
        this.setIconImage(windowIcon.getImage());
        this.setBounds(500, 100, 905, 700);
        this.setBackground(Color.DARK_GRAY);
        this.setResizable(false);
        this.setVisible(true);

        this.setTitle("SNAKE GAME");
        this.setForeground(Color.RED);

        //this.add(b);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
        time = new Timer(delay, this);
        time.start();
        //paint();                                                                                                                                                              
    }

    public void paint(Graphics g) {

        if (move == 0) {
            sxl[2] = 50;
            sxl[1] = 75;
            sxl[0] = 100;

            syl[2] = 100;
            syl[1] = 100;
            syl[0] = 100;
        }
        g.setColor(Color.white);
        g.drawRect(24, 10, 851, 55);

        ti = new ImageIcon(getClass().getResource("st.jpg"));
        ti.paintIcon(this, g, 25, 30);

        g.setColor(Color.WHITE);
        g.drawRect(24, 90, 851, 577);

        g.setColor(Color.black);
        g.fillRect(25, 85, 850, 575);

        g.setColor(Color.RED);
        g.setFont(new Font("arial", Font.PLAIN, 14));
        g.drawString("Score: " + score, 32, 65);

        g.setColor(Color.RED);
        g.setFont(new Font("arial", Font.PLAIN, 14));
        g.drawString("Length: " + lofsnake, 783, 65);

        g.setColor(Color.red);
        g.setFont(new Font("arial", Font.PLAIN, 14));
        g.drawString("HighScore: " + hs, 100, 65);

        rm = new ImageIcon(ClassLoader.getSystemResource("digitalsnake/icons/rightmouth.png"));
        rm.paintIcon(this, g, sxl[0], syl[0]);

        for (int a = 0; a < lofsnake; a++) {
            if (a == 0 && right) {
                rm = new ImageIcon(ClassLoader.getSystemResource("digitalsnake/icons/rightmouth.png"));
                rm.paintIcon(this, g, sxl[a], syl[a]);
            }
            if (a == 0 && left) {
                lm = new ImageIcon(ClassLoader.getSystemResource("digitalsnake/icons/leftmouth.png"));
                lm.paintIcon(this, g, sxl[a], syl[a]);
            }
            if (a == 0 && down) {
                dm = new ImageIcon(ClassLoader.getSystemResource("digitalsnake/icons/downmouth.png"));
                dm.paintIcon(this, g, sxl[a], syl[a]);
            }
            if (a == 0 && up) {
                um = new ImageIcon(ClassLoader.getSystemResource("digitalsnake/icons/upmouth.png"));
                um.paintIcon(this, g, sxl[a], syl[a]);
            }

            if (a != 0) {
                si = new ImageIcon(ClassLoader.getSystemResource("digitalsnake/icons/snakeimage.png"));
                si.paintIcon(this, g, sxl[a], syl[a]);
            }
        }

        ei = new ImageIcon(ClassLoader.getSystemResource("digitalsnake/icons/apple.png"));

        if ((exp[xpos] == sxl[0]) && (eyp[ypos] == syl[0])) {
            score++;
            lofsnake++;
            xpos = random.nextInt(34);
            ypos = random.nextInt(23);
        }

        ei.paintIcon(this, g, exp[xpos], eyp[ypos]);

        for (int i = 1; i < lofsnake; i++) {
            if ((sxl[i] == sxl[0]) && (syl[i] == syl[0])) {
                right = false;
                left = false;
                up = false;
                down = false;

                g.setColor(Color.RED);
                g.setFont(new Font("arial", Font.BOLD, 50));
                g.drawString("GAME OVER!", 300, 300);

                g.setFont(new Font("arial", Font.BOLD, 20));
                g.drawString("IF U WANT RESTART U CLICK SPACE", 300, 340);
            }
        }
        if (score > hs) {
            hs = score;
        }

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        time.start();
        if (right) {
            for (int i = lofsnake - 1; i >= 0; i--) {
                syl[i + 1] = syl[i];
            }
            for (int i = lofsnake; i >= 0; i--) {
                if (i == 0) {
                    sxl[i] = sxl[i] + 25;
                } else {
                    sxl[i] = sxl[i - 1];
                }
                if (sxl[i] > 850) {
                    sxl[i] = 25;
                }
            }
            repaint();
        }
        if (left) {
            for (int i = lofsnake - 1; i >= 0; i--) {
                syl[i + 1] = syl[i];
            }
            for (int i = lofsnake; i >= 0; i--) {
                if (i == 0) {
                    sxl[i] = sxl[i] - 25;
                } else {
                    sxl[i] = sxl[i - 1];
                }
                if (sxl[i] < 25) {
                    sxl[i] = 850;
                }
            }
            repaint();
        }
        if (up) {
            for (int i = lofsnake - 1; i >= 0; i--) {
                sxl[i + 1] = sxl[i];
            }
            for (int i = lofsnake; i >= 0; i--) {
                if (i == 0) {
                    syl[i] = syl[i] - 22;
                } else {
                    syl[i] = syl[i - 1];
                }
                if (syl[i] < 77) {
                    syl[i] = 625;
                }
            }
            repaint();
        }
        if (down) {
            for (int i = lofsnake - 1; i >= 0; i--) {
                sxl[i + 1] = sxl[i];
            }
            for (int i = lofsnake; i >= 0; i--) {
                if (i == 0) {
                    syl[i] = syl[i] + 22;
                } else {
                    syl[i] = syl[i - 1];
                }
                if (syl[i] > 625) {
                    syl[i] = 77;
                }
            }
            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            move = 0;
            score = 0;
            lofsnake = 3;
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            move++;
            right = true;
            if (!left) {
                right = true;
            } else {
                right = false;
                left = true;
            }
            up = false;
            down = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            move++;
            left = true;
            if (!right) {
                left = true;
            } else {
                left = false;
                right = true;
            }
            up = false;
            down = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            move++;
            up = true;
            if (!down) {
                up = true;
            } else {
                up = false;
                down = true;
            }
            left = false;
            right = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            move++;
            down = true;
            if (!up) {
                down = true;
            } else {
                up = true;
                down = false;
            }
            left = false;
            right = false;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    public static void main(String[] args) {
        SnakeGame a=new SnakeGame();
        a.setVisible(true);
    }

}
