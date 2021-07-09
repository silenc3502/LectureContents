package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    //빌드될때 어차피 포함안됨
    MemberService memberService;
    MemoryMemberRepository memberRepository;
    //이부분 문제 주의
    //이부분이 memoryMemberRepository내부의 CV가 있어서 다행이지만 아니라면 이객체를 생성했을때 아마 다른 DB에 연동이될것이다.

    @BeforeEach //동작하기전에 넣어줌
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }


    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hello");
        //when
        Long saveId = memberService.join(member);
        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    //정상작동만 볼게 아니라 Exception 처리도 꼭 확인이 필요하다.
    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("Sptring");

        Member member2 = new Member();
        member1.setName("Sptring");
        //when
        memberService.join(member1);
//        assertThrows(IllegalStateException.class, () -> memberService.join(member2));
//        memberService.join(member1);
//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존해하는 회원입니다.");
//        }
    }
    @Test
    void findMembers() {

    }

    @Test
    void findOne() {
    }
}