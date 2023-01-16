package controller;

import entity.KamarEntity;
import entity.ReservasiLokal;
import entity.ReservasiLuar;
import entity.TamuLokalEntity;
import entity.TamuLuarNegeriEntity;
import javax.swing.table.DefaultTableModel;
import utils.DateString;

public class TamuController {

    public DefaultTableModel dtmDaftarTamu = new DefaultTableModel();
    public DefaultTableModel dtmDataTamu = new DefaultTableModel();

    public void lokal(String nama, String noHp, String alamat, int lama, int ktp, String kamar) {
        inputLokal(nama, noHp, alamat, lama, ktp, kamar);
    }

    public void luar(String nama, String noHp, String alamat, int lama, int pasport, String kamar) {
        inputLuar(nama, noHp, alamat, lama, pasport, kamar);
    }

    public DefaultTableModel daftarTamu() {
        DefaultTableModel dtmDaftarTamu = new DefaultTableModel();
        Object[] kolom = {"index", "No Kamar", "Tipe Kamar", "Status Kamar"};
        dtmDaftarTamu.setColumnIdentifiers(kolom);
        int size = AllObjectModel.tamuMdl.allKamar().size();
        for (int i = 0; i < size; i++) {
            Object[] data = new Object[4];
            data[0] = i;
            data[1] = AllObjectModel.tamuMdl.allKamar().get(i).getNo_kamar();
            data[2] = AllObjectModel.tamuMdl.allKamar().get(i).getTipe_kamar();
            if (AllObjectModel.tamuMdl.allKamar().get(i).getStatus_kamar() == true) {
                data[3] = "Tersedia";
            } else {
                data[3] = "Terbooking";
            }
            dtmDaftarTamu.addRow(data);
        }
        return dtmDaftarTamu;
    }

    //start of data kamar
    public KamarEntity cari(String noKamar) {
        for (KamarEntity objek : AllObjectModel.tamuMdl.allKamar()) {
            if (objek.getNo_kamar().equals(noKamar)) {
                return objek;
            }
        }
        return null;
    }//cari kamar

    public void hapusKamar(String noKamar) {
        int index = indexData(noKamar);
        if (index != -1) {
            AllObjectModel.tamuMdl.allKamar().remove(index);
        }
    }//hapus kamar

    public int indexData(String noKamar) {
        KamarEntity kamar = cari(noKamar);
        return AllObjectModel.tamuMdl.allKamar().indexOf(kamar);
    }//index Data kamar

    private void updateKamar(KamarEntity kamar, boolean status) {
        for (KamarEntity objek : AllObjectModel.tamuMdl.allKamar()) {
            if (kamar.getNo_kamar().equals(objek.getNo_kamar())) {
                objek.setStatus_kamar(status);
                break;
            }
        }
    }//update kamar 
    //end of data kamar

    //Start of data turis lokal
    public void inputLokal(String nama, String noHp, String alamat, int lama, int ktp, String kamar) {
        TamuLokalEntity tamu = new TamuLokalEntity(nama, noHp, alamat, lama, ktp);
        KamarEntity kamarCari = cari(kamar);
        AllObjectModel.tamuMdl.allLokal().add(new ReservasiLokal(tamu, kamarCari));
    }//input data turis lokal

    public int cariReservasibyKodeKamarLokal(String kodeKamar) {
        int i = -1;
        for (ReservasiLokal objek : AllObjectModel.tamuMdl.allLokal()) {
            i += 1;
            if (objek.getKamar().getNo_kamar().equals(kodeKamar)) {
                if (!objek.getKamar().getStatus_kamar()) {
                    return i;
                }
            }
        }
        return -1;
    }//cari data reservasi turis lokal

    public void checkoutLokal(int index) {
        ReservasiLokal reservasi = AllObjectModel.tamuMdl.allLokal().get(index);
        reservasi.setChecout(DateString.now());
        KamarEntity kamar = reservasi.getKamar();
        updateKamar(kamar, true);
        AllObjectModel.tamuMdl.allLokal().set(index, reservasi);
    }//checkout turis lokal
    //end of data turis lokal

