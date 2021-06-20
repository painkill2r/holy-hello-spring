package hello.holyhellospring.service;

import hello.holyhellospring.domain.Member;
import hello.holyhellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 생성자를 통해서 MemberRepository를 넣어줌.
     *
     * @param memberRepository
     */
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     *
     * @param member
     * @return
     */
    public Long join(Member member) {
        validateDuplicateMember(member);

        memberRepository.save(member);

        return member.getId();
    }

    /**
     * 전체 회원 조회
     *
     * @return
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * 회원 조회
     *
     * @param memberId
     * @return
     */
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

    /**
     * 같은 이름이 있는 중복 회원이 있는지 검사
     *
     * @param member
     */
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
}
