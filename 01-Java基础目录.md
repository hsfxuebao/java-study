# Java基础
 > 主要包含JVM,java基础,多线程等

## 01-JVM

### 01-内存和垃圾回收

1. [JVM面试知识点（GC、参数、引用）](https://juejin.im/post/5e7c90c5f265da42cc3e1b24)
2. [对象和数组并不是都是在堆上分配内存的](https://juejin.im/post/5e53961ff265da5740641f12)
3. [JVM虚拟机CMS和G1收集器详解](https://juejin.im/post/5e43a766518825497467ea13)
4. [JVM系列(一) - JVM总体概述](https://juejin.im/post/5e43abe9518825492b50a37c)
5. [JVM系列(二) - JVM内存区域](https://juejin.im/post/5e4a4b7ef265da572c5485f4)
6. [JVM系列(三) - JVM对象探秘](https://juejin.im/post/5e4b464a6fb9a07ccd518105)
7. [JVM系列(四) - JVM类加载机制详解](https://juejin.im/post/5e4b4981f265da57697103d3)
8. [JVM系列(五) - JVM垃圾回收算法](https://juejin.im/post/5e4cb4cbe51d4526c70fa545)
9. [JVM系列(六) - JVM垃圾回收器](https://juejin.im/post/5e4cbafbe51d4526c550a601)
10. [JVM系列(七) - JVM线上监控工具](https://juejin.im/post/5e4cbb98e51d4526f65cbdad)
11. [《深入理解Java虚拟机》第2版挖的坑终于在第3版中被R大填平了](https://juejin.im/post/5e4a46c8518825496452a9e2)
12. [并发的可达性分析](https://juejin.im/post/5e63ab6251882549165423a1)
13. [Java堆内存是线程共享的！面试官：你确定吗？](https://juejin.im/post/5e66f59f6fb9a07cde64e6da)



强烈推荐：

1. [JVM(一)-JVM与Java体系结构](https://juejin.im/post/5e8e934be51d4546b4351079)
2. [JVM(二)-类加载子系统](https://juejin.im/post/5e8d6c1a6fb9a03c840d60ef)
3. [JVM(三)-运行时数据区（栈和程序计数器）](https://juejin.im/post/5e8edda45188257394723c74)

### 02-字节码与类加载

### 03-性能监控和调优

1. [JDK监控和故障处理工具揭秘](https://juejin.im/post/5e43a7e051882549417fbcf9)
2. [阿里巴巴开源的 Java 诊断工具Arthas【入门篇】](https://juejin.im/post/5e537a1be51d4526d0595347)
3. [cpu使用率过高和jvm old占用过高排查过程](https://juejin.im/post/5e74174ce51d4527196d7708)



### 04-推荐书籍

1. Java虚拟机规范（Java SE 8版）
2. 深入理解Java虚拟机（第三版）
3. 深入理解JVM & G1 GC
4. 揭秘Java虚拟机（JVM设计原理与实现）
5. Java虚拟机基础教程
6. 实战Java虚拟机（JVM故障诊断与性能优化）
7. Java虚拟机精讲

## 02-集合
### 01-Map
![image-20200412085830424](/Users/hsfxuebao/Library/Application Support/typora-user-images/image-20200412085830424.png)

1. [HashMap源码解读](https://juejin.im/post/5e4222b0518825492e494e19)   *********
2. [为啥HashMap的默认容量是16？](https://juejin.im/post/5e7c2bbff265da42bc796f6e)
3. [图解HashMap(一) ](https://juejin.im/post/5e7b47acf265da573d61cff5)  *********
4. [图解HashMap(二)](https://juejin.im/post/5e7b48c46fb9a07cdb469e66)   *********
5. [图解LinkedHashMap原理](https://juejin.im/post/5e74c4016fb9a07ca601c97a)   *
6. [LinkedHashMap源码解读](https://juejin.im/post/5e42242be51d4526c654b4e1)  
7. [图解TreeMap](https://juejin.im/post/5e7b4f2a5188255e277a3a8e)   *
10. [图解红黑树原理](https://juejin.im/post/5e7c18476fb9a009912d8b84) 

### 02-Collection

![image-20200412085904184](/Users/hsfxuebao/Library/Application Support/typora-user-images/image-20200412085904184.png)

#### 00-集合入门

1. [Java容器集合之入门](https://juejin.im/post/5e422053e51d4526e262749e)

#### 01-Set

1. HashSet
2. TreeSet

#### 02-List

1. [ArrayList源码](https://juejin.im/post/5e422191518825492c04f68f)  *********
2. [Vector & LinkedList源码](https://juejin.im/post/5e422204e51d4526e418f39b)  *********
3. Stack

#### 03-Queue

1. [解读 Java 并发队列 BlockingQueue](https://juejin.im/post/5e7b53d16fb9a07c951d045c) **
2. PriorityQueue

## 03-并发编程
### 01-并发编程的挑战

1. [并发编程1-上下文切换和死锁](https://juejin.im/post/5e926a296fb9a03c840d6792)

### 02-并发机制的底层实现原理

1. [volatile 相关整理](https://juejin.im/post/5e522439e51d4526ff024ee9)
2. [并发面试知识点（volatile、JMM、锁、CAS、阻塞队列、线程池、死锁）](https://juejin.im/post/5e7c6ec851882535f43973fe)
3. [Synchronized锁升级](https://juejin.im/post/5e7adfc1f265da5770145cc2) *********
4. [Synchronized实现原理（方法代码块）](https://juejin.im/post/5e7c5c686fb9a009612de451)  *********
5. [Synchronized及其实现原理](https://juejin.im/post/5e7485f1f265da570a5d69aa)
6. [Monitor（管程）是什么意思？Java中Monitor（管程）的介绍](https://juejin.im/post/5e7c5e62e51d455c1d67b0e9)    *********
7. [Java并发编程—并发流程控制与AQS原理及相关源码解析](https://juejin.im/post/5e551be0f265da572017ebd8#heading-25)
8. [Java如何实现原子操作（CAS或锁）](https://juejin.im/post/5e927e68e51d4546e5570c06)
9. [原子操作的实现原理](https://juejin.im/post/5e92d935f265da47b725e80a)

### 03-Java内存模型

1. [Java内存模型](https://juejin.im/post/5e930ef6518825739f6b0f60)
   - 重排序、final域、happens-before

### 04-并发编程基础

1. [Java并发基础-线程简介（状态、常用方法）](https://juejin.im/post/5e9304776fb9a03c3b2bcafe)join,sleep,yield方法等
2. [理解Object的wait,notify,notifyAll与Thread的sleep,yield,join等方法](https://juejin.im/post/5e62fc3951882548ff3aa578)
3. [线程的中断(interrupt)机制](https://juejin.im/post/5e72d0b0f265da5735507150)
4. [深入理解java中的线程](https://juejin.im/post/5e7c68c26fb9a009a52f54b2)
5. [诡异的并发之原子性](https://juejin.im/post/5e5db07cf265da574727969a)
6. [Java并发基础-启动和终止线程](https://juejin.im/post/5e93069ee51d454709220c8c)
7. [Java并发基础-线程间通信](https://juejin.im/post/5e930590f265da47b1779997) 
   - wait，notify
   - ThreadLocal
8. [并发容器之ThreadLocal](https://juejin.im/post/5e05789fe51d45584c554628)
9. [从源码深入详解ThreadLocal内存泄漏问题](https://juejin.im/post/5e057453518825127424c0e0)
10. [线程封闭](https://juejin.im/post/5e5e0f74e51d4526c3590685)
11. [Random和ThreadLocalRandom区别](https://juejin.im/post/5e72f70ff265da573a021410)

### 05-Java中的锁

1. [Java中的锁(Lock、重入锁、读写锁、队列同步器、Condition)](https://juejin.im/post/5e92dacce51d4546b50d474c#heading-7)

### 06-并发容器及框架

1. [ConcurrentHashMap1.7分段锁原理](https://juejin.im/post/5e929f02f265da47d6451baa)
2. [ConcurrentHashMap1.8源码 ](https://juejin.im/post/5e421fc0e51d4526c5509f54)  *********
3. [ConcurrentHashMap & HashTable](https://juejin.im/post/5e42249fe51d4526cc3b17f0)  
4. [Java 中的阻塞队列](https://juejin.im/post/5e92d6b26fb9a03c6f66fef3)
5. [ConcurrentLinkedQueue 的实现原理分析](https://juejin.im/post/5e92d745e51d45470125725e)
6. [Java并发 -- Fork/Join框架](https://juejin.im/post/5e527a8a6fb9a07c8a5a158b)

### 07-Java中的13个原子操作类

1. [Java中的13个原子操作类](https://juejin.im/post/5e9302b2f265da47c4321d2f)

### 08-并发工具类

1. [（CountDownLatch、CyclicBarrier、Semaphore、Exchanger）](https://juejin.im/post/5e7c6a94e51d455c7275d419)

### 09-线程池和Executor框架

1. [JAVA 线程池的分析和使用](https://juejin.im/post/5e92d8b151882573bf179116)
2. [ThreadPoolExecutor原理分析](https://juejin.im/post/5e929b53e51d4547134bdad5)
3. [线程池execute和submit区别](https://juejin.im/post/5e5bb18ce51d45270b7d646c)
4. [如何正确使用线程池submit和execute方法](https://juejin.im/post/5e72d6f66fb9a07cad3bbddf)
5. [ThreadPoolExecutor八种拒绝策略浅析](https://juejin.im/post/5e34e0206fb9a02ff7297959)
6. [异步技巧之CompletableFuture](https://juejin.im/post/5e7abaaae51d452716052f86)  **
7. [线程池中的空余线程是如何被回收的](https://juejin.im/post/5e7221a3e51d4527235b7f67)



## 04-常用类

### 01-Object

1. [equals 和 hashCode方法](https://juejin.im/post/5e42225551882549122aa038)

## 05-反射机制

1. [分析cglib动态代理的实现](https://juejin.im/post/5e34e2575188254df8741a61)
2. [分析JDK动态代理的实现](https://juejin.im/post/5e34e208e51d4558850ea8e6)
3. [谈谈Java反射：从入门到实践，再到原理](https://juejin.im/post/5e7c2af3f265da42e16b02b0)
4. [Java的反射中，Class.forName和ClassLoader的区别](https://juejin.im/post/5e8043fbe51d454708476b88)

## 06-Java8特性

1. [了解lambda及函数式接口](https://juejin.im/post/5e14879e5188253a9c440f1d)
2. [建议你使用LocalDateTime](https://juejin.im/post/5d7787625188252388753eae)
3. [Java8日期和时间API](https://juejin.im/post/5e52250fe51d45271355161e)
4. [Java Stream 相关操作](https://juejin.im/post/5e526912f265da5709701da1)

## 07-其他

1. [Comparable和Comparator](https://juejin.im/post/5e5376906fb9a07c9d6f9f34)
2. [深入理解Java中的逃逸分析](https://juejin.im/post/5e539a49f265da5747278dbf)
3. [深入分析Java编译原理](https://juejin.im/post/5e539aece51d45271c2fefc1)
4. [为什么不能轻易修改 serialVersionUID 字段](https://juejin.im/post/5e5f3109f265da572b767aaa)
5. [如何优雅的在java中统计代码块耗时](https://juejin.im/post/5e62f3696fb9a07cbe34750a)
6. [Java泛型-4（类型擦除后如何获取泛型参数）](https://juejin.im/post/5e6f1bcdf265da5711264b61)
7. [你真的搞清位运算了么？](https://juejin.im/post/5e731f94f265da575a6a2d9d)
8. [进程和线程的主要区别](https://juejin.im/post/5e74c15de51d4526f45a9559)
9. [浮点数在计算机中存储方式](https://juejin.im/post/5e757c10e51d4526f94a181f)

## 08-Netty

1. [Java-Netty高性能高并发](https://juejin.im/post/5e65c21b518825490966ebf0)

## 09-设计模式

1. [业务复杂=if else？刚来的大神竟然用策略+工厂彻底干掉了他们！](https://juejin.im/post/5e422501f265da570f501ef8)

## 10-代码健壮性

1. [java代码性能优化，提高健壮性](https://juejin.im/post/5e7c2ce7f265da42a201bbfc)
2. [用最小代价重构你的"判空地狱"](https://juejin.im/post/5e1001d6f265da5d3b32dc47)
3. [Java程序员最常犯的错竟然是这10个](https://juejin.im/post/5e13d24cf265da5d45542608)

## 11-单元测试

1. [单元测试利器 Mockito](https://juejin.im/post/5e52374e51882549406700f8)

## 12-其他小工具

### 01-Excel导出

1. [Poi 中文API文档](https://juejin.im/post/5e5f2da4e51d4526c550b51f)
2. [开源工具EasyExcel](https://juejin.im/post/5e5f5c1c6fb9a07ca24f5a1a)

### 02-Google guava工具类

1. [Google guava工具类的介绍和使用](https://juejin.im/post/5e6396dc518825496706884d)