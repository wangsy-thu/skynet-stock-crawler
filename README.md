# 股票爬虫系统
# 一、系统架构
系统主要成分为异步爬虫模块，爬虫模块运行在系统后台，爬取数据后，将数据放入阻塞队列，再由系统的另一个线程从阻塞队列中读取数据进行封装后发送到RabbitMQ。
# 二、运行教程
1. 启动RabbitMQ
2. 启动SpringBoot项目
3. 运行resource/http文件中的http脚本，获取异步任务号
4. 将异步任务号taskId作为参数，替换掉第二个测试命令，并运行脚本
5. Api文档地址：[Api](http://127.0.0.1:9000/crawler/doc.html)
# 三、相关知识点
| 系统知识点             | 应用场景                       |
|-------------------|----------------------------|
| Lambda表达式         | 多线程、forEach循环              |
| 反射与类加载            | AOP基础                      |
| 阻塞队列              | 异步解析Map类型数据                |
| JUC               | 线程池配置、多线程                  |
| IOC               | 系统模块组件化 @Component 注解      |
| AOP               | 异步任务监控器                    |
| 异步任务              | 异步爬虫任务、CommandLineRunner组件 |
| MQ                | 拉取数据发送目标                   |
| Json              | 数据序列化                      |
| Swagger           | 系统文档                       |
| MVC               | 对外提供服务接口                   |
| Docker            | 应用部署                       |
| ConcurrentHashMap | 并发访问map                    |
| PostConstruct     | Bean管理后处理器                 |
# 四、部署教程
1. 修改中间件远程配置配置并打包
2. 将app.jar复制到docker文件夹下
3. 使用Docker安装RabbitMQ
    ```shell
   docker pull rabbitmq:3-management
   docker run \
   -e RABBITMQ_DEFAULT_USER=WangY \
   -e RABBITMQ_DEFAULT_PASS=wsy20010418 \
   --name mq \
   --hostname mq1 \
   -p 15672:15672 \
   -p 5672:5672 \
   -d \
   rabbitmq:3-management
    ```
4. 运行Dockerfile文件
5. 使用镜像创建容器，端口映射 12000:8000
6. 运行两个 http 脚本并测试
7. Api文档地址[部署Api](http://192.168.44.100:12000/crawler/doc.html)
