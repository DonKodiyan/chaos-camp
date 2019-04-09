# Toxiproxy

To install toxiproxy locally just execute the install script.

The toxiproxy TCP proxy will run on port 8474.

## Install toxiproxy
Make sure the install script is executable

```
chomd +x install.sh
```

Go to 'service' directory
```
cd <path-to-project-chaos-camp>/toxiproxy/service
```

Run install script
```
./install.sh
```
## Run App with toxiproxy configuration

In IntelliJ just start the launch configuration "`App start local Toxiproxy`"

## Toxiproxy and Kubernetes

Toxiproxy does not run in Kubernetes without any further modifications:
> Unfortunately, although it can be packaged as a Docker container, ToxiProxy cannot work once deployed to Kubernetes
- [An Approach To Automating Application Resiliency Testing With Kubernetes](https://hackernoon.com/an-approach-to-automating-application-resiliency-testing-with-kubernetes-c336a4836c19)