# Sockets Example

## Buld
```
$ gradle build
```

## Send something on unix
```
echo $'Hello World!\rquit\r' > /dev/tcp/127.0.0.1/7081
```
