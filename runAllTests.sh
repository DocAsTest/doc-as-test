#!/usr/bin/env bash

mvn test

mvn exec:java -Dexec.mainClass="com.github.docastest.doctesting.MainDocumentation" -Dexec.classpathScope=test

. convertAdoc.sh
