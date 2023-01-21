package edu.neu.swc.stock.service.async;

import edu.neu.swc.stock.crawler.engine.Engine;
import edu.neu.swc.stock.crawler.vo.Request;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service(value = "asyncService")
@Transactional
public class AsyncServiceImpl implements IAsyncService{

    private final Engine engine;

    public AsyncServiceImpl(Engine engine) {
        this.engine = engine;
    }

    @Override
    @Async("getAsyncExecutor")
    public void asyncCrawJob(String taskId, Request... seed) {
        log.info("async crawler job started, taskId:[{}]", taskId);
        engine.run(seed);
    }
}
