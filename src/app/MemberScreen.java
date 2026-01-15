package src.app;

import src.model.UserInfo;

public class MemberScreen {

  private UserInfo user;

  public MemberScreen(UserInfo user) {
    this.user = user;
  }

  public void show() {
    System.out.println("ACCOUNT TYPE : " + user.getAccountType());
    System.out.println("Username : " + user.getName());
    System.out.println("Email : " + user.getEmail());
  }
}
