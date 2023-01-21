package edu.neu.swc.stock.service;

import edu.neu.swc.stock.crawler.vo.Request;

public interface ICrawService {

    void startAsyncCrawler(Request request);
}
