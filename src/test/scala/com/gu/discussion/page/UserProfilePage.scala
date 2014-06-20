package com.gu.discussion.page

import com.gu.automation.support.Wait
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.{By, WebDriver}

case class UserProfilePage(implicit driver: WebDriver) {

  private def featuredCommentsLabel = driver.findElement(By.className("discussion__comments--top-comments"))

  private def featuredComment = driver.findElement(By.className("article__meta-heading"))


  def ViewUserProfile() = {

    Wait().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.content__main-column.content__main-column--article div.js-comment-count a.js-show-discussion")))

    if (featuredComment.isDisplayed()) {

      featuredComment.click()
    } else {
      System.err.println("There are no comments for this article yet!")
    }

    this
  }



}
