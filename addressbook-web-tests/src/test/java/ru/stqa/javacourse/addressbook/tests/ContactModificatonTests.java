package ru.stqa.javacourse.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

/**
 * Created by kostoa on 4/30/2017.
 */
public class ContactModificatonTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData(
                      "firstname",
                      "middlename",
                      "lastname",
                      "nickname",
                      "company",
                      "title",
                      "address",
                      "homephone",
                      "mobilephone",
                      "workphone",
                      "fax",
                      "email@addressbook.com",
                      "email2@addressbook.com",
                      "email3@addressbook.com",
                      "homepage",
                      "address2",
                      "phone2",
                      "notes",
                      "test1"),
              true);
    }
  }

  @Test
  public void testContactModification() {
    List<ContactData> before = app.getContactHelper().getContactList();
    int index = before.size()-1;
    ContactData contact = new ContactData(before.get(index).getId(),
            "Anna",
            null,
            "Ivanova",
            "ivanushka",
            "company",
            "title",
            "Beverly Hills, 90210",
            "homephone",
            "mobilephone",
            "workphone",
            "fax",
            "ivanushka@addressbook.com",
            "ivanushka2@addressbook.com",
            "ivanushka3@addressbook.com",
            "homepage",
            "address2",
            "phone2",
            "notes",
            null);
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().modifyContact(index, contact);
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
