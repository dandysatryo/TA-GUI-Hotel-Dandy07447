package view;

import ViewCLI.AllObjectController;
import controller.AllObjectModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import model.TamuModel;

public class MenuTamuGUI {

    JFrame menuTamu = new JFrame();
    JButton pesanKamarBtn, lihatKamarBtn, checkoutBtn, backBtn;
    JLabel judulLbl;

    public MenuTamuGUI() {
        menuTamu.setSize(700, 630);
        menuTamu.setLayout(null);
        menuTamu.getContentPane().setBackground(Color.darkGray);

        judulLbl = new JLabel("MENU TAMU");
        judulLbl.setBounds(250, 50, 180, 40);
        judulLbl.setBackground(Color.ORANGE);
        judulLbl.setForeground(Color.YELLOW);
        judulLbl.setFont(new Font("Consolas", Font.BOLD, 35));
        menuTamu.add(judulLbl);

        pesanKamarBtn = new JButton("Pesan Kamar");
        pesanKamarBtn.setBounds(250, 150, 180, 40);
        pesanKamarBtn.setBackground(Color.ORANGE);
        menuTamu.add(pesanKamarBtn);

        lihatKamarBtn = new JButton("Lihat Daftar Kamar");
        lihatKamarBtn.setBounds(250, 250, 180, 40);
        lihatKamarBtn.setBackground(Color.ORANGE);
        menuTamu.add(lihatKamarBtn);

        checkoutBtn = new JButton("Checkout Kamar");
        checkoutBtn.setBounds(250, 350, 180, 40);
        checkoutBtn.setBackground(Color.ORANGE);
        menuTamu.add(checkoutBtn);

        backBtn = new JButton("Kembali");
        backBtn.setBounds(250, 450, 180, 40);
        backBtn.setBackground(Color.red);
        backBtn.setForeground(Color.WHITE);
        menuTamu.add(backBtn);
        
        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon("C:\\Users\\Dendi\\Downloads\\Apurva_Kempinski_Hotel_Bali-2022_11_10-06_57_52_d1853b510ae4fe16e437f5fc4212708c.jpg"));
        logo.setBounds(1, -200, 1000, 1050);
        menuTamu.add(logo);

        pesanKamarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                PesanKamarGUI pk = new PesanKamarGUI();
                menuTamu.dispose();
            }
        });

        lihatKamarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                DisplayKamarGUI dk = new DisplayKamarGUI();
                menuTamu.dispose();
            }
        });
        
        checkoutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CheckoutGUI co = new CheckoutGUI();
                menuTamu.dispose();
            }
        });

        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                LoginStaffGUI lgn = new LoginStaffGUI();
                menuTamu.dispose();
            }
        });

        menuTamu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuTamu.setLocationRelativeTo(null);
    }

//    public static void main(String[] args) {
//        System.out.println("1. Staff"
//                + "\n2. User Input Kamar"
//                + "\n3. Display Kamar"
//                + "\n4. checkout"
//                + "\n5. Exit"
//        );
//    }
}
