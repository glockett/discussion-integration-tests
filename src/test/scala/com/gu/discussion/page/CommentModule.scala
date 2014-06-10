package com.gu.discussion.page

import org.openqa.selenium.{WebDriver, By}
import com.gu.support.BasePage
import org.openqa.selenium.support.ui.{ExpectedConditions, Select}

case class CommentModule(implicit override val driver: WebDriver) extends BasePage(driver) {

  private def showMoreFeaturedCommeLink = driver.findElement(By.className(".show-more__container--featured"))

  private def showAllCommentsButton = driver.findElement(By.className(".d-discussion__show-all-comments"))

  private def commentTextArea = driver.findElement(By.className(".d-comment-box__body"))

  private def postYourCommentButton = driver.findElement(By.className(".d-comment-box__submit"))

  private def cancelButton = driver.findElement(By.className(".d-comment-box__cancel"))

  private def sortOrderControl = new Select(driver.findElement(By.className("d-discussion__order-control")))

  private def previousControl = driver.findElement(By.className(".pagination__item--prev"))

  private def nextControl = driver.findElement(By.className(".pagination__item--next"))

  private def showMoreRepliesButton = driver.findElement(By.className(".d-show-more-replies"))


  def showMoreFeaturedComments(): CommentModule = {
    driverWait.until(ExpectedConditions.elementToBeClickable(showMoreFeaturedCommeLink))
    showMoreFeaturedCommeLink.click()
    this
  }


  def addNewComment(): CommentModule = {
    driverWait.until(ExpectedConditions.elementToBeClickable(postYourCommentButton))
    commentTextArea.sendKeys("This is a test comment - Please ignore / delete as required. /n Lorem Ipsum Dispum comment thread text")
    this
  }

  def postNewComment(): CommentModule = {
    driverWait.until(ExpectedConditions.elementToBeClickable(postYourCommentButton))
    postYourCommentButton.click()
    this
  }

  def cancelNewComment(): CommentModule = {
    driverWait.until(ExpectedConditions.elementToBeClickable(cancelButton))
    cancelButton.click()
    this
  }

  def showAllComments(): CommentModule = {
    driverWait.until(ExpectedConditions.elementToBeClickable(showAllCommentsButton))
    showAllCommentsButton.click()
    this
  }

  def sortCommentsByOrder(sortOrder: String): CommentModule = {
    sortOrderControl.selectByValue(sortOrder)
    this
  }

  def nextPage(): CommentModule = {
    driverWait.until(ExpectedConditions.elementToBeClickable(nextControl))
    nextControl.click()
    this
  }

  def previousPage(): CommentModule = {
    driverWait.until(ExpectedConditions.elementToBeClickable(previousControl))
    previousControl.click()
    this
  }

  def showAllReplies(): CommentModule = {
    driverWait.until(ExpectedConditions.elementToBeClickable(showMoreRepliesButton))
    showMoreRepliesButton.click()
    this
  }


}
