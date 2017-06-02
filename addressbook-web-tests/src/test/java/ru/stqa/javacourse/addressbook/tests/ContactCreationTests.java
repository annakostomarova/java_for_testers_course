package ru.stqa.javacourse.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;
import ru.stqa.javacourse.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.goTo().homePage();
        File photo = new File("src/test/resources/image.jpg");
        Contacts before = app.contact().all();
        ContactData contact = new ContactData()
                .withFirstName("Firstname")
                .withMiddleName("Middlename")
                .withLastName("Lastname")
                .withAddress("Address")
                .withHomePhone("111homephone")
                .withMobilePhone("222mobilephone")
                .withWorkPhone("333workphone")
                .withEmail("email@addressbook.com")
                .withEmail2("email2@addressbook.com")
                .withEmail3("email3@addressbook.com")
                .withGroup("test1")
                .withPhoto(photo);

        app.contact().create(contact, true);
        app.goTo().homePage();
        assertThat(app.contact().count(),equalTo(before.size()+1));

        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

}