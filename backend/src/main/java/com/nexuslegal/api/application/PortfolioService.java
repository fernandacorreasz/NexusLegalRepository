package com.nexuslegal.api.application;

import com.nexuslegal.api.domain.PortfolioRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PortfolioService {
    private final PortfolioRepository repo;

    public PortfolioService(PortfolioRepository repo) {
        this.repo = repo;
    }

    public Map<String, Object> dashboard() {
        return repo.dashboard();
    }

    public List<Map<String, Object>> companies() {
        return repo.companies();
    }

    public List<Map<String, Object>> matters() {
        return repo.matters();
    }

    public List<Map<String, Object>> obligations() {
        return repo.obligations();
    }

    public List<Map<String, Object>> documents() {
        return repo.documents();
    }

    public List<Map<String, Object>> tasks() {
        return repo.tasks();
    }

    public List<Map<String, Object>> audit() {
        return repo.audit();
    }

    public List<Map<String, Object>> search(String q) {
        return repo.search(q == null ? "" : q);
    }

    public Map<String, Object> company(long id) {
        return repo.company(id);
    }

    public void updateMatter(long id, String status) {
        repo.updateMatter(id, status);
    }

    public void insertDocument(Long matter, Long company, String title, String category, String content, String user) {
        repo.insertDocument(1L, matter, company, title, category, content, user);
    }
}
