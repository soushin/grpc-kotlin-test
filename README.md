# grpc-kotlin-test

## Overview

This repository contains the demonstration of gRPC built by Kotlin. 

![demo](https://raw.githubusercontent.com/nsoushi/grpc-kotlin-test/master/docs/capture.png)

### Gateway Server

Gateway Server is implemented by using following software.

* Spring-webflux
* Spring Boot 2.0.0.BUILD-SNAPSHOT

### gRPC Server

Grpc Server is implemented by using following software.

* [grpc-spring-boot-starter](https://github.com/LogNet/grpc-spring-boot-starter)
* Spring Boot 1.5.2.BUILD-SNAPSHOT

## Motivation

I want to try Spring Framework 5.0 and Reactor Programming on Kotlin and to know how to running `gRPC Sever` on `Spring Boot`.

## How to confirm the demo

At first If `protoc` do not install, After execute following command then `protoc` is installed.
```
(grpc-kotlin-test) $ make deps
```

Next run both servers.

**Gateway Server**
```
(grpc-kotlin-test/client/grpc-client) $ ./gradlew clean generateProto bootRun
```

**gRPC Server**
```
(grpc-kotlin-testserver/grpc-grpc) $ ./gradlew clean generateProto bootRun
```

---

then confirm to request to `gRPC Server` via `Gateway Server`.
```
➜  ~ curl -XGET http://localhost:8081/api/echo\?msg\=aaa
{"data":"echo \\aaa/"}%
```

and also `gRPC Server` can request via HTTP/1.1.
```
➜  ~ curl -XGET http://localhost:8080/health_check
true%
```
