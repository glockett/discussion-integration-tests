package com.gu.discussion.page

import org.openqa.selenium.{By, WebDriver}
import com.gu.support.BasePage
import org.openqa.selenium.support.ui.ExpectedConditions

case class UserProfilePage (implicit override val driver: WebDriver) extends BasePage(driver) {

  private def commentsTab = driver.findElement(By.className(".article__meta-heading"))

  private def repliesTab = driver.findElement(By.className(".commentcount__label"))

  private def featuredTab = driver.findElement(By.className(".CTA Top comment bottom read more"))


  def viewUserComments() = {
    driverWait.until(ExpectedConditions.elementToBeClickable(commentsTab))

  }

  def viewUserReplies() = {
    driverWait.until(ExpectedConditions.elementToBeClickable(repliesTab))

  }

  def viewUserFeaturedComments() = {
    driverWait.until(ExpectedConditions.elementToBeClickable(featuredTab))


  }


}
