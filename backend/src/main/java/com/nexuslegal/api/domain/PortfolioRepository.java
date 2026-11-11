package com.nexuslegal.api.domain;
import java.util.*;
public interface PortfolioRepository { Map<String,Object> dashboard(); List<Map<String,Object>> companies(); List<Map<String,Object>> matters(); List<Map<String,Object>> obligations(); List<Map<String,Object>> documents(); List<Map<String,Object>> tasks(); List<Map<String,Object>> audit(); List<Map<String,Object>> search(String term); Map<String,Object> company(long id); void updateMatter(long id,String status); void insertDocument(long orgId,Long matterId,Long companyId,String title,String category,String content,String user); }
