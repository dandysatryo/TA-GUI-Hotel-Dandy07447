/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ViewCLI.AllObjectController;
import controller.AllObjectModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.TamuModel;

/**
 *
 * @author HP
 */
public class CheckoutGUI {

    JFrame co = new JFrame();
    JLabel lokalLbl, luarLbl,
            kodeLokal, kodeLuar;
    JTextField luarFld, lokalFld;
    JButton backBtn, coLuar, coLokal;

    public CheckoutGUI() {
        co.setSize(700, 400);
        co.setLayout(null);
        co.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        co.setVisible(true);
        co.setLocationRelativeTo(null);

        backBtn = new JButton("Kembali");
        backBtn.setBounds(274, 250, 100, 40);
        backBtn.setBackground(Color.red);
        backBtn.setForeground(Color.WHITE);
        co.add(backBtn);

        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MenuTamuGUI tamuGUI = new MenuTamuGUI();
                tamuGUI.menuTamu.setVisible(true);
                co.dispose();
            }
        });

        lokalLbl = new JLabel("Turis Lokal");
        lokalLbl.setBounds(100, 50, 180, 40);
        lokalLbl.setFont(new Font("Calibri", Font.BOLD, 30));
        lokalLbl.setForeground(Color.ORANGE);
        co.add(lokalLbl);

        kodeLokal = new JLabel("Kode Kamar");
        kodeLokal.setBounds(100, 100, 150, 40);
        kodeLokal.setFont(new Font("Calibri", Font.BOLD, 20));
        kodeLokal.setForeground(Color.ORANGE);
        co.add(kodeLokal);

        lokalFld = new JTextField();
        lokalFld.setBounds(100, 130, 150, 40);
        lokalFld.setFont(new Font("Calibri", Font.BOLD, 15));
        lokalFld.setForeground(new Color(204, 102, 0));
        co.add(lokalFld);

        coLokal = new JButton("Checkout");
        coLokal.setBounds(100, 200, 150, 40);
        coLokal.setFont(new Font("Calibri", Font.BOLD, 15));
        coLokal.setForeground(new Color(204, 102, 0));
        coLokal.setBackground(Color.LIGHT_GRAY);
        co.add(coLokal);

        coLokal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String cktLokal = lokalFld.getText();
                int index = AllObjectController.tamucon.cariReservasibyKodeKamarLokal(cktLokal);
                if (index > -1) {
                    AllObjectController.tamucon.checkoutLokal(index);
                    JOptionPane.showMessageDialog(
                            null, "Berhasil Chekout", "information", JOptionPane.INFORMATION_MESSAGE);
                    kosong();
                } else {
                    JOptionPane.showMessageDialog(
                            null, "Data Tidak Ditemukan", "information", JOptionPane.INFORMATION_MESSAGE);
                    kosong();
                }

            }
        });

        luarLbl = new JLabel("Turis Asing");
        luarLbl.setBounds(400, 50, 180, 40);
        luarLbl.setFont(new Font("Calibri", Font.BOLD, 30));
        luarLbl.setForeground(Color.ORANGE);
        co.add(luarLbl);

        kodeLuar = new JLabel("Kode Kamar");
        kodeLuar.setBounds(400, 100, 180, 40);
        kodeLuar.setFont(new Font("Calibri", Font.BOLD, 20));
        kodeLuar.setForeground(Color.ORANGE);
        co.add(kodeLuar);

        luarFld = new JTextField();
        luarFld.setBounds(400, 130, 150, 40);
        luarFld.setFont(new Font("Calibri", Font.BOLD, 15));
        luarFld.setForeground(new Color(204, 102, 0));
        co.add(luarFld);

        coLuar = new JButton("Checkout");
        coLuar.setBounds(400, 200, 150, 40);
        coLuar.setFont(new Font("Calibri", Font.BOLD, 15));
        coLuar.setForeground(new Color(204, 102, 0));
        coLuar.setBackground(Color.LIGHT_GRAY);
        co.add(coLuar);

        coLuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String cktLuar = luarFld.getText();
                    int index = AllObjectController.tamucon.cariReservasibyKodeKamarLuar(cktLuar);
                    if (index > -1) {
                        AllObjectController.tamucon.checkOutLuar(index);
                        JOptionPane.showMessageDialog(
                                null, "Berhasil Chekout", "information", JOptionPane.INFORMATION_MESSAGE);
                        kosong();
                    } else {
                        JOptionPane.showMessageDialog(
                                null, "Data Tidak Ditemukan", "information", JOptionPane.INFORMATION_MESSAGE);
                        kosong();
                    }
                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(
                            null, exc, "information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        co.getContentPane().setBackground(Color.darkGray);
    }

    void kosong() {
        luarFld.setText(null);
        lokalFld.setText(null);
    }
}
