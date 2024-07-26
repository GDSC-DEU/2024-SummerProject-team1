package team1.team1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
class MemberInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String name;
    public  String phoneNumber;
    public String password;
    List<Integer> enrolledEdus;
    List<Integer> enrolledJobs;
    List<Integer> createdEdus;
    List<Integer> createdJobs;
    public  MemberInfo(String name, String phoneNumber, String password)
    {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.enrolledEdus = new ArrayList<Integer>();
        this.enrolledJobs = new ArrayList<Integer>();
    }

    public MemberInfo(){
    }
}