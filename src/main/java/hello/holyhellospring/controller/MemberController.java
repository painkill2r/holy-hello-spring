package hello.holyhellospring.controller;

import hello.holyhellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    /**
     * 생성자를 통해 스프링 컨테이너에 등록되어 있는 MemberService를 주입시켜 준다.
     *
     * @param memberService
     */
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
