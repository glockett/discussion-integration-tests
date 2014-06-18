package com.gu.discussion.step


import com.gu.support.{Config, TestLogger}
import com.gu.discussion.page.{HomePage, SignInPage}
import org.openqa.selenium.WebDriver

case class SignInSteps(implicit driver: WebDriver, logger: TestLogger) {

  def givenIAmSignedIn() = {
    logger.log("I am registered signed user and signed into NGW")
    driver.get(Config().getTestBaseUrl())

    new HomePage().goToSigninPage()

    val email = Config().getUserValue("email")
    val password = Config().getUserValue("password")

    new SignInPage().signInGUDetails(email, password)

    CommentSteps()
  }


}
