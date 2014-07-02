package com.gu.discussion.page

import com.gu.automation.support.{Config, Wait}
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.{By, WebDriver}

case class ArticlePage(implicit driver: WebDriver) extends DataLocators {

  private def commentCountLabel = driver.findElement(By.cssSelector("div.content__main-column.content__main-column--article div.js-comment-count a.js-show-discussion"))
  private def showAllCommentsLink = driver.findElement(byDataLinkName("View all comments"))

  def goToStartOfComments(): ArticlePage = {

    if (commentCountLabel.isDisplayed()) {

      commentCountLabel.click()
    } else {
      System.err.println("There are no comments for this article yet!")
    }
    this
  }

  def showAllComments() = {
    showAllCommentsLink.click()
    this
  }




}

object ArticlePage {

  def goto()(implicit driver: WebDriver) = {
    driver.get(Config().getTestBaseUrl() + Config().getUserValue("testArticlePath"))
    ArticlePage()
  }



}
