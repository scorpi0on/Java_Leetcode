# Day05 哈希表、映射、集合

##  Hash table
- 哈希表/散列表，由 key-value pair组成。根据 key-value 来直接访问的数据结构。
- key-value 会被映射到表中的一个位置来访问。
- 映射函数叫做 Hash Function， 存放记录的数组叫做 Hash table。
-  常见的例子： 电话号码本， 用户信息表， LRU 缓存， 键值对存储

## JAVA code
    Map key-value对中， key不重复。
     - new HashMap() / new TreeMap()  
     - map.set(键, 值)
     - map.get(key)  
     - map.has(key)  
     - map.size()  
     - map.clear()
    Set 不重复袁术的集合
     - new HashSet() / new TreeSet()  
     - set.add(value)  
     - set.delete(value)  
     - set.hash(value）
  对 Java 中的 HashSet 类：
    - HashSet背后是由Hashmap实现的
    - add(e): 将e这个元素放到map的key位置上，value的值为PRESENT占位。
  
  对于 Java 中的HashMap类：
    - Node<K, V>: 对 Map.Entry 接口的实例化， 一个链表存储结构。
    - final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) ：
      - Node<K,V>[] tab 数组
      - resize() 
      - (n - 1) & hash： 用 & 代替 % 求余
      - 
  
