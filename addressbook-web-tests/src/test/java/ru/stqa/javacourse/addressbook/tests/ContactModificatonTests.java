package ru.stqa.javacourse.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;

/**
 * Created by kostoa on 4/30/2017.
 */
public class ContactModificatonTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().getContactCount();
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
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact(before - 1);
    app.getContactHelper().editSpecifiedContact();
    app.getContactHelper().fillAddNewForm(new ContactData(
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
            null),
            false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before);
  }
}
