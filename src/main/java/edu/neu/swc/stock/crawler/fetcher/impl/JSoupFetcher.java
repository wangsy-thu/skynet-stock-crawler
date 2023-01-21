package edu.neu.swc.stock.crawler.fetcher.impl;

import edu.neu.swc.stock.crawler.fetcher.Fetcher;
import edu.neu.swc.stock.crawler.vo.Request;
import org.springframework.stereotype.Component;

/**
 * <h1>JSoup框架驱动的Fetcher</h1>
 */
@Component
public class JSoupFetcher implements Fetcher {
    @Override
    public String fetch(Request request) {
        return null;
    }
}
