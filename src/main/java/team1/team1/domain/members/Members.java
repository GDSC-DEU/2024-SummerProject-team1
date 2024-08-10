package team1.team1.domain.members;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Getter
@NoArgsConstructor
@Entity
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(nullable = false)
    public String name;

    @Column(nullable = false)
    public  String phoneNumber;

    @Column(nullable = false)
    public String password;
    @ElementCollection(fetch = FetchType.LAZY)
    List<Integer> enrolledEdus;
    @ElementCollection(fetch = FetchType.LAZY)
    List<Integer> enrolledJobs;
    @ElementCollection(fetch = FetchType.LAZY)
    List<Integer> createdEdus;
    @ElementCollection(fetch = FetchType.LAZY)
    List<Integer> createdJobs;

    public void updateEnrolledEdus(List<Integer> enrolledEdus) {
        this.enrolledEdus = Stream.concat(this.enrolledEdus.stream(),enrolledEdus.stream()).toList();
    }
    public void updateEnrolledJobs(List<Integer> enrolledJobs) {
        this.enrolledJobs = Stream.concat(this.enrolledJobs.stream(),enrolledJobs.stream()).toList();
    }

    @Builder
    private Members(String name, String phoneNumber, String password)
    {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.enrolledEdus = new ArrayList<Integer>();
        this.enrolledJobs = new ArrayList<Integer>();
        this.createdEdus = new ArrayList<Integer>();
        this.createdJobs = new ArrayList<Integer>();
    }


}
