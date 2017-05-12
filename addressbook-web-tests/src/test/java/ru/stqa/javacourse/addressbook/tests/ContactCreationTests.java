package ru.stqa.javacourse.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoHomePage();
        int before = app.getContactHelper().getContactCount();
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
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before + 1);
    }
}