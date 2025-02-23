package com.sy.review.api.controller.drama;

import com.sy.review.api.controller.drama.dto.CreateDramaRequest;
import com.sy.review.api.service.drama.CreateDramaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Tag(name = "드라마 생성", description = "드라마 생성 컨트롤러입니다.")
@RestController
@RequestMapping("/api/drama")
public class CreateDramaController {
    private final CreateDramaService createDramaService;

    @Operation(summary = "드라마 등록", description = "드라마 추가 등록합니다.")
    @PostMapping
    public void createDrama(@RequestBody CreateDramaRequest request) {
        createDramaService.execute(request.toServiceCommand());
    }
}
