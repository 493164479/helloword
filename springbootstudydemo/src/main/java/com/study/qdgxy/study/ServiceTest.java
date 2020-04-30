package com.study.qdgxy.study;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ServiceTest {

    public static void main(String[] args) throws Exception {
        List<Context> all = ServiceTest.getAll();
        for (Context context : all) {
            System.out.println(context.getImg());
        }
    }

        public static List<Context> getAll() throws Exception {
            //https://search.jd.com/Search?keyword=web
            String url = "https://search.jd.com/Search?keyword=web";
            Document document = Jsoup.parse(new URL(url), 30000);
            Element element = document.getElementById("J_goodsList");
            Elements elementsByClass = element.getElementsByClass("gl-i-wrap");
            List<Context> list = new ArrayList<>();
            for (Element byClass : elementsByClass) {
                String img = byClass.getElementsByTag("img").attr("source-data-lazy-img");
                String name = byClass.getElementsByClass("p-name").eq(0).text();
                String price = byClass.getElementsByClass("p-price").eq(0).text();
                Context context = new Context(name, price, img);
                list.add(context);
            }
            return list;
        }
}
