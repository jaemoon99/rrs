package com.jyujyu.review.api;

import com.jyujyu.review.service.TestService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class TestEntityApi {

    private final TestService testService;

    @PostMapping("/test/entity/create")
    public void createTestEntity(
            @RequestBody CreateTestEntityRequest request
    ) {
        testService.create(request.name, request.age);
    }

    @PutMapping("/test/entity/{id}")
    public void putTestEntity(
            @PathVariable(name = "id") Long id,
            @RequestBody CreateTestEntityRequest request
    ) {
        testService.update(id, request.name, request.age);
    }

    @DeleteMapping("/test/entity/{id}")
    public void deleteTestEntity(
            @PathVariable(name = "id") Long id
    ) {
        testService.delete(id);
    }

    @AllArgsConstructor
    @Getter
    public static class CreateTestEntityRequest {
        private final String name;
        private final Integer age;
    }

}
