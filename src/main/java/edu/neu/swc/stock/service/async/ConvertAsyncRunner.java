package edu.neu.swc.stock.service.async;

import edu.neu.swc.stock.receiver.BlockingReceiverManager;
import edu.neu.swc.stock.send.StockSink;
import edu.neu.swc.stock.utils.ConvertUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class ConvertAsyncRunner implements CommandLineRunner {

    private final BlockingReceiverManager receiver;

    private final StockSink stockSink;

    public ConvertAsyncRunner(BlockingReceiverManager receiver, StockSink stockSink) {
        this.receiver = receiver;
        this.stockSink = stockSink;
    }

    @Override
    public void run(String... args) {
        new Thread(() -> {
            while (true) {
                Map<String, Object> result = receiver.blockingFetchByQueueName("company");
                stockSink.sinkStock(ConvertUtil.convert(result));
            }
        }).start();

        new Thread(() -> {
            while (true) {
                Map<String, Object> result = receiver.blockingFetchByQueueName("kLine");
                log.info("get k-line: [{}]", result);
            }
        }).start();
    }
}
