#!/bin/bash
source ~/.zshrc  

cleanup() {
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

java -cp aisco.product.ayobisa --module-path aisco.product.ayobisa -m aisco.product.ayobisa &

wait