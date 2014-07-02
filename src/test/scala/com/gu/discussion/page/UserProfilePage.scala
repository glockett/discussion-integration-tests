package com.gu.discussion.page

import com.gu.discussion.support.ByExt
import org.openqa.selenium.{By, WebDriver}


case class UserProfilePage(implicit driver: WebDriver) {

  private def commentsTab = driver.findElement(ByExt.dataTypeStream("discussions"))
  private def repliesTab = driver.findElement(ByExt.dataTypeStream("replies"))
  private def featuredTab = driver.findElement(ByExt.dataTypeStream("picks"))
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
