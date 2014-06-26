package com.gu.discussion.page

import java.text.SimpleDateFormat
import java.util.Calendar

import org.openqa.selenium.By

trait DataLocators {

  def byDataTypeStream(value: String) = By.cssSelector(s"""[data-stream-type="$value"]""")
  def byDataLinkName(value: String) = By.cssSelector(s"""[data-link-name="$value"]""")
  def byDataTypeContent(value: String) = By.cssSelector(s"""[data-link-content="$value"]""")

}