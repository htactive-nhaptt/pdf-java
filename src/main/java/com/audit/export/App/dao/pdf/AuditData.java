package com.audit.export.App.dao.pdf;

import java.util.Map;
import java.util.TreeMap;

public class AuditData {
    public Map<String, Object[]> getAuditData() {
        Map<String, Object[]> dates = new TreeMap<>();
        dates.put("1", new Object[]{"BRAND", "MODEL", "FEATURE TEXT", "M.P.", "ARTICLE", "PRO", "SAL"});
        dates.put("2", new Object[]{"BRAND", "MODEL", "FEATURE TEXT", "M.P.", "ARTICLE", "PRO", "SAL"});
        dates.put("3", new Object[]{"BRAND", "MODEL", "FEATURE TEXT", "M.P.", "ARTICLE", "PRO", "SAL"});
        dates.put("4", new Object[]{"BRAND", "MODEL", "FEATURE TEXT", "M.P.", "ARTICLE", "PRO", "SAL"});
        dates.put("5", new Object[]{"BRAND", "MODEL", "FEATURE TEXT", "M.P.", "ARTICLE", "PRO", "SAL"});
        dates.put("6", new Object[]{"BRAND", "MODEL", "FEATURE TEXT", "M.P.", "ARTICLE", "PRO", "SAL"});
        dates.put("7", new Object[]{"BRAND", "MODEL", "FEATURE TEXT", "M.P.", "ARTICLE", "PRO", "SAL"});
        dates.put("8", new Object[]{"BRAND", "MODEL", "FEATURE TEXT", "M.P.", "ARTICLE", "PRO", "SAL"});
        return dates;
    }
}
