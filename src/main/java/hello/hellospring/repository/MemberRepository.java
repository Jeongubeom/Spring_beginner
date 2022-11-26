package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //회원정도 id, name 등이 저장;
    Optional<Member> findById(Long id); // 저장된 회원의 id로 저장된 회원을 찾음
    Optional<Member> findByName(String name); //저장된 회원의 name으로 저장된 회원을 찾음
    List<Member> findAll(); // 지금까지 저장된 회원의 정보를 모두 반환
}
