# Boot Server Template

A simple template for getting started with a server-side boot project (in
Clojure)

## Instructions

Simply clone the repo down and start writing! Currently comes with the following
dependencies:

```
[org.clojure/clojure "1.8.0"]
[http-kit "2.1.19"]
[ring "1.4.0"]
[environ "1.0.2"]
[boot-environ "1.0.2"]
[adzerk/boot-test "1.1.1" :scope "test"]
[kerodon "0.7.0" :scope "test"]
[cheshire "5.5.0"]
[compojure "1.5.0"]
```

## Notable tasks:

`boot dev` will launch the server and boot up a nREPL server. Any changes made
to source files will be reloaded.

`boot run` will only launch the server. Any changes to source files will be
reloaded.

`boot build` will build an uberjar in the `target/` directory.

`boot test` will run the tests.

`boot watch-test` will run the tests and also re-run them on any changes.
**Note**: right now the tests re-run at an unacceptably slow place. See [this
issue](https://github.com/adzerk-oss/boot-test/issues/22) for more context.
