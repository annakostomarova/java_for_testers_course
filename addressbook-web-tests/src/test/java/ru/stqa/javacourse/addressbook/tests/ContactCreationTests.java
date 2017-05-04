package ru.stqa.javacourse.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getContactHelper().createContact(new ContactData(
                "firstname",
                "middlename",
                "lastname",
                "nickname",
                "company",
                "title",
                "address",
                "homephone",
                "mobilephone",
                "workphone",
                "fax",
                "email@addressbook.com",
                "email2@addressbook.com",
                "email3@addressbook.com",
                "homepage",
                "address2",
                "phone2",
                "notes",
                "test1"),
                true);
        app.getNavigationHelper().gotoHomePage();
    }
}