package ru.stqa.javacourse.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.goTo().homePage();
        List<ContactData> before = app.contact().list();
        ContactData contact = new ContactData(
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
                "test1");
        app.contact().create(contact, true);
        app.goTo().homePage();
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }
}