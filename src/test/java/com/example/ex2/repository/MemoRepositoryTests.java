package com.example.ex2.repository;

import com.example.ex2.entity.Memo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemoRepositoryTests {
    @Autowired
    MemoRepository memoRepository;

    @Test
    public void testClass() {
        System.out.println(memoRepository.getClass().getName());
    }

    //mno가 100인 Memo 엔티티를 데이터베이스에서 조회하여 출력하는 테스트
    @Test
    public void testInsertDummies() {

        IntStream.rangeClosed(1,100).forEach(i -> {
            Memo memo = Memo.builder().memoText("Sample..." +i).build();
            memoRepository.save(memo);
        });
    }

    //mno가 100인 Memo 엔티티의 memoText 값을 'Update Text'로 변경하여 데이터베이스에 저장
    @Test
    public void testSelect() {
        //데이터베이스에 존재하는 mno
        Long mno = 100L;

        Optional<Memo> result = memoRepository.findById(mno);

        System.out.println("===================================");

        if (result.isPresent()) {
            Memo memo = result.get();
            System.out.println(memo);
        }
    }

    @Test
    public void testUpdate() {
        Memo memo = Memo.builder().mno(100L).memoText("Update Text").build();

        System.out.println(memoRepository.save(memo));
    }

}
