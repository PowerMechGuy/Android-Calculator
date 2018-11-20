package com.apparatus.teccalc;

//APP INFO
//Author: PowerMechGuy
//Title: TecCalc
//Date of Latest Stable Version: November 16, 2018
//Purpose: to be a basic calculator
//Description: This is basically just a
//calculator. I tried to design it in such
//a way that it could be expanded upon.
//Things like error detection and arithmetic
//operators are all handle by char variables.
//The functions are supposed to make things
//easy to follow and to add efficiency to
//all the mundane repetitive house keeping
//operations necessary for the upkeep of a
//basic calculator. As of today, this app is
//stable, can handle values of 10 digits,
//can preform addition, subtraction, multiplication,
//and division, and has a fully functional delete
//button. The full calculation is also displayed
//for reference by the user unless the input will
//exceed the one line limit of the textview.
/*
 *
 *
 *
 */
//APP STATUS: STABLE


//Here we will be importing all the necessary packages!!!
import android.widget.Button;
import android.widget.TextView;
import android.view.*;
//import android.view.View.OnClickListener;
//import android.support.v7.app.AppCompatActivity;
//for some reason the app would not work with
//the above import. So I opted for android.app
//instead.
import android.app.*;
//import android.os.Bundle;
import android.os.*;
import android.widget.Toast;

class MainActivity extends Activity {

        //Here will will be declaring all the necessary global variables!
        //We'll start with  the basic calculation variables
        long first;
        long second;
        long result;
        long ans;
        int remain;
        float roundedresult;

        //Now we need some specific variables for division!!!
        float divresult;
        float divfirst;
        float divsecond;

        //Now we are going to declare some variables to store the values!
        int label; // This is probably the most referenced variable in this entire project!!!
        String num;
        String commaNum;
        String number;
        String fullCalc;
        String round;
        String finalresult;
        long partialresult;

        //Now we need some button variable declarations!!!
        //These right here are the number buttons!
        Button one;
        Button two;
        Button three;
        Button four;
        Button five;
        Button six;
        Button seven;
        Button eight;
        Button nine;
        Button zero;

        //And these will be the arithmetic buttons!
        Button plus;
        Button minus;
        Button multiply;
        Button divide;

        //And these are the Calulation and utility buttons!
        Button equals;
        Button clear;
        Button delete;

        //This is our Textview delcaration!!!
        TextView outputnumber; //very heavily referenced...

        //This is our function dection variable to help
        //us keep track of what arithmetic operation is
        //currently being used.
        char function;
        char operator;

        //This is our error tracking variable!!
        //This will help us keep track of erroneous things
        //input into the program by the user.
        char tracker;

        //This is our "next-calculation?" boolean!!!
        boolean anstracker;

        //This boolean checks if we have previously made a calculation!
        boolean precalc;

        //This boolean checks to see if our textview is cleared!
        boolean cleared;

        //This is a diagnostic variable being used to work with commas!
        byte comma;

        //This is yet another diagnostic comma variable.
        int set;

        //This boolean checks if we need commas!
        boolean bigNum;

        //This variable straight up counts commas!!!
        int commaCounter;

        //Error message resource strings
        String negative = "Postives Only!";
        String dividebyzero = "Cannot Divide By 0!";

        //resource character
        char n;

