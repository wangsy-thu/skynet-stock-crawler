package edu.neu.swc.stock.service.async;

import edu.neu.swc.stock.crawler.vo.Request;

/**
 * <h1>异步任务接口定义</h1>
 */
public interface IAsyncService {
    void asyncCrawJob(String taskId, Request ...seed);
}
