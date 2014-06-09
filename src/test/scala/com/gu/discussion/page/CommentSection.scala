package com.gu.discussion.page

import org.openqa.selenium.{WebDriver, By}
import com.gu.support.BasePage

class CommentSection (driver: WebDriver) extends BasePage(driver) {

  private def showAllCommentsLable = driver.findElement(By.className(".d-discussion__show-all-comments"))

  private def commentTextArea = driver.findElement(By.className(".d-comment-box__body"))

  private def postYourCommentButton = driver.findElement(By.className(".d-comment-box__submit"))

  private def cancelButton = driver.findElement(By.className(".d-comment-box__cancel"))

  private def discussionOrderControl = driver.findElement(By.className("d-discussion__order-control"))

  private def previousControl = driver.findElement(By.className(".pagination__item--prev"))

  private def nextControl = driver.findElement(By.className(".pagination__item--next"))

  private def replyToCommentButton = driver.findElement(By.className(".d-comment__action--reply-text"))

  private def pickCommentButton = driver.findElement(By.className(".d-comment__action--reply-pick"))

  private def reportCommentButton = driver.findElement(By.className(".d-comment__action--report"))

  private def showMoreRepliesButton = driver.findElement(By.className(".d-show-more-replies"))

  private def recommendCommentButton = driver.findElement(By.className(".d-comment__recommend-button"))


}
