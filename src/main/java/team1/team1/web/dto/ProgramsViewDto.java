package team1.team1.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import team1.team1.domain.programs.Programs;

@RequiredArgsConstructor
@Getter

public class ProgramsViewDto {
    private int id;
    private final String type;
    private final String title;
    private final String host;
    private final String endDate;
    private final String content;

    public ProgramsViewDto(Programs programs) {
        this.id = programs.getId();
        this.type = programs.getType();
        this.title = programs.getTitle();
        this.host = programs.getHost();
        this.endDate = programs.getEndDate();
        this.content = programs.getContent();
    }
}
