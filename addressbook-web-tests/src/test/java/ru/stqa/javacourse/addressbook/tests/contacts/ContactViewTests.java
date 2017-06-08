package ru.stqa.javacourse.addressbook.tests.contacts;

import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;
import ru.stqa.javacourse.addressbook.tests.TestBase;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactViewTests extends TestBase {

  @Test
  public void testContactView() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();

    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    ContactData contactInfoFromViewForm = app.contact().infoFromViewForm(contact.getId());

    assertThat(app.contact().mergeInfoFromViewForm(contactInfoFromViewForm), equalTo(mergeInfoFromEditForm(contactInfoFromEditForm)));
  }

  private String mergeInfoFromEditForm(ContactData contact) {
    return Arrays.asList(contact.getFirstname(),contact.getLastname(),contact.getAddress(),
            contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone(),
            contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactViewTests::cleaned)
            .collect(Collectors.joining(""));
  }

  public static String cleaned(String allInfo) {
    return allInfo.replaceAll("\\s","")
            .replaceAll("[-()]","")
            .replaceAll("[H:M:W:]","");
  }
}
