package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save(){
        Member member1 = new Member(); //Member클래스를 member의 객채로 생성
        member1.setName("Spring"); //member의 객체의 필드에 선언된 Name을 Spring으로 설정

        repository.save(member1); //repository에 member 값을 저장
        Member result1 = repository.findById(member1.getId()).get(); //repository에 저장된 member 값을 id를 getId로 찾아서 result에 저장
        //System.out.println("result = " + (result == member)); // result의 값과 member의 값이 같다면!! 제대로 된거!!
        //Assertions.assertEquals(member, result); // 이 함수로 result와 member의 값 비교 가능
        Assertions.assertThat(result1).isEqualTo(member1); //assertThat의 member는 .isEqualTo의 result와 같다!!

    }

    @Test
    public void findByName(){
        Member member1 = new Member(); //Member class를 member1 객체로 생성
        member1.setName("Spring1"); // 객체 member1에 필드변수 name을 setName으로 "Spring"으로 설정
        repository.save(member1); // repository에 개체 member1에 있는 값들을 .save에 저장해라

        Member member2 = new Member(); //Member class를 member1 객체로 생성
        member2.setName("Spring2"); // 객체 member1에 필드변수 name을 setName으로 "Spring"으로 설정
        repository.save(member2); // repository에 개체 member1에 있는 값들을 .save에 저장해라

        Member result = repository.findByName("Spring1").get(); //repository에 .findByName에 "Spring1"을 찾아서 .get()가져 오세요
        Assertions.assertThat(result).isEqualTo(member1); // assertThat에 result값이 .isEqualTo에 member1과 같은지 비교해보세요

    }

}
