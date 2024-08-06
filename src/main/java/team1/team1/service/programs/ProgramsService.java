package team1.team1.service.programs;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team1.team1.domain.programs.ProgramsRepository;
import team1.team1.web.dto.ProgramsResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProgramsService {
    private final ProgramsRepository programsRepository;

    @Transactional
    public List<ProgramsResponseDto> findAllJobs() {
        return programsRepository.findAllByType("job").stream()
                .map(programs -> new ProgramsResponseDto(programs))
                .collect(Collectors.toList());
    }
}
