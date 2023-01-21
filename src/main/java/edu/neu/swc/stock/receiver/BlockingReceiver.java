package edu.neu.swc.stock.receiver;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

@Slf4j
public class BlockingReceiver {
    private final BlockingQueue<Map<String, Object>> channel;

    public BlockingReceiver() {
        channel = new LinkedBlockingDeque<>();
    }

    public Map<String, Object> blockingFetch() {
        try {
            return channel.take();
        } catch (InterruptedException e) {
            log.error("fetch error");
        }
        return null;
    }

    public void insert(Map<String, Object> item) {
        try {
            this.channel.put(item);
        } catch (InterruptedException e) {
            log.error("put error");
        }
    }

}
