package edu.neu.swc.stock.crawler.parser.impl;

import edu.neu.swc.stock.crawler.parser.Parser;
import edu.neu.swc.stock.crawler.vo.Item;
import edu.neu.swc.stock.crawler.vo.ParseResult;
import edu.neu.swc.stock.crawler.vo.Request;
import edu.neu.swc.stock.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static edu.neu.swc.stock.constant.UrlConstant.*;

@Component
@Slf4j
public class StockParser implements Parser {

    private final Parser kLineParser;

    public StockParser(Parser kLineParser) {
        this.kLineParser = kLineParser;
    }

    @Override
    public ParseResult parse(String context, String url) {
        ParseResult r = new ParseResult();
        context = context.replace(STRIP_PREFIX_STR, "");
        context = context.replace(STRIP_SUFFIX_STR, "");
        List<Map<String, Object>> results = JsonUtils.extractStockList(context);

        // 解析公司具体数据
        for (Map<String, Object> result : results) {
            r.getItems().add(new Item("company", result));
            Request kLineReq = new Request(
                    K_LINE_URL + K_LINE_PARAM + result.get("SECURITY_CODE"),
                    kLineParser
            );
            r.getRequests().add(kLineReq);
        }

        // 寻找新的公司
        int pageNum = Integer.parseInt(url.split(PAGE_PARAM)[1]);
        pageNum++;
        if(pageNum < TOTAL_PAGE_NUM) {
            r.getRequests().add(
                    new Request(
                            ROOT_URL + PAGE_PARAM + pageNum,
                            this
                    )
            );
        }
        return r;
    }
}
