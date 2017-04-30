package ru.stqa.javacourse.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;

/**
 * Created by kostoa on 4/30/2017.
 */
public class ContactModificatonTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getContactHelper().selectContact();
    app.getContactHelper().editSpecifiedContact();
    app.getContactHelper().fillAddNewForm(new ContactData("Anna", "Ivanova", "ivanushka", "test",
            "-", "9008700", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "na"));
    app.getContactHelper().submitContactModification();
    app.getContactHelper().gotoHomePage();
  }

}
