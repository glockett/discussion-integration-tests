package com.gu.discussion.step

import com.gu.automation.support.{Assert, Config, TestLogger}
import com.gu.discussion.page.{ArticlePage, CommentModule}
import org.openqa.selenium.{By, WebDriver}

  case class CommentSteps (implicit driver: WebDriver, logger: TestLogger) {

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

    /*val commentDTS = driver.findElement(By.cssSelector("div.d-comment__inner > div.d-comment__meta > div.d-comment__meta-text > div.d-comment__timestamp > a.d-comment__timestamp > time.js-timestamp")).getText()
*/
    val newComment = driver.findElement(By.className("d-comment__body")).getText()

    Assert.assert(newComment, "This is a test reply - Please ignore / delete as required. \n Lorem Ipsum Dispum reply", "Text does not match!")
    this

  }

    /*def thenICanCancelAWrittenComment() = {
      logger.log("I can post a new comment")
      new CommentModule().addNewComment()
      new CommentModule().cancelNewComment()
      this

    }*/


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
