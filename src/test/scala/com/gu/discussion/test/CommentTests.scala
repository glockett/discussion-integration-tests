package com.gu.discussion.test

import com.gu.automation.support.WebBaseTest
import com.gu.discussion.step.{CommentSteps}

class CommentTests extends WebBaseTest {

  info("Set of Discussion tests to validate commenting on the NGW website")

  feature("As a signed in registered user I can contribute to a discussion") {

    /*scenarioWeb("Add a new top level comment to an article") {
      given {
        CommentSteps().givenIAmSignedIn()
      }.when {
        _.whenIViewAnArticleWithComments()
      }.then {
        _.thenICanPostANewComment()
      }
    }*/

   scenarioWeb("Reply to a top level comment") {
      given {
        CommentSteps().givenIAmSignedIn()
      }.when {
        _.whenIViewAnArticleWithComments()
      }.then {
        _.thenICanPostANewReply()
      }
    }

    /* scenarioWeb("Report a comment") {
       given {
         CommentSteps().givenIAmSignedIn()
       }.when {
         _.whenIViewAllComments()
       }.then {
         _.thenICanReportAComment()
         //Cannot easily test the endpoint as there is no API but we can use the moderation Tool if necessary

       }
     }*/

    /*scenarioWeb("View a users discussion posts") {
      given {
        CommentSteps().givenIAmSignedIn()
      }.when {
        _.whenIViewAllComments()
      }.then {
        _.thenICanViewUserCommentHistory()
      }
    }*/

  }
}