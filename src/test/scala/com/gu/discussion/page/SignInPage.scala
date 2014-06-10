package com.gu.discussion.page

import org.openqa.selenium.{WebDriver, By}
import com.gu.support.BasePage
import org.openqa.selenium.support.ui.ExpectedConditions
import java.util.Calendar
import java.text.SimpleDateFormat

case class SignInPage(implicit override val driver: WebDriver) extends BasePage(driver) {

  private def emailField = driver.findElement(By.id("email"))

  private def passwordField = driver.findElement(By.id("password"))

  private def signInButton = driver.findElement(By.cssSelector(".form-field>button"))

  def signInGUDetails(email: String, password: String): HomePage = {

    driverWait.until(ExpectedConditions.elementToBeClickable(signInButton))

    if (!"Sign in to the Guardian".equals(driver.getTitle())) {
      throw new IllegalStateException("This is not the sign in page");
    }

    emailField.sendKeys(email)
    passwordField.sendKeys(password)
    signInButton.click()

    new HomePage()
  }

  def getTimeStamp() = {
    val today = Calendar.getInstance.getTime
    val curTimeFormat = new SimpleDateFormat("HH:mm:ss")

    curTimeFormat.format(today)

  }

  def getRandomEmailAddress()  = {
    this "auto" + getTimeStamp() + "@gmail.com"
  }

  def getRandomUsername() = {
    return "auto" + getTimeStamp()
  }

}
