#!/usr/bin/env bash

curl -o  $(pwd)/weather_data.json -H 'Content-Type: application/json' 'http://api.openweathermap.org/data/2.5/forecast?id=5037649&APPID=b9c6301dd94936f0e13f76c69d19a30b'
