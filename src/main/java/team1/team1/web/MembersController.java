package team1.team1.web;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import team1.team1.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import team1.team1.service.members.MembersService;
import team1.team1.web.dto.MembersRequestDto;


@RequiredArgsConstructor
@Controller
public class MembersController {
    private final MembersService membersService;

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("memberInfo", new MembersRequestDto());
        return "login";
    }

    @PostMapping("/login")
    public String submitLoginPage(@ModelAttribute("memberInfo") MembersRequestDto loginDto, Model model, HttpServletRequest request) {
        if (membersService.isMemberGranted(loginDto)) {
            int memberId = membersService.getIdWithName(loginDto.getName());
            HttpSession session = request.getSession();
            session.setAttribute("memberId",memberId);
            return "redirect:/";
        } else {
            model.addAttribute("error", "잘못된 이름 또는 비밀번호입니다.");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
    @GetMapping("/signup")
    public String signupPage(Model model) {
        model.addAttribute("memberInfo", new MembersRequestDto());
        return "signup";
    }

    @PostMapping("/signup")
    public String submitSignupPage(@ModelAttribute("memberInfo") MembersRequestDto memberInfo) {
        membersService.save(memberInfo);
        return "redirect:/login";
    }
}
