# Chaos Camp

How to start your environment locally:
```
skaffold dev
```

You can find more info on how to install, here: https://skaffold.dev/docs/getting-started/

## Tools
* Spring Boot
* Hystrix
* Gatling
* [Chaos Monkey for Spring Boot](https://codecentric.github.io/chaos-monkey-spring-boot/)
* Chaos Monkey for Kubernetes
* Kubernetes
How to get all instances of a service
```
kubectl get pods -o=name --all-namespaces | grep chaoscamp-app
```
* Toxy Proxy
* Wiremock
* Grafana (Prometheus)
* Micrometer 

## Patterns
* Circuit Breaker
* Retry Pattern
* Compensating Transaction Pattern

## Topics
* Service Metrics
* Stability Patterns
* Chaos Engineering Practices

## Material
* [Stability Patterns & Antipatterns • Michael T. Nygard](https://m.youtube.com/watch?v=VZePNGQojfA)
* [Release It!](https://doc.lagout.org/programmation/Pragmatic%20Programmers/Release%20It%21%20Design%20and%20Deploy%20Production-Ready%20Software.pdf)
* [SRE Book](https://landing.google.com/sre/books/)

## How to connect to hasher pod with jmx
Find name of pod with
```
kubectl get pods
```
then forward local jmx port to pod with
```
kubectl port-forward <podname> 1099:1099
```
then connect to localhost:1099 with your favourite tool (jconsole, jmc, ...)
