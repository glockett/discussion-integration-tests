package com.gu.discussion.page

import com.gu.automation.support.Wait
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.{By, WebDriver}

case class UserProfilePage(implicit driver: WebDriver) extends DataLocators {

  private def commentsTab = driver.findElement(byDataTypeStream("discussions"))
  private def repliesTab = driver.findElement(byDataTypeStream("replies"))
  private def featuredTab = driver.findElement(byDataTypeStream("picks"))
  private def profileName = driver.findElement(By.className("user-profile__name"))

  def getUserProfileName: String = {
    //Wait().until(ExpectedConditions.presenceOfElementLocated(By.className("user-profile__name")))
    val userProfileName = profileName.getText()
    userProfileName
  }

  def viewProfileComments(): UserProfilePage = {
    //Wait().until(ExpectedConditions.presenceOfElementLocated(byDataTypeStream("discussions")))
    commentsTab.click()
    this
  }

  def viewProfileReplies(): UserProfilePage = {
    //Wait().until(ExpectedConditions.presenceOfElementLocated(byDataTypeStream("replies")))
    repliesTab.click()
    this
  }

  def viewProfileFeatured() : UserProfilePage =  {
    //Wait().until(ExpectedConditions.presenceOfElementLocated(byDataTypeStream("picks")))
    featuredTab.click()
    this
  }

}
