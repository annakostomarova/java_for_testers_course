package ru.stqa.javacourse.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;
import ru.stqa.javacourse.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
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
                      .withNotes("notes"),
              true);
    }
  }

  @Test
  public void testContactDeletion() {
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.goTo().homePage();
    app.contact().delete(deletedContact);
    app.goTo().homePage();
    Contacts after = app.contact().all();

    assertEquals(after.size(), before.size()-1);
    assertThat(after, equalTo(before.withoutAdded(deletedContact)));
  }

}
