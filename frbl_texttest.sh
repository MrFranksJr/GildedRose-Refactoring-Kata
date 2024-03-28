#!/bin/bash

while true
do
    # Run your command here
    if [ ! -d "venv" ]; then
        python3 -m venv venv
    fi
    venv/bin/pip install texttest
    venv/bin/texttest -d . -con "$@"
    # Wait for 2 minutes
    sleep 120
done