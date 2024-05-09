package com.example.core;

import com.example.core.discount.DiscountPolicy;
import com.example.core.discount.FixDiscountPolicy;
import com.example.core.discount.RateDiscountPolicy;
import com.example.core.member.MemberRepository;
import com.example.core.member.MemberService;
import com.example.core.member.MemberServiceImpl;
import com.example.core.member.MemoryMemberRepository;
import com.example.core.order.OrderService;
import com.example.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    // AppConfig가 MemberServiceImpl를 생성과 MemoryMemberRepository를 주입해준다
    // 생성자 주입
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


