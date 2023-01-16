package main;

import ViewCLI.AllObjectController;
import controller.AllObjectModel;
import model.StaffModel;
import model.TamuModel;
import controller.StaffController;
import view.*;

public class App {

    public static void main(String[] args) throws Exception {
//        StaffController staff = new StaffController();

        StaffModel.initialStaff();
        AllObjectModel.tamuMdl.initialKamar();
//        PesanKamarGUI g = new PesanKamarGUI();
        LoginStaffGUI gg = new LoginStaffGUI();
//        CheckoutGUI x = new CheckoutGUI();
//        MenuStaffGUI gui = new MenuStaffGUI();
//        MenuHapusGUI g = new MenuHapusGUI();

//        StaffModel.initialStaff();
//        staff.toMain();
    }
}
