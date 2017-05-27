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
    app.goTo().homePage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData(
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
    List<ContactData> before = app.contact().list();
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
    app.goTo().homePage();
    app.contact().modify(index, contact);
    app.goTo().homePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
