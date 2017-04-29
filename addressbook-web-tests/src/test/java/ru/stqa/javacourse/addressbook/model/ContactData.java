package ru.stqa.javacourse.addressbook.model;

public class ContactData {
  private final String firstname;
  private final String lastname;
  private final String nickname;
  private final String address;
  private final String homephone;
  private final String mobilephone;

  public ContactData(String firstname, String lastname, String nickname, String address, String homephone, String mobilephone) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.nickname = nickname;
    this.address = address;
    this.homephone = homephone;
    this.mobilephone = mobilephone;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getAddress() {
    return address;
  }

  public String getHomephone() {
    return homephone;
  }

  public String getMobilephone() {
    return mobilephone;
  }
}
