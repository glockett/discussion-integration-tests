package com.gu.discussion.step

import com.gu.automation.support.{Assert, Config, TestLogger, Wait}
import com.gu.discussion.page._
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.{By, WebDriver}
import org.scalatest.Matchers

case class CommentSteps(implicit driver: WebDriver, logger: TestLogger) extends Matchers {

  def whenIViewAnArticleWithComments() = {
    logger.log("I view comments on an article")
    driver.get(Config().getTestBaseUrl() + Config().getUserValue("testArticlePath"))

    new ArticlePage().goToStartOfComments()

    this
  }

  def whenIViewAllComments() = {
    logger.log("I view all comments for a given article")
    driver.get(Config().getTestBaseUrl() + Config().getUserValue("testArticlePath"))

    new ArticlePage().showAllComments()


    this
  }


  def thenICanPostANewComment() = {
    logger.log("I can post a new comment")
    new CommentModule().addNewComment()
    new CommentModule().postNewComment()

    Wait().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".js-new-comments .d-comment__body")))

    val newComment: String = CommentModule().getNewCommentText

    //newComment should be("This is a test comment - Please ignore / delete as required.")
    Assert.assert(newComment, "This is a test comment - Please ignore / delete as required.", "Text does not match!")

    this

  }

  def thenICanPostANewReply() = {
    logger.log("I can post a new reply")
    new CommentModule().showAllComments()
    new CommentItem().replyToComment()
    new CommentItem().postReply()
    new CommentItem().getCommentReply()

    val newReply = CommentItem().getCommentReply()

    newReply should be("This is a test reply - Please ignore / delete as required.")

    this

  }

  def thenICanReportAComment() = {
    logger.log("I can report a comment")

    new CommentItem().reportComment()

  }

  def thenICanViewUserCommentHistory() {
    logger.log("I can view a users profile comment history")

    val originatingAuthor = CommentItem().getCommentAuthor()

    val userHistory = CommentItem().viewUserHistory()

    val userProfileName: String = userHistory.getUserProfileName

    userProfileName should be(originatingAuthor)

    UserProfilePage().viewProfileReplies()
    //UserProfilePage().viewProfileFeatured()
    //UserProfilePage().viewProfileComments()
  }


  /*def thenICanViewAllComments() = {
    logger.log("I can view all comments")
    CommentModule().showAllComments()
    this
  }*/

  /*def thenICanSortCommentOrder() = {
    logger.log("I can post a new reply")
    new CommentModule().sortCommentsByOrder("oldest")
    this
  }*/


}
