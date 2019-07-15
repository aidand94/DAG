# DAG

A Java program to check whether a given graph is a DAG(Directed Acyclic Graph).

[Based on the Wikipidea implementation of Kahn's Algorithm](https://en.wikipedia.org/wiki/Topological_sorting#Kahn's_algorithm).
A topological ordering is possible if and only if the graph has no directed cycles, that is, if it is a directed acyclic graph (DAG).

# Compiling and Running

## Linux (Ubuntu 18.04.02)
1. Open terminal and clone the repo
```
git clone git@github.com:aidand94/DAG.git
```

2. If JDK is not installed
```
sudo apt-get install openjdk-11-jdk
```

3. Compile
```
cd aidand94/DAG/
javac *.java
```

4. Run
```
java DAG
```
