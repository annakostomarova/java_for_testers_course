package ru.stqa.javacourse.addressbook.tests.contacts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;
import ru.stqa.javacourse.addressbook.model.Groups;
import ru.stqa.javacourse.addressbook.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPostAddressTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    Groups groups = app.db().groups();
    ContactData newContact = new ContactData()
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
            .inGroup(groups.iterator().next());
    app.goTo().homePage();
    if (app.db().contacts().size() == 0) {
      app.contact().create(newContact,true);
    }
  }

  @Test
  public void testContactPostAddress() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));

  }

}
