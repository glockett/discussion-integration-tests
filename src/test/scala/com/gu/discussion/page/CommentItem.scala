package com.gu.discussion.page

import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.DefaultHttpClient
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.{By, WebDriver}

case class CommentItem(implicit driver: WebDriver) {

  private val latestComment = driver.findElement(By.cssSelector(".discussion__comments__container .d-comment"))

  private def showCommentButton = driver.findElement(By.className("d-comment-box__show-parent"))

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

  private def commentTimeStamp = latestComment.findElement(By.className("d-comment__timestamp"))

  /*TODO list of functions/methods
    As a Staff member choose a comment to be a Featured comment (Pick)
    Recommend a comment

   */

  def showCommentPost(): CommentItem = {
    showCommentButton.click()

    this
  }

  def replyToComment(): CommentItem = {
    replyToCommentButton.click()
    commentTextArea.sendKeys("This is a test reply - Please ignore / delete as required.")

    CommentItem()

  }

  def postReply(): CommentItem = {
    postReplyButton.click()
    this
  }

  def cancelReply(): CommentItem = {
    cancelReplyButton.click()
    this
  }

  def pickComment(): CommentItem = {
    pickCommentButton.click()
    this
  }

  def showAllReplies(): CommentItem = {
    showMoreRepliesButton.click()
    this
  }

  def reportComment(): CommentItem = {
    reportCommentButton.click()
    new Select(reportSelectControl).selectByVisibleText("Spam")
    reportTextArea.sendKeys("This is a test report")
    reportEmail.sendKeys("test.test@test.com")
    sendReportButton.click()

    //getHTTPResponse("http://discussion.code.dev-guardianapis.com/discussion-api")

    this
  }

  def viewUserProfile() = {
    commentAuthorAvatar.click()
    this
  }


  def getHTTPResponse(url: String): String = {
    val httpClient = new DefaultHttpClient
    val httpResponse = httpClient.execute(new HttpGet(url))
    val entity = httpResponse.getEntity
    var content = ""
    if (entity != null) {
      val inputStream = entity.getContent
      content = io.Source.fromInputStream(inputStream).getLines.mkString
      inputStream.close
    }
    System.out.println(httpResponse)
    System.out.println(httpResponse)

    httpClient.getConnectionManager.shutdown

    return content

  }

  def recommendComment(): CommentItem = {
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
