# Sockets Example

## Compile and Buld
```
$ gradle build
```

### Running
```
$ gradle run
```

### Send something on command prompt
```
echo $'Hello World!\rquit\r' > /dev/tcp/127.0.0.1/7081
```

### TODO
* Fix gradle configuration classpath to run jar like maven target directory.
