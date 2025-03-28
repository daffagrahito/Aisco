#!/bin/bash
source ~/.zshrc  

cleanup() {
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

java -cp aisco.product.bisayok --module-path aisco.product.bisayok -m aisco.product.bisayok &

wait