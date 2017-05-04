package ru.stqa.javacourse.addressbook.model;

public class ContactData {
  private final String firstname;
  private final String lastname;
  private final String middlename;
  private final String nickname;
  private final String company;
  private final String title;
  private final String address;
  private final String homephone;
  private final String mobilephone;
  private final String workphone;
  private final String fax;
  private final String email;
  private final String email2;
  private final String email3;
  private final String homepage;
  private final String address2;
  private final String phone2;
  private final String notes;
  private String group;


  public ContactData(String firstname,
                     String middlename,
                     String lastname,
                     String nickname,
                     String company,
                     String title,
                     String address,
                     String homephone,
                     String mobilephone,
                     String workphone,
                     String fax,
                     String email,
                     String email2,
                     String email3,
                     String homepage,
                     String address2,
                     String phone2,
                     String notes,
                     String group) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.company = company;
    this.title = title;
    this.address = address;
    this.homephone = homephone;
    this.mobilephone = mobilephone;
    this.workphone = workphone;
    this.fax = fax;
    this.email = email;
    this.email2 = email2;
    this.email3 = email3;
    this.homepage = homepage;
    this.address2 = address2;
    this.phone2 = phone2;
    this.notes = notes;
    this.group = group;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getCompany() {
    return company;
  }

  public String getTitle() {
    return title;
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

  public String getWorkphone() {
    return workphone;
  }

  public String getFax() {return  fax; }

  public String getEmail() {return email; }

  public String getEmail2() {return email2; }

  public String getEmail3() {return email3; }

  public String getHomepage() {return homepage; }

  public String getAddress2() {return address2; }

  public String getPhone2() {return phone2; }

  public String getNotes() {return notes; }

  public String getGroup() {
    return group;
  }
}
