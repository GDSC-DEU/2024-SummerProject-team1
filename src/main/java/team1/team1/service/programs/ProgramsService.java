package team1.team1.service.programs;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team1.team1.domain.programs.Programs;
import team1.team1.domain.programs.ProgramsRepository;
import team1.team1.web.dto.ProgramsResponseDto;
import team1.team1.web.dto.ProgramsViewDto;

import java.util.List;
import java.util.Optional;
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
    @Transactional
    public List<ProgramsResponseDto> findAllEdus() {
        return programsRepository.findAllByType("edu").stream()
                .map(programs -> new ProgramsResponseDto(programs))
                .collect(Collectors.toList());
    }
    @Transactional
    public List<ProgramsResponseDto> getEnrolledProgramsResponseDto(List<Integer> enrolledProgramsIdList) {
        return enrolledProgramsIdList.stream().map(id -> new ProgramsResponseDto(programsRepository.findById(id).get())).collect(Collectors.toList());
    }
    public ProgramsViewDto findById(int programId) {
        Optional<Programs> programsData = programsRepository.findById(programId);

        try {
            if (programsData.isEmpty())
            {
                throw new Exception();
            }
        }
        catch(Exception e) {

        }
        return new ProgramsViewDto(programsData.get());
    }
}
