package com.nexuslegal.api.web;
import com.nexuslegal.api.application.PortfolioService; import io.swagger.v3.oas.annotations.security.SecurityRequirement; import jakarta.validation.Valid; import jakarta.validation.constraints.*; import org.springframework.http.HttpStatus; import org.springframework.security.core.Authentication; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api") @SecurityRequirement(name="basicAuth") @CrossOrigin(origins="*") public class PortfolioController {private final PortfolioService service;public PortfolioController(PortfolioService service){this.service=service;}
 public record DocumentRequest(Long matterId,Long companyId,@NotBlank String title,@NotBlank String category,@NotBlank String content){}
 @GetMapping("/dashboard") public Map<String,Object> dashboard(){return service.dashboard();}
 @GetMapping("/companies") public List<Map<String,Object>> companies(){return service.companies();}
 @GetMapping("/companies/{id}") public Map<String,Object> company(@PathVariable long id){return service.company(id);}
 @GetMapping("/matters") public List<Map<String,Object>> matters(){return service.matters();}
 @PutMapping("/matters/{id}/status") public Map<String,Object> status(@PathVariable long id,@RequestParam String value){service.updateMatter(id,value);return Map.of("updated",true,"id",id,"status",value);}
 @GetMapping("/obligations") public List<Map<String,Object>> obligations(){return service.obligations();}
 @GetMapping("/documents") public List<Map<String,Object>> documents(){return service.documents();}
 @PostMapping("/documents") @ResponseStatus(HttpStatus.CREATED) public Map<String,Object> document(@RequestBody @Valid DocumentRequest r,Authentication auth){service.insertDocument(r.matterId(),r.companyId(),r.title(),r.category(),r.content(),auth.getName());return Map.of("created",true);}
 @GetMapping("/tasks") public List<Map<String,Object>> tasks(){return service.tasks();}
 @GetMapping("/audit") public List<Map<String,Object>> audit(){return service.audit();}
 @GetMapping("/search") public List<Map<String,Object>> search(@RequestParam String q){return service.search(q);}
}
