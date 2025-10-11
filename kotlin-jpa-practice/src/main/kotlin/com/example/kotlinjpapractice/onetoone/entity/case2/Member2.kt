package com.example.kotlinjpapractice.onetoone.entity.case2

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity(name = "MemberCase2")
@Table(name = "member_case2")
class Member2(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val name: String,

    @OneToOne(mappedBy = "member2", fetch = FetchType.LAZY)
    val locker2: Locker2? = null

)