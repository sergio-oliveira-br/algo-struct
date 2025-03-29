package com.github.sergiooliveirabr.algostruct.service;

import org.springframework.stereotype.Service;

@Service
public class ElapsedTimeService {

    long elapsedTime;

    public String getElapsedTime(long endTime, long startTime) {

        elapsedTime = endTime - startTime;
        return  "Elapsed Time: " + elapsedTime + "mill";
    }
}
