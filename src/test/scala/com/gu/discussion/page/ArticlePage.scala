package com.gu.discussion.page

import org.openqa.selenium.{WebDriver, By}
import com.gu.support.BasePage

class ArticlePage (driver: WebDriver)extends BasePage(driver) {

  private def featuredCommentsLabel = driver.findElement(By.className(".discussion__comments--top-comments"))

  private def commentCountLabel = driver.findElement(By.className(".commentcount__label"))

  def goToStartOfComments() {
    //TODO - Verify that comments are available - if so click to the start of them
    commentCountLabel.click()
    new CommentModule(driver)

  }

  def viewFeaturedComments() {
    //TODO - Verify that there are Featured comments are available - if so click to the first pick

  }

}
