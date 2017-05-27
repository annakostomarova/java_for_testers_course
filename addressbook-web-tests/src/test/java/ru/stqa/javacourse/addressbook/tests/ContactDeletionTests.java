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
  public void testContactDeletion() {
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact(before.size()-1);
    app.getContactHelper().deleteContact();
    app.getContactHelper().acceptDeletion();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size()-1);

  }
}
