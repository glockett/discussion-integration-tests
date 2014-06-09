package com.gu.discussion.step


import com.gu.support.BaseSteps

trait SignInSteps extends BaseSteps{

  def givenIAmSignedIn() = {
    given(logger, "I am logged in to NGW")

    //driver.get("http://www.theguardian.com/")
    //TODO get baseURL variable from config

    //new SignInPage(driver).signInGUDetails("it_is_me", "let_me_in")
    //TODO get user variables from config

  }

  def whenIViewTheSigninLocator() {
    when(logger, "I take a look at the SigninLocator")
  }

  def thenISeeMyUserName() {
    then(logger, "I will see my username")
  }

}
