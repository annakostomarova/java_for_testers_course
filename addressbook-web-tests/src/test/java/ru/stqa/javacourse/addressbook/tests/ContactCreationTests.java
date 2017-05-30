package ru.stqa.javacourse.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.goTo().homePage();
        Set<ContactData> before = app.contact().all();
        ContactData contact = new ContactData()
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
                .withNotes("notes");

        app.contact().create(contact, true);
        app.goTo().homePage();
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);
    }
}