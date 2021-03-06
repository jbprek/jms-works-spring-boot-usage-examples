Spring JMS Usage Examples
=========================

References
----------
- [Spring Framework JMS](https://docs.spring.io/spring/docs/5.1.7.RELEASE/spring-framework-reference/integration.html#jms)

- [Spring API doc](https://docs.spring.io/spring/docs/5.1.7.RELEASE/javadoc-api/)

- [JMS Specification](https://jcp.org/aboutJava/communityprocess/final/jsr343/index.html)

- [JMS Javadoc JEE7](https://docs.oracle.com/javaee/7/api/index.html?javax/jms/package-summary.html)


P2P Use cases
-------------

1. **com.foo.jms.queue.simple.echo** Simplest implementation with a listener receiving  plain text messages and message producers as tests (TODO) and REST enpoints.

2. TODO Overlay model request-response with temporary queues

3. TODO Multi listeners on the same queue, accepting input given a Message Header or Parameter

4. TODO Transactions

Topics
------

1. **Concurrency** of asynchronous listeners, concurrency parameter see : Use Case 1, com.foo.jms.p2p.simple.echo.EchoListener

