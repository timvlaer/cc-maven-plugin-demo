Checksum Maven Plugin
=====================

Axxes CC demo

Usage:
```xml
<plugin>
    <groupId>com.axxes.tim.maven_plugin_demo</groupId>
    <artifactId>maven_plugin_demo</artifactId>
    <version>1.0-SNAPSHOT</version>
    <executions>
        <execution>
            <phase>install</phase>
            <goals>
                <goal>calculate-checksum</goal>
            </goals>
        </execution>
    </executions>
    <configuration>
        <checksumFile>checksum.chk</checksumFile>
    </configuration>
</plugin>
```