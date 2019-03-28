#!/usr/bin/env bash

docker build -t gcr.io/chaos-camp/app app
docker build -t gcr.io/chaos-camp/hasher hasher