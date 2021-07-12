package com.audit.export.App.dao.pdf;
import com.audit.export.App.dao.pdf.entity.Article;
import com.audit.export.App.dao.pdf.entity.ProductGroup;
import com.audit.export.App.dao.pdf.entity.ShopData;

import java.util.List;
public class AuditData {

    public List<ShopData> getShopData() {
        return List.of(
                new ShopData("Period", "01.05.2019 - 31.05.2019 (1905M)"),
                new ShopData("Shop", "3003"),
                new ShopData("Print Date", "10.06.2019")
        );
    }

    public List<ProductGroup> getDataBody() {
        String ft = "10.00\" WXGA 16.0GB FLASH HD 2048MB-RAM ANDROID\n" +
                "5.1.X LOLLIPOP MT8321 3G NO SIM FREE NO GOLD";
        return List.of(
                new ProductGroup(1373, "MEDIATABLETS", List.of(
                        new Article(127395197, "LEAGOO", "LEAPAD 10", ft, "", "", "", ""),
                        new Article(143478032, "LEAGOO", "LEAPAD 10", ft, "", "", "", ""),
                        new Article(111946224, "SAMSUNG", "LEAPAD 10", ft, "", "", "", ""),
                        new Article(111946277, "SAMSUNG", "LEAPAD 10", ft, "", "", "", ""),
                        new Article(125778255, "SAMSUNG", "LEAPAD 10", ft, "", "", "", ""),
                        new Article(134025711, "SAMSUNG", "LEAPAD 10", ft, "", "", "", "")
                )),
                new ProductGroup(1599, "PHABLETS", List.of(
                        new Article(147812747, "LEAGOO", "LEAPAD 10", ft, "", "", "", ""),
                        new Article(147820722, "LEAGOO", "LEAPAD 10", ft, "", "", "", ""),
                        new Article(139140856, "SAMSUNG", "LEAPAD 10", ft, "", "", "", ""),
                        new Article(139441400, "SAMSUNG", "LEAPAD 10", ft, "", "", "", ""),
                        new Article(139586279, "SAMSUNG", "LEAPAD 10", ft, "", "", "", ""),
                        new Article(145908584, "SAMSUNG", "LEAPAD 10", ft, "", "", "", "")
                ))
        );
    }
}