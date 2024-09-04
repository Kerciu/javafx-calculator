package com.calculator;

public class CalculatorState {
    private double firstNumber;
    private double secondNumber;
    private String binaryOperator;

    private boolean binaryOperatorPressed;
    private boolean unaryOperatorPressed;
    private boolean equalsOperatorPressed;
    private boolean firstNumberStored;
    private boolean secondNumberStored;

    public double getFirstNumber() {
        return firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public String getBinaryOperator() {
        return binaryOperator;
    }

    public boolean isBinaryOperatorPressed() {
        return binaryOperatorPressed;
    }

    public boolean isUnaryOperatorPressed() {
        return unaryOperatorPressed;
    }

    public boolean isEqualsOperatorPressed() {
        return equalsOperatorPressed;
    }

    public boolean isFirstNumberStored() {
        return firstNumberStored;
    }

    public boolean isSecondNumberStored() {
        return secondNumberStored;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
        this.firstNumberStored = true;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
        this.secondNumberStored = true;
    }

    public void setBinaryOperator(String binaryOperator) {
        this.binaryOperator = binaryOperator;
        this.binaryOperatorPressed = true;
    }

    public void setBinaryOperatorPressed(boolean binaryOperatorPressed) {
        this.binaryOperatorPressed = binaryOperatorPressed;
    }

    public void setUnaryOperatorPressed(boolean unaryOperatorPressed) {
        this.unaryOperatorPressed = unaryOperatorPressed;
    }

    public void setEqualsOperatorPressed(boolean equalsOperatorPressed) {
        this.equalsOperatorPressed = equalsOperatorPressed;
    }

    public void setFirstNumberStored(boolean firstNumberStored) {
        this.firstNumberStored = firstNumberStored;
    }

    public void setSecondNumberStored(boolean secondNumberStored) {
        this.secondNumberStored = secondNumberStored;
    }

}
