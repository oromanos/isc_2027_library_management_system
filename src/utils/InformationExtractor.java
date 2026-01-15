package src.utils;

import java.io.*;
import java.util.StringTokenizer;
import src.model.UserInfo;

public class InformationExtractor {

  public UserInfo getInfo(String filename, String username) throws Exception {

    BufferedReader br = new BufferedReader(new FileReader(filename));
    String fileLine;

    while ((fileLine = br.readLine()) != null) {

      StringTokenizer st = new StringTokenizer(fileLine, "#");
      String name = st.nextToken();
      String email = st.nextToken();
      String password = st.nextToken();
      String accountType = st.nextToken();

      if (username.equals(name)) {
        br.close();
        return new UserInfo(name, email, password, accountType);
      }
    }

    br.close();
    throw new Exception("Username does not exist!");
  }
}
