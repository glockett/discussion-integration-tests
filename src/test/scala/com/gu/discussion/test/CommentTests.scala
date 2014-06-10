package com.gu.discussion.test

import com.gu.support.BaseTest
import com.gu.discussion.step.CommentSteps

class CommentTests extends BaseTest {

  info("Set of Discussion tests to validate commenting on the NGW website")

  feature("As a registered user I can create a discussion thread") {

    scenarioWeb("Add a new comment to an article") {
      given {
        CommentSteps().givenIAmSignedIn()
      }.when {
        _.whenIViewArticleComments()
      }.then {
        _.thenICanPostANewComment()
      }
    }


  }
}