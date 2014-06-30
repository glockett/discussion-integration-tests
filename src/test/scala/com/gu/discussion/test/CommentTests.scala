package com.gu.discussion.test

import com.gu.automation.core.GivenWhenThen
import com.gu.automation.support.WebDriverFeatureSpec
import com.gu.discussion.step.CommentSteps
import org.scalatest.Tag

class CommentTests extends WebDriverFeatureSpec with GivenWhenThen {

  info("Set of Discussion tests to validate commenting on the NGW website")

  feature("As a signed in registered user I can contribute to a discussion") {

    scenarioWeb("Add a new top level comment to an article") {
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

    scenarioWeb("Report a comment") {
       given {
         CommentSteps().givenIAmSignedIn()
       }.when {
         _.whenIViewAllComments()
       }.then {
         _.thenICanReportAComment()
         //NOTE:  Cannot easily test the endpoint as there is no API but we could use the moderation Tool if necessary
       }
     }

            /*scenarioWeb("Pick a comment to become a Featured Comment") {
             given {
               CommentSteps().givenIAmSignedIn()
             }.when {
               _.whenIViewAllComments()
             }.then {
               _.thenICanPickAComment()
             }
           }*/

    scenarioWeb("View a users discussion posts") {
      given {
        CommentSteps().givenIAmSignedIn()
      }.when {
        _.whenIViewAllComments()
      }.then {
        _.thenICanViewUserCommentHistory()
      }
    }

    scenarioWeb("Recommend a User Comment") {
      given {
        CommentSteps().givenIAmGuestUser()
      }.when {
        _.whenIViewAllComments()
      }.then {
        _.thenICanRecommendAComment()
      }
    }

    scenarioWeb("navigate through comment pages") {
      given {
        CommentSteps().givenIAmGuestUser()
      }.when {
        _.whenIViewAllComments()
      }.then {
        _.thenICanNavigateCommentPages()
      }
    }

  }
}