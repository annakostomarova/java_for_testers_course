package ru.stqa.javacourse.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.javacourse.addressbook.model.ContactData;
import ru.stqa.javacourse.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kostoa on 4/29/2017.
 */
public class ContactHelper extends HelperBase {

  public boolean creation;

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void createContact(ContactData contact, boolean b) {
    gotoAddNew();
    fillAddNewForm(contact, b);
    submitNewContactCreation();
  }

  public void modifyContact(int index, ContactData contact) {
    selectContact(index);
    editSpecifiedContact(index);
    fillAddNewForm(contact,false);
    submitContactModification();
  }

  public void fillAddNewForm(ContactData contactData, boolean creation) {
    this.creation = creation;
    type(By.name("firstname"),contactData.getFirstname());
    type(By.name("middlename"),contactData.getMiddlename());
    type(By.name("lastname"),contactData.getLastname());
    type(By.name("nickname"),contactData.getNickname());
    type(By.name("company"),contactData.getCompany());
    type(By.name("title"),contactData.getTitle());
    type(By.name("address"),contactData.getAddress());
    type(By.name("home"),contactData.getHomephone());
    type(By.name("mobile"),contactData.getMobilephone());
    type(By.name("work"),contactData.getWorkphone());
    type(By.name("fax"),contactData.getFax());
    type(By.name("email"),contactData.getEmail());
    type(By.name("email2"),contactData.getEmail2());
    type(By.name("email3"),contactData.getEmail3());
    type(By.name("homepage"),contactData.getHomepage());
    type(By.name("address2"),contactData.getAddress2());
    type(By.name("phone2"),contactData.getPhone2());
    type(By.name("notes"),contactData.getNotes());

    if(creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void gotoAddNew() {
    click(By.linkText("add new"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void submitNewContactCreation() {
    click(By.name("submit"));
  }

  public void editSpecifiedContact(int index) {

    wd.findElements(By.name("selected[]")).get(index).findElement(By.xpath("//img[contains(@title,'Edit')]")).click();

  }

  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void acceptDeletion() {
    accept();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<>();
    List<WebElement> rows = wd.findElements(By.cssSelector("tr[name=entry]"));

    for(WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.cssSelector("td"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData(id, firstname, null, lastname, null, null, null, null,
              null, null, null, null, null, null, null, null, null, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }

}