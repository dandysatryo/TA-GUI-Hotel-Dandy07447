package ViewCLI;

import controller.AllObjectModel;
import controller.StaffController;
import java.util.Scanner;
import model.StaffModel;

public class StaffCLI implements ClassInterface {

    Scanner input = new Scanner(System.in);
    StaffController staff = new StaffController();
    TamuCLI view = new TamuCLI();
    static StaffCLI staf = new StaffCLI();
    
    public static void main(String[] args) {
        AllObjectModel.tamuMdl.initialKamar();
        StaffModel.initialStaff();
        staf.menu();
    }

    //sudah
    @Override
    public void menu() {
        String pilih;
        do {
            System.out.println("1. Login\n2. Keluar");
            System.out.print("Masukkan Pilihan = ");
            pilih = input.nextLine();
            switch (pilih) {
                case "1" ->
                    pilihan();
                case "2" ->
                    System.out.println("exit");
                default ->
                    System.out.println("Inputan Tidak Ada");
            }
        } while (!pilih.equals("2"));
    }

    //sudah no1 dan 3 dan 5 kurang 2 dan 4
    private void pilihan() {
        String pilih;
        do {
            System.out.println("1. Staff"
                    + "\n2. User Input Kamar"
                    + "\n3. Display Kamar"
                    + "\n4. checkout"
                    + "\n5. Exit"
            );
            System.out.print("Masukkan Pilihan = ");
            pilih = input.nextLine();
            switch (pilih) {
                case "1" ->
                    login();
                case "2" ->
                    view.inputKamar();
                case "3" ->
                    view.displayKamar();
                case "4" ->
                    pilihanCheckout();
                case "5" ->
                    System.out.println("exit");
                default ->
                    System.out.println("Inputan Tidak Ada");
            }
        } while (!pilih.equals("5"));

    }

    //sudah masih error
    private void pilihanDisplay() {
        String pilih;
        do {
            System.out.println("1. Lihat Daftar Reservasi\n" + "2. Hapus Kamar\n" + "3. Exit");
            System.out.print("Masukkan Pilihan = ");
            pilih = input.nextLine();
            switch (pilih) {
                case "1" ->
                    view.daftarReservasi();
                case "2" ->
                    view.hapusKamar();
                case "3" ->
                    System.out.println("exit");
                default ->
                    System.out.println("Inputan Tidak Ada");
            }
        } while (!pilih.equals("3"));
    }

    private void pilihanCheckout() {
        String pilih;
        do {
            System.out.println("1. Tamu Lokal\n" + "2. Tamu Luar\n" + "3. Exit");
            System.out.print("Masukkan Pilihan = ");
            pilih = input.nextLine();
            switch (pilih) {
                case "1" ->
                    view.checkoutLokal();
                case "2" ->
                    view.checkoutLuar();
                case "3" ->
                    System.out.println("exit");
                default ->
                    System.out.println("Inputan Tidak Ada");
            }
        } while (!pilih.equals("3"));
    }

    //sudah
    private void login() {
        System.out.print("Masukkan Username = ");
        String username = input.nextLine();
        System.out.print("Masukkan Password = ");
        String password = input.nextLine();
        boolean status = staff.cari(username, password);
        if (status) {
            pilihanDisplay();
        } else {
            System.out.println("salah");
        }
    }
}
