package team1.team1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Member;


class Content {
    public int id;
    public String type;
    public String host;
    public String date;
    public String title;
    public Content(int id, String type, String host, String date, String title) {
        this.id = id;
        this.type = type;
        this.host = host;
        this.date = date;
        this.title = title;
    }
}
class MemberInfo {
    public int id;
    public String name;
    public  String phoneNumber;

    public  MemberInfo(int id, String name, String phoneNumber)
    {
         this.id = id;
         this.name = name;
         this.phoneNumber = phoneNumber;
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

    @GetMapping("/worklist")
    public String jobListPage() {


        return "worklist";
    }

    @GetMapping("/workwrite")
    public String jobWritePage() {
        return "workwrite";
    }

    @PostMapping("/view")
    public String jobViewPage(Model model) {
        System.out.println();
        return "";
    }

    @GetMapping("/signup")
    public String signupPage() {

        return "signup";
    }

    @GetMapping("/mypage_enrolled")
    public String myPageEnrolled(Model model) {
        Content[] contents = {
                new Content(0,"edu","동의대학교","2022년 8월 20일","영어회화 첫걸음"),
                new Content(1,"job","BNK 금융그룹","2022년 8월 20일","앱 API 테스터 모집"),
                new Content(2,"job","BNK 금융그룹","2022년 8월 20일","앱 API 테스터 모집"),
                new Content(3,"edu","동의대학교","2022년 8월 20일","영어회화 첫걸음")
        };
        model.addAttribute("contents",contents);
        return "mypage_enrolled";
    }

    @GetMapping("/mypage_created")
    public String myPageCreated(Model model) {
        Content[] contents = {
                new Content(0,"edu","동의대학교","2022년 8월 20일","영어회화 첫걸음"),
                new Content(1,"job","BNK 금융그룹","2022년 8월 20일","앱 API 테스터 모집"),
        };
        model.addAttribute("contents",contents);
        return "mypage_created";
    }

    @GetMapping("/applicant_list/{type}/{id}")
    public String myPageEnrolled(@PathVariable("type") String type, @PathVariable("id") int id,  Model model) {
        Content[] contents = {
                new Content(0,"edu","동의대학교","2022년 8월 20일","영어회화 첫걸음"),
                new Content(1,"job","BNK 금융그룹","2022년 8월 20일","앱 API 테스터 모집"),
        };
        Content content = contents[id];
        MemberInfo[] applicants = {
                new MemberInfo(0,"김지홍","010-1234-1234"),
                new MemberInfo(1,"김지홍","010-1234-1234")
        };
        model.addAttribute("content",content);
        model.addAttribute("applicants",applicants);
        return "applicant_list";
    }

}
