package src.app;

public class AdminScreen {

    boolean StaffFlag;

    public void admin(String accountType) {
        if (accountType.equals("staff")) {
            System.out.println("Staff screen");
            StaffFlag = true;
        } else if (accountType.equals("admin")) {
            System.out.println("Admin Screen");
            StaffFlag = false;

        }

    }

}
