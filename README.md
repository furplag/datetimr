# deamtiet

[![Coverage Status](https://coveralls.io/repos/github/furplag/deamtiet/badge.svg?branch=master)](https://coveralls.io/github/furplag/deamtiet?branch=master)

help us to understand to Date/Time API.

## Getting Start
Add the following snippet to any project's pom that depends on your project
```xml
<repositories>
  ...
  <repository>
    <id>deamtiet</id>
    <url>https://raw.github.com/furplag/deamtiet/mvn-repo/</url>
    <snapshots>
      <enabled>true</enabled>
      <updatePolicy>always</updatePolicy>
    </snapshots>
  </repository>
</repositories>
...
<dependencies>
  ...
  <dependency>
    <groupId>jp.furplag.sandbox</groupId>
    <artifactId>deamtiet</artifactId>
    <version>1.0.0</version>
  </dependency>
</dependencies>
```

## License
Code is under the [Apache Licence v2](LICENCE).
