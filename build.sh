#!/usr/bin/env bash
export DOCKER_BUILDKIT=1

docker build -t chaoscamp/app app
docker build -t chaoscamp/hasher hasher