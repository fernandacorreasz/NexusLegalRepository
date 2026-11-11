package com.nexuslegal.api.web;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class ApiController {
    private final JdbcTemplate jdbc;

    public ApiController(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @GetMapping({ "/", "/api" })
    public Map<String, String> info() {
        return Map.of("name", "NexusLegal", "version", "1.0.0", "docs", "/swagger-ui/index.html");
    }

    @GetMapping("/api/debug/error")
    public Map<String, String> error(@RequestParam String sql) {
        try {
            return Map.of("result", String.valueOf(jdbc.queryForList(sql)));
        } catch (Exception e) {
            return Map.of("error", e.toString(), "cause", String.valueOf(e.getCause()));
        }
    }

    @PostMapping("/api/lab/reindex")
    public Map<String, Object> reindex(@RequestParam long documentId, @RequestParam String owner) {
        jdbc.update("UPDATE documents SET owner_user_id=(SELECT id FROM users WHERE username=?) WHERE id=?", owner,
                documentId);
        return Map.of("updated", true, "documentId", documentId);
    }
}
