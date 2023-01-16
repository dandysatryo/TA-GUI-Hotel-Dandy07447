package controller;

import entity.StaffEntity;
import model.StaffModel;
import ViewCLI.StaffCLI;

import java.util.ArrayList;

public class StaffController implements InterfaceController {

    public void toMain() {
        StaffCLI staff = new StaffCLI();
        staff.menu();
    }
    int indexLogin = 0;

    public boolean cari(String username, String password) {
        ArrayList<StaffEntity> staff = StaffModel.all();
        for (StaffEntity objek : staff) {
            if (objek.getUsername().equals(username) && objek.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean login(String username, String password) {
        return cekData(username, password);
    }

    public Boolean cekData(String username, String password) {
        Boolean status = false;
        for (StaffEntity staffEntity00 : StaffModel.all()) {
            if (staffEntity00.getUsername().equals(username) && staffEntity00.getPassword().equals(password)) {
                status = true;
            }
        }
        return status;
    }
}
