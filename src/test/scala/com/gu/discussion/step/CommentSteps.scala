package com.gu.discussion.step

import com.gu.automation.support.{Assert, Config, TestLogger, Wait}
import com.gu.discussion.page.{ArticlePage, CommentItem, CommentModule}
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.{By, WebDriver}

case class CommentSteps(implicit driver: WebDriver, logger: TestLogger) {

  def whenIViewAnArticleWithComments() = {
    logger.log("I view comments on an article")
    driver.get(Config().getTestBaseUrl() + Config().getUserValue("testArticlePath"))

    new ArticlePage().goToStartOfComments()

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


  /*def thenICanCancelAWrittenComment() = {
    logger.log("I can post a new comment")
    new CommentModule().addNewComment()
    new CommentModule().cancelNewComment()

    Wait().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".js-new-comments .d-comment__body")))

    val newComment: String = CommentModule().getNewCommentText

    Assert.assert(newComment, "This is a test comment - Please ignore / delete as required.", "Text does not match!")

    this

  }
*/

  /*def thenICanViewAllComments() = {
    logger.log("I can post a new comment")
    CommentModule().showAllComments()
    this

  }*/

  /*def thenICanSortCommentOrder() = {
    logger.log("I can post a new reply")
    new CommentModule().sortCommentsByOrder("oldest")
    this

  }*/


}
