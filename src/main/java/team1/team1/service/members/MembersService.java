package team1.team1.service.members;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.stereotype.Service;
import team1.team1.domain.members.Members;
import team1.team1.domain.members.MembersRepository;
import team1.team1.domain.programs.Programs;
import team1.team1.domain.programs.ProgramsRepository;
import team1.team1.web.dto.MembersRequestDto;
import team1.team1.web.dto.ProgramsResponseDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class MembersService {
    private final MembersRepository membersRepository;
    @Transactional
    public int save(MembersRequestDto requestDto) {
        return membersRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public boolean isMemberGranted(MembersRequestDto membersRequestDto) {

        List<Members> membersList = membersRepository.findByName(membersRequestDto.getName());
        if (membersList.isEmpty()) return false;
        Members member = membersList.getFirst();
        if (membersRequestDto.getName() == null) return false;
        if (membersRequestDto.getPassword() == null) return false;
        if (member.getPassword().equals(membersRequestDto.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public int getIdWithName(String name) {
        List<Members> membersList = membersRepository.findByName(name);
        return membersList.getFirst().getId();
    }

    public List<Integer> getEnrolledProgramsIdListByMemberId(int memberId) {
        Optional<Members> members = membersRepository.findById(memberId);
        try {
            if (members.isEmpty())
            {
                throw new Exception();
            }
        }
        catch(Exception e) {

        }
        return Stream.concat(members.get().getEnrolledJobs().stream(), members.get().getEnrolledEdus().stream()).toList();
    }

}
