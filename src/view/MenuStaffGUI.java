package view;

import ViewCLI.AllObjectController;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MenuStaffGUI extends JFrame {

//   private static StafController tamu = new StafController();
    JTable tableLuar = new JTable(),
            tableLokal = new JTable();
    JScrollPane scrollLokal = new JScrollPane(tableLokal),
            scrollLuar = new JScrollPane(tableLuar);
    JButton back, verifLuar, verifLokal, hapus;
    JLabel admin, namalabel, passlabel;
    JTextField namatext, passtext, luarFld1, luarFld2;
    JRadioButton lokalRd, luarRd;

    public MenuStaffGUI() {
        setSize(1100, 600);
        setLayout(null);
        getContentPane().setBackground(Color.yellow);

        admin = new JLabel("Staff Hotel");
        admin.setBounds(225, 30, 200, 30);
        admin.setFont(new Font("Times New Roman", Font.BOLD, 40));
        add(admin);

        scrollLokal.setBounds(30, 100, 1000, 200);
        tableLokal.setVisible(false);
        scrollLokal.setVisible(false);
        tableLokal.setModel(AllObjectController.tamucon.DataTamuLokal());
        add(scrollLokal);

        scrollLuar.setBounds(30, 100, 1000, 200);
        tableLuar.setVisible(false);
        scrollLuar.setVisible(false);
        tableLuar.setModel(AllObjectController.tamucon.DataTamuLuar());
        add(scrollLuar);

//        tabeltamu.setModel(tamu.daftarprak);
        namalabel = new JLabel("Kode");
        namalabel.setBounds(50, 420, 100, 30);
        add(namalabel);

        namatext = new JTextField();
        namatext.setBounds(50, 450, 100, 30);
        namatext.setVisible(false);
        add(namatext);

        luarFld1 = new JTextField();
        luarFld1.setBounds(50, 450, 100, 30);
        luarFld1.setVisible(false);
        add(luarFld1);

        passlabel = new JLabel("Checkout");
        passlabel.setBounds(200, 420, 100, 30);
        add(passlabel);

        passtext = new JTextField();
        passtext.setBounds(200, 450, 100, 30);
        passtext.setVisible(false);
        add(passtext);

        luarFld2 = new JTextField();
        luarFld2.setBounds(200, 450, 100, 30);
        luarFld2.setVisible(false);
        add(luarFld2);

        verifLuar = new JButton("Set Checkout");
        verifLuar.setBounds(350, 450, 150, 30);
        verifLuar.setBackground(Color.GREEN);
        verifLuar.setVisible(false);
        add(verifLuar);

        verifLokal = new JButton("-Set Checkout");
        verifLokal.setBounds(350, 450, 150, 30);
        verifLokal.setBackground(Color.GREEN);
        verifLokal.setVisible(false);
        add(verifLokal);

        lokalRd = new JRadioButton("Lokal");
        lokalRd.setBounds(50, 370, 70, 30);
        lokalRd.setForeground(Color.black);
        lokalRd.setBackground(Color.YELLOW);
        lokalRd.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add(lokalRd);

        luarRd = new JRadioButton("Luar");
        luarRd.setBounds(150, 370, 70, 30);
        luarRd.setForeground(Color.black);
        luarRd.setBackground(Color.YELLOW);
        luarRd.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add(luarRd);

        back = new JButton("back");
        back.setBounds(50, 500, 100, 30);
        back.setBackground(Color.red);
        add(back);

        hapus = new JButton("Menu Hapus");
        hapus.setBounds(350, 500, 150, 30);
        hapus.setBackground(Color.red);
        add(hapus);

        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
                LoginStaffGUI gui = new LoginStaffGUI();
            }
        });

        hapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MenuHapusGUI mh = new MenuHapusGUI();
                dispose();
            }
        });

        lokalRd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (lokalRd.isSelected()) {

                    luarRd.setSelected(false);
                    lokalRd.setSelected(true);

                    scrollLokal.setVisible(true);
                    tableLokal.setVisible(true);

                    tableLuar.setVisible(false);
                    scrollLuar.setVisible(false);

                    verifLuar.setVisible(false);
                    verifLokal.setVisible(true);

                    namatext.setVisible(true);
                    passtext.setVisible(true);

                    luarFld1.setVisible(false);
                    luarFld2.setVisible(false);
                }
            }
        });

        luarRd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (luarRd.isSelected()) {
                    lokalRd.setSelected(false);
                    luarRd.setSelected(true);

                    scrollLokal.setVisible(false);
                    tableLokal.setVisible(false);

                    tableLuar.setVisible(true);
                    scrollLuar.setVisible(true);

                    verifLuar.setVisible(true);
                    verifLokal.setVisible(false);

                    namatext.setVisible(false);
                    passtext.setVisible(false);

                    luarFld1.setVisible(true);
                    luarFld2.setVisible(true);
                }
            }
        });

        verifLuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String kodeLuar = luarFld1.getText();
                int index = AllObjectController.tamucon.cariReservasibyKodeKamarLuar(kodeLuar);
                if (index > -1) {
                    AllObjectController.tamucon.checkOutLuar(index);
                    JOptionPane.showMessageDialog(
                            null, "Berhasil Ter-Checkout",
                            "information", JOptionPane.INFORMATION_MESSAGE);
                    refresh();
                    tableLuar.setModel(AllObjectController.tamucon.DataTamuLuar());
                } else {
                    JOptionPane.showMessageDialog(
                            null, "Gagal Ter-Checkout",
                            "information", JOptionPane.INFORMATION_MESSAGE);
                    refresh();
                }
            }
        });

        verifLokal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String kodeLokal = namatext.getText();
                int index = AllObjectController.tamucon.cariReservasibyKodeKamarLokal(kodeLokal);
                if (index > -1) {
                    AllObjectController.tamucon.checkoutLokal(index);
                    JOptionPane.showMessageDialog(
                            null, "Berhasil Ter-Checkout",
                            "information", JOptionPane.INFORMATION_MESSAGE);
                    tableLokal.setModel(AllObjectController.tamucon.DataTamuLokal());
                    refresh();
                } else {
                    JOptionPane.showMessageDialog(
                            null, "Gagal Ter-Checkout",
                            "information", JOptionPane.INFORMATION_MESSAGE);
                    refresh();
                }

            }
        });

//        Aslab.setLocationRelativeTo(null);
//        Aslab.setVisible(true);
//        Aslab.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        back.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                Aslab.dispose();
//                GUI07220 men = new GUI07220();
//            }
//        });
//        verif.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                String npm = npmtext.getText();
//                String pass = passtext.getText();
//                int index = AllObjectModel07220.daftarprakModel.cekData(npm, pass);
//                Allobjctrl07220.admin.updateIsVerified(index, Allobjctrl07220.Praktikan.showDaftarprak(index).getIndexPraktikum(), Allobjctrl07220.Praktikan.showDaftarprak(index).getPraktikan());
//                tabelpraktikan.setModel(praktikan.daftarprak());
//            }
//        });
//        tabelpraktikan.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                int i = tabelpraktikan.getSelectedRow();
//                npmtext.setText(Allobjctrl07220.Praktikan.daftarprak().getValueAt(i, 0).toString());
//                passtext.setText(Allobjctrl07220.Praktikan.daftarprak().getValueAt(i, 1).toString());
//            }
//        });
    }

    void refresh() {
        namatext.setText(null);
        passtext.setText(null);
        luarFld1.setText(null);
        luarFld2.setText(null);
    }
}
