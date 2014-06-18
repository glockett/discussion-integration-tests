package com.gu.discussion.page

import org.openqa.selenium.{WebDriver, By}
import org.openqa.selenium.support.ui.ExpectedConditions
import java.util.Calendar
import java.text.SimpleDateFormat

case class SignInPage(implicit driver: WebDriver) {


  private def emailField = driver.findElement(By.id("email"))

  private def passwordField = driver.findElement(By.id("password"))

  private def signInButton = driver.findElement(By.cssSelector(".form-field>button"))

  def signInGUDetails(email: String, password: String): HomePage = {

    if (!"Sign in | Identity | The Guardian".equals(driver.getTitle())) {
      throw new IllegalStateException("This is not the sign in page")
    }

    Wait().until(ExpectedConditions.elementToBeClickable(signInButton))
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

  def getRandomEmailAddress() = {
    "user" + getTimeStamp() + "@gmail.com"
    this

  }

  def getRandomUsername() = {
    "user" + getTimeStamp()
    this
  }

}
