package com.gu.discussion.page

import org.openqa.selenium.{WebDriver, By}
import com.gu.support.BasePage

class CommentSection(driver: WebDriver) extends BasePage(driver) {

  private def showMoreFeaturedComments = driver.findElement(By.className(".show-more__container--featured"))

  private def showAllComments = driver.findElement(By.className(".d-discussion__show-all-comments"))

  private def commentTextArea = driver.findElement(By.className(".d-comment-box__body"))

  private def postYourCommentButton = driver.findElement(By.className(".d-comment-box__submit"))

  private def cancelButton = driver.findElement(By.className(".d-comment-box__cancel"))

  private def sortOrderControl = driver.findElement(By.className("d-discussion__order-control"))

  private def previousControl = driver.findElement(By.className(".pagination__item--prev"))

  private def nextControl = driver.findElement(By.className(".pagination__item--next"))

  private def replyToCommentButton = driver.findElement(By.className(".d-comment__action--reply-text"))

  private def pickCommentButton = driver.findElement(By.className(".d-comment__action--pick"))

  private def reportCommentButton = driver.findElement(By.className(".d-comment__action--report"))

  private def showMoreRepliesButton = driver.findElement(By.className(".d-show-more-replies"))

  private def recommendCommentButton = driver.findElement(By.className(".d-comment__recommend-button"))

  private def commentAuthorAvatar = driver.findElement(By.className(".d-comment__avatar"))

  private def commentTimeStamp = driver.findElement(By.className(".d-comment__timestamp"))

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

  def showMoreFeaturedComments(): ArticlePage = {
    showMoreFeaturedComments.click()
    new ArticlePage(driver)
  }

  def addNewComment(): ArticlePage = {
    commentTextArea.sendKeys("This is to become a variable")
    postYourCommentButton.click()

    new ArticlePage(driver)
  }

  def cancelNewComment(): ArticlePage = {
    cancelButton.click()
    new ArticlePage(driver)
  }

  def showAllComments(): ArticlePage = {
    showAllComments.click()
    new ArticlePage(driver)
  }

  def nextPage(): ArticlePage = {
    nextControl.click()
    new ArticlePage(driver)
  }

  def previousPage(): ArticlePage = {
    previousControl.click()
    new ArticlePage(driver)
  }

  def sortCommentsByOrder(sortOrder): ArticlePage = {
    sortOrderControl(sortOrder).click()
    new ArticlePage(driver)
  }

  def pickComment(): ArticlePage = {
    pickCommentButton.click()
    new ArticlePage(driver)
  }

  def showAllReplies(): ArticlePage = {
    showMoreRepliesButton.click()
    new ArticlePage(driver)
  }

  def replyToComment(): ArticlePage = {
    replyToCommentButton.click()
    new ArticlePage(driver)
  }

  def reportComment(): ArticlePage = {
    reportCommentButton.click()
    new ArticlePage(driver)
  }

  def recommendComment(): ArticlePage = {
    recommendCommentButton.click()
    new ArticlePage(driver)
  }


}
