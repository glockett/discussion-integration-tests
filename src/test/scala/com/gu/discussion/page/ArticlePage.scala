package com.gu.discussion.page

import org.openqa.selenium.{WebDriver, By}


case class ArticlePage(implicit driver: WebDriver) {

  private def featuredCommentsLabel = driver.findElement(By.className("discussion__comments--top-comments"))

  private def featuredComment = driver.findElement(By.className("article__meta-heading"))

  private def commentCountLabel = driver.findElement(By.cssSelector("div.content__main-column.content__main-column--article div.js-comment-count a.js-show-discussion"))

  private def gotoFeaturedComments = driver.findElement(By.className("CTA Top comment bottom read more"))

  def goToStartOfComments() = {

    /*if (driverWait.until(ExpectedConditions.elementToBeClickable(commentCountLabel))
      .isDisplayed()) {
      commentCountLabel.click()
    } else {
      System.err.println("There are no comments for this article yet")
    }
*/
    commentCountLabel.click()

    val allCommentsLabel = driver.findElement(By.cssSelector("h2.js-visible")).getText()

    assert(allCommentsLabel == "All Comments")

    this
  }

  def viewFeaturedComments() = {

    if (featuredComment.getText().contains("Featured Content")) {
      gotoFeaturedComments.click()
    } else {
      System.err.println("There are no Featured comments for this article")
    }

  }

}
