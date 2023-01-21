package edu.neu.swc.stock.crawler.engine;


import edu.neu.swc.stock.crawler.fetcher.Fetcher;
import edu.neu.swc.stock.crawler.vo.Item;
import edu.neu.swc.stock.crawler.vo.ParseResult;
import edu.neu.swc.stock.crawler.vo.Request;
import edu.neu.swc.stock.crawler.worker.Worker;
import edu.neu.swc.stock.crawler.sink.Sink;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Queue;

import static edu.neu.swc.stock.constant.UrlConstant.FETCH_INTERVAL;

@Component
@Slf4j
@SuppressWarnings("all")
public class Engine {
    private final Queue<Request> requestQueue;
    private final Fetcher fetcher;
    private final Sink sink;

    public Engine(Fetcher httpFetcher, Sink simpleSink) {
        this.requestQueue = new LinkedList<>();
        this.fetcher = httpFetcher;
        this.sink = simpleSink;
    }

    public void run(Request ...seed) {
        for (Request request : seed) {
            requestQueue.offer(request);
        }
        while(!requestQueue.isEmpty()) {
            // 1,从请求队列中获取一个请求
            Request req = requestQueue.poll();
            // 2,处理请求
            ParseResult result = Worker.process(req, fetcher, req.getParser());
            // 3,存储解析出来的 Item
            for (Item item : result.getItems()) {
                sink.sink(item);
            }
            // 4,将解析出来的 URL 放入队列
            for (Request newRequest : result.getRequests()) {
                requestQueue.offer(newRequest);
            }
            log.info("fetched a page");
            try {
                Thread.sleep(FETCH_INTERVAL * 1000);
            } catch (InterruptedException e) {
                log.info("sleeping error");
            }
        }
    }
}
