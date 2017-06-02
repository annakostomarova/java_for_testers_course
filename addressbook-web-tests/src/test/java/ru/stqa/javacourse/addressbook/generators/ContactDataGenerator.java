package ru.stqa.javacourse.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import ru.stqa.javacourse.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  @Parameter(names = "-c", description = "Contact count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;


  public static void main(String[] args) throws IOException{
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContact(count);
    save(contacts, new File(file));
  }


  private static void save(List<ContactData> contacts, File file) throws IOException{
    Writer writer = new FileWriter(file);
    for (ContactData contact : contacts) {
      writer.write(String.format("%s; %s; %s; %s; %s; %s; %s\n", contact.getLastname(), contact.getFirstname(), contact.getMiddlename(),
              contact.getAddress(), contact.getEmail(), contact.getHomePhone(), contact.getMobilePhone()));
    }
    writer.close();
  }

  private static List<ContactData> generateContact(int count) {
    List<ContactData> contacts = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData()
              .withLastName(String.format("Ivanov%s", i)).withFirstName(String.format("Ivan%s", i)).withMiddleName(String.format("Kozma%s", i))
              .withAddress(String.format("New Vasuki%s", i)).withEmail(String.format("email%s@addressbook.com", i))
              .withHomePhone(String.format("911-00-0%s", i)).withMobilePhone(String.format("+7(911) 100 44 5%s", i)));
    }
    return contacts;
  }

}
