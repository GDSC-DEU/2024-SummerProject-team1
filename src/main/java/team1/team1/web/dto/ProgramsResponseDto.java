package team1.team1.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import team1.team1.domain.programs.Programs;

import java.util.Optional;

@RequiredArgsConstructor
@Getter
public class ProgramsResponseDto {
    private int id;
    private final String type;
    private final String title;
    private final String host;
    private final String endDate;

    public ProgramsResponseDto(Programs programs) {
        this.id = programs.getId();
        this.type = programs.getType();
        this.title = programs.getTitle();
        this.host = programs.getHost();
        this.endDate = programs.getEndDate();
    }


}
