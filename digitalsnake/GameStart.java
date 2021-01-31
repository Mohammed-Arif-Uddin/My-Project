package digitalsnake;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class GameStart extends JFrame {

    private Container c;
    private JLabel d, e, bgi;
    private ImageIcon Iicon, si, iconsnake;
    private JButton jb, ab;

    GameStart() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Iicon = new ImageIcon(getClass().getResource("images.png"));
        this.setIconImage(Iicon.getImage());
        this.setBounds(500, 100, 700, 750);
        this.setTitle("SNAKE GAME");
        //this.setFont(new Font("San Francisco", Font.BOLD, 8));
        iconsnake = new ImageIcon(getClass().getResource("welcome.png"));
        bgi = new JLabel(iconsnake);
        bgi.setBounds(0, 0, 700, 750);
        this.add(bgi);
        c = this.getContentPane();
        c.setLayout(null);
        //c.setBackground(Color.BLACK);

        jb = new JButton("START Border Less Snake");
        jb.setFont(new Font("arial", Font.BOLD, 20));
        jb.setForeground(Color.BLUE);
        jb.setBounds(200, 300, 300, 60);
        c.add(jb);

        ab = new JButton("START With Border Snake");
        ab.setFont(new Font("arial", Font.BOLD, 20));
        ab.setForeground(Color.BLUE);
        ab.setBounds(200, 410, 300, 60);
        c.add(ab);

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SnakeGame gp = new SnakeGame();
                gp.setVisible(true);
            }
        });

    }

}
