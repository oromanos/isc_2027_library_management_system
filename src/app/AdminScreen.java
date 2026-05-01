package src.app;

import src.model.UserInfo;

public class AdminScreen {

  private boolean staffFlag;

  private UserInfo user;

  public AdminScreen(UserInfo user) {
    this.user = user;
  }

  public void admin() {
    staffFlag = false;
    if (user.getAccountType().equalsIgnoreCase("staff")) {
      staffFlag = true;
    }
  }

  public void show() {
    System.out.println("ACCOUNT TYPE : " + user.getAccountType());
    System.out.println("Username : " + user.getName());
    System.out.println("Email : " + user.getEmail());
    System.out.println("Enter 1 to add account");
  }
}
