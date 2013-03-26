#!/bin/bash

START_DATE=$2
END_DATE=$1

if [ -z "${START_DATE}" ] || [ -z "${END_DATE}" ]; then
	echo "Usage: {START_DATE} {END_DATE}"
	exit;
fi

NOW_DATE_S=`date -d '1days ago' '+%s'`


CURR_DATE=$END_DATE
CURR_DATE_S=`date -d "$CURR_DATE" '+%s'`
START_DATE_S=`date -d "$START_DATE" '+%s'`
while [ $START_DATE_S -le $CURR_DATE_S ] && [ $CURR_DATE_S -le $NOW_DATE_S ]; do
        
        
        CURR_DATE=`date --date $CURR_DATE" 1days" +%Y-%m-%d`
        CURR_DATE_S=`date -d "$CURR_DATE" '+%s'`
done