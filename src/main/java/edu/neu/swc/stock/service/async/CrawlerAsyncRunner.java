package edu.neu.swc.stock.service.async;

import edu.neu.swc.stock.crawler.engine.Engine;
import edu.neu.swc.stock.crawler.parser.Parser;
import edu.neu.swc.stock.crawler.vo.Request;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;

import static edu.neu.swc.stock.constant.UrlConstant.PAGE_PARAM;
import static edu.neu.swc.stock.constant.UrlConstant.ROOT_URL;

@Slf4j
@SuppressWarnings("all")
public class CrawlerAsyncRunner implements CommandLineRunner {

    private final Engine engine;

    private final Parser rootParser;

    public CrawlerAsyncRunner(Engine engine, Parser stockParser) {
        this.engine = engine;
        this.rootParser = stockParser;
    }


    @Override
    public void run(String... args) {
        new Thread(() -> {
            Request seed = new Request(
                    ROOT_URL + PAGE_PARAM + 1,
                    rootParser
            );
            engine.run(seed);
            log.info("crawler job completed!");
        }).start();
        log.info("crawler start running!");
    }
}
