package com.gu.discussion.page

import org.openqa.selenium.{WebDriver, By}
import com.gu.support.BasePage
import org.openqa.selenium.support.ui.ExpectedConditions

case class ArticlePage (implicit override val driver: WebDriver) extends BasePage(driver) {

  private def featuredCommentsLabel = driver.findElement(By.className("discussion__comments--top-comments"))

  private def featuredComment = driver.findElement(By.className("article__meta-heading"))

  //private def commentCountLabel = driver.findElement(By.className("js-comment-count"))

  private def commentCountLabel = driver.findElement(By.xpath("//article[@id='article']/div/div/div[2]/div/a/span"))



  private def gotoFeaturedComments = driver.findElement(By.className("CTA Top comment bottom read more"))


  def goToStartOfComments() = {

    if (driverWait.until(ExpectedConditions.elementToBeClickable(commentCountLabel))
      .isDisplayed()) {
      commentCountLabel.click()
    } else {
      System.err.println("There are no comments for this article yet");
    }
    //TODO verify that Im at the comments
  }

  def viewFeaturedComments() = {

    if (featuredComment.getText().contains("Featured Content"))
    {
      gotoFeaturedComments.click()
    }else {
      System.err.println("There are no Featured comments for this article");
    }

  }


}
