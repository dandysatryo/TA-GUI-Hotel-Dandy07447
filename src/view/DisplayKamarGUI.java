
package view;

import ViewCLI.AllObjectController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class DisplayKamarGUI {

    JButton backBtn, tampilTamuBtn, resetBtn;
    JFrame dk = new JFrame();
    JTable tabelTamu = new JTable();
    JScrollPane ScrollTamu = new JScrollPane(tabelTamu);

    public DisplayKamarGUI() {
        dk.setSize(700, 630);
        dk.setLayout(null);
        dk.getContentPane().setBackground(Color.darkGray);

        backBtn = new JButton("Kembali");
        backBtn.setBounds(250, 450, 100, 40);
        backBtn.setBackground(Color.red);
        backBtn.setForeground(Color.WHITE);
        dk.add(backBtn);

//        tampilTamuBtn = new JButton("Display Tamu");
//        tampilTamuBtn.setBounds(250, 350, 180, 40);
//        tampilTamuBtn.setBackground(Color.red);
//        tampilTamuBtn.setForeground(Color.WHITE);
//        dk.add(tampilTamuBtn);
        ScrollTamu.setBounds(150, 100, 400, 200);
        tabelTamu.setModel(AllObjectController.tamucon.daftarTamu());
        tabelTamu.getTableHeader().setReorderingAllowed(false);
        tabelTamu.setEnabled(false);
        dk.add(ScrollTamu);

        resetBtn = new JButton("reset Tabel");
        resetBtn.setBounds(400, 450, 100, 40);
        resetBtn.setBackground(Color.red);
        resetBtn.setForeground(Color.WHITE);
        dk.add(resetBtn);

        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MenuTamuGUI tamuGUI = new MenuTamuGUI();
                tamuGUI.menuTamu.setVisible(true);
                dk.dispose();

            }
        });

//        tampilTamuBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                
//            }
//        });
        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                AllObjectController.tamucon.daftarTamu().setRowCount(0);
            }
        });

        dk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dk.setVisible(true);
        dk.setLocationRelativeTo(null);
    }

}
