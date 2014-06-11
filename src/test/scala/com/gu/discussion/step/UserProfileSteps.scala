package com.gu.discussion.step

import com.gu.support.{TestLogger}
import org.openqa.selenium.WebDriver

case class UserProfileSteps(implicit override val driver: WebDriver, override val logger: TestLogger) extends SignInSteps {

 /* def whenIClickACommentersAvatar() = {
    logger.log("I view comments on an article")

    this
  }

  def thenICanViewAllProfileComments() = {
    logger.log("I can post a new comment")


    this

  }
*/


}