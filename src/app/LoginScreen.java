package src.app;

import static src.utils.ClearScreen.clearScreen;

import java.util.Scanner;
import src.model.UserInfo;
import src.utils.Encrypter;
import src.utils.InformationExtractor;

public class LoginScreen {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    Encrypter en = new Encrypter();
    InformationExtractor ie = new InformationExtractor();

    System.out.print("Enter Username: ");
    String username = sc.nextLine();

    System.out.print("Enter Password: ");
    String password = sc.nextLine();

    try {

      UserInfo info = ie.getInfo("src/database/login_info.txt", username);

      // check hashed pass
      if (info.getPassword().equals(en.encryptString(password))) {

        System.out.println("Login successful!");
        clearScreen();
        // check acc type
        if (info.getAccountType().equalsIgnoreCase("member")) {
          MemberScreen ms = new MemberScreen(info);
          ms.show();

        } else if (info.getAccountType().equalsIgnoreCase("staff")
            || info.getAccountType().equalsIgnoreCase("admin")) {
          AdminScreen as = new AdminScreen(info);
          as.show();

        } else {
          System.out.println("Unknown account type!");
        }

      } else {
        System.out.println("Invalid password!");
      }

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
