organization := "monash"

name := "CanonicalPerson"

version := "0.2.14"

scalaVersion := "2.10.4"

resolvers ++= Seq("snapshots" at "http://artifactory.its.monash.edu:8081/artifactory/repo",
"release" at "http://artifactory.its.monash.edu:8081/artifactory/repo"
)

EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource

scalacOptions ++= Seq("-deprecation", "-unchecked")

publishMavenStyle := true

credentials += Credentials("Artifactory Realm","artifactory.its.monash.edu","checkin","checkin")

publishTo := Some("monash-artifactory" at "http://artifactory.its.monash.edu:8081/artifactory/libs-release-local")

libraryDependencies ++= {
  Seq(
    "org.specs2"        %% "specs2"             % "1.13"           % "test",
    "monash" %% "mapper" % "0.1",
    "com.novocode" % "junit-interface" % "0.9" % "test",
    "monash" %% "canonicalshared" % "0.+",
    "monash" %% "canonicaladdress" % "0.0.+",
    "monash" %% "canonicalcontact" % "0.0.+"
  )
}
