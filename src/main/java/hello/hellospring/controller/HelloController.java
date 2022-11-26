package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello") // json의 get과 동일한 방식
    public String hello(Model model){
        model.addAttribute("data", "Rina-invers");
//        model변수??에 attributeName이 date인 곳에 값을 hello를 넣으세요
        return "hello";
//      실행되면 templates에 hello.html라는 곳으로 pulic String hello부터 return사이의 값을 렌더링 즉 실행시킨다
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);

//         http://localhost:8080/hello-mvc?name=Spring!!!!
//         여기에서 String name이라는 변수 선언
//         model.addAttribute("name", name); name에 = Spring!!!! 이라는 문자열 대입
//         대입 받은 것을 template 하위 폴더에 있는 hello-template으로 반환한다
        return "hello-template";

//<body>
//<p th:text="'hello ' + ${name}">hello! empty</p>
//<!--실제로 서버에서 구동시 hello! empty이 내용은 이 내용으로 바뀜"'hello ' + ${name}"-->
//</body>
//controller에서 반환받은 값은 template 하위 폴더에 있는 hello-template으로 가져오는데 ${name}으로 값이 표현된다
    }
    @GetMapping("hello-string")
    @ResponseBody //html에서 나오는 body가 아니라 http의 body부분에 ResponseBody에 이 데이터를 직접 넣어준다는 뜻
    public String helloString(@RequestParam("name") String name){
        return "hello" + name; // String name 부문에 Spring의 값을 넣으면 "hello Spring의 값이 반환 되어 요청한 클라이언트에 그대로 내려간다
    }
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello(); //class Hello를 호출해서 hello의 새로운 객체를 생성
        hello.setName(name);  //http://localhost:8080/hello-api?name=Spring 여기서 ?name=Spring방식으로 name에 Spring을 대입
        return hello; //대입 받은 값은 객체 hello로 반환
    }

    static class Hello{

        //alt+insert누르고 get 및 setter 생성
        private String name; //String name은 Hello의 value의 key 값

        public String getName() {  //
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
