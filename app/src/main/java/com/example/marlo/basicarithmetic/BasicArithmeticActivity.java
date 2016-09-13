package com.example.marlo.basicarithmetic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class BasicArithmeticActivity extends AppCompatActivity
{

    //region Private Fields

    private TextView firstOperandTextView;
    private TextView secondOperandTextView;
    private TextView operatorTextView;
    private TextView headerTextView;
    private EditText resultEditText;
    private Button confirmButton;
    private ArrayList<MathOperation> mathOperations = new ArrayList<MathOperation>();
    private int currentOperationIndex = 0;

    //endregion

    //region Events

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setupContentView();
        setupEvents();
        generateOperations();
        updateView();
    }

    //endregion

    //region Setup

    private void setupEvents()
    {
        confirmButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                mathOperations.get(currentOperationIndex).setTypedResult(new Integer(resultEditText.getText().toString()));
                if(currentOperationIndex < 4)
                {
                    currentOperationIndex++;
                    updateView();
                }
                else
                {
                    int score = 0;
                    for(MathOperation o : mathOperations)
                    {
                        if (o.isCorrect())
                            score++;
                    }
                    resultEditText.setEnabled(false);
                    confirmButton.setEnabled(false);
                    currentOperationIndex = 0;

                    Toast.makeText(getApplication().getBaseContext(), "Your score is " + String.valueOf(score * 100 / 5) + "%", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void setupContentView()
    {
        setContentView(R.layout.activity_basic_arithmetic);
        headerTextView = (TextView)findViewById(R.id.headerTextView);
        firstOperandTextView = (TextView)findViewById(R.id.firstOperandTextView);
        secondOperandTextView = (TextView)findViewById(R.id.secondOperandTextView);
        operatorTextView = (TextView)findViewById(R.id.operatorTextView);
        resultEditText = (EditText) findViewById(R.id.resultEditText);
        confirmButton = (Button)findViewById(R.id.confirmButton);
    }

    //endregion

    //region Private Methods

    private void updateView()
    {
        headerTextView.setText(String.valueOf(currentOperationIndex + 1) + " of 5");
        firstOperandTextView.setText(String.valueOf(mathOperations.get(currentOperationIndex).getFirstOperand()));
        secondOperandTextView.setText(String.valueOf(mathOperations.get(currentOperationIndex).getSecondOperand()));
        operatorTextView.setText(String.valueOf(mathOperations.get(currentOperationIndex).getOperator()));
        resultEditText.setText(null);
    }

    private void generateOperations()
    {
        Random random = new Random();

        for(int i = 0; i < 5; i++)
        {
            int firstOperand = random.nextInt(10);
            int secondOperand = random.nextInt(10);

            char operator;
            boolean aux =  random.nextBoolean();
            if (aux)
                operator = '+';
            else
                operator = '-';

            MathOperation operation = new MathOperation(firstOperand,operator,secondOperand);
            mathOperations.add(i, operation);

            resultEditText.setFocusable(true);

        }
    }

    //endregion

}
