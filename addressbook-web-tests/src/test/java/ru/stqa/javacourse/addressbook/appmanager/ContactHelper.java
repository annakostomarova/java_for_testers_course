package ru.stqa.javacourse.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.javacourse.addressbook.model.ContactData;

/**
 * Created by kostoa on 4/29/2017.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }
  /* for contact */

  public void fillAddNewForm(ContactData contactData) {
    type(By.name("firstname"),contactData.getFirstname());
    type(By.name("middlename"),contactData.getLastname());
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
  }

  public void gotoAddNewPage() {
    click(By.linkText("add new"));
  }

  public void selectContact() {
    if (!wd.findElement(By.name("selected[]")).isSelected()) {
      click(By.name("selected[]"));
    }
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void submitNewContactCreation() {
    click(By.name("submit"));
  }

  public void editSpecifiedContact() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void gotoHomePage() {
    click(By.linkText("home page"));
  }

  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void acceptDeletion() {
    accept();
  }

}