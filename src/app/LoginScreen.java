package src.app;

import static src.utils.ClearScreen.clearScreen;

import java.util.Scanner;
import src.model.Member;
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

      Member member = ie.getInfo("src/database/login_info.txt", username);

      // Check password
      if (member.getPassword().equals(en.encryptString(password))) {

        System.out.println("Login successful!");
        clearScreen();

        // Redirect based on account type
        if (member.getAccountType().equalsIgnoreCase("member")) {
          MemberScreen ms = new MemberScreen();
          ms.member();

        } else if (member.getAccountType().equalsIgnoreCase("staff")
            || member.getAccountType().equalsIgnoreCase("admin")) {
          AdminScreen as = new AdminScreen();
          as.admin(member.getAccountType());

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
