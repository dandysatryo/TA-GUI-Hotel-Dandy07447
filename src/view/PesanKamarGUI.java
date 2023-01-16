/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ViewCLI.AllObjectController;
//import controller.AllObjectModel;
import entity.KamarEntity;
//import entity.ReservasiLokal;
//import entity.ReservasiLuar;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author HP
 */
public class PesanKamarGUI {

    JFrame pk = new JFrame();
    JLabel namaLbl, noLbl, alamatLbl, lamaLbl,
            KTPLbl, PASSPORTLbl, kodeLuar, kodeLokal, pilLuar, pilLokal,
            cariKodeLbl;
    JRadioButton lokalRd, luarRd;
    JTextField namaFld, noFld, alamatFld, lamaFld, tamuFld,
            KTPFld, PPFld, kodeLuarFld, kodeLokalFld, pilLuarFld, pilLokalFld,
            cariKodeFld;
    JTextArea textLokal, textLuar;
    JButton backBtn, tambahLokal, tambahLuar, cariKodeBtn;

    public PesanKamarGUI() {
        pk.setSize(600, 600);
        pk.setLayout(null);
        pk.getContentPane().setBackground(Color.darkGray);

        backBtn = new JButton("Kembali");
        backBtn.setBounds(70, 500, 100, 40);
        backBtn.setBackground(Color.red);
        backBtn.setForeground(Color.WHITE);
        pk.add(backBtn);

        namaLbl = new JLabel("Nama");
        namaLbl.setBounds(70, 25, 100, 100);
        namaLbl.setForeground(Color.ORANGE);
        namaLbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
        pk.add(namaLbl);

        namaFld = new JTextField();
        namaFld.setBounds(70, 85, 100, 30);
        namaFld.setForeground(Color.ORANGE);
        namaFld.setFont(new Font("Times New Roman", Font.BOLD, 15));
        pk.add(namaFld);

        noLbl = new JLabel("No Hp");
        noLbl.setBounds(70, 90, 100, 100);
        noLbl.setForeground(Color.ORANGE);
        noLbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
        pk.add(noLbl);

        noFld = new JTextField();
        noFld.setBounds(70, 147, 100, 30);
        noFld.setForeground(Color.ORANGE);
        noFld.setFont(new Font("Times New Roman", Font.BOLD, 15));
        pk.add(noFld);

        alamatLbl = new JLabel("Alamat");
        alamatLbl.setBounds(70, 150, 100, 100);
        alamatLbl.setForeground(Color.ORANGE);
        alamatLbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
        pk.add(alamatLbl);

        alamatFld = new JTextField();
        alamatFld.setBounds(70, 205, 100, 30);
        alamatFld.setForeground(Color.ORANGE);
        alamatFld.setFont(new Font("Times New Roman", Font.BOLD, 15));
        pk.add(alamatFld);

        lamaLbl = new JLabel("Lama Menginap");
        lamaLbl.setBounds(70, 210, 130, 100);
        lamaLbl.setForeground(Color.ORANGE);
        lamaLbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
        pk.add(lamaLbl);

        lamaFld = new JTextField();
        lamaFld.setBounds(70, 270, 100, 30);
        lamaFld.setForeground(Color.ORANGE);
        lamaFld.setFont(new Font("Times New Roman", Font.BOLD, 15));
        pk.add(lamaFld);

        lokalRd = new JRadioButton("Lokal");
        lokalRd.setBounds(70, 300, 70, 50);
        lokalRd.setForeground(Color.ORANGE);
        lokalRd.setBackground(Color.darkGray);
        lokalRd.setFont(new Font("Times New Roman", Font.BOLD, 15));
        pk.add(lokalRd);

        luarRd = new JRadioButton("Luar");
        luarRd.setBounds(160, 300, 70, 50);
        luarRd.setForeground(Color.ORANGE);
        luarRd.setBackground(Color.darkGray);
        luarRd.setFont(new Font("Times New Roman", Font.BOLD, 15));
        pk.add(luarRd);

        PASSPORTLbl = new JLabel("PASSPORT");
        PASSPORTLbl.setBounds(70, 330, 140, 100);
        PASSPORTLbl.setForeground(Color.ORANGE);
        PASSPORTLbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
        PASSPORTLbl.setVisible(false);
        pk.add(PASSPORTLbl);

        PPFld = new JTextField();
        PPFld.setBounds(70, 390, 100, 30);
        PPFld.setForeground(Color.ORANGE);
        PPFld.setFont(new Font("Times New Roman", Font.BOLD, 15));
        PPFld.setVisible(false);
        pk.add(PPFld);

        KTPLbl = new JLabel("KTP");
        KTPLbl.setBounds(70, 330, 130, 100);
        KTPLbl.setForeground(Color.ORANGE);
        KTPLbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
        KTPLbl.setVisible(false);
        pk.add(KTPLbl);

        KTPFld = new JTextField();
        KTPFld.setBounds(70, 390, 100, 30);
        KTPFld.setForeground(Color.ORANGE);
        KTPFld.setFont(new Font("Times New Roman", Font.BOLD, 15));
        KTPFld.setVisible(false);
        pk.add(KTPFld);

        kodeLuar = new JLabel("Kode Kamar");
        kodeLuar.setBounds(350, 30, 130, 100);
        kodeLuar.setForeground(Color.ORANGE);
        kodeLuar.setFont(new Font("Times New Roman", Font.BOLD, 15));
        kodeLuar.setVisible(false);
        pk.add(kodeLuar);

        kodeLuarFld = new JTextField();
        kodeLuarFld.setBounds(350, 90, 100, 30);
        kodeLuarFld.setForeground(Color.ORANGE);
        kodeLuarFld.setFont(new Font("Times New Roman", Font.BOLD, 15));
        kodeLuarFld.setVisible(false);
        pk.add(kodeLuarFld);

        kodeLokal = new JLabel("-Kode Kamar");
        kodeLokal.setBounds(350, 30, 130, 100);
        kodeLokal.setForeground(Color.ORANGE);
        kodeLokal.setFont(new Font("Times New Roman", Font.BOLD, 15));
        kodeLokal.setVisible(false);
        pk.add(kodeLokal);

        kodeLokalFld = new JTextField();
        kodeLokalFld.setBounds(350, 90, 100, 30);
        kodeLokalFld.setForeground(Color.ORANGE);
        kodeLokalFld.setFont(new Font("Times New Roman", Font.BOLD, 15));
        kodeLokalFld.setVisible(false);
        pk.add(kodeLokalFld);

        tambahLokal = new JButton("INPUT");
        tambahLokal.setBounds(350, 150, 100, 50);
        tambahLokal.setBackground(Color.red);
        tambahLokal.setForeground(Color.WHITE);
        tambahLokal.setVisible(false);
        pk.add(tambahLokal);

        tambahLuar = new JButton("INPUT");
        tambahLuar.setBounds(350, 150, 100, 50);
        tambahLuar.setBackground(Color.red);
        tambahLuar.setForeground(Color.WHITE);
        tambahLuar.setVisible(false);
        pk.add(tambahLuar);

//        textLokal = new JTextArea();
//        textLokal.setBounds(350, 250, 400, 350);
//        textLokal.setText(displayLokal());
//        textLokal.setVisible(false);
//        pk.add(textLokal);
//
//        textLuar = new JTextArea();
//        textLuar.setBounds(350, 250, 400, 350);
//        textLuar.setText(displayLuar());
//        textLuar.setVisible(false);
//        pk.add(textLuar);

        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MenuTamuGUI tamuGUI = new MenuTamuGUI();
                tamuGUI.menuTamu.setVisible(true);
                pk.dispose();
            }
        });

        lokalRd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    if (lokalRd.isSelected()) {
                        luarRd.setSelected(false);

                        PASSPORTLbl.setVisible(false);
                        KTPLbl.setVisible(true);

                        kodeLuar.setVisible(false);
                        kodeLokal.setVisible(true);

                        KTPFld.setVisible(true);
                        PPFld.setVisible(false);

                        kodeLokalFld.setVisible(true);
                        kodeLuarFld.setVisible(false);

                        tambahLuar.setVisible(false);
                        tambahLokal.setVisible(true);

                        textLuar.setVisible(false);
                        textLokal.setVisible(true);
                        
                        pk.add(textLokal);
                    }
                } catch (Exception ex) {

                }
            }
        });

        luarRd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    if (luarRd.isSelected()) {
                        lokalRd.setSelected(false);

                        PASSPORTLbl.setVisible(true);
                        KTPLbl.setVisible(false);

                        kodeLokal.setVisible(false);
                        kodeLuar.setVisible(true);

                        KTPFld.setVisible(false);
                        PPFld.setVisible(true);

                        kodeLokalFld.setVisible(false);
                        kodeLuarFld.setVisible(true);

                        tambahLuar.setVisible(true);
                        tambahLokal.setVisible(false);

                        textLuar.setVisible(true);
                        textLokal.setVisible(false);
                        
                        pk.add(textLuar);
                    }
                } catch (Exception ex) {

                }
            }
        });

        tambahLokal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String nama = namaFld.getText();
                    String noHp = noFld.getText();
                    String alamat = alamatFld.getText();
                    String lama = lamaFld.getText();
                    int lm = Integer.parseInt(lama);
                    String k = KTPFld.getText();
                    int ktp = Integer.parseInt(k);
                    String kamarLokal = kodeLokalFld.getText();
                    KamarEntity kmrLokal = AllObjectController.tamucon.cari(kamarLokal);
                    if (kmrLokal != null) {
                        if (kmrLokal.getStatus_kamar()) {
                            kmrLokal.setStatus_kamar(false);
                            AllObjectController.tamucon.inputLokal(nama,
                                    noHp, alamat, lm, ktp, kamarLokal);
                            JOptionPane.showMessageDialog(
                                    null, "Data berhasil Diinputkan, Sebagai Turis Lokal",
                                    "information", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(
                                    null, "KAMAR SUDAH TERBOOKING",
                                    "information", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(
                                null, "KAMAR KOSONG",
                                "information", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(
                            null, "Format Data Error",
                            "information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        tambahLuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String nama = namaFld.getText();
                    String noHp = noFld.getText();
                    String alamat = alamatFld.getText();
                    String lama = lamaFld.getText();
                    int lm = Integer.parseInt(lama);
                    String k = PPFld.getText();
                    int pp = Integer.parseInt(k);
                    String kamarLuar = kodeLuarFld.getText();
                    KamarEntity kmrLuar = AllObjectController.tamucon.cari(kamarLuar);
                    if (kmrLuar != null) {
                        if (kmrLuar.getStatus_kamar()) {
                            kmrLuar.setStatus_kamar(false);
                            AllObjectController.tamucon.inputLuar(nama,
                                    noHp, alamat, lm, pp, kamarLuar);
                            JOptionPane.showMessageDialog(
                                    null, "Data berhasil Diinputkan, Sebagai Turis Asing",
                                    "information", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(
                                    null, "KAMAR SUDAH TERBOOKING",
                                    "information", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(
                                null, "KAMAR KOSONG",
                                "information", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(
                            null, "Format Data Error",
                            "information", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });

        pk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pk.setVisible(true);
        pk.setLocationRelativeTo(null);
    }

//    public String displayLokal() {
//        if (AllObjectModel.tamuMdl.allLokal().isEmpty() == true) {
//            String txt = "===========================\n"
//                    + "        Tamu Lokal        \n"
//                    + "==========================\n"
//                    + "        Data Tidak Ada    \n"
//                    + "==========================\n";
//            return txt;
//        } else {
//            String txt = "kosong";
//            for (ReservasiLokal objek : AllObjectModel.tamuMdl.allLokal()) {
//                String cekOut = "Belum Check Out";
//                if (objek.getChecout() == null) {
//                    txt = "==========================\n"
//                            + "        Tamu Lokal    \n"
//                            + "======================\n"
//                            + "        Nama             : " + objek.getTamuLokal().getNama()
//                            + "        No Hp            : " + objek.getTamuLokal().getNoHp()
//                            + "        Alamat           : " + objek.getTamuLokal().getAlamat()
//                            + "        Lama             : " + objek.getTamuLokal().getLama()
//                            + "        KTP              : " + objek.getTamuLokal().getKtp()
//                            + "        No Kamar         : " + objek.getKamar().getNo_kamar()
//                            + "        Tipe Kamar       : " + objek.getKamar().getTipe_kamar()
//                            + "        Tanggal Check in : " + objek.getCheckin()
//                            + "        Check            : " + cekOut
//                            + "==========================\n";
//                    break;
//                } else {
//                    txt = "==========================\n"
//                            + "        Tamu Lokal    \n"
//                            + "==========================\n"
//                            + "        Nama             : " + objek.getTamuLokal().getNama() + "\n"
//                            + "        No Hp            : " + objek.getTamuLokal().getNoHp() + "\n"
//                            + "        Alamat           : " + objek.getTamuLokal().getAlamat() + "\n"
//                            + "        Lama             : " + objek.getTamuLokal().getLama() + "\n"
//                            + "        KTP              : " + objek.getTamuLokal().getKtp() + "\n"
//                            + "        No Kamar         : " + objek.getKamar().getNo_kamar() + "\n"
//                            + "        Tipe Kamar       : " + objek.getKamar().getTipe_kamar() + "\n"
//                            + "        Tanggal Check in : " + objek.getCheckin()
//                            + "        Check            : " + cekOut
//                            + "==========================\n";
//                    break;
//                }
//            }
//            return txt;
//        }
//    }
//
//    public String displayLuar() {
//        if (AllObjectModel.tamuMdl.allLuar().isEmpty()) {
//            String txt = "==========================\n"
//                    + "        Tamu Asing        \n"
//                    + "==========================\n"
//                    + "        Data Tidak Ada    \n"
//                    + "==========================\n";
//            return txt;
//        } else {
//            String txt = "kosong";
//            for (ReservasiLuar objek : AllObjectModel.tamuMdl.allLuar()) {
//                String cekOut = "Belum Check Out";
//                if (objek.getChecout() == null) {
//                    txt = "==========================\n"
//                            + "        Tamu Asing    \n"
//                            + "==========================\n"
//                            + "        Nama             : " + objek.getTamuLuar().getNama()+ "\n"
//                            + "        No Hp            : " + objek.getTamuLuar().getNoHp()+ "\n"
//                            + "        Alamat           : " + objek.getTamuLuar().getAlamat()+ "\n"
//                            + "        Lama             : " + objek.getTamuLuar().getLama()+ "\n"
//                            + "        PASSPORT         : " + objek.getTamuLuar().getPasport()+ "\n"
//                            + "        No Kamar         : " + objek.getKamar().getNo_kamar()+ "\n"
//                            + "        Tipe Kamar       : " + objek.getKamar().getTipe_kamar()+ "\n"
//                            + "        Tanggal Check in : " + objek.getCheckin()
//                            + "        Check            : " + cekOut
//                            + "==========================\n";
//                    break;
//                } else {
//                    txt = "==========================\n"
//                            + "        Tamu Asing    \n"
//                            + "==========================\n"
//                            + "        Nama             : " + objek.getTamuLuar().getNama()+ "\n"
//                            + "        No Hp            : " + objek.getTamuLuar().getNoHp()+ "\n"
//                            + "        Alamat           : " + objek.getTamuLuar().getAlamat()+ "\n"
//                            + "        Lama             : " + objek.getTamuLuar().getLama()+ "\n"
//                            + "        PASSPORT         : " + objek.getTamuLuar().getPasport()+ "\n"
//                            + "        No Kamar         : " + objek.getKamar().getNo_kamar()+ "\n"
//                            + "        Tipe Kamar       : " + objek.getKamar().getTipe_kamar()+ "\n"
//                            + "        Tanggal Check in : " + objek.getCheckin()+ "\n"
//                            + "        Check            : " + cekOut
//                            + "==========================\n";
//                    break;
//                }
//            }
//            return txt;
//        }
//    }
}
