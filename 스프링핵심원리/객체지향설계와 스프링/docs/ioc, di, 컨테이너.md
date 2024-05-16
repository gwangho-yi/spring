## 제어의 역전 IOC(Inversion of Control)

- 클라이언트 구현 객체가 스스로 서버 구현 객체 생성, 연결, 실행하는 흐름으로 구현 객체가 직접 제어를 했음.

    ```java
    public class OrderServiceImpl implements OrderService {
    		MemberRepository m = new MemoryMemberRepository();
    		MemberRepository m = new JdbcMemberRepository();
    }
    ```

- AppConfig가 객체 생성하는 역할을 대신 함으로써 OrderServiceImpl은 로직을 실행하는 역할만 한다.

    ```java
    public class AppConfig { 
    
    		public OrderService orderService() {
            return new OrderServiceImpl(memoryMemberRepository(), discountPolicy());
        }
        
        private MemoryMemberRepository memoryMemberRepository() {
            return new MemoryMemberRepository();
        }
        
        public DiscountPolicy discountPolicy() {
    //        return new FixDiscountPolicy();
            return new RateDiscountPolicy();
        }
    }
    ```

- 프로그램에 대한 제어 흐름에 대한 모든 권한을 AppConfig가 가지고 있고, OrderServiceImpl같은 구현체 들은 자신의 로직만 수행하면 된다.
- 이렇듯 프로그램의 제어 흐름을 직접 제어하는 것이 아니라 외부에서 관리하는 것을 제어의 역전 IoC 라고 한다.

## 의존관계 주입 DI (Dependency Injection)

- OrderServiceImpl은 DiscountPolicy와 OrderServiceImpl 두가지 인터페이스에 의존한다. 어떤 구현 객체가 사용될지는 모른다.
- 의존관계는  두가지가 있다.
  - 정적인 클래스 의존관계

    클래스가 사용하는 import 코드만 보고 의존 관례를 판단할 수 있다. 애플리케이션을 실행하지 않아도 분석 가능.

  - 실행 시점에 결정되는 동적인 객체 의존관계
- OrderServiceImpl은 실행 시점에 AppConfig에서 구현객체를 할당 받기 때문 동적인 객체 의존관계라고 할 수 있다.
- 앱의 실행 시점에 외부에서 실제 구현 객체를 생성하고 클라이언트에 전달해서 클라이언트와 서버의 실제 의존관계가 연결되는 것을 의존관계 주입이라고 한다.
  - 외부 = AppConfig
  - 실제 구현 객체 = DiscountPolicy, OrderServiceImpl
  - 클라이언트 = OrderServiceImpl
- DI, 의존관계를 주입하면 생기는 이점
  - 클라이언트 코드를 변경하지 않고, 클라이언트가 호출하는 대상의 타입 인스턴스를 변경할 수 있다.
  - 정적인 클래스 의존관계를 변경하지 않고, 동적인 객체 인스턴스 의존 관계를 쉽게 변경할 수 있다.
    - 정적인 클래스 의존관계를 변경하지 않는다는 말은 코드를 손대지 않고도 변경이 가는 말이다.

## IoC 컨테이너, DI 컨테이너

- AppConfig처럼 객체를 생성하고 관리하면서 의존관계를 연결해주는 것을 Ioc컨테이너, DI 컨테이너라고 한다.
- 의존관계 주입에 초점을 맞추어 최근에는 주로 DI 컨테이너라고 한다.