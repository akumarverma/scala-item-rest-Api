# Item API in Scala #
A very basic Scala Rest API to perform CRUD operation on in-memory data structure.


## Build & Run ##

```sh
$ cd my-scalatra-web-app
$ sbt
> jetty:start
> browse
```

###### Add below lines in libraryDependencies for Json Support ######
```
  "org.scalatra" %% "scalatra-json" % "2.7.0",
  "org.json4s"   %% "json4s-jackson" % "3.5.5"
```

If `browse` doesn't launch your browser, manually open [http://localhost:8080/](http://localhost:8080/) in your browser.
