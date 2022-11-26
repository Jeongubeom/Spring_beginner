package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.security.PrivateKey;
import java.util.*;

public class MemoryMemberRepository implements MemberRepository{ //MemoryMemberRepository를 implements로 구현한다 이것으로emberRepository // alt+shift+enter

    private static Map<Long, Member> store = new HashMap<>();//key 회원 아이디라서 Long, value 즉 값은 Member(name?)값을 같는 store를 새로운 HashMap으로 생성
                                                            //-----------나중에 "HashMap찾기" 이거는 내 뭔지 모름-----------
    private static long sequence = 0L; //key 값을 생성

    @Override
    public Member save(Member member) { // member에 값을 넣는다
        member.setId(++sequence); // member.setId 이 걸로 Member class에서 선언된 id에 ++sequence의 값을 넣는다.(데이터를 구분하기 위해 시스템이 정하는 ID)
        store.put(member.getId(), member); // store.put 이 걸로 store에 member.getId()로 받은 값과, member의 값을 HashMap에 저장한다
        return member; // member값을 반환
    }

    @Override
    public Optional<Member> findById(Long id) { //store에서 id값을 가져나오면된다
        return Optional.ofNullable(store.get(id)); //store.get(id) store에서 get으로 id를 가져온다. 그런데 Optional.ofNullalbel로 Null 값이 나오지 못하게 막는다
    }

    @Override
    public Optional<Member> findByName(String name) {//store에서 name값을 가져나온다
        return store.values().stream() //--------------람다식, 이거 찾아봐야함--------------
                .filter(member -> member.getName().equals(name)) //Member 클래스에 저장된 name과 findByName에 입력된 name과 똑같은지 반복하면서 필터링
                .findAny(); // 찾는다면 해당 name의 값이 있으면 해당 값이, 없으면 null값이 Optional<Member>에 반환됨
    }

    @Override
    public List<Member> findAll() { //저장된 모든 회원정보 찾기

        return new ArrayList<>(store.values()); // store.values의 값은 values 즉 private static Map<Long, Member> 중 Member가 ArrayList를 생성해서 반환함
    }                                           //                                                     이 Member는 Member classs임

    public void clearStore() {
        store.clear(); //메소드 clearStore가 실행되면 store에 있는 데이터 값을 .clear() 전부 삭제한다
    }

}
