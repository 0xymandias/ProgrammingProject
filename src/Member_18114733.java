public class Member_18114733 {

  private String memberID;
  private String memberName;
  private String memberAddress;
  private String memberPhone;
  private String memberEmail;

  public void setMemberID(String memberID) {
    this.memberID = memberID;
  }

  public void setMemberName(String memberName) {
    this.memberName = memberName;
  }

  public void setMemberAddress(String memberAddress) {
    this.memberAddress = memberAddress;
  }

  public void setMemberPhone(String memberPhone) {
    this.memberPhone = memberPhone;
  }

  public void setMemberEmail(String memberEmail) {
    this.memberEmail = memberEmail;
  }

  //getters

  public String getMemberID() {
    return memberID;
  }

  public String getMemberName() {
    return memberName;
  }

  public String getMemberAddress() {
    return memberAddress;
  }

  public String getMemberPhone() {
    return memberPhone;
  }

  public String getMemberEmail() {
    return memberEmail;
  }


  /**
   * Constructor for creating new Member_18114733 objects Either from file, or using the addMember()
   * method
   * 
   * @param memberID - The Member's unique ID
   * @param memberName - The Member's name
   * @param memberAddress - The Member's home address
   * @param memberPhone - The Member's phone number
   * @param memberEmail - The Member's email address
   */
  public Member_18114733(String memberID, String memberName, String memberAddress,
      String memberPhone, String memberEmail) {
    this.memberID = memberID;
    this.memberName = memberName;
    this.memberAddress = memberAddress;
    this.memberPhone = memberPhone;
    this.memberEmail = memberEmail;
  }

  @Override

  public String toString() {
    return (this.getMemberID() + "," + this.getMemberName() + "," + this.getMemberAddress() + ","
        + this.getMemberPhone() + "," + this.getMemberEmail() + "\n");
  }

}


