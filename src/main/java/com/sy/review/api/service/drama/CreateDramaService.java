package com.sy.review.api.service.drama;

import com.sy.review.api.service.drama.dto.CreateDramaServiceCommand;
import com.sy.review.domain.drama.DramaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateDramaService {
    private final DramaRepository dramaRepository;

    public void execute(CreateDramaServiceCommand command) {
        dramaRepository.save(command.toChangeEntity());
    }
}
