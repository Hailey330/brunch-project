# Brunch Project

- Spring, React, Android, MySQL 활용한 Brunch 프로젝트

### Brunch 홈페이지

- https://brunch.co.kr/

## 1. 개발 환경

- Spring boot
- React
- MySQL
- Android

## 1-1. 의존성

- MyBatis
- Spring Web
- Spring Security
- Lombok
- Validation
- OAuth2

## 2. 요구사항(기능)

- 로그인
- 사용자 프로파일(사진) 업로드
- 게시글 등록
- 게시글 수정
- 게시글 삭제
- 게시글 목록
- 게시글 상세보기
- 게시글 좋아요
- 게시글 검색
- 게시글 권한 관리
- 댓글 등록
- 댓글 삭제

## 3. application.yml 설정

```yml
server:
  port: 8080
  servlet:
    context-path: /
    encoding:
      charset: UTF-8
      enabled: true
      force: true

spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/brunch?serverTimezone=Asia/Seoul
    username: brunch
    password: bitc5600

  jpa:
    hibernate:
      ddl-auto: create #create update none
      naming:
        physical-strategy: org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl #내가 적은 그대로 테이블 속성명으로 넣어줌
    show-sql: true
```
