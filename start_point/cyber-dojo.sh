
CLASSES=.:`ls /jmock/*.jar | tr '\n' ':'`
javac -Xlint:unchecked -cp $CLASSES  *.java
if [ $? -eq 0 ]; then
  # run test classes even if they are inner classes
  java -cp $CLASSES org.junit.runner.JUnitCore \
    `ls -1 *Test*.class | grep -v '\\$' | sed 's/\(.*\)\..*/\1/'`
fi
