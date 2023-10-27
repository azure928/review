package com.ji.review.api;

import com.ji.review.model.TestEntity;
import com.ji.review.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TestQueryApi {
    private final TestService testService;

    @GetMapping("/test/query/jpa")
    public List<TestEntity> queryJpa() {
        return testService.findAllByNameByJPA("ji");
    }

    @GetMapping("/test/query/querydsl")
    public List<TestEntity> queryQuerydsl() {
        return testService.findAllByNameByQuerydsl("ji");
    }
}
