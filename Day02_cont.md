# Day02 Cont

# Queue
 - 基本操作 enqueue() 和 dequeue()
 - 顺序队列 由 数组 实现
   - 有个缺点：数据需要搬移 -> 循环队列
 - 链式队列 由 连标 实现
 - 循环队列
   - 判断条件： 满的时候 tail == null，空的时候 head == tail 
   - head 和 tail 的关系： (tail + 1)%length = head
 - 实际的生产应用：
   - 阻塞队列：生产消费者模型
   - 并发队列：循环数组 + CAS原子操作