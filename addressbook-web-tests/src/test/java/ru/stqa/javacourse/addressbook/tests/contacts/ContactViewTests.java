package ru.stqa.javacourse.addressbook.tests.contacts;

import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;
import ru.stqa.javacourse.addressbook.tests.TestBase;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ContactViewTests extends TestBase {

  @Test(enabled = false)
  public void testContactView() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();


    ContactData contactInfoFromViewForm = app.contact().infoFromViewForm(contact);
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
/****
    assertThat(mergeInfoFromViewForm(contactInfoFromViewForm), equalTo(mergeInfoFromEditForm(contactInfoFromEditForm)));
*****/
  }


  private String mergeInfoFromEditForm(ContactData contact) {
    return Arrays.asList(contact.getLastname(),contact.getFirstname(),contact.getMiddlename(),
            contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone(),
            contact.getEmail(), contact.getEmail2(), contact.getEmail3(),contact.getAddress())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactViewTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String allInfo) {
    return allInfo.replaceAll("\\s","")
            .replaceAll("[-()]","")
            .replaceAll("[H:M:W:]","");
  }
}
