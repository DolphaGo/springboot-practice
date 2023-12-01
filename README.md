# kotlin-multi-module-spring-practice

Spring practice project

- SpringBoot: 3.1.5
- kotlinVersion: 1.7.22

> 모듈 구성

- board-front
  - board-front-api
    - SpringBoot + Kotlin
  - board-front-ui
    - Vue3 + TypeScript + Vite
- board-api
  - SpringBoot + Kotlin
- board-batch
  - SpringBoot + Kotlin
  - MySQL
- board-entity
  - SpringBoot + Kotlin
  - MySQL
- board-support
  - SpringBoot + Kotlin
- buildSrc
  - Project Library and Version Management
