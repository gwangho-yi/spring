package com.example.kotlinjpapractice.onetoone.Entity.case2.another

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "member_case3")
class Member3(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val name: String,

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private val _lockers: MutableSet<Locker3> = mutableSetOf()
) {
    // 읽기 전용으로 노출
    val locker: Locker3?
        get() = _lockers.firstOrNull()


    // 1개만 설정 가능한 setter
    fun setLocker(locker: Locker3?) {
        // 기존 관계 제거
        _lockers.clear()

        // 새 관계 설정
        if (locker != null) {
            _lockers.add(locker)
            locker.member = this  // 양방향 설정
        }
    }

}