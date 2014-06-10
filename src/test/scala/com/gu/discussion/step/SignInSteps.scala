package com.gu.discussion.step


import com.gu.support.{TestLogger, BaseSteps}
import com.gu.discussion.page.ArticlePage
import org.openqa.selenium.WebDriver

case class SignInSteps(implicit val driver: WebDriver, override val logger: TestLogger) extends BaseSteps(logger) {

  def givenIAmSignedIn() = {
    logger.log("I am logged in to NGW")
    new ArticlePage()

    //driver.get("http://www.theguardian.com/")
    //TODO get testBaseURL variable from config

    //new SignInPage(driver).signInGUDetails("it_is_me", "let_me_in")
    //TODO get user variables from config
    this
  }

  def whenIViewTheSigninLocator() = {
    logger.log("I take a look at the SigninLocator")
    this
  }

  def thenISeeMyUserName() = {
    logger.log("I will see my username")
    this
  }

}
