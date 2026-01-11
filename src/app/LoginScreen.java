package src.app;

import java.io.*;
import java.util.*;
import static src.utils.ClearScreen.clearScreen;
import src.utils.Encrypter;

class LoginScreen {

    public static void main(String args[]) {

        String id, password, fileline;
        boolean flag = false;
        Encrypter en = new Encrypter();
        // ClearScreen cls = new ClearScreen();
        String fileName = "src/database/login_info.txt";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID :");
        id = sc.nextLine();
        System.out.print("Enter Password :");
        password = sc.nextLine();

        try {

            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            FileReader frcount = new FileReader(fileName);
            BufferedReader brcount = new BufferedReader(frcount);
            int line = 0;
            while (brcount.readLine() != null) {
                line++;
            }
            brcount.close();
            if (line == 0) {
                System.out.println("no records found");
            }
            for (int i = 0; i < line; i++) {
                fileline = br.readLine();

                int firstPipe = fileline.indexOf('#');
                int secondPipe = fileline.indexOf('#', firstPipe + 1);

                String email = fileline.substring(0, firstPipe);
                String pass = fileline.substring(firstPipe + 1, secondPipe);
                String accountType = fileline.substring(secondPipe + 1);
                br.close();

                if (email.equals(id)) {
                    flag = true;
                    if (pass.equals(en.encryptString(password))) {
                        System.out.println("Login complete");
                        clearScreen();
                        if (accountType.equals("member")) {

                            MemberScreen ms = new MemberScreen();
                            ms.member();

                        } else if (accountType.equals("Staff")) {
                            AdminScreen as = new AdminScreen();
                            as.admin(accountType);

                        }

                    } else {
                        System.out.println("invalid password");
                    }
                }

            }
            if (!flag) {
                System.out.println("Email not found!");

            }

        }

        catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }
}