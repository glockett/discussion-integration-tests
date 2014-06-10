package com.gu.discussion.test

import com.gu.support.BaseTest

class CommentTests extends BaseTest {

  info("Set of Discussion tests to validate commenting on the NGW website")

  feature("As a registered user I can join in a discussion") {

    scenarioWeb("Add a new comment to an article") {
      given {
        CommSteps()
      }.when {
        _.whenIViewTheSigninLocator()
      }.then {
        _.thenISeeMyUserName()
      }
    }



  }
}