package ru.stqa.javacourse.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by kostoa on 4/30/2017.
 */
public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().list().size() == 0) {
      ContactData contact = new ContactData()
              .withFirstname("firstname")
              .withMiddlename("middlename")
              .withLastname("lastname")
              .withtNickname("nickname")
              .withTitle("title")
              .withCompany("company")
              .withAddress("address")
              .withHomephone("homephone")
              .withMobilephone("mobilephone")
              .withWorkphone("workphone")
              .withFax("fax")
              .withEmail("email@addressbook.com")
              .withEmail2("email2@addressbook.com")
              .withEmail3("email3@addressbook.com")
              .withHomepage("homepage")
              .withAddress2("address2")
              .withPhone2("phone2")
              .withNotes("notes");
      app.contact().create(contact, true);
    }
  }

  @Test
  public void testContactDeletion() {
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.goTo().homePage();
    app.contact().delete(index);
    app.goTo().homePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size()-1);
  }
}
