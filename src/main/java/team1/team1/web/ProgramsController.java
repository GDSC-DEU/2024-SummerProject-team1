package team1.team1.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import team1.team1.domain.programs.ProgramsRepository;
import team1.team1.service.programs.ProgramsService;

@RequiredArgsConstructor
@Controller
public class ProgramsController {
    final private ProgramsService programsService;

    @GetMapping("/work_list")
    public String workListPage(Model model) {
        model.addAttribute("jobs",programsService.findAllJobs());
        return "worklist";
    }

    @GetMapping("/edu_list")
    public String eduListPage() {
        return "edulist";
    }

    @GetMapping("/work_write")
    public String workWritePage(Model model) {
        /*
        model.addAttribute("job", new ProgramResponseDto());
         */
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

    @GetMapping("/programs/{type}/{programId}")
    public String workPage(Model model) {
        return "view";
    }
}
