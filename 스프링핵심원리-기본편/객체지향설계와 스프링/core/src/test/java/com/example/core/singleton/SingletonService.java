package com.example.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    // 바깥에서 SingletonService를 new로 생성하지 못하게 private로 생성자 설정
//    private SingletonService() {
//    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
