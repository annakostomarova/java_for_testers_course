package ru.stqa.javacourse.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
                      .withFirstName("firstname")
                      .withMiddleName("middlename")
                      .withLastName("lastname")
                      .withNickName("nickname")
                      .withTitle("title")
                      .withCompany("company")
                      .withAddress("address")
                      .withHomePhone("homephone")
                      .withMobilePhone("mobilephone")
                      .withWorkPhone("workphone")
                      .withFax("fax")
                      .withEmail("email@addressbook.com")
                      .withEmail2("email2@addressbook.com")
                      .withEmail3("email3@addressbook.com")
                      .withHomePage("homepage")
                      .withAddress2("address2")
                      .withPhone2("phone2")
                      .withNotes("notes")
                      .withGroup("test1"),
              true);
    }
  }

  @Test
  public void testContactEmails() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactEmailTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String email) {
    return email.replaceAll("\\s","").replaceAll("[-()]","");
  }
}
