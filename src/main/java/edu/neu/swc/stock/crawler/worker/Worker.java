package edu.neu.swc.stock.crawler.worker;

import edu.neu.swc.stock.crawler.fetcher.Fetcher;
import edu.neu.swc.stock.crawler.parser.Parser;
import edu.neu.swc.stock.crawler.vo.ParseResult;
import edu.neu.swc.stock.crawler.vo.Request;

/**
 * <h1>工作函数</h1>
 */
public class Worker {
    public static ParseResult process(Request request, Fetcher fetcher, Parser parser) {
        String content = fetcher.fetch(request);
        return parser.parse(content, request.getUrl());
    }
}
