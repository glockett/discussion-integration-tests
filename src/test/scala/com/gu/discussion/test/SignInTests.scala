package com.gu.discussion.test

import com.gu.support.BaseTest

import com.gu.discussion.step.SignInSteps

class SignInTests extends BaseTest {

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