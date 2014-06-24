name := "AutomatedTests"

version := "1.1"

resolvers ++= Seq(
"Sonatype OSS Staging" at "https://oss.sonatype.org/content/repositories/staging"
  , "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases/")



libraryDependencies ++= Seq(
  "com.gu" % "web-automation-core-scala_2.10" % "1.15")
