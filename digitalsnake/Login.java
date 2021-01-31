package digitalsnake;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class Login extends JFrame implements ActionListener {
    
    private JLabel userLabel, passLabel, k;
    private JTextField tf;
    private JPasswordField pf;
    // private JCheckBox showPassword;
    JCheckBox showPassword = new JCheckBox();
    private JButton loginButton, clearButton, signupButton;
    private Container c;
    private ImageIcon front, t;
    private Font f;
    private Color color;
    
    Login() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(500, 100, 700, 700);
        this.setTitle("SNAKE GAME");
        
        c = this.getContentPane();
        front = new ImageIcon(getClass().getResource("images.png"));
        this.setIconImage(front.getImage());
        color = new Color(47, 50, 57);
        c.setBackground(color);
        c.setLayout(null);
        
        t = new ImageIcon(getClass().getResource("ol.png"));
        
        k = new JLabel(t);
        k.setBounds(100, 300, 450, 450);
        c.add(k);
        
        f = new Font("Arial", Font.BOLD, 18);
        
        userLabel = new JLabel("USER-EMAIL : ");
        userLabel.setBounds(80, 50, 145, 50);
        // userLabel.setBackground(Color.RED);
        userLabel.setForeground(Color.RED);
        
        userLabel.setFont(f);
        c.add(userLabel);
        
        tf = new JTextField();
        tf.setFont(f);
        tf.setBounds(230, 50, 205, 50);
        c.add(tf);

        // passLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        passLabel = new JLabel("PASSWORD : ");
        passLabel.setFont(f);
        passLabel.setBounds(85, 120, 155, 50);
        passLabel.setForeground(Color.RED);
        c.add(passLabel);
        
        pf = new JPasswordField();
        pf.setBounds(230, 120, 205, 50);
        c.add(pf);
        
        loginButton = new JButton("Login");
        loginButton.setFont(f);
        loginButton.setBounds(230, 230, 90, 50);
        c.add(loginButton);
        
        clearButton = new JButton("Clear");
        clearButton.setFont(f);
        clearButton.setBounds(340, 230, 90, 50);
        c.add(clearButton);
        
        signupButton = new JButton("Sign");
        signupButton.setFont(f);
        signupButton.setBounds(570, 590, 100, 50);
        c.add(signupButton);
        
        clearButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                tf.setText("");
                pf.setText("");
            }
        });
        
        signupButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (e.getSource() == signupButton) {
                    //this.setVisible(false);
                    dispose();
                    SignUp s = new SignUp();
                    s.setVisible(true);
                    
                }
            }
            
        });
        
        loginButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                String userName = tf.getText();
                String password = pf.getText();
                try {
                    String path = "F:\\Java Problem\\DigitalSnake\\src\\digitalsnake\\file.txt";
                    // System.out.println("1");
                    //Scanner get = new Scanner(new File(path));
                    FileReader fr = new FileReader(path);
                    BufferedReader br = new BufferedReader(fr);
                    
                    boolean isLoginSuccess = false, isfromNSU = false;
                    int u = 0;
                    String line, fuserEmail, fpass, fuserID;

                    //while ((line = get.nextLine()) != null)
                    while ((line = br.readLine()) != null) {
                        // System.out.println(line);
                        fuserEmail = line.split(" ")[2];
                        fpass = line.split(" ")[3];
                        
                        fuserID = fuserEmail.split("@")[0];
                        //System.out.println(fuserID);

                        if (fuserEmail.split("@")[1].equalsIgnoreCase("northsouth.edu")) {
                            isfromNSU = true;
                        }
                        
                        if ((fuserID.equalsIgnoreCase(userName) || fuserEmail.equalsIgnoreCase(userName)) && fpass.equals(password)) {
                            isLoginSuccess = true;

//                            this.setVisible(false);
//
//                            HomePage dashboard = new HomePage(fuserEmail);
//                            dashboard.setVisible(true);
                            dispose();
                            SelectType dashboard = new SelectType();
                            dashboard.setVisible(true);
                            break;
                        } else if (fuserID.equalsIgnoreCase(userName) || fuserEmail.equalsIgnoreCase(userName)) {
                            u++;
                        }
                    }
                    if (!isLoginSuccess) {
                        if (u > 0) {
                            JOptionPane.showMessageDialog(null, "Invalid Password!", "WARNING!!", JOptionPane.WARNING_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid User!", "WARNING!!", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    
                    fr.close();
                    //get.close();

                } catch (Exception ep) {
                    System.out.println("ERROR 404! File-Not-Found");
                    //ep.printStackTrace();
                }
                
            }
            
        });
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
