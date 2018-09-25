package com.apparatus.app.calculator;

import android.app. ; import android.os. ; import android.widget.Button; import android.widget.TextView; import android.util.Log; import android.view. ; import android.widget.Toast; import android.view.View.OnClickListener; import android.widget. ;

public class MainActivity extends Activity { //declaring global variables //for use in calculation long first; long second; long result; long ans; int remain; float roundedresult;

//division variables
float divresult;
float divfirst;
float divsecond;


//For storing value collected
//by button press
int label = 0;
String num;
String number;
String round;

//declaring all buttons to use them
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
Button plus;
Button minus;
Button multiply;
Button divide;
Button equals;
Button clear;
Button delete;

//declaring the text view
TextView outputnumber;

//declaring function detection variable
char function;
char operator;

//declaring error tracking variable
char tracker;

//ans booleans
boolean anstracker;

//pre ans calculation boolean
boolean precalc;


@Override
protected void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
 
 calculate calculator = new calculate();
 
}


public class calculate implements View.OnClickListener
    {
 
  public calculate()
      {
    //We'll use this int to store the result
    result = 0;
    roundedresult = 0;
    //this int to store the actual first number
    first = 0;
    //this int to store the actual second number
    second = 0;
    //this will store the remainder

    //division variables
    divresult = 0;
    divfirst = 0;
    divsecond = 0;
    remain = 0;
    
    //collecting all the buttons
    one = (Button)findViewById(R.id.one);
    two = (Button)findViewById(R.id.two);
    three = (Button)findViewById(R.id.three);
    four = (Button)findViewById(R.id.four);
    five = (Button)findViewById(R.id.five);
    six = (Button)findViewById(R.id.six);
    seven = (Button)findViewById(R.id.seven);
    eight = (Button)findViewById(R.id.eight);
    nine = (Button)findViewById(R.id.nine);
    zero = (Button)findViewById(R.id.zero);
    plus = (Button)findViewById(R.id.add);
    minus = (Button)findViewById(R.id.subtract);
    multiply = (Button)findViewById(R.id.multiply);
    divide = (Button)findViewById(R.id.divide);
    equals = (Button)findViewById(R.id.equals);
    clear = (Button)findViewById(R.id.clear);
    delete = (Button)findViewById(R.id.delete);
    
    //collecting output text view
    outputnumber = (TextView)findViewById(R.id.textViewResult);
    
    //distributing on-click-listners
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
    plus.setOnClickListener(this);
    minus.setOnClickListener(this);
    multiply.setOnClickListener(this);
    divide.setOnClickListener(this);
    clear.setOnClickListener(this);
    equals.setOnClickListener(this);
    delete.setOnClickListener(this);
    
    //initializing num
    num = "";
    
    //initializing tracker
    tracker = '@';
    
    //initializing function variables
    function = '@';
    operator = '@';
    
    //initializing ans
    ans = 0;
    anstracker = false;
    precalc = false;

    
   }

   @Override
   public void onClick(View p1)
   {
    // TODO: Implement this method
    switch(p1.getId())
        {
      case R.id.one:
       
       label = 1;
       
       break;
       
      case R.id.two:
       
       label = 2;

       break;
       
      case R.id.three:
       
       label = 3;

       break;
       
      case R.id.four:
       
       label = 4;

       break;
       
      case R.id.five:
       
       label = 5;

       break;
       
      case R.id.six:
       
       label = 6;

       break;
       
      case R.id.seven:
       
       label = 7;

       break;
       
      case R.id.eight:
       
       label = 8;

       break;
       
      case R.id.nine:
       
       label = 9;

       break;
       
      case R.id.zero:
       
       label = 0;

       break;
       
      case R.id.add:
       
       tracker = '&';
       function = '+';
       break;
       
      case R.id.subtract:
       
       tracker = '&';
       function = '-';
       break;
       
      case R.id.multiply:
       
       tracker = '&';
       function = '*';
       break;
       
      case R.id.divide:
       
       tracker = '&';
       function = '/';
       break;
       
      case R.id.clear:
       
       clearOutput();
       break;
       
      case R.id.equals:
       
       tracker = '&';
       operator = function;
       function = '=';
       break;
       
      case R.id.delete:
       del();
       break;
     }
     
     updatenumber();
   }

   public void updatenumber()
       {
     if(tracker == 'd')
         {
       if(num.length() == 0)
       {
        tracker = '?';
        updatenumber();
       }
       else
        outputnumber.setText(num);
      }
     else if(tracker == 'b')
         {
       Toast.makeText(getApplicationContext(), "Still Too Big", Toast.LENGTH_LONG).show();
       return;
      }
      
     else if(tracker == 'n')
         {
       outputnumber.setText("Positives Only!");
       num = "";
       function = '@';
      }
      
     else if(tracker == 'z')
         {
       outputnumber.setText("Cannot Divide by Zero!");
       num ="";
       function = '@';
      }
      
     else if(tracker == '@')
         {
       
       num = num + String.valueOf(label);
       if(num.length() == 10)
           {
         Toast.makeText(getApplicationContext(), "Too Big", Toast.LENGTH_LONG).show();
         tracker = 'b';
         return;
        }
        
       else
           {
         number = num;
         outputnumber.setText(num);
        }
       
       
       
      }
     else if(tracker == '?')
         {
       outputnumber.setText("0");
      }
     else 
      {
       switch(function)
           {
         case '+':
          if((outputnumber.getText() != "0") && precalc)
           anstracker = true;
          outputnumber.setText("+");
          loading(); 
          break;
          
         case '-':
          if((outputnumber.getText() != "0") && precalc)
           anstracker = true;
          outputnumber.setText("-");
          loading();
          break;
          
         case '*':
          if((outputnumber.getText() != "0") && precalc)
           anstracker = true;
          outputnumber.setText("*");
          loading();
          break;
          
         case '/':
          if((outputnumber.getText() != "0") && precalc)
          {
           anstracker = true;
          }
          outputnumber.setText("/");
          loading();
          break;
          
         case '=':
          if(compute(number) == -1)
              {
            updatenumber();
           }
           
          else if(operator == '/')
              {
            precalc = true;
            outputnumber.setText(String.valueOf(divresult));
            ans = (long) divresult;
            number = num;
            num = "";
            divresult = 0;
            result = 0;
            break;
           }
           
          else if(round.length() > 11)
              {
            
            roundedresult = result;
            outputnumber.setText(String.valueOf(roundedresult));
            
            result = 0;
            roundedresult = 0;             result = 0;
            num = "";
            
            break;
            
            
           }
          else
              {
            precalc = true;
            outputnumber.setText(String.valueOf(compute(number)));
            number = num;
            ans = result;
            num = "";
            result = 0;
            break;
           }
          
          
        }
        
      }
      
     tracker = '@';
     
     
    }
    
   public void del()
       {
     if(num.length() == 0)
     {
      clearOutput();
     }
     else
     {
      char[] value = num.toCharArray();
      char[] newvalues = new char[value.length - 1];
      System.arraycopy(value, 0, newvalues, 0, (value.length - 1 ));
      num = new String(newvalues);
      number = num;
      tracker = 'd';
     }
    }
    
   public int rounder(int input)
       {
     int power = 10;
     input = input - 11;
     for(int i = input; i == 0; i--)
         {
       power = power * 10;
      }
      
     return power;
    }
   
   public void loading()
       {
     if(anstracker)
     {
      first = ans;
      divfirst = ans;
     }
     else
     {
      first = Integer.parseInt(number);
      divfirst = first;
      num = "";
     }
    }
    
   
   public void clearOutput()
       {
     num = "";
     function = '@';
     tracker = '?';
     anstracker = false;
     ans = 0;
     precalc = false;
    }
    
   public long compute(String input)
       {
     
     second = Integer.parseInt(input);
     
     switch(operator)
         {
       case'+':
        result = first + second;
        break;
        
       case'-':
        if(first < second)
            {
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
          tracker ='z';
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
     round = String.valueOf(result); 
     function = '@';
     return result;
    }
  
  
  
  
    }



}