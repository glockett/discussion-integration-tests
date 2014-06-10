package com.gu.discussion.step

import com.gu.support.{ConfigLoader, TestLogger, BaseSteps}
import org.openqa.selenium.WebDriver
import com.gu.discussion.page.{CommentItem, CommentModule, SignInPage}

case class CommentSteps(implicit val driver: WebDriver, override val logger: TestLogger) extends BaseSteps(logger) {


  def givenIAmSignedIn() = {
    logger.log("I am signed in")
    driver.get(ConfigLoader().getTestBaseUrl())
    //TODO get testBaseURL variable from config

    new SignInPage().signInGUDetails(ConfigLoader()."It is me", ConfigLoader()."let_me_in")
    //TODO get user variables from config

    this

  }

  def whenIViewAnArticleWithComments() {
    logger.log("I view comments on an article")
    driver.get("http://www.theguardian.com/science/grrlscientist/2012/aug/07/3")
    //TODO get testArticleURL variable from config



    this
  }


  def thenICanViewAllComments() {
    logger.log("I can post a new comment")
      CommentModule().showAllComments()

    this

  }


  def thenICanPostANewComment() {
    logger.log("I can post a new comment")
    new CommentModule().addNewComment()
    new CommentModule().postNewComment()

    this

  }


  def thenICanSortCommentOrder() {
    logger.log("I can post a new reply")
    new CommentModule().sortCommentsByOrder("oldest")

    this

  }




  def thenICanPostANewReply() {
    logger.log("I can post a new reply")
    new CommentItem().replyToComment()
    new CommentItem().postReply()

    this

  }


}
