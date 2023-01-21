package edu.neu.swc.stock.crawler.sink;

import edu.neu.swc.stock.crawler.vo.Item;

/**
 * <h1>保存数据接口定义</h1>
 */
public interface Sink {
    void sink(Item item);
}
