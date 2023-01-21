package edu.neu.swc.stock.crawler.vo;

import edu.neu.swc.stock.crawler.parser.Parser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>数据抓取请求封装</h1>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    private String url;
    private Parser parser;
}
