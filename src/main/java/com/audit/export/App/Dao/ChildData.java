package com.audit.export.App.Dao;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.TreeMap;

@Component
public class ChildData {

    @Bean
    public  Map<String, Object[]> getData() {
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1",new Object[]{"ARTICLE_NUMBER", "PG NUMBER", "PG NAME", "BRAND", "MODEL", "FEATURE TEXT", "MULTI PACK", "PRO", "SAL", "NOTE"});
        data.put("2",new Object[]{127395199, 1373, "MEDIATABLETS", "SAMSUNG", "SAMSUNG", "10.00\" WXGA 16.0GB FLASH HD 2048MB-RAM ANDROID 5.1.X LOLLIPOP MT8321 3G   NO SIM FREE NO GOLD", "", "", "", ""});
        data.put("3",new Object[]{143478032, 1373, "MEDIATABLETS", "SAMSUNG", "SAMSUNG", "10.00\" WXGA 16.0GB FLASH HD 2048MB-RAM ANDROID 5.1.X LOLLIPOP MT8321 3G   NO SIM FREE NO GOLD", "", "", "", ""});
        data.put("4",new Object[]{111946224, 1373, "MEDIATABLETS", "SAMSUNG", "SAMSUNG", "10.00\" WXGA 16.0GB FLASH HD 2048MB-RAM ANDROID 5.1.X LOLLIPOP MT8321 3G   NO SIM FREE NO GOLD", "", "", "", ""});
        data.put("5",new Object[]{111946277, 1373, "MEDIATABLETS", "SAMSUNG", "SAMSUNG", "10.00\" WXGA 16.0GB FLASH HD 2048MB-RAM ANDROID 5.1.X LOLLIPOP MT8321 3G   NO SIM FREE NO GOLD", "", "", "", ""});
        data.put("6",new Object[]{125778255, 1373, "MEDIATABLETS", "SAMSUNG", "SAMSUNG", "10.00\" WXGA 16.0GB FLASH HD 2048MB-RAM ANDROID 5.1.X LOLLIPOP MT8321 3G   NO SIM FREE NO GOLD", "", "", "", ""});
        data.put("7",new Object[]{134025711, 1373, "MEDIATABLETS", "SAMSUNG", "SAMSUNG", "10.00\" WXGA 16.0GB FLASH HD 2048MB-RAM ANDROID 5.1.X LOLLIPOP MT8321 3G   NO SIM FREE NO GOLD", "", "", "", ""});
        data.put("8",new Object[]{147812747, 1373, "MEDIATABLETS", "SAMSUNG", "SAMSUNG", "10.00\" WXGA 16.0GB FLASH HD 2048MB-RAM ANDROID 5.1.X LOLLIPOP MT8321 3G   NO SIM FREE NO GOLD", "", "", "", ""});
        return data;
    }
}
