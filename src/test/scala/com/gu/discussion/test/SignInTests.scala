package com.gu.discussion.test

import com.gu.discussion.step.SignInSteps
import com.gu.support.WebBaseTest

class SignInTests extends WebBaseTest {

  info("Set of Login tests to validate sign in to the NGW website")

  feature("Sign in to NGW") {

    scenarioWeb("Login using valid Guardian credentials") {
      given {
        SignInSteps().thenISeeMyUserName()
      }.when {
        _.whenIViewTheSigninLocator()
      }.then {
        _.thenISeeMyUserName()
      }
    }

  }
}