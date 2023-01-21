package edu.neu.swc.stock.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
public class BlockingReceiverManager {

    private final Map<String, Object> blockingQueueMap;

    public BlockingReceiverManager() {
        this.blockingQueueMap = new ConcurrentHashMap<>();
    }

    @PostConstruct
    public void init() {
        this.registerBlockingQueue("company");
        this.registerBlockingQueue("kLine");
    }

    public void registerBlockingQueue(String queueName) {
        BlockingReceiver receiver = new BlockingReceiver();
        this.blockingQueueMap.put(queueName, receiver);
    }

    public Map<String, Object> blockingFetchByQueueName(String queueName) {
        BlockingReceiver blockingReceiver = (BlockingReceiver) this.blockingQueueMap.get(queueName);
        return blockingReceiver.blockingFetch();
    }

    public void insertByQueueName(String queueName, Map<String, Object> item) {
        BlockingReceiver blockingReceiver = (BlockingReceiver) this.blockingQueueMap.get(queueName);
        blockingReceiver.insert(item);
    }
}
