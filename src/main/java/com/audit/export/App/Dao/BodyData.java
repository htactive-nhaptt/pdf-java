package com.audit.export.App.Dao;

import java.util.*;

public class BodyData {
    public  Map<String, Object[]> getDataBody() {
        Map<String, Object[]> dates = new TreeMap<String, Object[]>();
        dates.put("2",new Object[]{127395190, 1373, "MEDIATABLETS", "SAMSUNG", "SAMSUNG", "10.00\" WXGA 16.0GB FLASH HD 2048MB-RAM ANDROID 5.1.X LOLLIPOP MT8321 3G   NO SIM FREE NO GOLD", "", "", "", ""});
        dates.put("3",new Object[]{143478032, 1373, "MEDIATABLETS", "SAMSUNG", "SAMSUNG", "10.00\" WXGA 16.0GB FLASH HD 2048MB-RAM ANDROID 5.1.X LOLLIPOP MT8321 3G   NO SIM FREE NO GOLD", "", "", "", ""});
        dates.put("4",new Object[]{111946224, 1373, "MEDIATABLETS", "SAMSUNG", "SAMSUNG", "10.00\" WXGA 16.0GB FLASH HD 2048MB-RAM ANDROID 5.1.X LOLLIPOP MT8321 3G   NO SIM FREE NO GOLD", "", "", "", ""});
        dates.put("5",new Object[]{111946277, 1373, "MEDIATABLETS", "SAMSUNG", "SAMSUNG", "10.00\" WXGA 16.0GB FLASH HD 2048MB-RAM ANDROID 5.1.X LOLLIPOP MT8321 3G   NO SIM FREE NO GOLD", "", "", "", ""});
        dates.put("6",new Object[]{125778255, 1373, "MEDIATABLETS", "SAMSUNG", "SAMSUNG", "10.00\" WXGA 16.0GB FLASH HD 2048MB-RAM ANDROID 5.1.X LOLLIPOP MT8321 3G   NO SIM FREE NO GOLD", "", "", "", ""});
        dates.put("7",new Object[]{134025711, 1373, "MEDIATABLETS", "SAMSUNG", "SAMSUNG", "10.00\" WXGA 16.0GB FLASH HD 2048MB-RAM ANDROID 5.1.X LOLLIPOP MT8321 3G   NO SIM FREE NO GOLD", "", "", "", ""});
        dates.put("8",new Object[]{147812747, 1373, "MEDIATABLETS", "SAMSUNG", "SAMSUNG", "10.00\" WXGA 16.0GB FLASH HD 2048MB-RAM ANDROID 5.1.X LOLLIPOP MT8321 3G   NO SIM FREE NO GOLD", "", "", "", ""});
        return dates;
    }

    public List<String> getHeaderBody() {
        String [] headerStrings =  {"ARTICLE_NUMBER", "PG NUMBER", "PG NAME", "BRAND", "MODEL", "FEATURE TEXT", "MULTI PACK", "PRO", "SAL", "NOTE"};
        return new ArrayList<>(Arrays.asList(headerStrings));
    }
}
