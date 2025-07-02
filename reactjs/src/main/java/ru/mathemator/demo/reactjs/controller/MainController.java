package ru.mathemator.demo.reactjs.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mathemator.demo.reactjs.dto.MemberDto;
import ru.mathemator.demo.reactjs.dto.ResultRequestPayload;
import ru.mathemator.demo.reactjs.dto.ResultRowDto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class MainController {


    @GetMapping("/api/members")
    public List<MemberDto> members() {
        return List.of(new MemberDto(1, "Т-Банк"),
                new MemberDto(2, "Альфа-Банк"),
                new MemberDto(3, "Сбер"));

    }

    @PostMapping("/api/send")
    public ResponseEntity<Void> send(@RequestBody Object payload) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/api/results/{caseType}")
    public PagedModel<ResultRowDto> getResults(
            @PathVariable String caseType,
            @RequestBody ResultRequestPayload payload,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        // Тестовые данные
        ResultRowDto row = new ResultRowDto();
        row.setSentAt(Instant.now());
        row.setRequestId("req-123");
        row.setTraceId("trace-abc");
        row.setDeliveryTime("1.2s");
        row.setBody("{\"message\": \"ok\"}");
        row.setError(null);

        List<ResultRowDto> content = Collections.nCopies(10, row);

        // Создаём Page из списка вручную
        Page<ResultRowDto> pageImpl = new PageImpl<>(content,
                Pageable.ofSize(size).withPage(page),
                25);

        // Возвращаем как PagedModel
        return new PagedModel(pageImpl);
    }



}
