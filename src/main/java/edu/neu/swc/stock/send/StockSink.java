package edu.neu.swc.stock.send;

import edu.neu.swc.stock.domain.StockEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * <h1>Stock信息存储</h1>
 */
@Component
@Slf4j
public class StockSink {
    private final RabbitTemplate rabbitTemplate;

    public StockSink(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sinkStock(StockEntity stock) {
        rabbitTemplate.convertAndSend("stock.cache", stock);
    }
}
