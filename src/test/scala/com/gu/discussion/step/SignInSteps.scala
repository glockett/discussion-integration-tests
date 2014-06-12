package com.gu.discussion.step


import com.gu.support.{Config, TestLogger, BaseSteps}
import com.gu.discussion.page.{SignInPage, ArticlePage}
import org.openqa.selenium.WebDriver

case class SignInSteps (implicit val driver: WebDriver, override val logger: TestLogger) extends BaseSteps(logger) {

  def givenIAmSignedIn() = {
    logger.log("I am registered signed user and signed into NGW")

    driver.get(Config().getTestBaseUrl() + "signin")

    val email = Config().getUserValue ("email")
    val password = Config().getUserValue ("password")

    new SignInPage().signInGUDetails(email, password)

    CommentSteps()
  }


}
