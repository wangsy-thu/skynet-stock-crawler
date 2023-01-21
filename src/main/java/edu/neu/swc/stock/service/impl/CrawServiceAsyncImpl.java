package edu.neu.swc.stock.service.impl;

import edu.neu.swc.stock.crawler.engine.Engine;
import edu.neu.swc.stock.crawler.parser.Parser;
import edu.neu.swc.stock.crawler.vo.Request;
import edu.neu.swc.stock.service.ICrawService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <h1>爬虫任务异步实现</h1>
 */
@Service(value = "crawAsyncService")
@Slf4j
public class CrawServiceAsyncImpl implements ICrawService {
    private final Engine engine;

    private final Parser rootParser;

    public CrawServiceAsyncImpl(Engine engine, Parser stockParser) {
        this.engine = engine;
        this.rootParser = stockParser;
    }

    public void startAsyncCrawler(Request request) {
        request.setParser(rootParser);
        new Thread(() -> {
            engine.run(request);
            log.info("crawler job completed!");
        }).start();
        log.info("crawler job started!");
    }
}
