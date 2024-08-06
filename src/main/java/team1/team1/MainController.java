package team1.team1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;



@Controller
public class MainController {

    @Autowired
    private ProgramRepository programRepository;

    @Autowired
    private MemberInfoRepository memberInfoRepository;
    @GetMapping("/")
    public String mainPage(Model model) {
        return "index";
    }

    @GetMapping("/work_list")
    public String workListPage() {
        return "worklist";
    }

    @GetMapping("/edu_list")
    public String eduListPage() {
        return "edulist";
    }

    @GetMapping("/workwrite")
    public String workWritePage() {
        return "workwrite";
    }

    @PostMapping("/view")
    public String jobViewPage(Model model) {
        return "";
    }


    @GetMapping("/mypage_enrolled")
    public String myPageEnrolled(Model model) {
        List<Program> programs = programRepository.findAll();
        model.addAttribute("programs", programs);
        return "mypage_enrolled";
    }

    @GetMapping("/mypage_created")
    public String myPageCreated(Model model) {
        List<Program> programs = programRepository.findAll();
        model.addAttribute("programs", programs);
        return "mypage_created";
    }

    @GetMapping("/applicant_list/{type}/{id}")
    public String myPageEnrolled(@PathVariable("type") String type, @PathVariable("id") int id,  Model model) {
        Program[] programs = {
                new Program(0,"edu",1,"동의대학교","2022년 8월 20일","영어회화 첫걸음"),
                new Program(1,"job",1,"BNK 금융그룹","2022년 8월 20일","앱 API 테스터 모집"),
        };
        Program program = programs[id];
        memberInfoRepository.findAll();
        model.addAttribute("content", program);
        model.addAttribute("content", program);
        return "applicant_list";
    }
}
