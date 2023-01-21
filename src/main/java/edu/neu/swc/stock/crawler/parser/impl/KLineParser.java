package edu.neu.swc.stock.crawler.parser.impl;

import edu.neu.swc.stock.crawler.parser.Parser;
import edu.neu.swc.stock.crawler.vo.Item;
import edu.neu.swc.stock.crawler.vo.ParseResult;
import edu.neu.swc.stock.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * <h1>K-线图解析器</h1>
 */
@Component(value = "kLineParser")
@Slf4j
public class KLineParser implements Parser {
    @Override
    public ParseResult parse(String context, String url) {
        List<Map<String, Object>> res = JsonUtils.extractKLine(context);
        log.info("parse from url: [{}]", url);
        ParseResult parseResult = new ParseResult();
        for (Map<String, Object> re : res) {
            parseResult.getItems().add(new Item("kLine", re));
        }
        return parseResult;
    }
}
