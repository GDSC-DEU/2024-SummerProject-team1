package team1.team1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public int createrId;
    public String type;
    public String host;
    public String date;
    public String title;
    public String content;
    public Date createdTime;
    public List<Integer> appllicants;
    public Program(int id, String type, int createdId,String host, String date, String title) {
        this.id = id;
        this.type = type;
        this.createrId = createdId;
        this.host = host;
        this.date = date;
        this.title = title;
        this.appllicants = new ArrayList<Integer>();
    }
    public Program(){
    }
}