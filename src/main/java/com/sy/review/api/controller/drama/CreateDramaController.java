package com.sy.review.api.controller.drama;

import com.sy.review.api.controller.drama.dto.CreateDramaRequest;
import com.sy.review.api.service.drama.CreateDramaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/drama")
public class CreateDramaController {
    private final CreateDramaService createDramaService;

    @PostMapping
    public void createDrama(@RequestBody CreateDramaRequest request) {
        createDramaService.execute(request.toServiceCommand());
    }
}
