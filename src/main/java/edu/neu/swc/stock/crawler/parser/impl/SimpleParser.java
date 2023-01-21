package edu.neu.swc.stock.crawler.parser.impl;


import edu.neu.swc.stock.crawler.parser.Parser;
import edu.neu.swc.stock.crawler.vo.ParseResult;
import org.springframework.stereotype.Component;

/**
 * <h1>案例解析器</h1>
 */
@Component
public class SimpleParser implements Parser {

    @Override
    public ParseResult parse(String context, String url) {
        return new ParseResult();
    }
}
