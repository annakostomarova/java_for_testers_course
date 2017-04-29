package ru.stqa.javacourse.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.javacourse.addressbook.model.ContactData;

/**
 * Created by kostoa on 4/29/2017.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }
  /* for contact */

  public void returnToHomePage() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillAddNewForm(ContactData contactData, By locator) {
    type(By.name("firstname"),contactData.getFirstname());
    type(By.name("lastname"),contactData.getLastname());
    type(By.name("nickname"),contactData.getNickname());
    type(By.name("address"),contactData.getAddress());
    type(By.name("home"),contactData.getHomephone());
    type(By.name("mobile"),contactData.getMobilephone());
  }

  public void gotoAddNewPage() {
    click(By.linkText("add new"));
  }
}
