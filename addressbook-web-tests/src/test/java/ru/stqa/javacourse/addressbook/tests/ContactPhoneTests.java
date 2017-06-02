package ru.stqa.javacourse.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase{

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
  public void testContactPhones() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomephone(), contact.getMobilephone(), contact.getWorkphone(), contact.getPhone2())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s","").replaceAll("[-()]","");
  }
}
