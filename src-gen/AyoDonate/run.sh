#!/bin/bash
source ~/.zshrc  

cleanup() {
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

java -cp aisco.product.ayodonate --module-path aisco.product.ayodonate -m aisco.product.ayodonate &

wait