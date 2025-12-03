import java.util.*;
class Books_Issued{

    private int id; //record id
    private int bookId;
    private int memberId;

    private String issuedOn; //date
    private int issuedBy; //staff id

    private String returnedOn; //date if not returned yet ""
    private int returnedBy; //staff id

    Books_Issued (int id,int bookId,int memberId,String issuedOn,int issuedBy,String returnedOn,int returnedBy){
        this.id=id;
        this.bookId=bookId;
        this.memberId=memberId;
        this.issuedOn=issuedOn;
        this.issuedBy=issuedBy;
        this.returnedOn=returnedOn;
        this.returnedBy=returnedBy;
    }
     Books_Issued (int id,int bookId,int memberId,String issuedOn,int issuedBy){//when book is not returned yet
        this.id=id;
        this.bookId=bookId;
        this.memberId=memberId;
        this.issuedOn=issuedOn;
        this.issuedBy=issuedBy;
        returnedOn="";
        returnedBy=0;
        
    }
    public void bookReturned(String returnDate , int staffId){

        this.returnedOn=returnDate;
        this.returnedBy=staffId;

    }
    boolean isReturned(){
        return !returnedOn.equals("");
    }

    public String toRecord() {
    return id + "|" + bookId + "|" + memberId + "|" +
           issuedOn + "|" + issuedBy + "|" +
           returnedOn + "|" + returnedBy;
}
public String toString() {
    return "Books_Issued{" +
            "id=" + id +
            ", bookId=" + bookId +
            ", memberId=" + memberId +
            ", issuedOn='" + issuedOn + '\'' +
            ", issuedBy=" + issuedBy +
            ", returnedOn='" + returnedOn + '\'' +
            ", returnedBy=" + returnedBy +
            '}';
}
public static Books_Issued fromRecord(String line) {

    StringTokenizer st = new StringTokenizer(line, "|");

    int id = Integer.parseInt(st.nextToken());
    int bookId = Integer.parseInt(st.nextToken());
    int memberId = Integer.parseInt(st.nextToken());
    String issuedOn = st.nextToken();
    int issuedBy = Integer.parseInt(st.nextToken());
    String returnedOn = st.nextToken();
    int returnedBy = Integer.parseInt(st.nextToken());

    return new Books_Issued(id, bookId, memberId, issuedOn, issuedBy, returnedOn, returnedBy);
}





}