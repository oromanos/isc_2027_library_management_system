package src.model;

import java.io.*;

class Books {
  String name;
  String discription;
  String author;
  String ID;

  Books(String name, String discription, String author, String ID) {
    this.name = name;
    this.discription = discription;
    this.author = author;
    this.ID = ID;
  }

  void saveToFile() throws IOException {
    FileWriter fw = new FileWriter("Books.txt", true);
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter pw = new PrintWriter(bw);
    pw.println(ID + "|" + name + "|" + discription + "|" + author);
  }
}
