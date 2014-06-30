package com.gu.discussion.page

import com.gu.automation.support.Wait
import org.openqa.selenium.support.ui.{ExpectedConditions, Select}
import org.openqa.selenium.{By, WebDriver}

case class CommentModule(implicit driver: WebDriver) {

  private val startComments = driver.findElement(By.cssSelector(".d-discussion .d-discussion__pagination .pagination"))
  private def showMoreFeaturedCommeLink = driver.findElement(By.className("show-more__container--featured"))
  private def showAllCommentsButton = driver.findElement(By.className("d-discussion__show-all-comments"))
  private def commentTextArea = driver.findElement(By.className("d-comment-box__body"))
  private def postYourCommentButton = driver.findElement(By.className("d-comment-box__submit"))
  private def cancelButton = driver.findElement(By.className("d-comment-box__cancel"))
  private def sortOrderControl = new Select(driver.findElement(By.className("d-discussion__order-control")))
  private def nextPageControl = startComments.findElement(By.cssSelector(".pagination__item--next .pagination__item-inner"))
  private def previousPageControl = startComments.findElement(By.cssSelector(".pagination__item--prev .pagination__item-inner"))
  private def firstPageControl = startComments.findElement(By.cssSelector(".pagination__item--first .pagination__item-inner"))
  private def lastPageControl = startComments.findElement(By.cssSelector(".pagination__item--last .pagination__item-inner"))
  private def showMoreRepliesButton = driver.findElement(By.className("d-show-more-replies"))

  def showAllReplies(): CommentModule = {
    Wait().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.d-discussion__pagination .js-discussion-change-page")))
    showMoreRepliesButton.click()
    this
  }

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
    nextPageControl.click()
    waitCommentsToLoad()
    println("Next Page")
    this
  }

  def gotoPreviousPage(): CommentModule = {
    previousPageControl.click()
    waitCommentsToLoad()
    println("Previous Page")
    this
  }

  def gotofirstPage(): CommentModule = {
    firstPageControl.click()
    waitCommentsToLoad()
    println("First Page")
    this
  }

  def gotoLastPage(): CommentModule = {
    lastPageControl.click()
    waitCommentsToLoad()
    println("Last Page")
    this
  }

  def waitCommentsToLoad() = {
    Wait().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".discussion__comments__container .preload-msg.d-discussion__loader.u-h")))
  }

}
