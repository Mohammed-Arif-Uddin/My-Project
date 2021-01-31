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

class SelectType extends JFrame {

    private Container c;
    private JLabel d, e, bgi;
    private ImageIcon Iicon, si, iconsnake;
    private JButton jb, ab;

    SelectType() {
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
//
//        d = new JLabel("WELCOME TO SNAKE GAME");
//        d.setBounds(50, 50, 800, 100);
//        d.setForeground(Color.WHITE);
//        d.setFont(new Font("arial", Font.BOLD, 50));
//        c.add(d);

//        si = new ImageIcon(getClass().getResource("p_1.png"));
//        e = new JLabel(si);
//        e.setBounds(200, 450, 400, 300);
//        c.add(e);
        jb = new JButton("Select Game Type");
        jb.setFont(new Font("arial", Font.BOLD, 20));
        jb.setForeground(Color.BLUE);
        jb.setBounds(230, 340, 250, 60);
        c.add(jb);

//        ab = new JButton("START With Border Snake");
//        ab.setFont(new Font("arial", Font.BOLD, 20));
//        ab.setForeground(Color.BLUE);
//        ab.setBounds(250, 450, 500, 60);
//        c.add(ab);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                GameStart gp = new GameStart();
                gp.setVisible(true);
            }
        });

//        ab.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                dispose();
//                Snake up = new Snake();
//                up.setVisible(true);
//            }
//        });
    }
//    public static void main(String[] args) {
//        SelectType a=new SelectType();
//        a.setVisible(true);
//    }

}
