package com.gu.discussion.page

import org.openqa.selenium.{WebDriver, By}
import com.gu.support.BasePage
import org.openqa.selenium.support.ui.ExpectedConditions

case class ArticlePage (implicit override val driver: WebDriver) extends BasePage(driver) {

  private def featuredCommentsLabel = driver.findElement(By.className(".discussion__comments--top-comments"))

  private def featuredComment = driver.findElement(By.className(".d-comment__pick"))

  private def commentCountLabel = driver.findElement(By.className(".commentcount__label"))

  def goToStartOfComments() {

    if (driverWait.until(ExpectedConditions.elementToBeClickable(commentCountLabel))
      .isDisplayed()) {
      commentCountLabel.click()
    } else {
      System.err.println("There are no comments for this article");
    }

  }

  def viewFeaturedComments() {
    //TODO - Verify that there are Featured comments are available - if so click to the first pick


  }


}
