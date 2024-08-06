package team1.team1.domain.programs;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import team1.team1.domain.programs.Programs;
import team1.team1.domain.programs.ProgramsRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProgramsRepositoryTest {
    @Autowired
    ProgramsRepository programsRepository;

    @After("")
    public void cleanup(){
        programsRepository.deleteAll();
    }

    @Test
    public void 프로그램저장_불러오기() {
        String title = "테스트 제목";
        String host = "테스트 내용";
        String endDate = "2024년 8월 9일";
        String type = "job";
        programsRepository.save(Programs.builder()
                .title(title)
                .host(host)
                .endDate(endDate)
                .type(type)
                .build()
        );
        List <Programs> programsList = programsRepository.findAll();
        Programs programs = programsList.get(0);
        assertThat(programs.getTitle()).isEqualTo(title);
        assertThat(programs.getHost()).isEqualTo(host);
        assertThat(programs.getType()).isEqualTo(type);
        assertThat(programs.getEndDate()).isEqualTo(endDate);
    }
}
