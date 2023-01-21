package edu.neu.swc.stock.crawler.sink.impl;

import edu.neu.swc.stock.crawler.sink.Sink;
import edu.neu.swc.stock.crawler.vo.Item;
import edu.neu.swc.stock.receiver.BlockingReceiverManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SimpleSink implements Sink {

    private final BlockingReceiverManager receiver;

    public SimpleSink(BlockingReceiverManager blockingReceiverManager) {
        this.receiver = blockingReceiverManager;
    }

    @Override
    public void sink(Item item) {
        this.receiver.insertByQueueName(item.getTag(), item.getInfo());
    }
}
