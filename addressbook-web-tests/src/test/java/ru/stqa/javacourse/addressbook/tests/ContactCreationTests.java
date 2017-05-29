package ru.stqa.javacourse.addressbook.tests;

import org.openqa.selenium.By;
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
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}