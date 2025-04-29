package com.test.basic;

import com.test.basic.board.BoardDAO;
import com.test.basic.board.CommentDAO;
import com.test.basic.board.TagDAO;
import com.test.basic.dto.Member;
import com.test.basic.dto.Student;
import com.test.basic.dto.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class BuildTest {

    @Autowired
    private BoardDAO dao;

    @Autowired
    private CommentDAO cdao;

    @Autowired
    private TagDAO tdao;

    @Test
    void test(){

        //빌더 패턴, Builder Pattern
        //복잡한 객체를 단계별로 생성할 수 있도록 하는 생성 디자인 패턴


        //생성자
        //인자의 개수와 순서, 이름을 파악하기가 어려움
        //다양한 생성 패턴에 있어서 비용이 들고 한계가 있음 (오버로딩에 한계)



        //Member객체의 생성
        Member m1 = new Member();
        m1.setSeq(1L);
        m1.setName("강아지");
        m1.setAge(2);
        m1.setAddress("NewYork");
        m1.setGender("m");

        System.out.println(m1);

        Member m2 = new Member(2L, "고양이", 3, "인천시", "f");
        System.out.println(m2);

        Member m3 = new Member(3L, "병아리", "f");
        System.out.println(m3);

        User u1 = new User.Builder()
                .setSeq(4L)
                .setName("돼지")
                .setAge(3)
                .setAddress("부산시")
                .setGender("m")
                .build();

        System.out.println(u1);


        User u2 = new User.Builder()
                .setSeq(4L)
                .setAge(3)
                .setGender("m")
                .build();

        System.out.println(u2);

        Student s1 = Student.builder()
                .seq(4L)
                .name("악어")
                .age(10)
                .gender("f")
                .address("종로")
                .build();

        System.out.println(s1);
    }

    @Test
    void testBean(){
        assertNotNull(dao);
    }

    @Test
    void testBean2(){
        assertNotNull(cdao);
    }

    @Test
    void testBean3(){
        assertNotNull(tdao);
    }


}
