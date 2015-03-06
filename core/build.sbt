import common._

name := "core"

normalizedName := "remotely-core"

artifactName := { (sv: ScalaVersion, module: ModuleID, artifact: Artifact) =>
  "remotely-core"
}

resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"

scalacOptions ++= Seq(
  "-Ywarn-value-discard",
  "-Xlint",
  "-deprecation",
  "-feature",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-language:postfixOps"
)

libraryDependencies ++= Seq(
  "org.typelevel"      %% "scodec-core"   % "1.5.0",
  "org.scalaz"         %% "scalaz-core"   % "7.1.0",
  "org.scalaz.stream"  %% "scalaz-stream" % "0.6a",
  "org.apache.commons" % "commons-pool2"  % "2.2",
  "io.netty"           % "netty-handler"  % "4.0.25.Final",
  "io.netty"           % "netty-codec"    % "4.0.25.Final"
)

macrosSettings

testSettings

bintraySettings

bintrayPublishSettings

osgiSettings

publishMavenStyle := true

licenses += ("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0.html"))

scmInfo := Some(ScmInfo(url("https://github.com/oncue/remotely"),
                        "git@github.com:oncue/remotely.git"))

bintray.Keys.packageLabels in bintray.Keys.bintray := Seq("remote", "functional programming", "rpc", "reasonable")

bintray.Keys.bintrayOrganization in bintray.Keys.bintray := Some("oncue")

bintray.Keys.repository in bintray.Keys.bintray := "release"

OsgiKeys.bundleSymbolicName := "remotely-core"

OsgiKeys.exportPackage := Seq("remotely.*")

OsgiKeys.importPackage := Seq(
  """scalaz.*;version="$<range;[==,=+);$<@>>"""",
  """io.netty.*;version="$<range;[==,=+);$<@>>"""",
  """scodec.*;version="$<range;[==,=+);$<@>>"""",
  "*")

