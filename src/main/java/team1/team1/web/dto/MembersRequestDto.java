package team1.team1.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team1.team1.domain.members.Members;
@Setter
@Getter
@NoArgsConstructor
public class MembersRequestDto {
    private String name;
    private String phoneNumber;
    private String password;

    @Builder
    public MembersRequestDto(String name, String phoneNumber, String password)
    {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public Members toEntity() {
        return Members.builder()
                .name(name)
                .phoneNumber(phoneNumber)
                .password(password)
                .build();
    }

}
