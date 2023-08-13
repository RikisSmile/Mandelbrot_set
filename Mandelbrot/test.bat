javac -d obj *.java

cd obj

jar cfe Mandelbrot.jar Main *.class

java -jar Mandelbrot.jar

cd..
