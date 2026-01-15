package src.app;

import src.model.UserInfo;

public class AdminScreen {

  private boolean staffFlag;

  private UserInfo user;

  public AdminScreen(UserInfo user) {
    this.user = user;
  }

  public void admin() {
    if (user.getAccountType().equalsIgnoreCase("staff")) {
      staffFlag = true;
    } else {
      staffFlag = false;
    }
  }

  public void show() {
    System.out.println("ACCOUNT TYPE : " + user.getAccountType());
    System.out.println("Username : " + user.getName());
    System.out.println("Email : " + user.getEmail());
  }
}
