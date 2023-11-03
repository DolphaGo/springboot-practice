# kotlin-multi-module-sample
코프링 멀티모듈 뼈대 샘플

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
- board-entity
  - SpringBoot + Kotlin
  - MySQL
- board-support
  - SpringBoot + Kotlin
- buildSrc
  - Project Library and Version Management
