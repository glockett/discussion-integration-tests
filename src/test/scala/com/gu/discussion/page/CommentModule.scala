package com.gu.discussion.page

import com.gu.automation.support.Wait
import org.openqa.selenium.support.ui.{ExpectedConditions, Select}
import org.openqa.selenium.{By, WebDriver}

case class CommentModule(implicit driver: WebDriver) {

  private val startComments = driver.findElement(By.cssSelector(".d-discussion .d-discussion__pagination"))

  private def showMoreFeaturedCommeLink = driver.findElement(By.className("show-more__container--featured"))
  private def showAllCommentsButton = driver.findElement(By.className("d-discussion__show-all-comments"))
  private def commentTextArea = driver.findElement(By.className("d-comment-box__body"))
  private def postYourCommentButton = driver.findElement(By.className("d-comment-box__submit"))
  private def cancelButton = driver.findElement(By.className("d-comment-box__cancel"))
  private def sortOrderControl = new Select(driver.findElement(By.className("d-discussion__order-control")))


  private def previousControl = startComments.findElement(By.cssSelector(".pagination .pagination__item--prev .pagination__item-inner"))

  private def nextPageControl = startComments.findElement(By.cssSelector(".pagination .pagination__item--next .pagination__item-inner"))

  private def firstPageControl = startComments.findElement(By.cssSelector(".pagination .pagination__item--first .pagination__item-inner"))

  private def lastPageControl = startComments.findElement(By.cssSelector(".pagination .pagination__item--last .pagination__item-inner"))

  private def showMoreRepliesButton = driver.findElement(By.className("d-show-more-replies"))

  def showMoreFeaturedComments(): CommentModule = {
    showMoreFeaturedCommeLink.click()
    this
  }

  def addNewComment(): CommentModule = {
    Wait().until(ExpectedConditions.presenceOfElementLocated(By.className("d-comment-box__body")))
    commentTextArea.sendKeys("This is a test comment --- ZZZZZZZZ")
    this
  }

  def postNewComment(): CommentModule = {
      Wait().until(ExpectedConditions.presenceOfElementLocated(By.className("d-comment-box__submit")))
      postYourCommentButton.click()

      //Ugly hack to wait for URL to change
      var retries = 10
      while (!driver.getCurrentUrl().contains("#comment-") || retries < 0) {
        Thread.sleep(500)
        retries = retries - 1
      }
    this
  }

  def cancelNewComment(): CommentModule = {
    cancelButton.click()
    this
  }

  def showAllComments(): CommentModule = {
    showAllCommentsButton.click()
    this
  }

  def sortCommentsByOrder(sortOrder: String): CommentModule = {
    sortOrderControl.selectByValue(sortOrder)
    this
  }

  def gotoNextPage(): CommentModule = {
    Wait().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.d-discussion__pagination .js-discussion-change-page")))
      nextPageControl.click()
    this
  }

  def previousPage(): CommentModule = {
    previousControl.click()
    this
  }

  def showAllReplies(): CommentModule = {
    showMoreRepliesButton.click()
    this
  }

}
