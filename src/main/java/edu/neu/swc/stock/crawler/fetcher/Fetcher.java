package edu.neu.swc.stock.crawler.fetcher;


import edu.neu.swc.stock.crawler.vo.Request;

/**
 * <h1>下载器接口定义</h1>
 */
public interface Fetcher {
    String fetch(Request request);
}
