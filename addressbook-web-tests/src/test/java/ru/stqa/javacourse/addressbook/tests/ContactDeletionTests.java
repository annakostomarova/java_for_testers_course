package ru.stqa.javacourse.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;
import ru.stqa.javacourse.addressbook.model.GroupData;

import java.util.List;
import java.util.Set;

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
    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.goTo().homePage();
    app.contact().delete(deletedContact);
    app.goTo().homePage();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size()-1);

    before.remove(deletedContact);
    Assert.assertEquals(before, after);
  }

}
