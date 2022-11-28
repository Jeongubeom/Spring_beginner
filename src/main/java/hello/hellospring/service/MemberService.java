package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 클래스 내부에서만 호출할 수 있는 private으로 final최종 즉 값이 수정할 수 없는 상태로 만들고 MemberRepository객체인 memberRepository생성


    /**
     * 회원가입
     */
    public Long join(Member member){ //메소드 클래스 join을 생성하고 Member에 member변수로 값을 받음

        //같은 이름이 있는 중복회원은 안됨
       /* case1.
        Optional<Member> result = memberRepository.findByName(member.getName()); //memberRepository에서 .findByName으로 member클래스에 있는 .getName을 호출해서 result값에 넣어라
        result.ifPresent(m->{ //result 안에 .ifPresent null이 아닌 입력값(여기서는 m)이 있다면, throw 값은 던져라 new IllegalStateException("이미 존재하는 회원입니다")를
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });*/

        //private void validateDuplicateMember(Member member) 이부분을 전체 드래그해서 리팩터링->메소드추출 -> 셋팅모양 클릭 -> 추가변경 후 설정
        validateDuplicateMember(member); //중복회원 검증
        memberRepository.save(member); // memberRepository에 .save저장하세요 member변수로 받은 값을
        return member.getId(); //값을 반환해라. member에 있는 .getId로 그리고 저장.
    }
    //case2. /이것을 리팩토링->메소드추출하면 위에 같이 나타남
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){ //findMembers메소드 생성
        return memberRepository.findAll(); //memberRepository안에 .findAll을 호출해서 반환하세요
    }
    public Optional<Member> findOne(Long memberId){ //findOne 메소드 생성
        return memberRepository.findById(memberId); //memberRepository에서 .findById로 입력받은 memberId에 있는 값을 실행해서 반환
    }
}
