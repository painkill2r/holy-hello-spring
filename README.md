#### 최초 작성일 : 2021.05.09(일)

# 스프링 프레임워크 입문

Spring Boot를 이용한 DI/IoC, Web MVC, DB 접근 기술에 대한 학습을 진행한다.

## 학습 환경

1. OS : MacOS
2. JDK : OpenJDK 11.0.5
3. Framework : Spring Boot 2.4.5
    - [Spring Initializer 링크 : https://start.spring.io](https://start.spring.io)
    - 의존설정(Dependencies)
        - Spring Web
        - Thymeleaf View Template
4. Build Tools : Gradle
5. Database : H2

## View 환경설정

1. 스프링 부트가 제공하는 Welcome Page 기능
    - Spring Boot는 정적 및 템플릿 환영 페이지를 모두 지원한다. 먼저 구성된 정적 콘텐츠 위치에서 index.html 파일을 찾고, 없는 경우 인덱스 템플릿을 찾는다. 둘 중 하나가 있으면 자동으로
      응용 프로그램의 시작 페이지로 사용된다.
2. Thymeleaf 템플릿 엔진 동작 확인
   ![요청 화면 출력 과정](images/01.jpg)
    - 실행 : http://localhost:8080/hello
    - 컨트롤러에서 리턴 값으로 문자열을 반환하면 `뷰 리졸버(View Resolver)`가 화면을 찾아서 처리한다.
        - 스프링 부트 템플릿엔진 기본 View Name 매핑 : '/src/main/resource/templates/' + {View Name} + '.html'

> `spring-boot-devtools` 라이브러리를 추가하면, `html` 파일을 컴파일만 해주어도 서버 재시작 없이 View 파일 변경이 가능하다.

## 빌드하고 실행하기

1. 콘솔(Console)로 이동
2. `./gradlew build` 명령어 입력
3. 빌드 후 생성되는 build 디렉토리로 이동(`cd build/libs`)
4. `java -jar holy-hello-spring-0.0.1-SNAPSHOT.jar` 명령어 입력
5. 실행 확인

> 빌드를 지우고 싶거나 새로 빌드를 하고 싶은 경우 `./gradlew clean 또는 ./gradlew clean build` 명령어 입력

## 참고자료

1. [스프링 공식 튜토리얼 : https://spring.io/guides/gs/serving-web-content](https://spring.io/guides/gs/serving-web-content)
2. [타임리프 공식 사이트 : https://www.thymeleaf.org](https://www.thymeleaf.org)
3. [스프링 부트 메뉴얼 : https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features)