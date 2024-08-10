package team1.team1.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.support.SessionStatus;
import team1.team1.domain.members.Members;
import team1.team1.service.members.MembersService;
import team1.team1.service.programs.ProgramsService;
import team1.team1.web.dto.ProgramsRequestDto;
import team1.team1.web.dto.ProgramsResponseDto;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ProgramsController {
    final private ProgramsService programsService;
    final private MembersService membersService;

    @GetMapping("/work_list")
    public String workListPage(Model model) {
        model.addAttribute("jobs",programsService.findAllJobs());
        return "worklist";
    }

    @GetMapping("/edu_list")
    public String eduListPage(Model model) {
        model.addAttribute("edus",programsService.findAllEdus());
        return "edulist";
    }

    @GetMapping("/work_write")
    public String workWritePage(Model model) {
        model.addAttribute("job", new ProgramsRequestDto());
        return "workwrite";
    }

    @PostMapping ("/work_write")
    public String workWrite() {
        return "workwrite";
    }

    @GetMapping("/edu_write")
    public String eduWritePage() {
        return "eduwrite";
    }

    @GetMapping("/view/{programId}")
    public String detailView(@PathVariable int programId, Model model) {
        model.addAttribute("program",programsService.findById(programId));
        model.addAttribute("programId",programId);
        return "view";
    }

    @PostMapping("apply/{programId}")
    public String apply(@SessionAttribute(name = "memberId",required = false) String memberId, @PathVariable int programId)
    {
        if (memberId == null)
        {
            return "redirect:/login";
        }
        return "hi";
    }
    @GetMapping("/mypage_enrolled")
    public String myPageEnrolled(@SessionAttribute(value = "memberId",required = false) String memberId ,Model model) {
        if (memberId == null)
        {
            return "redirect:/login";
        }
        List<Integer> enrolledProgramsIdList = membersService.getEnrolledProgramsIdListByMemberId(Integer.parseInt(memberId));
        List<ProgramsResponseDto> enrolledProgramsDtoList = programsService.getEnrolledProgramsResponseDto(enrolledProgramsIdList);
        model.addAttribute("programs",enrolledProgramsDtoList);
        return "mypage_enrolled";
    }

    @GetMapping("/mypage_created")
    public String myPageCreated(Model model) {
        return "mypage_created";
    }


}
