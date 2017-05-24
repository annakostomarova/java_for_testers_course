package ru.stqa.javacourse.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;
import ru.stqa.javacourse.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

/**
 * Created by kostoa on 4/30/2017.
 */
public class ContactModificatonTests extends TestBase {

  @Test
  public void testContactModification() {
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
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().editSpecifiedContact(before.size() - 1);
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(),
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
    app.getContactHelper().fillAddNewForm(contact,false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }
}
