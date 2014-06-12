package com.gu.discussion.test

import com.gu.support.WebBaseTest
import com.gu.discussion.step.SignInSteps

class CommentTests extends WebBaseTest {

  info("Set of Discussion tests to validate commenting on the NGW website")

  feature("As a signed in registered user I can create a discussion thread") {

    scenarioWeb("Add a new top level comment to an article") {
      given {
        SignInSteps().givenIAmSignedIn()
      }.when {
         _.whenIViewAnArticleWithComments()
      }.then {
        _.thenICanPostANewComment()
      }
    }


    /*scenarioWeb("Reply to a top level comment") {
      given {
        CommentSteps().givenIAmSignedIn()
      }.when {
        _.whenIViewAnArticleWithComments()
      }.then {
        _.thenICanPostANewComment()
      }
    }

    scenarioWeb("Reply to a top level comment") {
      given {
        CommentSteps().givenIAmSignedIn()
      }.when {
        _.whenIViewAnArticleWithComments()
      }.then {
        _.thenICanPostANewReply()
      }
    }
*/




  }
}