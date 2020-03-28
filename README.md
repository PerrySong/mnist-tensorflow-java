# Tensorflow java MNIST

## Dependencies
### Java dependencies 
compile group: 'org.tensorflow', name: 'tensorflow', version: '1.13.1'   
compile group: 'org.tensorflow', name: 'proto', version: '1.13.1'   
compile group: 'org.tensorflow', name: 'libtensorflow', version: '1.13.1'   

### Tensorflow version: 1.3.0

The java code can not correctly load the model created by tensorflow2.0

## How to run
```
git clone https://github.com/PerrySong/mnist-tensorflow-java.git
cd mnist-tensorflow-java/java/dataflow 
gradle run
```

## Result
Tested with 10000 labeled data, 9928/10000 were predicted correctly, which is 99.28%.

## Reference
[Github Repo](https://github.com/kalaspuffar/tensorflow-mnist-test)    
[Youtube Tutorial](https://www.youtube.com/watch?v=j3MZ0brQ0QE&t=678s)
