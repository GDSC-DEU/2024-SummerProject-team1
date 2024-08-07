package team1.team1.domain.programs;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity

public class Programs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String host;

    @Column(nullable = false)
    private String endDate;

    private String content;
    private Date createdTime;

    private List<Integer> appllicantIdArray;

    @Builder
    public Programs(String type, String title, String host, String endDate)
    {
        this.type = type;
        this.title = title;
        this.host = host;
        this.endDate = endDate;
    }

}
