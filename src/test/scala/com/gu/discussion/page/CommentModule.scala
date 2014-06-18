package com.gu.discussion.page

import org.openqa.selenium.{WebDriver, By}
import org.openqa.selenium.support.ui.{ExpectedConditions, Select}

case class CommentModule(implicit driver: WebDriver)  {

  private def showMoreFeaturedCommeLink = driver.findElement(By.className("show-more__container--featured"))

  private def showAllCommentsButton = driver.findElement(By.className("d-discussion__show-all-comments"))

  private def commentTextArea = driver.findElement(By.cssSelector("textarea[name=\"body\"]"))

  private def postYourCommentButton = driver.findElement(By.cssSelector("button.submit-input.d-comment-box__submit"))

  private def cancelButton = driver.findElement(By.className("d-comment-box__cancel"))

  private def sortOrderControl = new Select(driver.findElement(By.className("d-discussion__order-control")))

  private def previousControl = driver.findElement(By.className("pagination__item--prev"))

  private def nextControl = driver.findElement(By.className("pagination__item--next"))

  private def showMoreRepliesButton = driver.findElement(By.className("d-show-more-replies"))

  private def newCommentDateStamp = driver.findElement(By.className("js-timestamp"))


  def showMoreFeaturedComments(): CommentModule = {
    Wait().until(ExpectedConditions.elementToBeClickable(showMoreFeaturedCommeLink))
    showMoreFeaturedCommeLink.click()
    this
  }

  def addNewComment(): CommentModule = {
    commentTextArea.sendKeys("This is a test comment - Please ignore / delete as required. \n Lorem Ipsum Dispum " +
      "comment thread text")

    this
  }

  def postNewComment(): CommentModule = {
    Wait().until(ExpectedConditions.elementToBeClickable(postYourCommentButton))
    postYourCommentButton.click()
    val commentDTS = driver.findElement(By.cssSelector("div.d-comment__inner > div.d-comment__meta > div.d-comment__meta-text > div.d-comment__timestamp > a.d-comment__timestamp > time.js-timestamp")).getText()

    assert(commentDTS == "Just now")



    this


  }

  def cancelNewComment(): CommentModule = {
    Wait().until(ExpectedConditions.elementToBeClickable(cancelButton))
    cancelButton.click()
    this
  }

  def showAllComments(): CommentModule = {
    Wait().until(ExpectedConditions.elementToBeClickable(showAllCommentsButton))
    showAllCommentsButton.click()
    this
  }

  def sortCommentsByOrder(sortOrder: String): CommentModule = {
    sortOrderControl.selectByValue(sortOrder)
    this
  }

  def nextPage(): CommentModule = {
    Wait().until(ExpectedConditions.elementToBeClickable(nextControl))
    nextControl.click()
    this
  }

  def previousPage(): CommentModule = {
    Wait().until(ExpectedConditions.elementToBeClickable(previousControl))
    previousControl.click()
    this
  }

  def showAllReplies(): CommentModule = {
    Wait().until(ExpectedConditions.elementToBeClickable(showMoreRepliesButton))
    showMoreRepliesButton.click()
    this
  }


}
