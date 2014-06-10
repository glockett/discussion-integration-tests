package com.gu.discussion.page

import org.openqa.selenium.{WebDriver, By}
import com.gu.support.BasePage

case class SignInPage (implicit override val driver: WebDriver) extends BasePage(driver) {

  private def emailField = driver.findElement(By.id("email"))
  private def passwordField = driver.findElement(By.id("password"))
  private def signInButton = driver.findElement(By.cssSelector(".form-field>button"))

  def signInGUDetails(email: String, password: String): HomePage = {
    emailField.sendKeys(email)
    passwordField.sendKeys(password)
    signInButton.click()
    new HomePage()
  }


}
