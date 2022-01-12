FROM openjdk:15
COPY target/coffee.jar /opt/coffee.jar
ENTRYPOINT ["java", "-XX:+UseZGC", "-XX:MinHeapSize=2G", "-XX:InitialHeapSize=2G", \
            "-XX:ParallelGCThreads=100", "-XX:ConcGCThreads=25", \
            "-XX:SoftRefLRUPolicyMSPerMB=0","-XX:ZCollectionInterval=30", "-XX:ZFragmentationLimit=10", \
            "-XX:MaxGCPauseMillis=5", "-XX:+UseCompressedClassPointers", "-XX:-UseCompressedOops", "-XX:ZUncommitDelay=30", \
            "-XX:InitiatingHeapOccupancyPercent=35", "-XX:G1HeapRegionSize=16M", \
            "-XX:MinMetaspaceFreeRatio=50", "-XX:MaxMetaspaceFreeRatio=100",  \
            "-XX:+UnlockExperimentalVMOptions", "-jar","/opt/coffee.jar"]
EXPOSE 2026
