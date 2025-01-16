# Gradle 6 with Goggle Guava

New versions of Google's Guava library cause issues for Gradle 6. 

Specifically, the error I see when upgrading to a recent version like: `33.3.1-jre` : 

```
* What went wrong:
Execution failed for task ':compileJava'.
> Could not resolve all files for configuration ':compileClasspath'.
   > Could not resolve com.google.guava:guava:33.3.1-jre.
     Required by:
         project :
      > The consumer was configured to find an API of a library compatible with Java 11, preferably in the form of class files, and its dependencies declared externally. However we cannot choose between the following variants of com.google.guava:guava:33.3.1-jre:
          - androidApiElements
          - jreApiElements
        All of them match the consumer attributes:
          - Variant 'androidApiElements' capabilities com.google.collections:google-collections:33.3.1-jre and com.google.guava:guava:33.3.1-jre declares an API of a library compatible with Java 8, packaged as a jar, and its dependencies declared externally:
              - Unmatched attributes:
                  - Provides attribute 'org.gradle.jvm.environment' with value 'android' but the consumer didn't ask for it
                  - Provides release status but the consumer didn't ask for it
          - Variant 'jreApiElements' capabilities com.google.collections:google-collections:33.3.1-jre and com.google.guava:guava:33.3.1-jre declares an API of a library compatible with Java 8, packaged as a jar, and its dependencies declared externally:
              - Unmatched attributes:
                  - Provides attribute 'org.gradle.jvm.environment' with value 'standard-jvm' but the consumer didn't ask for it
                  - Provides release status but the consumer didn't ask for it
```

This seems to be somewhat of a known issue, documented here: https://github.com/google/guava/releases/tag/v32.1.0

Also on Stack Overflow: https://stackoverflow.com/questions/77746136/how-to-exclude-one-of-the-variants-of-com-google-guava-dependency-while-building

Possible Solutions:
1. Upgrade to a newer version of Gradle? Chatter online suggests that upgrading to Gradle 7+ will fix the issue
2. Use the Android version of the library - you probably don't want to do this unless you're building an application targeted 
   specifically for Android. Note: The Android version does NOT support all the APIs that the JRE version supports
3. Modify the build script to work around the issue using some Gradle mojo - This is the approach I chose for this demo and probably
   the least expensive option if you're in a time crunch, although option 1 is the better long-term solution
