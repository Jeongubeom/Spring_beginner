package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save(){
        Member member = new Member(); //Member클래스를 member의 객채로 생성
        member.setName("Spring"); //member의 객체의 필드에 선언된 Name을 Spring으로 설정

        repository.save(member); //repository에 member 값을 저장
        Member result = repository.findById(member.getId()).get(); //repository에 저장된 member 값을 id를 getId로 찾아서 result에 저장
        //System.out.println("result = " + (result == member)); // result의 값과 member의 값이 같다면!! 제대로 된거!!
        Assertions.assertEquals(member, result); // 이 함수로 result와 member의 값 비교 가능

    }

}
