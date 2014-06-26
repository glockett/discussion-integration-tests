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

  def givenIAmGuestUser(): CommentSteps = {
    logger.step("I am Guest user on NGW")
    driver.get(Config().getTestBaseUrl() + Config().getUserValue("testArticlePath"))
    this
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

    val newComment = CommentItem().getLatestCommentText()

    newComment should be("This is a test comment --- ZZZZZZZZ")
  }

  def thenICanPostANewReply() = {
    logger.step("I can post a new reply")
    new CommentModule().showAllComments()
    new CommentItem().replyToComment()
    new CommentItem().postReply()

    val newReply = CommentItem().getLatestCommentsLatestReply()
    newReply should be("Test reply please ignore blah!!!!")
  }

  def thenICanReportAComment() = {
    logger.step("I can report a comment")
    new CommentItem().reportComment()
  }

  def thenICanViewUserCommentHistory() = {
    logger.step("I can view a users profile comment history")
    val originatingAuthor = CommentItem().getCommentAuthor()
    val userHistory = CommentItem().viewUserHistory()
    val userProfileName: String = userHistory.getUserProfileName

    userProfileName should be(originatingAuthor)

    UserProfilePage().viewProfileReplies()
    UserProfilePage().viewProfileFeatured()
  }

  def thenICanRecommendAComment() = {
    logger.step("I can recommend a comment")
    val recommendCommentCount = CommentItem().recommendComment()

    recommendCommentCount._1
    recommendCommentCount._2

    recommendCommentCount._2 should be > recommendCommentCount._1
  }

  def thenICanPickAComment() = {
    logger.step("I can Pick a comment")
    CommentItem().pickComment()
    this
  }

  /*def thenICanSortCommentOrder() = {
    logger.step("I can post a new reply")
    new CommentModule().sortCommentsByOrder("oldest")
    this
  }*/

}
