package com.gu.discussion.page

import org.openqa.selenium.{WebDriver, By}
import com.gu.support.BasePage

class CommentSection (driver: WebDriver) extends BasePage(driver) {

  private def showMoreFeaturedComments = driver.findElement(By.className(".show-more__container--featured"))

  private def showAllComments = driver.findElement(By.className(".d-discussion__show-all-comments"))

  private def commentTextArea = driver.findElement(By.className(".d-comment-box__body"))

  private def postYourCommentButton = driver.findElement(By.className(".d-comment-box__submit"))

  private def cancelButton = driver.findElement(By.className(".d-comment-box__cancel"))

  private def discussionOrderControl = driver.findElement(By.className("d-discussion__order-control"))

  private def previousControl = driver.findElement(By.className(".pagination__item--prev"))

  private def nextControl = driver.findElement(By.className(".pagination__item--next"))

  private def commentAuthorAvatar = driver.findElement(By.className(".d-comment__avatar"))

  private def commentTimeStamp = driver.findElement(By.className(".d-comment__timestamp"))

  private def replyToCommentButton = driver.findElement(By.className(".d-comment__action--reply-text"))

  private def pickCommentButton = driver.findElement(By.className(".d-comment__action--pick"))

  private def reportCommentButton = driver.findElement(By.className(".d-comment__action--report"))

  private def showMoreRepliesButton = driver.findElement(By.className(".d-show-more-replies"))

  private def recommendCommentButton = driver.findElement(By.className(".d-comment__recommend-button"))

  /*TODO list of functions/methods
    Add a new comment
    Show all comments threads
    Sort comments by order
    Traverse through the pages of comments
    As a Staff member choose a comment to be a Featured comment (Pick)
    Reply to a comment
    Report a comment
    Show all replies
    Recommend a comment

   */

  def addNewComment(): ArticlePage = {
    emailField.sendKeys(email)
    passwordField.sendKeys(password)
    signInButton.click()
    new ArticlePage(driver)
  }

  def showAllComments(): ArticlePage = {

    new ArticlePage(driver)
  }

  def nextPage(): ArticlePage = {

    new ArticlePage(driver)
  }

  def previousPage(): ArticlePage = {

    new ArticlePage(driver)
  }

  def sortCommentsByOrder(sortOrder): ArticlePage = {

    new ArticlePage(driver)
  }

  def staffPickComment(): ArticlePage = {

    new ArticlePage(driver)
  }

  def showAllReplies(): ArticlePage = {

    new ArticlePage(driver)
  }

  def replyToComment(): ArticlePage = {

    new ArticlePage(driver)
  }

  def reportComment(): ArticlePage = {

    new ArticlePage(driver)
  }

  def recommendComment(): ArticlePage = {

    new ArticlePage(driver)
  }



}
