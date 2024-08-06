package team1.team1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class MemberInfo {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Integer> getEnrolledEdus() {
        return enrolledEdus;
    }

    public void setEnrolledEdus(List<Integer> enrolledEdus) {
        this.enrolledEdus = enrolledEdus;
    }

    public List<Integer> getEnrolledJobs() {
        return enrolledJobs;
    }

    public void setEnrolledJobs(List<Integer> enrolledJobs) {
        this.enrolledJobs = enrolledJobs;
    }

    public List<Integer> getCreatedEdus() {
        return createdEdus;
    }

    public void setCreatedEdus(List<Integer> createdEdus) {
        this.createdEdus = createdEdus;
    }

    public List<Integer> getCreatedJobs() {
        return createdJobs;
    }

    public void setCreatedJobs(List<Integer> createdJobs) {
        this.createdJobs = createdJobs;
    }
}