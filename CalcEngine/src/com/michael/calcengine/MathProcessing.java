package com.michael.calcengine;

public interface MathProcessing {
    String SEPERATOR = " ";
    String getKeyWord();
    char getSymbol();
    double doCalculation(double leftVal, double rightVal);
}