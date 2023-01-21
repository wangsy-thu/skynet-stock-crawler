package edu.neu.swc.stock.crawler.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>解析结果</h1>
 */
@Data
@AllArgsConstructor
public class ParseResult {
    private List<Request> requests;
    private List<Item> items;

    public ParseResult() {
        requests = new ArrayList<>();
        items = new ArrayList<>();
    }
}