        //END OF DECLARATION FUNCTION

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Now we are gonna make an instance of the calculate class to handle business
        calculate calculator = new calculate();
    }


    class calculate implements View.OnClickListener
    {
        //Now we are going to make our super initialization constructor!!
        calculate() {
            //Initializing result variables
            result = 0;
            roundedresult = 0;

            //Initializing basic operand variables to 0
            //This variable stores the first number in every calculation.
            first = 0;
            //This variable stores the seond number in every calculatioin.
            second = 0;

            //Initializing divisionl variables to 0
            divresult = 0;
            divfirst = 0;
            divsecond = 0;
            remain = 0;

            //These variables will be responsible for
            //holding the string version of our numbers.
            //These will be heavily referenced and at this
            //point will be initialized to "0"
            num = "0";
            number = "0";
            //This variable will hold the full calculation string
            //Which will include the arithmetic operators and both
            //operands of the calculation.
            fullCalc = ""; //initialized to null
            //This is our comma calcualation variable.
            //It is still in the daignostic stage
            //and therefore may be commented out.
            commaNum = "";

            //This variable is very important.
            //It will be used to keep track of the
            //control flow of the calculator.
            //It's default value is @
            tracker = '@';

            //These variables are also important.
            //They are responsible for keep track
            //of the current arithmetic operation
            //being performed.
            //Their defaults are also '@';
            function = '@';
            operator = '@';

            //These variables will be used to keep
            //track of performing another calculation
            //on top of another calculation.
            ans = 0;
            anstracker = false;
            precalc = false;

            //This variable tells us whether or not
            //our textview has a value of zero.
            //It's default value will be true.
            cleared = true;

            //This is the actual comma counting variable.
            //We'll start it off at zero.
            comma = 0;

            //This boolean will tell us if we need commas.
            //The default should be false.
            bigNum = false;

            //This is a comma set counter.
            //It is still in diagnostic phase
            set = 1;

            //This is another part of the comma
            //system. It's default value is 1.
            commaCounter = 1;

            //resource strings
            finalresult = "";

            //resource long's
            partialresult = 0;

            //resource characters
            n = ' ';

            //this function initializes all the buttons separately
            init();

            //END OF CONSTRUCTOR

        }

        void init()
        {
            //Initializing all the buttons!!!
            //Here are our number buttons!
            one = (Button) findViewById(R.id.one);
            two = (Button) findViewById(R.id.two);
            three = (Button) findViewById(R.id.three);
            four = (Button) findViewById(R.id.four);
            five = (Button) findViewById(R.id.five);
            six = (Button) findViewById(R.id.six);
            seven = (Button) findViewById(R.id.seven);
            eight = (Button) findViewById(R.id.eight);
            nine = (Button) findViewById(R.id.nine);
            zero = (Button) findViewById(R.id.zero);


            //Now for the arithmetic buttons
            plus = (Button) findViewById(R.id.plus);
            minus = (Button) findViewById(R.id.minus);
            multiply = (Button) findViewById(R.id.multiply);
            divide = (Button) findViewById(R.id.divide);

            //And finally the utility buttons!
            equals = (Button) findViewById(R.id.equals);
            clear = (Button) findViewById(R.id.clear);
            delete = (Button) findViewById(R.id.delete);

            //Now we are assigning our textview variable
            //to the one in our app!
            outputnumber = (TextView) findViewById(R.id.outputnumber);

            //Now we are gonna give all our buttons an on click listener
            //so that they will do something when they are pressed.
            //We will start with our number buttons.
            one.setOnClickListener(this);
            two.setOnClickListener(this);
            three.setOnClickListener(this);
            four.setOnClickListener(this);
            five.setOnClickListener(this);
            six.setOnClickListener(this);
            seven.setOnClickListener(this);
            eight.setOnClickListener(this);
            nine.setOnClickListener(this);
            zero.setOnClickListener(this);

            //Now for our arithmetic buttons!
            plus.setOnClickListener(this);
            minus.setOnClickListener(this);
            multiply.setOnClickListener(this);
            divide.setOnClickListener(this);

            //And finally for our utility buttons
            equals.setOnClickListener(this);
            clear.setOnClickListener(this);
            delete.setOnClickListener(this);
        }

        @Override
        public void onClick(View display)
        {
            //This switch statement will manage all the button presses!!!
            //Amazing!
            //We will start will all our number buttons!
            switch(display.getId())
            {
                //BUTTON ONE
                case R.id.one:
                    if(num == "0" && precalc && !anstracker)
                    {
                        nextCalc();
                    }

                    label = 1;
                    break;

                //BUTTON TWO
                case R.id.two:
                    if(num == "0" && precalc && !anstracker)
                    {
                        nextCalc();
                    }

                    label = 2;
                    break;

                //BUTTON THREE
                case R.id.three:
                    if(num == "0" && precalc && !anstracker)
                    {
                        nextCalc();
                    }

                    label = 3;
                    break;

                //BUTTON FOUR
                case R.id.four:
                    if(num == "0" && precalc && !anstracker)
                    {
                        nextCalc();
                    }

                    label = 4;
                    break;

                //BUTTON FIVE
                case R.id.five:
                    if(num == "0" && precalc && !anstracker)
                    {
                        nextCalc();
                    }

                    label = 5;
                    break;

                //BUTTON SIX
                case R.id.six:
                    if(num == "0" && precalc && !anstracker)
                    {
                        nextCalc();
                    }

                    label = 6;
                    break;

                //BUTTON SEVEN
                case R.id.seven:
                    if(num == "0" && precalc && !anstracker)
                    {
                        nextCalc();
                    }

                    label = 7;
                    break;

                //BUTTON EIGHT
                case R.id.eight:
                    if(num == "0" && precalc && !anstracker)
                    {
                        nextCalc();
                    }

                    label = 8;
                    break;

                //BUTTON NINE
                case R.id.nine:
                    if(num == "0" && precalc && !anstracker)
                    {
                        nextCalc();
                    }

                    label = 9;
                    break;

                //BUTTON ZERO
                case R.id.zero:
                    if(num == "0" && precalc && !anstracker)
                    {
                        nextCalc();
                    }

                    label = 0;
                    break;


                //And now for our arithmetic operator buttons!!
                //ADDITION BUTTON
                case R.id.plus:
                    if(function != '@')
                    {
                        tracker = 't';
                        break;
                    }
                    tracker = '&';
                    function = '+';
                    break;

                //SUBTRACTION BUTTON
                case R.id.minus:
                    if(function != '@')
                    {
                        tracker = 't';
                        break;
                    }
                    tracker = '&';
                    function = '-';
                    break;

                //MULTIPLICATION BUTTON
                case R.id.multiply:
                    if(function != '@')
                    {
                        tracker = 't';
                        break;
                    }
                    tracker = '&';
                    function = '*';
                    break;

                //DIVISION BUTTON
                case R.id.divide:
                    if(function != '@')
                    {
                        tracker = 't';
                        break;
                    }
                    tracker = '&';
                    function = '/';
                    break;

                //And finally for our utility buttons!!!
                //CLEAR BUTTON
                case R.id.clear:
                    clearOutput();
                    break;

                //EQUALS BUTTON
                case R.id.equals:
                    tracker = '&';
                    operator = function;
                    function = '=';
                    break;

                //DELETE BUTTON
                case R.id.delete:
                    del();
                    break;

                //END OF SWITCH STATEMENT
            }

            //This is the super handy function
            //that will update our textview!
            updatenumber();

            //END OF ON CLICK METHOD
        }

        void updatenumber()
        {
            //In this function we will be using a series of
            //if statements to deal with the control flow.
            //This first part will be dealing with the delete button.
            //We know the delete button has been pressed if tracker
            //is equal to the letter d. It is set to this value in the
            //above switch statement.
            //DELETE ROUTINE
            if(tracker == 'd')
            {
                if(num.length() == 0 && function == '@')
                {
                    tracker = '?';
                    updatenumber();
                }
                else if (function != '@' && num.length() == 0)
                {
                    num = "0";
                    number = num;
                    fullCalc = first + " " + function + " " + num;
                    outputnumber.setText(fullCalc);
                    //HELP ME!!!
                }
                else if (function != '@' && num != "0")
                {
                    fullCalc = String.valueOf(first) + " " + function + " " + num;
                    outputnumber.setText(fullCalc);
                }

                else
                    outputnumber.setText(num);
            }

            //This routine checks to see if the number is
            //still to big. The digit limit is 10. In the
            //following routines, we will tell this user if
            //the number they entered hit the digit limit.
            //this routine makes sure the user cannot exceed
            //the digit limit.
            //DIGIT LIMIT LOCK CHECK
            else if (tracker == 'b')
            {
                Toast.makeText(getApplicationContext(), "Still Too Big", Toast.LENGTH_LONG).show();
                return;
            }

            //This routine checks to make sure the user is
            //not trying to switch arithmetic operations mid-
            //calculation. We reset the tracker variable here
            //as well
            //TOO MANY OPERATIONS CHECK
            else if (tracker == 't')
            {
                Toast.makeText(getApplicationContext(), "Too Many Operations", Toast.LENGTH_LONG).show();
                tracker = '@';
                return;
            }

            //This routine deals with negative numbers.
            //Later on, there will be code that identifies
            //a situation where the result will be a negative
            //number. Once that is triggered, it will stop the
            //updatenumber function here and zero out our number
            //collection variable of num and restart the calculation.
            //NEGATIVE NUMBER CHECK
            else if (tracker == 'n')
            {
                outputnumber.setText(negative);
                num = "0";
                function = '@';
            }

            //This routine deals with dividing by zero.
            //Later on, there will be code that identifies
            //a situation where the user tries to divide by
            //zero. If that occurs, the updatenumber function
            //will stop here, zero out our number collection
            //variable, and restart the calculation.
            //DIVIDE BY ZERO CHECK
            else if (tracker == 'z')
            {
                outputnumber.setText(dividebyzero);
                num = "0";
                function = '@';
            }

            //This is our "normal case senario" routine.
            //This will check to see if an operation is
            //being performed or of a number button was
            //pressed. If numbers are being pressed, they
            //are concatenated onto the length of the num
            //variable. We are also checking if the digit limit
            //of 10 has been hit in this routine. If an operation
            //is being preformed, then we move the contents of the
            //num variable to our special fullCalc variable to store
            //the full written calculation for reference by the user.
            //"NORMAL CASE SENARIO"/NUMBER LOADING/DIGIT LIMIT CHECK ROUTINE
            else if (tracker == '@')
            {
                if (num == "0")
                    num = "";

                num = num + String.valueOf(label);
                //diagnostic comma code
                /*comma ++;
                if (comma >= 4)
                    addComma();*/

                if (num.length() == 10)
                {
                    Toast.makeText(getApplicationContext(), "Too Big", Toast.LENGTH_LONG).show();
                    tracker = 'b';
                    return;
                }

                else
                {
                    if (function != '@')
                    {
                        //if(num == "0")
                        //    num = "";
                        number = num;
                        fullCalc = first + " " + function + " " + num;
                        outputnumber.setText(fullCalc);
                        cleared = false;

                    }

                    else
                    {
                        //more diagnostic comma code
                        /*if (bigNum)
                            outputnumber.setText(commaNum);

                        else
                        {
                            number = num;
                            outputnumber.setText(num);
                            cleared = false;
                        }*/
                        number = num;
                        outputnumber.setText(num);
                        cleared = false;
                    }
                }
            }

            //This routine clears the textview.
            //Later code will change the value of
            //our tracker variable in order for this
            //to occur.
            //CLEAR ROUTINE
            else if (tracker == '?')
                outputnumber.setText("0");

            //ARITHMETIC FUNCTION ROUTINE
            //this routine deals with the arithmetic
            //operation buttons. This routine has to
            //run through a series of checke each time
            //a arithmetic button is pressed to make
            //sure it is not pressed at the wrong time.
            //This routine also makes sure the fullCalc
            //variable is updated with the current operation
            //being preformed. I've now realized I could have
            //possibly built the fullCalc variables value
            //differently, but either way it works.
            //This is also where every calculation finishes
            //as the equals button is handled here as well.
            //After the equals button, everything is cleared
            //in preparation for the next calculation.
            //It looks as if my use of precalc may have been
            //redundant within the following lines of code.
            else {
                switch (function) {
                        case '+':
                            if (precalc) {
                                if ((outputnumber.getText() != "0") && precalc)
                                    anstracker = true;
                                fullCalc = String.valueOf(ans) + " + ";
                                outputnumber.setText(fullCalc);
                                loading();
                                break;
                            } else if (!precalc && cleared) {
                                tracker = '?';
                                updatenumber();
                                break;
                            } else {
                                if ((outputnumber.getText() != "0") && precalc)
                                    anstracker = true;
                                fullCalc = num + " + ";
                                outputnumber.setText(fullCalc);
                                loading();
                                break;
                            }

                        case '-':
                            if (precalc) {
                                if ((outputnumber.getText() != "0") && precalc)
                                    anstracker = true;
                                fullCalc = String.valueOf(ans) + " - ";
                                outputnumber.setText(fullCalc);
                                loading();
                                break;
                            } else if (!precalc && cleared) {
                                tracker = '?';
                                updatenumber();
                                break;
                            } else {
                                if ((outputnumber.getText() != "0") && precalc)
                                    anstracker = true;
                                fullCalc = num + " - ";
                                outputnumber.setText(fullCalc);
                                loading();
                                break;
                            }

                        case '*':
                            if (precalc) {
                                if ((outputnumber.getText() != "0") && precalc)
                                    anstracker = true;
                                fullCalc = String.valueOf(ans) + " * ";
                                outputnumber.setText(fullCalc);
                                loading();
                                break;
                            } else if (!precalc && cleared) {
                                tracker = '?';
                                updatenumber();
                                break;
                            } else {
                                if ((outputnumber.getText() != "0") && precalc)
                                    anstracker = true;
                                fullCalc = num + " * ";
                                outputnumber.setText(fullCalc);
                                loading();
                                break;
                            }

                        case '/':
                            if (precalc) {
                                if ((outputnumber.getText() != "0") && precalc)
                                    anstracker = true;
                                fullCalc = String.valueOf(ans) + " / ";
                                outputnumber.setText(fullCalc);
                                loading();
                                break;
                            } else if (!precalc && cleared) {
                                tracker = '?';
                                updatenumber();
                                break;
                            } else {
                                if ((outputnumber.getText() != "0") && precalc)
                                    anstracker = true;
                                fullCalc = num + " / ";
                                outputnumber.setText(fullCalc);
                                loading();
                                break;
                            }

                        case '=':
                            if(first == 0 && second == 0 && result == 0)
                            {
                                tracker = '?';
                                updatenumber();
                                break;
                            }
                            else if (!precalc && cleared) {
                                tracker = '?';
                                updatenumber();
                                break;

                            //We have to deal with division separately
                            //in order to preserve the use of floats
                            //instead of longs.
                            } else {
                                if (compute(number) == -1)
                                    updatenumber();

                                else if (operator == '/') {
                                    precalc = true;
                                    fullCalc += " = ";
                                    partialresult = (long)divresult;
                                    finalresult = String.valueOf(partialresult);
                                    fullCalc = fullCalc + finalresult;
                                    if(fullCalc.length() > 20)
                                        fullCalc = String.valueOf(divresult);
                                    outputnumber.setText(fullCalc);
                                    finalresult = "";
                                    ans = (long) divresult;
                                    number = num;
                                    num = "0";
                                    divresult = 0;
                                    result = 0;
                                    divfirst = 0;
                                    divsecond = 0;
                                    first = 0;
                                    second = 0;
                                    bigNum = false;
                                    break;
                                }

                                //This was a rounding experiment.
                                //This is commented diagostic code.
                                    /*else if (round.length() > 11)
                                    {
                                        roundedresult = result;
                                        outputnumber.setText(String.valueOf(roundedresult));
                                        result = 0;
                                        roundedresult = 0;
                                        num = "0";
                                        break;
                                    }*/

                                else {
                                    precalc = true;
                                    fullCalc += " = ";
                                    partialresult = compute(number);
                                    finalresult = String.valueOf(partialresult);
                                    fullCalc += finalresult;
                                    finalresult = String.valueOf(fullCalc);
                                    if(fullCalc.length() > 20)
                                        finalresult = String.valueOf(result);
                                    outputnumber.setText(finalresult);
                                    finalresult = "";
                                    fullCalc = "";
                                    number = num;
                                    ans = result;
                                    num = "0";
                                    result = 0;
                                    first = 0;
                                    second = 0;
                                    bigNum = false;
                                    break;
                                }
                            }
                    }
            }

            //Always have to reset the error detection
            //variable to be ready for the next user error.
            tracker = '@';
            //END OF UPDATENUMBER FUNCTION

        }


        //Diagnostic Comma adding code.
        void addComma()
        {
            int step = 0;
            String superComma = commaNum;
            char[] oldNum = superComma.toCharArray();
            char[] newNum = new char[16];
            newNum[4 - step] = oldNum[step];

            //diagnostic comma adding loop
            /*for(int i = 0; i == 4; i ++)
            {
                System.arraycopy(oldNum, i, newNum,(4 - i), 1);
                //newNum[(newNum.length - (4 + step))] = ',';
                //System.arraycopy(oldNum,,newNum, , 1);
                //step += 4;
                //newNum[4-1] = oldNum[i];
            }*/
            //newNum[3] = oldNum[0];
            //newNum[2] = oldNum[1];
            //newNum[1] = oldNum[2];
            //newNum[0] = oldNum[3];
            superComma = new String(newNum);
            commaNum = superComma;
            commaCounter ++;
            bigNum = true;
            comma = 0;
            set = set + 4;
        }

        //This function deletes the most recently
        //input digit from the current string of numbers.
        //We are using a char array to deal with the change
        //at the end of the string. It turns our num string
        //into a character array, places that array into another
        //array minus the very last digit, and finally turns it
        //back into a string.
        //DELETE FUNCTION
        void del()
        {
            //This makes sure we are not trying to delete
            //zero. Which would cause an error due to the way
            //our code handles zero.
            if(num == "0" && function == '@')
            {
                num = "";
            }

            if((num.length() == 0 && function != '@') || (num == "0" && function != '@'))
            {
                num = "0";
                number = num;
                tracker = 'd';
            }

            else if(num.length() == 0 && function == '@')
            {
                clearOutput();
            }

            else
            {
                //We are transferring the num String
                //to a character array in order to edit it.
                //I couldn't find an easy way to subract the last
                //value off of a string, so I built my own.
                //This simply copies all the num String into
                //a character array except for the last character and
                //then turns it back into a string.
                char[] value = num.toCharArray();
                char[] newvalues = new char[value.length - 1];
                System.arraycopy(value, 0, newvalues, 0, (value.length - 1));
                num = new String(newvalues);
                number = num;
                tracker = 'd';
            }

            //END OF DELETE FUNCTION
        }

        //This is a experimental rounding function.
        //So far, it does not work...
        //ROUNDING FUNCTION
        public int rounder(int input)
        {
            int power = 10;
            input = input - 11;
            for(int i = input; i == 0; i--)
            {
                power = power = power * 10;
            }
            return power;

            //END OF ROUNDING FUNCTION
        }

        //This nifty little function "loads"
        //our first number for calculation into
        //the "first" number variables to be used later
        //on for calculation. It also checks to see if we
        //have already preformed a calculation.
        //If we have, the first number becomes the
        //answer to the previous calculation.
        //LOADING FUNCTION
        void loading()
        {
            if(anstracker)
            {
                first = ans;
                divfirst = ans;
            }

            else
            {
                if(number == "0")
                {
                    first = 0;
                    divfirst = 0;
                }
                else
                {
                    first = Integer.parseInt(number);
                    divfirst = first;
                    num = "0";
                }
            }

            //END OF LOADING FUNCTION
        }

        //CLEAR FUNCTION
        //So basically, this function zeroes out
        //everything and sets us up for a new calculation
        void clearOutput()
        {
            num = "0";
            function = '@';
            tracker = '?';
            anstracker = false;
            ans = 0;
            precalc = false;
            cleared = true;
            fullCalc = "";
            bigNum = false;

            //END OF CLEAROUTPUT FUNCTION
        }

        //NEXTCALC FUNCTION
        //This function prepares us for
        //another calculation on top of the
        //one we just did.
        void nextCalc()
        {
            num = "0";
            function = '@';
            tracker = '@';
            precalc = false;

            //END OF NEXTCALC FUNCTION
        }

        //OOMPUTE FUNCTION
        //This is the actual calculator portion
        //of our calculator. The main reason this
        //program is so big is just for error detection!
        //This function adds, subtracts, multiplies, or divides
        //The values given it and returns an answer.
        //For division problems, a float is returned to
        //honor decimal places for more exact division.
        //We also have a check here to make sure we are
        //now preforming negative division and to make sure
        //we are not dividing by zero.
        //This is where our awesome calculator program finally ends!
        long compute(String input)
        {
            if(number == "0")
                second = 0;
            else
                second = Integer.parseInt(input);

            switch(operator)
            {
                case'+':
                    result = first + second;
                    break;

                case'-':
                    if(first < second)
                    {
                        //checking for negative numbers
                        tracker = 'n';
                        result = -1;
                        break;
                    }
                    result = first - second;
                    break;

                case'*':
                    result = first * second;
                    break;

                case'/':
                    divsecond = second;
                    if(second == 0)
                    {
                        //checking to see if the user
                        //is attemtpting to divide by zero
                        tracker = 'z';
                        result = -1;
                        break;
                    }
                    else
                    {
                        divresult = divfirst / divsecond;
                        break;
                    }
            }

            anstracker = false;
            //round = String.valueOf(result);
            function = '@';
            return result;

            //END OF COMPUTE METHOD
        }

        //END OF CALCULATE CLASS
    }

    //END OF MAIN ACTIVITY
}
