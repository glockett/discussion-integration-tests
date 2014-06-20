package com.gu.discussion.step

import com.gu.automation.support.{Assert, Config, TestLogger, Wait}
import com.gu.discussion.page._
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.{By, WebDriver}

case class CommentSteps(implicit driver: WebDriver, logger: TestLogger) {

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

    Assert.assert(newComment, "This is a test comment - Please ignore / delete as required.", "Text does not match!")

    this

  }

  def thenICanPostANewReply() = {
    logger.log("I can post a new reply")
    new CommentModule().showAllComments()
    new CommentItem().replyToComment()
    new CommentItem().postReply()

    Wait().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".js-new-comments .d-comment__body")))

    val newComment = driver.findElement(By.cssSelector(".js-new-comments .d-comment__body")).getText()

    Assert.assert(newComment, "This is a test reply - Please ignore / delete as required.", "Text does not match!")

    this

  }

  def thenICanReportAComment() = {
    logger.log("I can report a comment")

    new CommentItem().reportComment()

  }

  /*def thenICanCancelAWrittenComment() = {
   logger.log("I can cancel a written comment")
   new CommentModule().addNewComment()
   new CommentModule().cancelNewComment()

   Wait().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".js-new-comments .d-comment__body")))

   val newComment: String = CommentModule().getNewCommentText

   Assert.assert(newComment, "This is a test comment - Please ignore / delete as required.", "Text does not match!")

   this

 }
*/

  def thenICanViewUserCommentHistory() {
    logger.log("I can view a users profile comment history")
    CommentItem().viewUserProfile()
    new UserProfilePage().viewUserProfile()

    Wait().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".js-new-comments .d-comment__body")))

    val userProfileName: String = UserProfilePage().getUserProfileName

    Assert.assert(userProfileName, Config().getUserValue("username"), "Profile name does not match!")

    UserProfilePage().viewProfileReplies()
    //UserProfilePage().viewProfileFeatured()
    //UserProfilePage().viewProfileComments()

  }


  /*def thenICanCancelAWrittenComment() = {
    logger.log("I can cancel a written comment")
    new CommentModule().addNewComment()
    new CommentModule().cancelNewComment()

    Wait().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".js-new-comments .d-comment__body")))

    val newComment: String = CommentModule().getNewCommentText

    Assert.assert(newComment, "This is a test comment - Please ignore / delete as required.", "Text does not match!")

    this

  }
 */

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
