package hello.hellospring.domain;

public class Member {
    private Long id; //데이터를 구분하기 위해 시스템이 정하는 ID
    private String name; // 회원가입할 때 적는 이름

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }



}
