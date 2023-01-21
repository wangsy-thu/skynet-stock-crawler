package edu.neu.swc.stock.service.async;

import edu.neu.swc.stock.constant.AsyncTaskStatusEnum;
import edu.neu.swc.stock.crawler.vo.Request;
import edu.neu.swc.stock.vo.AsyncTaskInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * <h1>异步任务执行管理器</h1>
 * 对异步任务进行包装管理，记录并塞入异步任务的执行信息
 */
@Slf4j
@Component
public class AsyncTaskManager {
    /** 异步任务执行信息的容器 */
    private final Map<String, AsyncTaskInfo> taskContainer =
            new HashMap<>(16);

    private final IAsyncService asyncService;

    public AsyncTaskManager(IAsyncService asyncService) {
        this.asyncService = asyncService;
    }

    /**
     * <h2>初始化异步任务</h2>
     */
    public AsyncTaskInfo initTask(){
        AsyncTaskInfo taskInfo = new AsyncTaskInfo();

        //设置一个唯一的异步任务ID，唯一即可
        taskInfo.setTaskId(UUID.randomUUID().toString());
        taskInfo.setStatus(AsyncTaskStatusEnum.STARTED);
        taskInfo.setStartTime(new Date());

        //初始化的时候就要把异步任务执行信息存储到容器中
        taskContainer.put(taskInfo.getTaskId(),taskInfo);
        return taskInfo;
    }

    /**
     * <h2>提交异步任务</h2>
     */
    public AsyncTaskInfo submit(Request ...seed){

        //初始化一个异步任务的监控信息
        AsyncTaskInfo taskInfo = initTask();
        asyncService.asyncCrawJob(taskInfo.getTaskId(), seed);
        return taskInfo;
    }

    /**
     * <h2>设置异步任务执行状态信息</h2>
     */
    public void setTaskInfo(AsyncTaskInfo taskInfo){
        taskContainer.put(taskInfo.getTaskId(),taskInfo);
    }

    /**
     * <h2>获取异步任务</h2>
     */
    public AsyncTaskInfo getTaskInfo(String taskId){
        return taskContainer.get(taskId);
    }
}
