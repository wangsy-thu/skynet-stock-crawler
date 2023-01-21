package edu.neu.swc.stock.controller;

import edu.neu.swc.stock.crawler.parser.Parser;
import edu.neu.swc.stock.crawler.vo.Request;
import edu.neu.swc.stock.service.async.AsyncTaskManager;
import edu.neu.swc.stock.vo.AsyncTaskInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static edu.neu.swc.stock.constant.UrlConstant.PAGE_PARAM;
import static edu.neu.swc.stock.constant.UrlConstant.ROOT_URL;

/**
 * <h1>爬取数据控制器定义</h1>
 */
@RestController
@RequestMapping("/async-craw")
@Slf4j
@Api(tags = "异步爬取股票数据")
public class AsyncCrawController {

    private final AsyncTaskManager asyncTaskManager;

    private final Parser rootParser;

    public AsyncCrawController(AsyncTaskManager asyncTaskManager, Parser stockParser) {
        this.asyncTaskManager = asyncTaskManager;
        this.rootParser = stockParser;
    }

    @ApiOperation(value = "爬取数据", notes = "异步爬取网站数据信息", httpMethod = "GET")
    @GetMapping("/fetch-data")
    public AsyncTaskInfo crawData() {
        return asyncTaskManager.submit(new Request(ROOT_URL + PAGE_PARAM + 1, rootParser));
    }

    @GetMapping("/task-info")
    @ApiOperation(value = "查询状态",notes = "查询异步任务的执行状态",httpMethod = "GET")
    public AsyncTaskInfo getTaskInfo(@RequestParam String taskId){
        return asyncTaskManager.getTaskInfo(taskId);
    }
}
