package com.gu.discussion.page

import com.gu.automation.support.{Wait}
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.{By, WebDriver}

case class UserProfilePage(implicit driver: WebDriver) {

  private def commentsTab = driver.findElement(By.cssSelector("#js-context > div > div > div.identity-header > div.tabs.tabs--identity.js-visible > ol > li:nth-child(2) > a"))

  private def repliesTab = driver.findElement(By.cssSelector("#js-context > div > div > div.identity-header > div.tabs.tabs--identity.js-visible > ol > li:nth-child(2) > a"))

  private def featuredTab = driver.findElement(By.cssSelector("#js-context > div > div > div.identity-header > div.tabs.tabs--identity.js-visible > ol > li:nth-child(2) > a"))

  def getUserProfileName: String = {
    val userProfileName = driver.findElement(By.className("user-profile__name")).getText()
    userProfileName
  }

  def viewUserProfile() = {
    Wait().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#js-context > div > div > div.identity-header > div.tabs.tabs--identity.js-visible > ol > li:nth-child(2) > a")))

    UserProfilePage()
  }

  def viewProfileComments() = {
    commentsTab.click()
    

    UserProfilePage()
  }

  def viewProfileReplies() = {
    repliesTab.click()


    UserProfilePage()
  }

  def viewProfileFeatured() = {
    featuredTab.click()

    UserProfilePage()
  }


}
