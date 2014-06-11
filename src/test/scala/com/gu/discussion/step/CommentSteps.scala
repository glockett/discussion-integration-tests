package com.gu.discussion.step

import com.gu.support.{Config,TestLogger}
import org.openqa.selenium.WebDriver
import com.gu.discussion.page.{CommentItem, CommentModule}

case class CommentSteps(implicit override val driver: WebDriver, override val logger: TestLogger) extends SignInSteps() {


 /* def whenIViewAnArticleWithComments() = {
    logger.log("I view comments on an article")
    driver.get(Config().getUserValue("testArticleURL"))

    this
  }

  def thenICanViewAllComments() = {
    logger.log("I can post a new comment")
    CommentModule().showAllComments()

    this

  }

  def thenICanPostANewComment() = {
    logger.log("I can post a new comment")
    new CommentModule().addNewComment()
    new CommentModule().postNewComment()

    this

  }

  def thenICanSortCommentOrder() = {
    logger.log("I can post a new reply")
    new CommentModule().sortCommentsByOrder("oldest")

    this

  }

  def thenICanPostANewReply() = {
    logger.log("I can post a new reply")
    new CommentItem().replyToComment()
    new CommentItem().postReply()

    this

  }
*/

}