    //start of data turis asing 
    public int cariReservasibyKodeKamarLuar(String kodeKamar) {
        int i = -1;
        for (ReservasiLuar objek : AllObjectModel.tamuMdl.allLuar()) {
            i += 1;
            if (objek.getKamar().getNo_kamar().equals(kodeKamar)) {
                if (!objek.getKamar().getStatus_kamar()) {
                    return i;
                }
            }
        }
        return -1;
    }//cara data resevari turis asing

    public void inputLuar(String nama, String noHp, String alamat, int lama, int pasport, String kamar) {
        TamuLuarNegeriEntity tamu = new TamuLuarNegeriEntity(nama, noHp, alamat, lama, pasport);
        KamarEntity kamarCari = cari(kamar);
        AllObjectModel.tamuMdl.allLuar().add(new ReservasiLuar(tamu, kamarCari));
    }//input data turis asing

    public void checkOutLuar(int index) {
        ReservasiLuar reservasi = AllObjectModel.tamuMdl.allLuar().get(index);
        reservasi.setChecout(DateString.now());
        KamarEntity kamar = reservasi.getKamar();
        updateKamar(kamar, true);
        AllObjectModel.tamuMdl.allLuar().set(index, reservasi);
    }//checkout turis asing
    //end of data turis asing

    public DefaultTableModel DataTamuLokal() {
        DefaultTableModel dtmDtLokal = new DefaultTableModel();
        Object[] kolom = {"index", "Nama", "No Hp", "Alamat",
            "Lama Menginap", "KTP", "No Kamar", "Tipe Kamar",
            "Tanggal Check in", "Status Chekout"};
        dtmDtLokal.setColumnIdentifiers(kolom);
        for (ReservasiLokal objek : AllObjectModel.tamuMdl.allLokal()) {
            Object[] data = new Object[10];
            data[0] = AllObjectModel.tamuMdl.allLokal().indexOf(objek);
            data[1] = objek.getTamuLokal().getLama();
            data[2] = objek.getTamuLokal().getNoHp();
            data[3] = objek.getTamuLokal().getAlamat();
            data[4] = objek.getTamuLokal().getLama();
            data[5] = objek.getTamuLokal().getKtp();
            data[6] = objek.getKamar().getNo_kamar();
            data[7] = objek.getKamar().getTipe_kamar();
            data[8] = objek.getCheckin();
            if (objek.getChecout() == null) {
                data[9] = "Belum Checkout";
            } else {
                data[9] = objek.getChecout();
            }
            dtmDtLokal.addRow(data);
        }
        return dtmDtLokal;
    }

    public DefaultTableModel DataTamuLuar() {
        DefaultTableModel dtmDtLuar = new DefaultTableModel();
        Object[] kolom = {"index", "Nama", "No Hp", "Alamat",
            "Lama Menginap", "PASSPORT", "No Kamar", "Tipe Kamar",
            "Tanggal Check in", "Status Chekout"};
        dtmDtLuar.setColumnIdentifiers(kolom);
        for (ReservasiLuar objek : AllObjectModel.tamuMdl.allLuar()) {
            Object[] data = new Object[10];
            data[0] = AllObjectModel.tamuMdl.allLuar().indexOf(objek);
            data[1] = objek.getTamuLuar().getNama();
            data[2] = objek.getTamuLuar().getNoHp();
            data[3] = objek.getTamuLuar().getAlamat();
            data[4] = objek.getTamuLuar().getLama();
            data[5] = objek.getTamuLuar().getPasport();
            data[6] = objek.getKamar().getNo_kamar();
            data[7] = objek.getKamar().getTipe_kamar();
            data[8] = objek.getCheckin();
            if (objek.getChecout() == null) {
                data[9] = "Belum Checkout";
            } else {
                data[9] = objek.getChecout();
            }
            dtmDtLuar.addRow(data);
        }
        return dtmDtLuar;
    }
}
