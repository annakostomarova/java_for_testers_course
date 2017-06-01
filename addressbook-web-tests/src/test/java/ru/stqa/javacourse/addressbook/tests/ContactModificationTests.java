package ru.stqa.javacourse.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;
import ru.stqa.javacourse.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.withoutAdded(modifiedContact).withAdded(contact)));
  }

}
