# Redis
 > redis相关的

## 01-数据结构与对象

1. [redis设计与实现1-数据结构与对象篇](https://juejin.im/post/5ea6a705e51d454db74361eb)
   - SDS、链表、字典、跳跃表、整数集合、压缩列表
   - 五大对象用的底层数据结构
2. dict结构扩容需考虑bgsave,缩容不需要考虑？
   - 扩容需要申请额外的很多内存，且会重新链接链表（如果会冲突的话）, 这样会造成很多内存碎片（回收），也会占用更多的内存，造成系统的压力。
   - 而缩容过程中，由于申请的内存比较小，同时会释放掉一些已经使用的内存，不会增大系统的压力。因此不用考虑是否在进行 BGSAVE 操作。

## 02-单机数据库篇

1. [redis设计与实现2-数据库实现篇](https://juejin.im/post/5ea93ca6f265da7bd802a5cf)
   - 持久化、事件、客户端和服务器
2. [深入理解Redis的持久化](https://juejin.im/post/5e5780ade51d452729094c96)

## 03-多机数据库实现篇

1. [redis设计与实现3-复制、Sentinel和集群](https://juejin.im/post/5eb509276fb9a043282a51e2)
   - 复制、Sentinel哨兵机制、集群

2. []()



## 04-独立功能实现篇

1. [redis设计与实现4-订阅和事务](https://juejin.im/post/5eb50a10e51d4524eb4c2804)
   - 发布与订阅、事务
2. [redis设计与实现5-Lua脚本、排序和二进制位数组](https://juejin.cn/post/6902655442258755598/)
   - 监视器

3. 执行大量的Redis命令，担心效率问题,pipeline](https://juejin.im/post/5ef2f028f265da02df1e2ca9)



### 4.1分布式锁、延时队列、位图

1. [bitMap](https://juejin.im/post/6865972904140800008/)
2. [Bitmap避免OOM](https://juejin.im/post/6865974442414391303/)
3. 

### 4.2HyperLogLog(模糊去重）、布隆过滤器

1. hyperLogLog模糊去重占用12k的空间，需考虑成本
2. 默认error_rate=0.01,initial_size=100,如果超过initial_size，误判率会上升

### 4.3限流（简单、漏斗）、GeoHash(附近位置)、Scan

1. Redis-cell模块，漏斗限流，redis4.0开始

### 4.4原理

- 线程IO模型、通信协议、持久化
- 管道pipeline、事务、PubSub、小对象压缩(ziplist)、主从同步



### 4.5集群

- Sentinel、RedisCluster

## 05-拓展

### 5.1Stream、Info、分布式锁

### 5.2过期策略、LRU、懒惰删除

### 5.3Jedis、保护Redis、Redis安全通信



## 06-推荐书籍

1. Redis设计与实现
2. Redis深度历险：核心原理和应用实践
3. Redis实战



## 07-redis

1. [3w字深度好文|Redis面试全攻略](https://juejin.im/post/5e55cd75f265da571d2f27ce)
2. [设计缓存系统：缓存穿透，缓存击穿，缓存雪崩解决方案分析](https://juejin.im/post/5e576b0af265da576e64a01e)
3. [Redis 中的布隆过滤器](https://juejin.im/post/5e576bd6f265da57616a9652)
4. [Redis 布隆过滤器实战「缓存击穿、雪崩效应」](https://juejin.im/post/5e576c6ef265da571e261d73)
5. [Redis开发建议](https://juejin.im/collection/5e020fd5e51d45364b883d4a)
6. [《吊打面试官》系列- Redis基础](https://juejin.im/post/5e577335e51d4526e26283a1)
7. [《吊打面试官》系列-Redis哨兵、持久化、主从、手撕LRU](https://juejin.im/post/5e5777f35188254935092270#heading-8)
8. [《吊打面试官》系列-Redis双写一致性、并发竞争、线程模型](https://juejin.im/post/5e577bb56fb9a07ccb7e97da)
9. [《吊打面试官》系列-Redis常见面试题（带答案）](https://juejin.im/post/5e577ed8518825493d6a9092)
10. 
11. [如何保障mysql和redis之间的数据一致性？](https://juejin.im/post/5e57815be51d4526ec0d3967)
12. [Redis 数据结构+线程模型+持久化+内存淘汰+分布式](https://juejin.im/post/5e57846de51d4526de392af8)
13. [面试01-Redis 如何从海量数据中查询出某一个 Key](https://juejin.im/post/5e5e2137f265da572978947c)
14. [面试02-Redis 中的过期元素是如何被处理的？](https://juejin.im/post/5e5e21fce51d4526ff0259df)
15. [Redlock 算法-主从redis分布式锁主节点宕机锁丢失的问题](https://juejin.im/post/5e661883518825490b649130)

