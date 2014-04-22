OpenCVHueDetect
===============
Basic object tracking, using color hue. Most of this code is copied from http://ganeshtiwaridotcomdotnp.blogspot.com/2011/12/object-tracking-in-java-detect-position.html, but the setup here is super easy!

The performance isn't amazing; specifically the algorithm is quite sensitive to environment changes. I've put this up so people can get to the first step of object tracking quickly. This is not complete code, just useful code.

Installation
    clone this repository

    Eclipse: Import the project. The .classpath and .project files are included. Run either VideoObjectDetect or ObjectPositionDetect. VideoObjectDetect will open up a camera feed and process the position tracking as fast as possible. The latter does just a single frame from an image in the images directory and writes a file to the home directory.

    Linux (from the command line):
    Compile with:
    $ javac -cp "bin:javacv-bin/*:javacv-cppjars/*" src/tracker/VideoObjectDetect.java
    Run with:
    $ java -cp "bin:javacv-bin/*:javacv-cppjars/*" tracker.VideoObjectDetect

The javacv-bin and javacv-cppjars came from https://code.google.com/p/javacv/downloads/list
