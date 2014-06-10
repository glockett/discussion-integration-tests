package com.gu.discussion.page

import org.openqa.selenium.{WebDriver, By}
import com.gu.support.BasePage
import org.openqa.selenium.support.ui.ExpectedConditions

case class CommentItem(implicit override val driver: WebDriver) extends BasePage(driver) {

  private def showCommentButton = driver.findElement(By.className(".d-comment-box__show-parent"))

  private def replyToCommentButton = driver.findElement(By.className(".d-comment__action--reply-text"))

  private def commentTextArea = driver.findElement(By.className(".d-comment-box__body"))

  private def postReplyButton = driver.findElement(By.className(".d-comment-box__submit"))

  private def cancelReplyButton = driver.findElement(By.className(".d-comment-box__cancel"))


  private def pickCommentButton = driver.findElement(By.className(".d-comment__action--pick"))

  private def reportCommentButton = driver.findElement(By.className(".d-comment__action--report"))

  private def showMoreRepliesButton = driver.findElement(By.className(".d-show-more-replies"))

  private def recommendCommentButton = driver.findElement(By.className(".d-comment__recommend-button"))

  private def commentAuthorAvatar = driver.findElement(By.className(".d-comment__avatar"))

  private def commentTimeStamp = driver.findElement(By.className(".d-comment__timestamp"))

  /*TODO list of functions/methods
    Add a reply
    As a Staff member choose a comment to be a Featured comment (Pick)
    Report a comment
    Recommend a comment

   */

  def showCommentPost(): CommentItem = {
    driverWait.until(ExpectedConditions.elementToBeClickable(showCommentButton))
    showCommentButton.click()
    this
  }

  def replyToComment(): CommentItem = {
    driverWait.until(ExpectedConditions.elementToBeClickable(replyToCommentButton))
    replyToCommentButton.click()
    commentTextArea.sendKeys("This is a test reply - Please ignore / delete as required. /n Lorem Ipsum Dispum reply")
    postReplyButton.click()
    this
  }

  def cancelReply(): CommentItem = {
    driverWait.until(ExpectedConditions.elementToBeClickable(cancelReplyButton))
    cancelReplyButton.click()
    this
  }


  def pickComment(): CommentItem = {
    driverWait.until(ExpectedConditions.elementToBeClickable(pickCommentButton))
    pickCommentButton.click()
    this
  }

  def showAllReplies(): CommentItem = {
    driverWait.until(ExpectedConditions.elementToBeClickable(showMoreRepliesButton))
    showMoreRepliesButton.click()
    this
  }

  def reportComment(): CommentItem = {
    driverWait.until(ExpectedConditions.elementToBeClickable(reportCommentButton))
    reportCommentButton.click()
    this
  }

  def recommendComment(): CommentItem = {
    driverWait.until(ExpectedConditions.elementToBeClickable(recommendCommentButton))
    recommendCommentButton.click()
    this
  }

  def isAvatarPresent(): Boolean = {
    commentAuthorAvatar.isDisplayed()
  }

  def isDateStampPresent(): Boolean = {
    commentTimeStamp.isDisplayed()
  }


}
