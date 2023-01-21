package edu.neu.swc.stock.crawler.parser;


import edu.neu.swc.stock.crawler.vo.ParseResult;

/**
 * <h1>页面解析器接口定义</h1>
 */
public interface Parser {
    ParseResult parse(String context, String url);
}
