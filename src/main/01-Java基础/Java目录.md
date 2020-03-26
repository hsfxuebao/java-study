# Java基础
 > 主要包含JVM,java基础,多线程等

## 01-JVM

### 01-内存和垃圾回收

1. [JVM面试知识点（GC、参数、引用）](https://juejin.im/post/5e7c90c5f265da42cc3e1b24)
2. [对象和数组并不是都是在堆上分配内存的](https://juejin.im/post/5e53961ff265da5740641f12)

### 02-字节码与类加载

### 03-性能监控和调优



## 02-集合
### 01-Map
![Map接口](https://github.com/hsfxuebao/java-study/blob/master/src/main/01-Java%E5%9F%BA%E7%A1%80/Figure/01-Map%E6%8E%A5%E5%8F%A3%E7%BB%A7%E6%89%BF%E5%85%B3%E7%B3%BB.png)
1. [HashMap源码解读](https://juejin.im/post/5e4222b0518825492e494e19)   *********
2. [为啥HashMap的默认容量是16？](https://juejin.im/post/5e7c2bbff265da42bc796f6e)
3. [图解HashMap(一) ](https://juejin.im/post/5e7b47acf265da573d61cff5)  *********
4. [图解HashMap(二)](https://juejin.im/post/5e7b48c46fb9a07cdb469e66)   *********
5. [图解LinkedHashMap原理](https://juejin.im/post/5e74c4016fb9a07ca601c97a)   *
6. [LinkedHashMap源码解读](https://juejin.im/post/5e42242be51d4526c654b4e1)  
7. [图解TreeMap](https://juejin.im/post/5e7b4f2a5188255e277a3a8e)   *
8. [ConcurrentHashMap源码 ](https://juejin.im/post/5e421fc0e51d4526c5509f54)  *********
9. [ConcurrentHashMap & HashTable](https://juejin.im/post/5e42249fe51d4526cc3b17f0)  
10. [图解红黑树原理](https://juejin.im/post/5e7c18476fb9a009912d8b84) 

### 02-Collection

![Collection](https://github.com/hsfxuebao/java-study/blob/master/src/main/01-Java基础/Figure/02-Collection继承关系图.png)

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

## 03-并发
### 01-多线程
1. [异步技巧之CompletableFuture](https://juejin.im/post/5e7abaaae51d452716052f86)  **
2. [深入理解java中的线程](https://juejin.im/post/5e7c68c26fb9a009a52f54b2)
3. [线程通信（CountDownLatch、CyclicBarrier、Semaphore）](https://juejin.im/post/5e7c6a94e51d455c7275d419)
4. [Java并发 -- Fork/Join框架](https://juejin.im/post/5e527a8a6fb9a07c8a5a158b)
5. [线程池execute和submit区别](https://juejin.im/post/5e5bb18ce51d45270b7d646c)
6. [如何正确使用线程池submit和execute方法](https://juejin.im/post/5e72d6f66fb9a07cad3bbddf)
7. [ThreadPoolExecutor八种拒绝策略浅析](https://juejin.im/post/5e34e0206fb9a02ff7297959)
8. [诡异的并发之原子性](https://juejin.im/post/5e5db07cf265da574727969a)
9. [理解Object的wait,notify,notifyAll与Thread的sleep,yield,join等方法](https://juejin.im/post/5e62fc3951882548ff3aa578)
10. [线程池中的空余线程是如何被回收的](https://juejin.im/post/5e7221a3e51d4527235b7f67)
11. [线程的中断(interrupt)机制](https://juejin.im/post/5e72d0b0f265da5735507150)

### 02-锁

1. [Synchronized实现原理（方法代码块）](https://juejin.im/post/5e7c5c686fb9a009612de451)  *********
2. [Synchronized及其实现原理](https://juejin.im/post/5e7485f1f265da570a5d69aa)
3. [Monitor（管程）是什么意思？Java中Monitor（管程）的介绍](https://juejin.im/post/5e7c5e62e51d455c1d67b0e9)    *********
4. [Synchronized锁升级](https://juejin.im/post/5e7adfc1f265da5770145cc2) *********
5. [并发编程知识点（volatile、JMM、锁、CAS、阻塞队列、线程池、死锁）](https://juejin.im/post/5e7c6ec851882535f43973fe)
6. [volatile 相关整理](https://juejin.im/post/5e522439e51d4526ff024ee9)
7. [Java并发编程—并发流程控制与AQS原理及相关源码解析](https://juejin.im/post/5e551be0f265da572017ebd8#heading-25)

### 03-ThreadLocal

1. [并发容器之ThreadLocal](https://juejin.im/post/5e05789fe51d45584c554628)
2. [从源码深入详解ThreadLocal内存泄漏问题](https://juejin.im/post/5e057453518825127424c0e0)
3. [线程封闭](https://juejin.im/post/5e5e0f74e51d4526c3590685)
4. [Random和ThreadLocalRandom区别](https://juejin.im/post/5e72f70ff265da573a021410)

## 04-常用类

### 01-Object

1. [equals 和 hashCode方法](https://juejin.im/post/5e42225551882549122aa038)

## 05-反射机制

1. [分析cglib动态代理的实现](https://juejin.im/post/5e34e2575188254df8741a61)
2. [分析JDK动态代理的实现](https://juejin.im/post/5e34e208e51d4558850ea8e6)
3. [谈谈Java反射：从入门到实践，再到原理](https://juejin.im/post/5e7c2af3f265da42e16b02b0)

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