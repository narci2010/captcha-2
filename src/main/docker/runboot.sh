#!/usr/bin/env bash

sleep 5
java -Ddatabase.ip=${DATABASE_IP} \
    -Ddatabase.port=${DATABASE_PORT} \
    -Djava.security.egd=file:/dev/./urandom \
    -Dspring.redis.port=${REDIS_PORT} \
    -Dspring.redis.host=${REDIS_HOST} \
    -jar /app/app.jar
