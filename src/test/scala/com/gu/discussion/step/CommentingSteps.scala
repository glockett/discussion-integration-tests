package com.gu.discussion.step

import com.gu.support.BaseSteps

/** Created by glockett.  */
trait CommentingSteps extends BaseSteps{
 

     def givenIAmSignedIn() = {
      given(logger, "I am signed in")
      /*driver.get("http://www.theguardian.com/")
      //TODO get testBaseURL variable from config
  
      //new SignInPage(driver).signInGUDetails("it_is_me", "let_me_in")
      //TODO get user variables from config
  */
    }

    def whenIViewArticleComments() {
      when(logger, "I view comments on an article")
      driver.get("http://www.theguardian.com/science/grrlscientist/2012/aug/07/3")
      //TODO get testArticleURL variable from config

      //new ArticlePagePage(driver).goToStartOfComments()


    }

    def thenICanPostAComment() {
      then(logger, "I can post my own comment")
    }

}
