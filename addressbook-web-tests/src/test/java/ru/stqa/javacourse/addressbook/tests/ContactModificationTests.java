package ru.stqa.javacourse.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;
import ru.stqa.javacourse.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

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
              .withHomephone("111homephone")
              .withMobilephone("222mobilephone")
              .withWorkphone("333workphone")
              .withFax("fax")
              .withEmail("email@addressbook.com")
              .withEmail2("email2@addressbook.com")
              .withEmail3("email3@addressbook.com")
              .withHomepage("homepage")
              .withAddress2("address2")
              .withPhone2("444phone2")
              .withNotes("notes")
              .withGroup("test1"),
              true);
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstname("Anna").withLastname("Ivanova")
            .withtNickname("Ivanushka").withAddress("Beverly Hills, 90210");
    app.goTo().homePage();
    app.contact().modify(contact);
    app.goTo().homePage();
    assertThat(app.contact().count(),equalTo(before.size()));

    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.withoutAdded(modifiedContact).withAdded(contact)));
  }

}
