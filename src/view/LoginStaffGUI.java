package view;

import ViewCLI.AllObjectController;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginStaffGUI {

    JFrame Lgn = new JFrame();
    JLabel login, top;
    JTextField textUsernamelogin;
    JLabel labelUsernamelogin, labelpasswordlogin;
    JButton Masuk, exitBtn, UserLoginBtn;
    JPasswordField passwordlogin;

    public LoginStaffGUI() {
        Lgn.setSize(700, 630);
        Lgn.setLayout(null);
        Lgn.getContentPane().setBackground(Color.darkGray);
        top = new JLabel("<<<<<<< HOTEL G20 >>>>>>>");
        top.setBounds(60, 10, 750, 50);
        top.setFont(new Font("Times New Roman", Font.BOLD, 40));
        Lgn.add(top);
        top.setForeground(Color.yellow);

        labelUsernamelogin = new JLabel("Username");
        labelUsernamelogin.setBounds(290, 278, 60, 27);
        labelUsernamelogin.setForeground(Color.YELLOW);
        Lgn.add(labelUsernamelogin);

        textUsernamelogin = new JTextField();
        textUsernamelogin.setBounds(180, 300, 280, 35);
        Lgn.add(textUsernamelogin);

        labelpasswordlogin = new JLabel("Password");
        labelpasswordlogin.setBounds(290, 335, 200, 30);
        labelpasswordlogin.setForeground(Color.YELLOW);
        Lgn.add(labelpasswordlogin);

        passwordlogin = new JPasswordField();
        passwordlogin.setBounds(180, 360, 280, 36);
        Lgn.add(passwordlogin);

//        login = new JLabel("Login");
//        login.setBounds(281, 200, 100, 100);
//        login.setFont(new Font("Times New Roman", Font.BOLD, 30));
//        Lgn.add(login);
//        login.setForeground(Color.yellow);

        Masuk = new JButton("Masuk sebagai Staf");
        Masuk.setBounds(230, 400, 180, 40);
        Masuk.setBackground(Color.ORANGE);
        Lgn.add(Masuk);

        UserLoginBtn = new JButton("Masuk Sebagai User");
        UserLoginBtn.setBounds(230, 450, 180, 40);
        UserLoginBtn.setBackground(Color.ORANGE);
        UserLoginBtn.setForeground(Color.RED);
        Lgn.add(UserLoginBtn);
        
        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon("C:\\Users\\Dendi\\Downloads\\the-apurva-kempinski-bali-6.jpeg"));
        logo.setBounds(1, -200, 1000, 1050);
        Lgn.add(logo);

        Lgn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Lgn.setLocationRelativeTo(null);
        Lgn.setVisible(true);
        

        UserLoginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(
                        null, "Anda Masuk Sebagai Tamu", "information", JOptionPane.INFORMATION_MESSAGE);
                refresh();
                Lgn.dispose();
                MenuTamuGUI tamuGUI = new MenuTamuGUI();
                tamuGUI.menuTamu.setVisible(true);
            }
        });

        Masuk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                String username = textUsernamelogin.getText();
                String password = passwordlogin.getText();
                if (AllObjectController.stafcon.login(username, password) == true) {
                    JOptionPane.showMessageDialog(
                            null, "Login Berhasil", "information", JOptionPane.INFORMATION_MESSAGE);
                    refresh();
                    Lgn.dispose();
                    MenuStaffGUI stf = new MenuStaffGUI();

                } else {
                    JOptionPane.showMessageDialog(
                            null, "Login Gagal", "information", JOptionPane.ERROR_MESSAGE);
                    refresh();
                }
            }
        });
    }

    void refresh() {
        textUsernamelogin.setText(null);
        passwordlogin.setText(null);
    }
}
