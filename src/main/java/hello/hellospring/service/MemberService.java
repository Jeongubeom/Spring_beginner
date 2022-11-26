package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 클래스 내부에서만 호출할 수 있는 private으로 final최종 즉 값이 수정할 수 없는 상태로 만들고 MemberRepository객체인 memberRepository생성


    /**
     * 회원가입
     */
    public Long join(Member member){ //메소드 클래스 join을 생성하고 Member에 member변수로 값을 받음
        memberRepository.save(member); // memberRepository에 .save저장하세요 member변수로 받은 값을
        return member.getId(); //member에 저장된 값을 .getId로 가져와서  반환해라
    }
}
