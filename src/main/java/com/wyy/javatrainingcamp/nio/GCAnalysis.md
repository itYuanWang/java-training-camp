使用串行GC
-XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx1g -Xms1g -XX:+UseSerialGC
总计进行了
7次young GC，总的GC时间为420ms，平均每次的暂停时间是60ms
0次Full GC
Young总共可分配的内存为307.19 mb
Old区域总共可分配的内存为682.69 mb

使用并行GC
-XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx1g -Xms1g -XX:+UseParallelGC
总计进行了
10次young GC，总的GC时间为470ms，平均每次的暂停时间是47ms
0次Full GC
Young总共可分配的内存为298.5 mb
Old区域总共可分配的内存为683 mb

使用CMSGC
-XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx1g -Xms1g -XX:+UseConcMarkSweepGC
总计进行了
7次young GC，总的GC时间为370ms，平均每次的暂停时间是52.9ms
0次Full GC
Young总共可分配的内存为307.19 mb
Old区域总共可分配的内存为682.69 mb

使用G1GC
-XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx1g -Xms1g -XX:+UseG1GC
吞吐量：79.258%
平均停顿 GC 时间：17.3 ms
最大停顿 GC 时间：90.0 ms
总计进行了
7次young GC，总的GC时间为160 ms，平均每次的暂停时间是22.9 ms
0次Full GC
Young总共可分配的内存为673 mb
Old区域总共可分配的内存为973 mb

使用G1GC,指定最大暂停时间
-XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx1g -Xms1g -XX:+UseG1GC -XX:MaxGCPauseMillis=50
吞吐量：62.264%
平均停顿 GC 时间：13.6 ms
最大停顿 GC 时间：50.0 ms
总计进行了
21次young GC，总的GC时间为320 ms，平均每次的暂停时间是15.2 ms
0次Full GC
Young总共可分配的内存为119 mb
Old区域总共可分配的内存为973 mb