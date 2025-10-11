package com.example.kotlinjpapractice.onetoone.case1

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "member_case1")
class Member(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val name: String,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "locker_id")  // 주 테이블 Member에 FK
    val locker: Locker? = null)
