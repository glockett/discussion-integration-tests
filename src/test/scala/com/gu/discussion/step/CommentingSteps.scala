package com.gu.discussion.step

import com.gu.support.{ConfigLoader, TestLogger, BaseSteps}
import org.openqa.selenium.WebDriver
import com.gu.discussion.page.SignInPage

case class CommentingSteps(implicit val driver: WebDriver, override val logger: TestLogger) extends BaseSteps(logger) {
 

     def givenIAmSignedIn() = {
      logger.log("I am signed in")
      driver.get(ConfigLoader().getTestBaseUrl())
      //TODO get testBaseURL variable from config
  
      new SignInPage().signInGUDetails(ConfigLoader()., "let_me_in")
      //TODO get user variables from config

    }

    def whenIViewArticleComments() {
      logger.log("I view comments on an article")
      driver.get("http://www.theguardian.com/science/grrlscientist/2012/aug/07/3")
      //TODO get testArticleURL variable from config

      //new ArticlePagePage(driver).goToStartOfComments()


    }

    def thenICanPostAComment() {
      logger.log("I can post my own comment")
    }

}
