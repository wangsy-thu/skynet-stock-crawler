package edu.neu.swc.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <h1>股票数据爬虫应用启动类</h1>
 * Document url: <a href="http://localhost:9000/crawler/doc.html">接口文档地址</a>
 */
@SpringBootApplication
public class StockCrawlerApplication {
    public static void main(String[] args) {
        SpringApplication.run(StockCrawlerApplication.class, args);
    }
}
