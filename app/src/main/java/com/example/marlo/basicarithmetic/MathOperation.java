package com.example.marlo.basicarithmetic;

/**
 * Created by marlo on 12/09/2016.
 */
public class MathOperation
{

    //region Private Fields

    private int firstOperand;
    private int secondOperand;
    private char operator;
    private int expectedResult;
    private int typedResult;

    //endregion

    //region Constructors

    public MathOperation(int firstOperand, char operator, int secondOperand)
    {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operator = operator;
        this.expectedResult = calculate();
    }

    //endregion

    //region Getters and Setters

    public int getFirstOperand()
    {
        return firstOperand;
    }

    public int getSecondOperand()
    {
        return secondOperand;
    }

    public char getOperator()
    {
        return operator;
    }

    public void setTypedResult(int typedResult)
    {
        this.typedResult = typedResult;
    }

    //endregion

    //region Methods

    public boolean isCorrect()
    {
        return (expectedResult == typedResult);
    }

    private int calculate()
    {
        if(operator == '+')
            return firstOperand + secondOperand;
        else if (operator == '-')
            return firstOperand - secondOperand;
        else
            return -99;
    }

    //endregion

}
