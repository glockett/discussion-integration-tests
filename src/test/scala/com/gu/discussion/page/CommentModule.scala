package com.gu.discussion.page

import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.{By, WebDriver}

case class CommentModule(implicit driver: WebDriver) {

  private def showMoreFeaturedCommeLink = driver.findElement(By.className("show-more__container--featured"))

  private def showAllCommentsButton = driver.findElement(By.className("d-discussion__show-all-comments"))

  private def commentTextArea = driver.findElement(By.className("d-comment-box__body"))

  private def postYourCommentButton = driver.findElement(By.className("d-comment-box__submit"))

  private def cancelButton = driver.findElement(By.className("d-comment-box__cancel"))

  private def sortOrderControl = new Select(driver.findElement(By.className("d-discussion__order-control")))

  private def previousControl = driver.findElement(By.className("pagination__item--prev"))

  private def nextControl = driver.findElement(By.className("pagination__item--next"))

  private def showMoreRepliesButton = driver.findElement(By.className("d-show-more-replies"))

  private def newCommentDateStamp = driver.findElement(By.className("js-timestamp"))

  def showMoreFeaturedComments(): CommentModule = {
    showMoreFeaturedCommeLink.click()
    this
  }

  def addNewComment(): CommentModule = {
    commentTextArea.sendKeys("This is a test comment - Please ignore / delete as required.")
    this

  }

  def postNewComment(): CommentModule = {
    postYourCommentButton.click()
    this
  }

  def getNewCommentText: String = {
    val newComment = driver.findElement(By.cssSelector(".js-new-comments .d-comment__body"))

    newComment.getText
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

  def nextPage(): CommentModule = {
    nextControl.click()
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
