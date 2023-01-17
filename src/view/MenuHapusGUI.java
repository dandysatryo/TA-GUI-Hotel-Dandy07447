
package view;

import ViewCLI.AllObjectController;
import entity.KamarEntity;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class MenuHapusGUI extends JFrame {

    JLabel kodeKamarLbl;
    JTextField kodeFld;
    JButton hpsBtn, back;

    public MenuHapusGUI() {
        setSize(500, 400);
        setLayout(null);

        kodeKamarLbl = new JLabel("Kode Kamar");
        kodeKamarLbl.setForeground(Color.orange);
        kodeKamarLbl.setBounds(50, 10, 100, 100);
        add(kodeKamarLbl);

        kodeFld = new JTextField();
        kodeFld.setBounds(50, 80, 100, 40);
        add(kodeFld);

        hpsBtn = new JButton("Hapus");
        hpsBtn.setBounds(50, 130, 100, 30);
        hpsBtn.setBackground(Color.ORANGE);
        add(hpsBtn);

        back = new JButton("back");
        back.setBounds(50, 300, 100, 30);
        back.setBackground(Color.ORANGE);
        add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MenuStaffGUI g = new MenuStaffGUI();
                dispose();
            }
        });

        hpsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String kodeKm = kodeFld.getText();
                    KamarEntity kamar = AllObjectController.tamucon.cari(kodeKm);
                    if (kamar != null) {
                        AllObjectController.tamucon.hapusKamar(kodeKm);
                        JOptionPane.showMessageDialog(
                                null, "Kamar berhasil Dihapus",
                                "information", JOptionPane.INFORMATION_MESSAGE);
                        kodeFld.setText(null);
                    } else {
                        JOptionPane.showMessageDialog(
                                null, "Kamar Gagal Dihapus",
                                "information", JOptionPane.INFORMATION_MESSAGE);
                        kodeFld.setText(null);
                    }
                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(
                                null, "Inputan salah "+ exc,
                                "information", JOptionPane.INFORMATION_MESSAGE);
                    kodeFld.setText(null);
                }
            }
        });

        getContentPane().setBackground(Color.darkGray);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

//    public static void main(String[] args) {
//        System.out.print("Masukan Kode Kamar    = ");
//        String noKamar = input.nextLine();
//        KamarEntity kamar = AllObjectController.tamucon.cari(noKamar);
//        if (kamar != null) {
//            AllObjectController.tamucon.hapusKamar(noKamar);
//            System.out.println("Berhasil dihapus");
//        } else {
//            System.out.println("data tidak ditemukan");
//        }
//    }
}
