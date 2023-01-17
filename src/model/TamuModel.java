package model;

//import controller.AllObjectModel;
//import entity.TamuLokalEntity;
//import entity.TamuLuarNegeriEntity;
import entity.ReservasiLokal;
import entity.ReservasiLuar;
import entity.KamarEntity;
//import utils.DateString;

import java.util.ArrayList;

public class TamuModel {

    //array untuk tamu lokal 
    ArrayList<ReservasiLokal> arrayLokal = new ArrayList<>();
    //array untuk tamu asing
    ArrayList<ReservasiLuar> arrayLuar = new ArrayList<>();
    //array kamar
    ArrayList<KamarEntity> arrayKamar = new ArrayList<>();

    //penambahan kamar
    public void initialKamar() {
        arrayKamar.add(new KamarEntity("110", "Single Bed", true));
        arrayKamar.add(new KamarEntity("111", "Double Bed", true));
        arrayKamar.add(new KamarEntity("112", "Family Bed", true));
        arrayKamar.add(new KamarEntity("113", "Reguller Bed", true));
        arrayKamar.add(new KamarEntity("114", "VVIP Bed", true));
    }

    public ArrayList<ReservasiLokal> allLokal() {
        return arrayLokal;
    }

    public ArrayList<ReservasiLuar> allLuar() {
        return arrayLuar;
    }

    public ArrayList<KamarEntity> allKamar() {
        return arrayKamar;
    }

//    //start of data kamar
//    //cari kamar
//    public KamarEntity cari(String noKamar) {
//        for (KamarEntity objek : allKamar()) {
//            if (objek.getNo_kamar().equals(noKamar)) {
//                return objek;
//            }
//        }
//        return null;
//    }
//
//    //hapus kamar
//    public void hapusKamar(String noKamar) {
//        int index = indexData(noKamar);
//        if (index != -1) {
//            arrayKamar.remove(index);
//        }
//    }
//
//    //index Data kamar
//    public int indexData(String noKamar) {
//        KamarEntity kamar = cari(noKamar);
//        return arrayKamar.indexOf(kamar);
//    }
//
//    //end of data kamar
//    //Start of data turis lokal
//    //input data turis lokal
//    public void inputLokal(String nama, String noHp, String alamat, int lama, int ktp, String kamar) {
//        TamuLokalEntity tamu = new TamuLokalEntity(nama, noHp, alamat, lama, ktp);
//        KamarEntity kamarCari = cari(kamar);
//        allLokal().add(new ReservasiLokal(tamu, kamarCari));
//    }
//
//    //cari data reservasi turis lokal
//    public int cariReservasibyKodeKamarLokal(String kodeKamar) {
//        int i = -1;
//        for (ReservasiLokal objek : AllObjectModel.tamuMdl.arrayLokal) {
//            i += 1;
//            if (objek.getKamar().getNo_kamar().equals(kodeKamar)) {
//                if (!objek.getKamar().getStatus_kamar()) {
//                    return i;
//                }
//            }
//        }
//        return -1;
//    }
//
//    //checkout turis lokal
//    public void checkoutLokal(int index) {
//        ReservasiLokal reservasi = arrayLokal.get(index);
//        reservasi.setChecout(DateString.now());
//        KamarEntity kamar = reservasi.getKamar();
//        updateKamar(kamar, true);
//        arrayLokal.set(index, reservasi);
//    }
//
//    //end of data turis lokal
//    //start of data turis asing 
//    //cara data resevari turis asing
//    public int cariReservasibyKodeKamarLuar(String kodeKamar) {
//        int i = -1;
//        for (ReservasiLuar objek : arrayLuar) {
//            i += 1;
//            if (objek.getKamar().getNo_kamar().equals(kodeKamar)) {
//                if (!objek.getKamar().getStatus_kamar()) {
//                    return i;
//                }
//            }
//        }
//        return -1;
//    }
//
//    //input data turis asing
//    public void inputLuar(String nama, String noHp, String alamat, int lama, int pasport, String kamar) {
//        TamuLuarNegeriEntity tamu = new TamuLuarNegeriEntity(nama, noHp, alamat, lama, pasport);
//        KamarEntity kamarCari = cari(kamar);
//        arrayLuar.add(new ReservasiLuar(tamu, kamarCari));
//    }
//
//    //checkout turis asing
//    public void checkOutLuar(int index) {
//        ReservasiLuar reservasi = arrayLuar.get(index);
//        reservasi.setChecout(DateString.now());
//        KamarEntity kamar = reservasi.getKamar();
//        updateKamar(kamar, true);
//        arrayLuar.set(index, reservasi);
//    }
//    //update kamar 
//    private void updateKamar(KamarEntity kamar, boolean status) {
//        for (KamarEntity objek : arrayKamar) {
//            if (kamar.getNo_kamar().equals(objek.getNo_kamar())) {
//                objek.setStatus_kamar(status);
//                break;
//            }
//        }
//    }
    //end of data turis asing 
}
