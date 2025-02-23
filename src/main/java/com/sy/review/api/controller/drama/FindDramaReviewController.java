package com.sy.review.api.controller.drama;

import com.sy.review.api.controller.drama.dto.FindDramaReviewResponse;
import com.sy.review.api.service.drama.FindDramaReviewService;
import com.sy.review.domain.drama.DramaReview;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/drama/review")
public class FindDramaReviewController {
    private final FindDramaReviewService findDramaReviewService;

    @ApiResponse(responseCode = "200", description = "조회 성공",
            content = @Content(
                    schema = @Schema(implementation = FindDramaReviewResponse.class),
                    examples = {
                            @ExampleObject(
                                    name = "dramaId 내림 차순 기준으로 전체 드라마 리스트 출력",
                                    value = "[\n"
                                            + "  {\n"
                                            + "    \"dramaId\": 103,\n"
                                            + "    \"dramaReviewId\": 1003,\n"
                                            + "    \"memberId\": 5003,\n"
                                            + "    \"dramaReviewTitle\": \"최고의 연기\",\n"
                                            + "    \"dramaTitle\": \"응답하라 1988\"\n"
                                            + "  },\n"
                                            + "  {\n"
                                            + "    \"dramaId\": 102,\n"
                                            + "    \"dramaReviewId\": 1002,\n"
                                            + "    \"memberId\": 5002,\n"
                                            + "    \"dramaReviewTitle\": \"감동적인 이야기\",\n"
                                            + "    \"dramaTitle\": \"미스터 션샤인\"\n"
                                            + "  },\n"
                                            + "  {\n"
                                            + "    \"dramaId\": 101,\n"
                                            + "    \"dramaReviewId\": 1001,\n"
                                            + "    \"memberId\": 5001,\n"
                                            + "    \"dramaReviewTitle\": \"재밌는 드라마!\",\n"
                                            + "    \"dramaTitle\": \"나의 아저씨\"\n"
                                            + "  }\n"
                                            + "]\n"
                            )
                    }
            )
    )
    @GetMapping
    public FindDramaReviewResponse findAllDramaReviews(
            @Parameter(description = "페이지 번호 (1부터 시작)", example = "1")
            @RequestParam(defaultValue = "1")  @Min(value = 1, message = "페이지 번호는 1 이상 입니다.") Integer page,

            @Parameter(description = "페이지 사이즈", example = "10")
            @RequestParam(defaultValue = "10") @Min(value = 10, message = "10개 이상만 조회 가능합니다.") @Max(value = 100, message = "100을 넘을 수 없습니다.") Integer size
    ) {
        List<DramaReview> dramaReviews = findDramaReviewService.findAllDramaReview(PageRequest.of(page - 1, size, Sort.by(Sort.Direction.DESC, "id")));
        return FindDramaReviewResponse.of(dramaReviews);
    }
}