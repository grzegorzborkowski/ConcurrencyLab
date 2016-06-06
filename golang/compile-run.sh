#!/usr/bin/env bash

function compile-run {
    go install github.com/grzegorzborkowski/$1
    sudo $GOPATH/bin/$1
}