package team1.team1.web.dto;

import lombok.Builder;
import lombok.NoArgsConstructor;
import team1.team1.domain.members.Members;
import team1.team1.domain.programs.Programs;

@NoArgsConstructor
public class ProgramsRequestDto {
    private String type;
    private String title;
    private String host;
    private String endDate;
    private String content;

    @Builder
    public ProgramsRequestDto(String type, String title, String host, String endDate,String content)
    {
        this.type = type;
        this.title = title;
        this.host = host;
        this.endDate = endDate;
        this.content = content;
    }

    public Programs toEntity() {
        return Programs.builder()
                .type(type)
                .title(title)
                .host(host)
                .endDate(endDate)
                .content(content)
                .build();
    }
}
