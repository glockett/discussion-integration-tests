package com.gu.discussion.page

import org.openqa.selenium.{WebDriver, By}
import com.gu.support.BasePage

class ArticlePage (driver: WebDriver)extends BasePage(driver) {

  private def featuredCommentsLable = driver.findElement(By.className(".article__meta-heading"))

  private def commentCountlabel = driver.findElement(By.className(".js-comment-count"))


  def goToStartOfComments() {
    //TODO - Verify that comments are available - if so click to the start of them
    commentCountlabel.click()
    new CommentSection(driver)

  }

  def viewFeaturedComments() {
    //TODO - Verify that there are Featured comments are available - if so click to the first


  }

}
