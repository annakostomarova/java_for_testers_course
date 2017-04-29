package ru.stqa.javacourse.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.javacourse.addressbook.appmanager.ApplicationManager;
import ru.stqa.javacourse.addressbook.model.ContactData;

/**
 * Created by kostoa on 4/29/2017.
 */
public class TestBase {

  protected final ApplicationManager app = new ApplicationManager();

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }

}