package team1.team1.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import team1.team1.domain.programs.Programs;

@RequiredArgsConstructor
@Getter
public class ProgramsViewDto{
    private final String type;
    private final String title;
    private final String host;
    private final String endDate;
    private final String content;

    public ProgramsViewDto(Programs program) {
        type = program.getType();
        title = program.getTitle();
        host = program.getHost();
        endDate = program.getEndDate();
        content = program.getContent();
    }
}
