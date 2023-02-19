﻿# WSDL -> CXF Java API -> Spring REST -> OpenAPI

```xml
<plugin>
    <groupId>pl.bpsa</groupId>
    <artifactId>java2spring</artifactId>
    <version>0.0.3-SNAPSHOT</version>
    <executions>
        <execution>
            <goals>
                <goal>cxf2spring</goal>
            </goals>
        </execution>
    </executions>
    <configuration>
        <clazz>https.www_w3schools_com.xml.TempConvertHttpPost</clazz>
        <packageName>pl.bpsa.java2spring</packageName>
        <path>${project.build.directory}/generated-sources/cxf/</path>
    </configuration>
</plugin>
```
![img.png](img.png)

