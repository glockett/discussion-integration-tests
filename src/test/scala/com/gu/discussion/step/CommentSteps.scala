package com.gu.discussion.step

import com.gu.automation.support._
import com.gu.discussion.page._
import org.openqa.selenium.WebDriver
import org.scalatest.Matchers

case class CommentSteps(implicit driver: WebDriver) extends Matchers with LoggingIn with TestLogging {

  def givenIAmSignedIn() = {
    logger.step("I am registered signed user and signed into NGW")
    logInToGUPage(ArticlePage.goto)
    CommentSteps()
  }

  def whenIViewAnArticleWithComments() = {
    logger.step("I view comments on an article")
    new ArticlePage().goToStartOfComments()
    this
  }

  def whenIViewAllComments() = {
    logger.step("I view all comments for a given article")
    new ArticlePage().showAllComments()
    this
  }

  def thenICanPostANewComment() = {
    logger.step("I can post a new comment")
    new CommentModule().addNewComment()
    new CommentModule().postNewComment()

    val newComment: String = CommentItem().getLatestCommentText
    newComment should be("This is a test comment - Please ignore / delete as required.")
  }

  def thenICanPostANewReply() = {
    logger.step("I can post a new reply")
    new CommentModule().showAllComments()
    new CommentItem().replyToComment()
    new CommentItem().postReply()
    new CommentItem().getCommentReply()

    val newReply = CommentItem().getCommentReply()
    newReply should be("This is a test reply - Please ignore / delete as required.")
  }

  def thenICanReportAComment() = {
    logger.step("I can report a comment")
    new CommentItem().reportComment()
  }

  def thenICanViewUserCommentHistory() {
    logger.step("I can view a users profile comment history")
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
