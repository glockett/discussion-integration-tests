package com.gu.discussion.page

import org.openqa.selenium.{By, WebDriver}

case class UserProfilePage(implicit driver: WebDriver) extends DataLocators {

  private def commentsTab = driver.findElement(byDataTypeStream("discussions"))
  private def repliesTab = driver.findElement(byDataTypeStream("replies"))
  private def featuredTab = driver.findElement(byDataTypeStream("picks"))
  private def profileName = driver.findElement(By.className("user-profile__name"))

  def getUserProfileName: String = {
    val userProfileName = profileName.getText()
    userProfileName
  }

  def viewProfileComments(): UserProfilePage = {
    commentsTab.click()
    this
  }

  def viewProfileReplies(): UserProfilePage = {
    repliesTab.click()
    this
  }

  def viewProfileFeatured() : UserProfilePage =  {
    featuredTab.click()
    this
  }

}
