package com.gu.discussion.page

import org.openqa.selenium.By

trait Locators {

  def byDataTypeStream(value: String) = By.cssSelector("*[data-type-stream='$value']")

  def byDataLinkName(value: String) = By.cssSelector("*[data-link-name='$value']")

  def byDataTypeContent(value: String) = By.cssSelector("*[data-type-stream='$value']")



}