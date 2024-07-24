package team1.team1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


class Content {
    public int id;
    public String type;
    public String creater;
    public String date;
    public String title;
    public Content(int id, String type, String creater, String date, String title) {
        this.id = id;
        this.type = type;
        this.creater = creater;
        this.date = date;
        this.title = title;
    }
}
@Controller
public class MainController {
    @GetMapping("/")
    public String mainPage(Model model) {
        return "index";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/list/job")
    @ResponseBody
    public String jobListPage() {
        /*
        * 일자리 정보를 가져와서 객체로 만들기
        * */
        return "로그인";
    }
    @GetMapping("/signup")
    @ResponseBody
    public String signupPage() {

        return "회원가입";
    }


    @GetMapping("/mypage_enrolled")
    public String myPageEnrolled(Model model) {
        Content[] contents = {
                new Content(0,"edu","동의대학교","2022년 8월 20일","영어회화 첫걸음"),
                new Content(1,"job","BNK 금융그룹","2022년 8월 20일","앱 API 테스터 모집"),
                new Content(2,"job","BNK 금융그룹","2022년 8월 20일","앱 API 테스터 모집"),
                new Content(0,"edu","동의대학교","2022년 8월 20일","영어회화 첫걸음")
        };
        model.addAttribute("contents",contents);
        return "mypage_enrolled";
    }

}
