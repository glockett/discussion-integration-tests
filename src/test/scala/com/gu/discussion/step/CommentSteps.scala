package com.gu.discussion.step

import com.gu.support.{BaseSteps, Config, TestLogger}
import org.openqa.selenium.WebDriver
import com.gu.discussion.page.{ArticlePage, CommentModule}

  case class CommentSteps (implicit val driver: WebDriver, override val logger: TestLogger) extends BaseSteps(logger) {

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

    this

  }

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

  /*def thenICanPostANewReply() = {
    logger.log("I can post a new reply")
    new CommentItem().replyToComment()
    new CommentItem().postReply()

    this

  }*/


}
