package edu.neu.swc.stock.crawler.fetcher.impl;

import edu.neu.swc.stock.crawler.fetcher.Fetcher;
import edu.neu.swc.stock.crawler.vo.Request;
import org.springframework.stereotype.Component;

/**
 * <h1>正则表达式提取器</h1>
 */
@Component
public class SimpleFetcher implements Fetcher {

    @Override
    public String fetch(Request request) {
        //1,使用httpClient下载html串
        //2,返回
        return "example request";
    }
}
