package com.gu.discussion.step

import com.gu.support.{ConfigLoader, TestLogger, BaseSteps}
import org.openqa.selenium.WebDriver
import com.gu.discussion.page.SignInPage

case class UserProfileSteps(implicit val driver: WebDriver, override val logger: TestLogger) extends BaseSteps(logger) {

  def givenIAmSignedIn() = {
    logger.log("I am signed in")
    driver.get(ConfigLoader().getTestBaseUrl())
    //TODO get testBaseURL variable from config

    new SignInPage().signInGUDetails(ConfigLoader()."It is me", ConfigLoader()."let_me_in")
    //TODO get user variables from config

    this

  }

  def whenIClickACommentersAvatar() = {
    logger.log("I view comments on an article")

    //TODO get testArticleURL variable from config

    this
  }

  def thenICanViewAllProfileComments() = {
    logger.log("I can post a new comment")


    this

  }



}