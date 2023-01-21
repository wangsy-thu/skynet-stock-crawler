package edu.neu.swc.stock.service.async;

import edu.neu.swc.stock.constant.AsyncTaskStatusEnum;
import edu.neu.swc.stock.vo.AsyncTaskInfo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * <h1>异步任务执行监控切面</h1>
 */
@Slf4j
@Aspect
@Component
public class AsyncTaskMonitor {

    /** 注入异步任务管理器 */
    private final AsyncTaskManager asyncTaskManager;

    public AsyncTaskMonitor(AsyncTaskManager asyncTaskManager) {
        this.asyncTaskManager = asyncTaskManager;
    }

    /**
     * <h2>异步任务执行的环绕切面</h2>
     * 环绕切面让我们可以在方法执行之前和执行之后执行一些额外操作
     */
    @Around("execution(* edu.neu.swc.stock.service.async.AsyncServiceImpl.*(..))")
    public Object taskHandle(ProceedingJoinPoint proceedingJoinPoint){
        // 获取taskID，调用异步任务传入的第二个参数
        String taskId = proceedingJoinPoint.getArgs()[0].toString();

        //获取任务信息，在taskManager提交任务的时候已经放入到容器中了
        AsyncTaskInfo taskInfo = asyncTaskManager.getTaskInfo(taskId);

        log.info("AsyncTaskMonitor is monitoring async task:[{}]", taskId);

        taskInfo.setStatus(AsyncTaskStatusEnum.RUNNING);

        //设置为运行状态，并重新放入容器
        asyncTaskManager.setTaskInfo(taskInfo);

        AsyncTaskStatusEnum status;
        Object result;

        try{
            //执行异步任务
            result = proceedingJoinPoint.proceed(); // 分割点
            status = AsyncTaskStatusEnum.SUCCESS;
        }catch (Throwable ex){
            //异步任务出现了异常
            result = null;
            status = AsyncTaskStatusEnum.FAILED;
            log.error("AsyncTaskMonitor: async task [{}] is failed, Error Info:[{}]",
                    taskId,ex.getMessage(),ex);
        }

        //设置任务其他信息，并再次放到容器中
        taskInfo.setEndTime(new Date());
        taskInfo.setStatus(status);
        taskInfo.setTotalTime(String.valueOf(
                taskInfo.getEndTime().getTime() - taskInfo.getStartTime().getTime()
        ));
        asyncTaskManager.setTaskInfo(taskInfo);

        return result;
    }

}
