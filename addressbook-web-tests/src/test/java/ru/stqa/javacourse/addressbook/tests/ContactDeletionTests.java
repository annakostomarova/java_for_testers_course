package ru.stqa.javacourse.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;
import ru.stqa.javacourse.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstName("Firstname")
              .withMiddleName("Middlename")
              .withLastName("Lastname")
              .withAddress("Address")
              .withHomePhone("111homephone")
              .withMobilePhone("222mobilephone")
              .withWorkPhone("333workphone")
              .withEmail("email@addressbook.com")
              .withEmail2("email2@addressbook.com")
              .withEmail3("email3@addressbook.com")
              .withGroup("test1"),
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
    assertThat(app.contact().count(),equalTo(before.size()-1));

    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.withoutAdded(deletedContact)));
  }

}
