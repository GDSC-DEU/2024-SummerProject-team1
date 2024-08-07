package team1.team1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberInfoRepository extends JpaRepository<MemberInfo, Integer> {
    MemberInfo findByName(String userId);
}