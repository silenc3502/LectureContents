package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    //참고 : 테스트먼저하고 구현부 클래스를 만드는 것을 Tdd라고 한다.
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach()//Test간의 간섭으로 오류발생하기 때문에 한 메서드를 실행한 후에 비워주도록해야한다. repostiory클래스에 들어가서 clear메서드를 설정해주자.
    public void afterEach() {
        repository.clearStore();
    }




    @Test
    public void save() {

        Member member = new Member();
        member.setName("Spring");

        repository.saver(member);

        Member result = repository.findById(member.getId()).get();
        System.out.println("result = " + (result == member));

//        Assertions.assertEquals(member, null);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.saver(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.saver(member2);

        Member result = repository.findByName("spring2").get();

        assertThat(member2).isEqualTo(result);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.saver(member1);

        Member member2 = new Member();
        member2.setName("spring1");
        repository.saver(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);

        
    }
}
