package com.gu.discussion.page

import org.openqa.selenium.{By, WebDriver}
import com.gu.support.BasePage

case class HomePage (implicit override val driver: WebDriver) extends BasePage(driver) {

  private def signInLink = driver.findElement(By.className("js-profile-info control__info"))

  def goToSigninPage() = {
    signInLink.click()
    new SignInPage()
  }


}