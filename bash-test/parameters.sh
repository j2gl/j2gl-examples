#!/bin/bash

# For example, in docker-entypoint.sh, this form:
# SET JAVA_TOOL_OPTIONS="${JAVA_TOOL_OPTIONS- -Xms256m -Xmx1024m -XX:+PrintFlagsFinal}"
 
# MUST be changed to this form to preserve developer-mandated defaults:

JAVA_TOOL_OPTIONS="-Xms64m -Xmx128m"
echo $JAVA_TOOL_OPTIONS
java $JAVA_TOOL_OPTIONS MemoryTest 

export JAVA_TOOL_OPTIONS="${JAVA_TOOL_OPTIONS:-} -Xms40m -Xmx45m"
echo $JAVA_TOOL_OPTIONS
java $JAVA_TOOL_OPTIONS MemoryTest 