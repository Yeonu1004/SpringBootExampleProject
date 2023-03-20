package com.example.ex2.repository;

import com.example.ex2.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

/*
    Spring Data JPA는 JpaRepository 인터페이스를 제공
    이 인터페이스는 CRUD(Create, Read, Update, Delete) 기능을 지원하는 메소드들을 제공
    여기에서 제네릭으로 엔티티 클래스와 ID 타입을 받음
    MemoRepository는 Memo 엔티티 클래스를 데이터베이스에서 가져오고, 저장하고, 삭제하는 등의 작업을 수행할 수 있다
 */
public interface MemoRepository extends JpaRepository<Memo, Long> {

}
