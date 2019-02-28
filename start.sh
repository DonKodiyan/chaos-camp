#!/usr/bin/env bash

kubectl apply -f ./app/kubernetes/deployment.yaml
kubectl apply -f ./app/kubernetes/service.yaml


kubectl apply -f ./hasher/kubernetes/deployment.yaml
kubectl apply -f ./hasher/kubernetes/service.yaml