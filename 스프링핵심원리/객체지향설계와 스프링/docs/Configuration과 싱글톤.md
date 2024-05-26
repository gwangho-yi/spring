- new 로 생성된 서비스나 레포지토리 같은 인스턴스들은 여러번 생성해서 쓰면 싱글톤 깨지는거 아닌가??

```java
@Configuration
public class AppConfig {
    
    // @Bean -> memberService -> new MemoryMemberRepository()
    // @Bean -> orderService -> new MemoryMemberRepository()
    // MemoryMemberRepository 2번 호출 싱글톤 깨지는거 아닌가?
    
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memoryMemberRepository());
    }

    @Bean
    public MemoryMemberRepository memoryMemberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memoryMemberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
```

- 테스트 코드 작성 시 3개가 다 같은 메모리 참조 값이 찍힌다.

```java
@Test
    void configurationTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);

        MemberRepository memberRepository = ac.getBean("memoryMemberRepository", MemoryMemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemoryMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();
        System.out.println("memberService -> memberRepository = " + memberRepository1);
        System.out.println("orderService -> memberRepository = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);

        Assertions.assertThat(memberRepository1).isSameAs(memberRepository2).isSameAs(memberRepository);

    }
```

## @Configuration과 바이트코드 조작의 마법

- 스프링컨테이너는 싱글톤 레지스트리다.
- 따라서 스프링 빈이 싱글톤이 되도록 보장해줘야한다.
- 위 예제 처럼 3번 호출 되는게 맞는데 바이트코드를 조작하는 라이브러리를 사용한다.

```java
@Test
    void configurationDeep() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);
        
        System.out.println("bean = " + bean);  // com.example.core.AppConfig$$EnhancerBySpringCGLIB$$bb49e3e0@60bdf15d

        MemberServiceImpl bean1 = ac.getBean(MemberServiceImpl.class);
        System.out.println("bean1 = " + bean1); // com.example.core.member.MemberServiceImpl@47da3952
    }
```

- AppConfig는 약간 클래스 명이 약간 이상하다.
- 스프링이 CGLIB라는 바이트코드 조작 라이브러리를 사용해서 AppConfig 클래스를 상속 받은 임의의 클래스를 만들고, 다른 클래스를 스프링 빈으로 등록한다.
- 임의의 클래스가 싱글톤이 보장해주도록 한다.
- 아마 MemoryMemberRepository가 컨테이너에 한번 등록 되어 있으면 찾아서 그대로 반환해주는 코드를 동적으로 만들어주는거 같다.
- `@Configuration` 어노테이션 때버리면 싱글톤으로는 사용이 불가능하다.