package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

//    MemberService memberService = new MemberServiceImpl();
    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        //given 이런 환경에서
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when 이런 일이 주어졌을 때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then 이런 결과가 나온다
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
