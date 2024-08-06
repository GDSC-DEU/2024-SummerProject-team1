package team1.team1.web;
import team1.team1.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MembersController {
    @Autowired
    private MemberInfoRepository memberInfoRepository;

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("loginRequest", new MemberInfo());
        return "login";
    }

    @PostMapping("/login")
    public String submitLoginPage(@ModelAttribute("loginRequest") MemberInfo loginRequest, Model model) {
        MemberInfo memberInfo = memberInfoRepository.findByName(loginRequest.getName());

        if (memberInfo != null && memberInfo.getPassword().equals(loginRequest.getPassword())) {
            return "redirect:/home";
        } else {
            model.addAttribute("error", "잘못된 이름 또는 비밀번호입니다.");
            return "login";
        }
    }


    @GetMapping("/signup")
    public String signupPage(Model model) {
        model.addAttribute("memberInfo", new MemberInfo());
        return "signup";
    }

    @PostMapping("/signup")
    public String submitSignupPage(@ModelAttribute MemberInfo memberInfo) {
        System.out.println(memberInfo.getPassword());
        memberInfoRepository.save(memberInfo);
        return "redirect:/login";
    }

}
