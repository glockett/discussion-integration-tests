package com.gu.discussion.page

import org.openqa.selenium.{By, WebDriver}
import com.gu.support.BasePage
import org.openqa.selenium.support.ui.ExpectedConditions

case class HomePage(implicit override val driver: WebDriver) extends BasePage(driver) {

  private def signInLink = driver.findElement(By.className("js-profile-info control__info"))

  def goToSigninPage() = {

    if (driverWait.until(ExpectedConditions.elementToBeClickable(signInLink)).isDisplayed()) {
      signInLink.click()
      new SignInPage()

    } else

      throw new IllegalStateException("This is not the sign in page")

  }


}