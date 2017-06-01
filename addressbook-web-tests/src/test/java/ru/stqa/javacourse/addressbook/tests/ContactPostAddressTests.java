package ru.stqa.javacourse.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPostAddressTests extends TestBase {

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
  public void testContactPostAddress() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
  }

  /***
  public static String cleaned(String email) {
    return email.replaceAll("\\s","").replaceAll("[-()]","");
  }
   ***/
}
