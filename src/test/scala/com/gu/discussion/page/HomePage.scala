package com.gu.discussion.page

import org.openqa.selenium.{By, WebDriver}

case class HomePage(implicit driver: WebDriver) {

  //private def signInLink = driver.findElement(By.cssSelector("span.js-profile-info.control__info"))

  private def signInLink = driver.findElement(By.cssSelector("#header a[data-link-name=\"User profile\"] > span:nth-child(2)"))


  def goToSigninPage() = {

    /*
        if (Wait().until(ExpectedConditions.elementToBeClickable(signInLink)).isDisplayed()) {
          signInLink.click()

          new SignInPage()

        } else

          throw new IllegalStateException("This is not the sign in page")*/

    signInLink.click()

    SignInPage()
  }

}

