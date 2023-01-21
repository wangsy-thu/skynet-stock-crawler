package edu.neu.swc.stock.crawler.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * <h1>爬取的结果</h1>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    /* Item 的类型标识字段 */
    private String tag;
    private Map<String, Object> info;
}
