package com.gu.discussion.page

import org.openqa.selenium.{By, WebDriver}

case class HomePage(implicit driver: WebDriver) {

  private def signInLink = driver.findElement(By.cssSelector("#header a[data-link-name=\"User profile\"] > span:nth-child(2)"))

  def goToSigninPage() = {

    signInLink.click()

    SignInPage()
  }

}

