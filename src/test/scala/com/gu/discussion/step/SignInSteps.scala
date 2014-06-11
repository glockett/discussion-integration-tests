package com.gu.discussion.step


import com.gu.support.{Config, TestLogger, BaseSteps}
import com.gu.discussion.page.{SignInPage, ArticlePage}
import org.openqa.selenium.WebDriver

case class SignInSteps (implicit val driver: WebDriver, override val logger: TestLogger) extends BaseSteps(logger) {

  def givenIAmSignedIn() = {
    logger.log("I am logged in to NGW")
    new ArticlePage()

    driver.get(Config().getTestBaseUrl())

    val email = Config().getUserValue ("email")
    val password = Config().getUserValue ("password")

    new SignInPage().signInGUDetails(email, password)

    this
  }



  def whenIViewTheSigninLocator() = {
    logger.log("I take a look at the SigninLocator ")
    this
  }

  def thenISeeMyUserName() = {
    logger.log("I will see my username")
    this
  }

}
