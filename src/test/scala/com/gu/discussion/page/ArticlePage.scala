package com.gu.discussion.page

import com.gu.automation.support.{Config, Wait}
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.{By, WebDriver}

case class ArticlePage(implicit driver: WebDriver) {

  private def featuredCommentsLabel = driver.findElement(By.className("discussion__comments--top-comments"))

  private def featuredComment = driver.findElement(By.className("article__meta-heading"))

  private def commentCountLabel = driver.findElement(By.cssSelector("div.content__main-column.content__main-column--article div.js-comment-count a.js-show-discussion"))

  private def gotoFeaturedComments = driver.findElement(By.className("CTA Top comment bottom read more"))

  private def showAllCommentsLink = driver.findElement(By.cssSelector("#comments > div.discussion__comments__container > div.discussion-container.js-discussion-container > a"))

  def goToStartOfComments(): ArticlePage ={
    Wait().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.content__main-column.content__main-column--article div.js-comment-count a.js-show-discussion")))

    //TODO Istvan to have a look
    // Wait().until(ExpectedConditions.visibilityOf(commentCountLabel))
    if (commentCountLabel.isDisplayed()) {

      commentCountLabel.click()
    } else {
      System.err.println("There are no comments for this article yet!")

      //Got to add a comment
    }
    this
  }

  def viewFeaturedComments(): ArticlePage = {
    /*if (featuredComment.getText().contains("Featured Content")) {
      gotoFeaturedComments.click()
    } else {
      System.err.println("There are no Featured comments for this article")
    }*/
    gotoFeaturedComments.click()
    this
  }

  def showAllComments(): ArticlePage ={
    Wait().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#comments > div.discussion__comments__container > div.discussion-container.js-discussion-container > a")))
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
