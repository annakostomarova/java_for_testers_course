package ru.stqa.javacourse.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;
import ru.stqa.javacourse.addressbook.model.Contacts;
import ru.stqa.javacourse.addressbook.model.GroupData;
import ru.stqa.javacourse.addressbook.model.Groups;

import java.sql.*;

public class DbConnectionTest {

@Test
  public void testDbConnectionGroups(){
    Connection conn = null;
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?user=root&password=");
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("select group_id,group_name,group_header,group_footer from group_list");
      Groups groups = new Groups();
      while (rs.next()) {
        groups.add(new GroupData().withId(rs.getInt("group_id")).withName(rs.getString("group_name"))
                .withHeader(rs.getString("group_header")).withFooter(rs.getString("group_footer")));
      }
      rs.close();
      st.close();
      conn.close();
      System.out.println(groups);

    } catch (SQLException ex) {
      // handle any errors
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }
  }

  @Test
  public void testDbConnectionContacts(){
    Connection conn = null;
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?user=root&password=");
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery(
              "select id,firstname,middlename,lastname,address,company,title,home,work,mobile,email,email2,email3 from addressbook");
      Contacts contacts = new Contacts();
      while (rs.next()) {
        contacts.add(new ContactData().withId(rs.getInt("id")).withFirstName(rs.getString("firstname")).withMiddleName(rs.getString("middlename")).withLastName(rs.getString("lastname"))
                .withAddress(rs.getString("address")).withHomePhone(rs.getString("home")).withMobilePhone(rs.getString("mobile")).withWorkPhone(rs.getString("work"))
                .withEmail(rs.getString("email")).withEmail2(rs.getString("email2")).withEmail3(rs.getString("email3"))
                .withCompany("company").withTitle("title"));
      }
      rs.close();
      st.close();
      conn.close();
      System.out.println(contacts);

    } catch (SQLException ex) {
      // handle any errors
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }
  }

}
