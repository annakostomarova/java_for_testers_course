package ru.stqa.javacourse.addressbook.tests.contacts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;
import ru.stqa.javacourse.addressbook.model.Contacts;
import ru.stqa.javacourse.addressbook.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.db().contacts().size() == 0) {
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
  public void testContactModification() {
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstName("Anna").withLastName("Ivanova")
            .withNickName("Ivanushka").withAddress("Beverly Hills, 90210");
    app.goTo().homePage();
    app.contact().modify(contact);
    app.goTo().homePage();
    assertThat(app.contact().count(),equalTo(before.size()));

    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.withoutAdded(modifiedContact).withAdded(contact)));
    verifyContactListInUI();
  }

}
