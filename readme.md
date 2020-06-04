#这是一个用来演示JVM报错的示例demo
使用JVM的参数 -Xms5m -Xmx5m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./jvm.dump
## OutOfMemoryError
发生内存溢出。无法申请到新的内存空间。主要发生在堆内存上。
### 堆内存溢出产生常见原因。
   内存泄露。及所创建对象即便是不在使用也无法回收。JVM使用根节点引用法来判断对象是否可达。可达对象的强引用无法被回收。
   
   可被当做GCRoot的对象主要有:
   静态变量所引用强引用的对象.
   方法区常量所强引用的对象。
   JVM栈中所引强用的对象。
   JVM本地方法栈中所强引用的对象。
### 内存泄露
   定义静态变量并且持有强引用。并向该引用下不断的加入的对象。不执行回收清除操作。
   ```
     public static List<String> list=new ArrayList();
     public static void  add(String str){
       list.add(str);     
      }
   ```
   
  
   
## StackOverflowError
