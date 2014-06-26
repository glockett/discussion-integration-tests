package com.gu.discussion.page

import com.gu.automation.support.Wait
import org.openqa.selenium.support.ui.{ExpectedConditions, Select}
import org.openqa.selenium.{By, WebDriver}

case class CommentItem(implicit driver: WebDriver) {

  private val latestComment = driver.findElement(By.cssSelector(".discussion__comments__container .d-comment"))
  private def commentBody = latestComment.findElement(By.className("d-comment__body"))
  private def showCommentButton = latestComment.findElement(By.className("d-comment-box__show-parent"))
  private def replyToCommentButton = latestComment.findElement(By.className("d-comment__action--reply"))
  private def commentTextArea = latestComment.findElement(By.cssSelector("textarea[name=\"body\"]"))
  private def postReplyButton = latestComment.findElement(By.className("d-comment-box__submit"))
  private def cancelReplyButton = latestComment.findElement(By.className("d-comment-box__cancel"))
  private def pickCommentButton = latestComment.findElement(By.className("d-comment__action--pick"))
  private def reportCommentButton = latestComment.findElement(By.className("d-comment__action--report"))
  private def reportSelectControl = latestComment.findElement(By.name("category"))
  private def reportTextArea = latestComment.findElement(By.id("d-report-comment__reason"))
  private def reportEmail = latestComment.findElement(By.id("d-report-comment__email"))
  private def sendReportButton = latestComment.findElement(By.cssSelector("button.d-report-comment__submit"))
  private def showMoreRepliesButton = latestComment.findElement(By.className("d-show-more-replies"))
  private def recommendCommentButton = latestComment.findElement(By.className("d-comment__recommend-button"))
  private def commentAuthorAvatar = latestComment.findElement(By.className("d-comment__avatar"))
  private def commentAuthorLink = latestComment.findElement(By.cssSelector(".d-comment__author a"))
  private def commentTimeStamp = latestComment.findElement(By.className("d-comment__timestamp"))
  private def oldRecommendCommentCount = latestComment.findElement(By.cssSelector(".d-comment__recommend-count--old"))
  private def newRecommendCommentCount = latestComment.findElement(By.cssSelector(".d-comment__recommend-count--new"))

    //TODO list of functions/methods
    //As a Staff member choose a comment to be a Featured comment (Pick)

  def showCommentPost(): CommentItem = {
    Wait().until(ExpectedConditions.presenceOfElementLocated(By.className("d-comment-box__show-parent")))
    showCommentButton.click()
    this
  }

  def replyToComment(): CommentItem = {
    Wait().until(ExpectedConditions.presenceOfElementLocated(By.className("d-comment__action--reply")))
    replyToCommentButton.click()
    commentTextArea.sendKeys("Test reply please ignore blah!!!!")
    CommentItem()
  }

  def postReply(): CommentItem = {
    Wait().until(ExpectedConditions.presenceOfElementLocated(By.className("d-comment-box__submit")))
    postReplyButton.click()

    //Ugly hack to wait for URL to change
    var retries = 10
    while (!driver.getCurrentUrl().contains("#comment-") || retries < 0) {
      Thread.sleep(500)
      retries = retries - 1
    }
    this
  }

  def cancelReply(): CommentItem = {
    cancelReplyButton.click()
    this
  }

  def pickComment(): CommentItem = {
    Wait().until(ExpectedConditions.presenceOfElementLocated(By.className("d-comment__action--pick")))
    pickCommentButton.click()
    this
  }

  def showAllReplies(): CommentItem = {
    Wait().until(ExpectedConditions.presenceOfElementLocated(By.className("d-show-more-replies")))

    //TODO Cannot pick your own comment so need to choose another method and verify the comment has been picked
    showMoreRepliesButton.click()
    this
  }

  def reportComment(): CommentItem = {
    Wait().until(ExpectedConditions.presenceOfElementLocated(By.className("d-comment__action--report")))
    reportCommentButton.click()
    new Select(reportSelectControl).selectByVisibleText("Spam")
    reportTextArea.sendKeys("This is a test report")
    reportEmail.sendKeys("test.test@test.com")
    sendReportButton.click()
    this
  }

  def viewUserProfile() = {
    commentAuthorAvatar.click()
  }

  def viewUserHistory() = {
    commentAuthorLink.click()
    UserProfilePage()
  }

  def getCommentAuthor() = {
    commentAuthorLink.getText()
  }

  def recommendComment(): (Int, Int) = {

    Wait().until(ExpectedConditions.presenceOfElementLocated(By.className("d-comment__recommend-button")))
    val oldRecommendCount = oldRecommendCommentCount.getText().toInt

    recommendCommentButton.click()

    val newRecommendCount = newRecommendCommentCount.getText().toInt
    (oldRecommendCount, newRecommendCount)
  }

  def isAvatarPresent(): Boolean = {
    commentAuthorAvatar.isDisplayed()
  }

  def isDateStampPresent(): Boolean = {
    commentTimeStamp.isDisplayed()
  }

  def getLatestCommentText: String = {
    Wait().until(ExpectedConditions.presenceOfElementLocated(By.className("d-comment__body")))
    commentBody.getText
  }

  def getLatestCommentsLatestReply() = {
    val newCommentURL = driver.getCurrentUrl()
    val newCommentID = newCommentURL.substring(newCommentURL.indexOf("#") + 1)
    driver.findElement(By.id(s"$newCommentID")).findElement(By.cssSelector(".d-comment__body p")).getText()
  }

  def goToLatestComment(): CommentItem =  {
    Wait().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".d-comment--response p")))
    commentBody.isDisplayed()
    this
  }

}
