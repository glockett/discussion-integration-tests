package com.gu.discussion.page

import org.openqa.selenium.{WebDriver, By}
import com.gu.support.BasePage

case class ArticlePage(implicit override val driver: WebDriver) extends BasePage(driver) {

  private def featuredCommentsLabel = driver.findElement(By.className(".discussion__comments--top-comments"))

  private def featuredComment = driver.findElement(By.className(".d-comment__pick"))

  private def commentCountLabel = driver.findElement(By.className(".commentcount__label"))

  def goToStartOfComments() {
    //TODO - Verify that comments are available - if so click to the start of them
    commentCountLabel.click()
    new CommentModule()

  }

  def viewFeaturedComments() {
    //TODO - Verify that there are Featured comments are available - if so click to the first pick

  }


}
