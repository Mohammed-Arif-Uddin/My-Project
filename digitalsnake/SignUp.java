/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalsnake;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class SignUp extends JFrame implements ActionListener {

    String path = "F:\\Java Problem\\DigitalSnake\\src\\digitalsnake\\file.txt";

    Container sContainer = getContentPane();

    JTextField fnTextField = new JTextField();
    JTextField lnTextField = new JTextField();
    JTextField idTextField = new JTextField();

    //ImageIcon window = new ImageIcon(getClass().getResource("signup.jpg"));
    ImageIcon bgi = new ImageIcon(getClass().getResource("signup.jpg"));

    JLabel term = new JLabel(bgi);
    private JLabel fn, ln, emailname, pass;

    JPasswordField passwordField = new JPasswordField();

    JCheckBox showPassword = new JCheckBox();
    private Color color;

    JButton regButton = new JButton("Create Account");
    JButton loginButton = new JButton("Log in");

    SignUp() {
        this.setTitle("SNAKE GAME");
        //this.setIconImage(window.getImage());
        this.setBounds(300, 80, 800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setBackground(Color.BLACK);
        this.setResizable(false);
        // bgi.setBounds(5,5,6,9);

        term.setBounds(0, 0, 800, 300);

        this.add(term);

        Initialize();
        addActionEvent();
    }

    public void Initialize() {

        sContainer.setLayout(null);
        color = new Color(21, 24, 41);
        sContainer.setBackground(color);
        //sContainer.setBackground(Color.BLACK);
        //fnTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        fn = new JLabel("Enter Your First Name: ");
        fn.setBounds(200, 295, 355, 50);
        fn.setFont(new Font("San Francisco", Font.BOLD, 20));
        fn.setForeground(Color.RED);
        sContainer.add(fn);

        fnTextField.setToolTipText("First name");
        fnTextField.setBounds(485, 310, 270, 28);
        fnTextField.setFont(new Font("San Francisco", Font.PLAIN, 15));
        sContainer.add(fnTextField);

        ln = new JLabel("Enter Your Last Name: ");
        ln.setBounds(200, 337, 355, 50);
        ln.setFont(new Font("San Francisco", Font.BOLD, 20));
        ln.setForeground(Color.RED);
        sContainer.add(ln);

        lnTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        lnTextField.setBounds(485, 350, 270, 28);
        lnTextField.setToolTipText("Last name");
        lnTextField.setFont(new Font("San Francisco", Font.PLAIN, 15));
        sContainer.add(lnTextField);

        emailname = new JLabel("Enter Your E-Mail       : ");
        emailname.setBounds(200, 375, 355, 50);
        emailname.setFont(new Font("San Francisco", Font.BOLD, 20));
        emailname.setForeground(Color.RED);
        sContainer.add(emailname);

        idTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        idTextField.setBounds(485, 390, 270, 28);
        idTextField.setToolTipText("Email address");
        idTextField.setFont(new Font("San Francisco", Font.PLAIN, 15));
        sContainer.add(idTextField);

        pass = new JLabel("Enter Your Password : ");
        pass.setBounds(200, 417, 355, 50);
        pass.setFont(new Font("San Francisco", Font.BOLD, 20));
        pass.setForeground(Color.RED);
        sContainer.add(pass);

        passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        passwordField.setBounds(485, 430, 270, 28);
        passwordField.setToolTipText("Password");
        passwordField.setFont(new Font("San Francisco", Font.PLAIN, 15));
        sContainer.add(passwordField);

        showPassword.setBounds(760, 430, 20, 20);
        showPassword.setBackground(Color.red);
        showPassword.setToolTipText("Show Password");
        sContainer.add(showPassword);

        regButton.setBounds(485, 470, 268, 37);
        regButton.setBorderPainted(false);
        regButton.setBackground(new Color(255, 0, 0));
        regButton.setForeground(Color.WHITE);
        regButton.setFont(new Font("San Francisco", Font.BOLD, 15));
        sContainer.add(regButton);

        loginButton.setBounds(300, 510, 78, 40);
        loginButton.setBorderPainted(false);
        loginButton.setBackground(Color.WHITE);
        loginButton.setForeground(new Color(255, 0, 0));
        loginButton.setFont(new Font("San Francisco", Font.BOLD, 14));
        sContainer.add(loginButton);

    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        regButton.addActionListener(this);
        showPassword.addActionListener(this);
    }

    public boolean check(String email) {
        String line;
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);

            while ((line = br.readLine()) != null) {
                if (email.split("@")[0].equalsIgnoreCase(line.split(" ")[2].split("@")[0])) {
                    return true;
                }
            }
        } catch (Exception ep) {

            //System.out.println("ERROR 404! File-Not-Found");
            //ep.printStackTrace();
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {

            this.setVisible(false);
            Login lf = new Login();
            lf.setVisible(true);
        }
        if (e.getSource() == regButton) {
            try {
                if (!check(idTextField.getText())) {

                    FileWriter myWriter = new FileWriter(path, true);
                    myWriter.write(fnTextField.getText() + " " + lnTextField.getText() + " " + idTextField.getText() + " " + passwordField.getText() + "\n");
                    myWriter.close();
                    JOptionPane.showMessageDialog(null, "Successfully Registered! Please Login to continue...", "Confirmation", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Username already in use!", "Confirmation", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception ep) {
                SnakeGame dashboard = new SnakeGame();
                dashboard.setVisible(true);
               
            }
        }
        if (e.getSource() == showPassword) {

            //int d = passwordField.getEchoChar();
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar((char) 8226);
            }
        }
    }
}
