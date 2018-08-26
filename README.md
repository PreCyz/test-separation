# test-separation
Frameworks: Spring Boot, Gradle, JUnit

Shows how to separate unit test from integration test for Spring Boot
with Gradle.

### Motivation
I want to separate JUnit tests from integration tests and execute them
within my IDE. I want this to be done for Spring Boot project.

### Solution
I found solution [here](https://moelholm.com/2016/10/22/spring-boot-separating-tests/).
To solve this challenge two interfaces where created: `UnitTest` and `IntegrationTest`. Having this
interfaces I marked test classes accordingly using JUnit annotation `@Category`. For unit tests
I annotated my classes `@Category(UnitTest.class)` and I did the similarly with integration test classes: `@Category(IntegrationTest.class)`.

After I annotated my test classes, I created two tasks in my _gradle.build_ file as follows:

    test {
        useJUnit {
            includeCategories 'com.gawa.integration.UnitTest'
        }
    }

    task integrationTest(type: Test) {
        useJUnit {
            includeCategories 'com.gawa.integration.IntegrationTest'
        }
    }

No magic here. Task _`test`_ is a definition of task, that triggers test classes annotated `@Category(UnitTest.class)`.
Similarly task _`integrationTest`_ is a definition of task, that triggers test classes annotated `@Category(IntegrationTest.class)`.

You can execute these tasks from command line as follows:

    ./gradlew test
or

    ./gradlew integrationTest

I configured my IDE (Intelij Idea) to execute unit tests and integration test with separate `Run configurations`. Both
configuration are `Gradle run configurations`.