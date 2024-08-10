package team1.team1.domain.members;
import org.springframework.data.jpa.repository.JpaRepository;
import team1.team1.domain.members.Members;
import team1.team1.web.dto.MembersRequestDto;

import java.util.List;
import java.util.Optional;


public interface MembersRepository extends JpaRepository<Members, Integer> {
    List<Members> findByName(String name);

}