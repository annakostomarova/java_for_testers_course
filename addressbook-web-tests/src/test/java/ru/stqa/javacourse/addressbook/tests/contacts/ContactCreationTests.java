package ru.stqa.javacourse.addressbook.tests.contacts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;
import ru.stqa.javacourse.addressbook.model.Contacts;
import ru.stqa.javacourse.addressbook.model.GroupData;
import ru.stqa.javacourse.addressbook.tests.TestBase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() throws IOException {
    File photo = new File("src/test/resources/image.jpg");
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/contacts.csv"));
    String line = reader.readLine();
    while (line != null) {
      String[] split = line.split(";");
      list.add(new Object[] {new ContactData().withLastName(split[0]).withFirstName(split[1]).withMiddleName(split[2])
              .withAddress(split[3]).withEmail(split[4]).withHomePhone(split[5]).withMobilePhone(split[6]).withGroup(split[7])
              .withPhoto(photo)});
      line = reader.readLine();
    }
    return list.iterator();
  }

    @Test(dataProvider = "validContacts")
    public void testContactCreation(ContactData contact) {
      /**
       **/
      app.goTo().homePage();
      Contacts before = app.contact().all();
      app.contact().create(contact, true);
      app.goTo().homePage();
      assertThat(app.contact().count(),equalTo(before.size()+1));
      Contacts after = app.contact().all();
      assertThat(after, equalTo(
              before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }
}