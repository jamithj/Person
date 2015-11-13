resolvers ++= Seq("snapshots"     at "https://artifactory.its.monash.edu/artifactory/repo",
  "releases"        at "https://artifactory.its.monash.edu/artifactory/repo"
)

credentials += Credentials("Artifactory Realm","artifactory.its.monash.edu","sbt","password")

addSbtPlugin("com.earldouglas" % "xsbt-web-plugin" % "0.9.0")

//Enable the sbt idea plugin
addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.6.0")

//Enable the sbt eclipse plugin
addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.5.0")

//Enable standalone jetty launcher
addSbtPlugin("com.typesafe.sbt" % "sbt-start-script" % "0.10.0")
