package team1.team1.domain.programs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProgramsRepository extends JpaRepository<Programs, Integer> {
    List<Programs> findAllByType(String type);
}