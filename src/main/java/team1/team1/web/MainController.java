package team1.team1.web;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;


@Controller
public class MainController {
    @GetMapping("/")
    public String mainPage(@SessionAttribute(name = "memberId", required = false) String memberId, Model model ) {
        if (memberId != null)
        {
            return "index_logined";
        }
        return "index";
    }

    @GetMapping("/applicant_list/{type}/{id}")
    public String myPageEnrolled(@PathVariable("type") String type, @PathVariable("id") int id,  Model model) {
        return "applicant_list";
    }

    @ResponseBody
    @GetMapping("/test/{type}/{id}")
    public String test(@PathVariable("type") String type, @PathVariable("id") int id, Model model) {
        return "gi";
    }
}
