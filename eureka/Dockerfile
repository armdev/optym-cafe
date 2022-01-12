FROM openjdk:15

COPY target/eureka.jar /opt/eureka.jar
ENTRYPOINT ["java", "-XX:+UseZGC", "-XX:MinHeapSize=1G", "-XX:InitialHeapSize=1G", "-XX:MaxHeapSize=8G", \
            "-XX:ParallelGCThreads=100", "-XX:ConcGCThreads=25", \
            "-XX:SoftRefLRUPolicyMSPerMB=0","-XX:ZCollectionInterval=30", "-XX:ZFragmentationLimit=10", \
            "-XX:MaxGCPauseMillis=5", "-XX:+UseCompressedClassPointers", "-XX:-UseCompressedOops", "-XX:ZUncommitDelay=30", \
            "-XX:InitiatingHeapOccupancyPercent=35", "-XX:G1HeapRegionSize=16M", \
            "-XX:MinMetaspaceFreeRatio=50", "-XX:MaxMetaspaceFreeRatio=100",  \
            "-XX:+UnlockExperimentalVMOptions", "-XshowSettings:vm", "-XX:+PrintFlagsFinal", "-XshowSettings:vm" ,"-jar","/opt/eureka.jar"]
EXPOSE 8761
