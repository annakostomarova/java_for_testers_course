package ru.stqa.javacourse.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getContactHelper().gotoAddNewPage();
        app.getContactHelper().fillAddNewForm(new ContactData("Ivan", "Ivanov", "ivanushka", "test",
                "-", "898700", null, "-", null, "-", "-", null, "-", null, "-", "-", null, "na"));
        app.getContactHelper().submitNewContactCreation();
        app.getContactHelper().gotoHomePage();
    }

}
