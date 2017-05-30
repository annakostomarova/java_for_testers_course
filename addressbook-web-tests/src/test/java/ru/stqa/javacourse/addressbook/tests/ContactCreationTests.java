package ru.stqa.javacourse.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;
import ru.stqa.javacourse.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
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
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size() + 1);

        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }
}