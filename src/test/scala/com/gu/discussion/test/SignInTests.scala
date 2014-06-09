package com.gu.discussion.test

import com.gu.support.BaseTest

import com.gu.discussion.step.SignInSteps

class SignInTests extends BaseTest with SignInSteps{

  info("Set of Login tests to validate signin to the NGW website")

  feature("Signin to NGW") {

    scenarioWeb("Login using valid Guardian credentials") {
      givenIAmSignedIn
      whenIViewTheSigninLocator
      thenISeeMyUserName
    }
  }


}