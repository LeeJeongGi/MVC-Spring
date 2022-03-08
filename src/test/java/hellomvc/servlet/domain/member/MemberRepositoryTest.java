package hellomvc.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void clearEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Member member = new Member("hello", 20);

        //when
        Member saveMember = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findById(saveMember.getId());
        assertThat(findMember).isEqualTo(saveMember);

    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 21);
        Member member3 = new Member("member3", 22);

        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);

        //when
        List<Member> members = memberRepository.findAll();
        //then
        assertThat(members.size()).isEqualTo(3);
        assertThat(members).contains(member1, member2, member3);
    }
}
