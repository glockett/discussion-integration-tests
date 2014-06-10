package com.gu.discussion.page

import org.openqa.selenium.{WebDriver, By}
import com.gu.support.BasePage

class CommentModule(driver: WebDriver) extends BasePage(driver) {

  private def showMoreFeaturedComments = driver.findElement(By.className(".show-more__container--featured"))

  private def showAllComments = driver.findElement(By.className(".d-discussion__show-all-comments"))

  private def commentTextArea = driver.findElement(By.className(".d-comment-box__body"))

  private def postYourCommentButton = driver.findElement(By.className(".d-comment-box__submit"))

  private def cancelButton = driver.findElement(By.className(".d-comment-box__cancel"))

  private def sortOrderControl = driver.findElement(By.className("d-discussion__order-control"))

  private def previousControl = driver.findElement(By.className(".pagination__item--prev"))

  private def nextControl = driver.findElement(By.className(".pagination__item--next"))

  private def showMoreRepliesButton = driver.findElement(By.className(".d-show-more-replies"))


  def showMoreFeaturedComments(): CommentModule = {
    showMoreFeaturedComments.click()
    this
  }

  def addNewComment(): CommentModule = {
    commentTextArea.sendKeys("This is to become a variable testComment")
    postYourCommentButton.click()
    this
  }

  def cancelNewComment(): CommentModule = {
    cancelButton.click()
    this
  }

  def showAllComments(): CommentModule = {
    showAllComments.click()
    this
  }

  def sortCommentsByOrder(sortOrder): CommentModule = {
    sortOrderControl(sortOrder).click()
    this
  }

  def nextPage(): CommentModule = {
    nextControl.click()
    this
  }

  def previousPage(): CommentModule = {
    previousControl.click()
    this
  }

  def showAllReplies(): CommentModule = {
    showMoreRepliesButton.click()
    this
  }





}
