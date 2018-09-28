package com.apparatus.app.calculator;

import android.app.*;
import android.os.*;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;
import android.view.*;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.widget.*;

public class MainActivity extends Activity 
{
	//declaring global variables
	//for use in calculation
	long first;
	long second;
	long result;
	long ans;
	int remain;
	float roundedresult;
	
	//division variables
	float divresult;
	float divfirst;
	float divsecond;
	
	
	//For storing value collected
	//by button press
	int label = 0;
	String num;
	String commaNum;
	String number;
	String fullCalc;
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
	
	//cleared boolean
	boolean cleared;
	
	//comma counter
	byte comma;
	
	//comma set counter
	int set;
	
	//comma boolean
	boolean bigNum;
	
	//comma counter
	int commaCounter;
	
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
					
					//initializing num and number
					num = "0";
					number = "0";
					fullCalc = "";
					commaNum = "";
					
					//initializing tracker
					tracker = '@';
					
					//initializing function variables
					function = '@';
					operator = '@';
					
					//initializing ans
					ans = 0;
					anstracker = false;
					precalc = false;
					
					//initializing cleared boolean
					cleared = true;
					
					//initializing comma counter
					comma = 0;
					
					//initializing comma boolean
					bigNum = false;
					
					//initializing comma set counter
					set = 1;
					
					//initializing commaCounter
					commaCounter = 1;

					
				}

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					switch(p1.getId())
					    {
							case R.id.one:
								if(num == "0" && precalc && anstracker == false)
									nextCalc();
									
								label = 1;
								
								break;
								
							case R.id.two:
								if(num == "0" && precalc && anstracker == false)
									nextCalc();
								
								label = 2;

								break;
								
							case R.id.three:
								if(num == "0" && precalc && anstracker == false)
									nextCalc();
								
								label = 3;

								break;
								
							case R.id.four:
								if(num == "0" && precalc && anstracker == false)
									nextCalc();
								
								label = 4;

								break;
								
							case R.id.five:
								if(num == "0" && precalc && anstracker == false)
								nextCalc();
								
								label = 5;

								break;
								
							case R.id.six:
								if(num == "0" && precalc && anstracker == false)
									nextCalc();
								
								label = 6;

								break;
								
							case R.id.seven:
								if(num == "0" && precalc && anstracker == false)
									nextCalc();
								
								label = 7;

								break;
								
							case R.id.eight:
								if(num == "0" && precalc && anstracker == false)
									nextCalc();
								
								label = 8;

								break;
								
							case R.id.nine:
								if(num == "0" && precalc && anstracker == false)
									nextCalc();
								
								label = 9;

								break;
								
							case R.id.zero:
								if(num == "0" && precalc && anstracker == false)
									nextCalc();
								
								label = 0;

								break;
								
							case R.id.add:
								
								if(function != '@')
								{
									tracker = 't';
									break;
								}
								tracker = '&';
								function = '+';
								break;
								
							case R.id.subtract:
								
								if(function != '@')
								{
									tracker = 't';
									break;
								}
								tracker = '&';
								function = '-';
								break;
								
							case R.id.multiply:
								
								if(function != '@')
								{
									tracker = 't';
									break;
								}
								tracker = '&';
								function = '*';
								break;
								
							case R.id.divide:
								
								if(function != '@')
								{
									tracker = 't';
									break;
								}
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
								if(num.length() == 0 && function == '@')
								{
									tracker = '?';
									updatenumber();
								}
								else
									if(function != '@' && num.length() == 0)
									{
										num = "0";
										number = num;
									}
										
									if(function != '@')
										outputnumber.setText(fullCalc + num);
									else
										outputnumber.setText(num);
							}
						else if(tracker == 'b')
						    {
								Toast.makeText(getApplicationContext(), "Still Too Big", Toast.LENGTH_LONG).show();
								return;
							}
							
						else if(tracker == 't')
						{
							Toast.makeText(getApplicationContext(), "Too Many Operations", Toast.LENGTH_LONG).show();
							tracker = '@';
							return;
						}
							
						else if(tracker == 'n')
						    {
								outputnumber.setText("Positives Only!");
								num = "0";
								function = '@';
							}
							
						else if(tracker == 'z')
						    {
								outputnumber.setText("Cannot Divide by Zero!");
								num ="0";
								function = '@';
							}
							
						else if(tracker == '@')
						    {
								if(num == "0")
									num = "";
								
								num = num + String.valueOf(label);
								/*commaNum = commaNum + String.valueOf(label);
								comma ++;
								if(comma >= 4)
									addComma();*/
								
								
								if(num.length() == 10)
								    {
										Toast.makeText(getApplicationContext(), "Too Big", Toast.LENGTH_LONG).show();
										tracker = 'b';
										return;
									}
									
								else
								    {
										
										if(function != '@')
										{
											number = num;
											outputnumber.setText(fullCalc + num);
											cleared = false;
										}
										
										else
										{
											/*if(bigNum)
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
						else if(tracker == '?')
						    {
								outputnumber.setText("0");
							}
						else 
							{
								
								switch(function)
								    {
										case '+':
											if(precalc)
											{
												if((outputnumber.getText() != "0") && precalc)
													anstracker = true;
												fullCalc = String.valueOf(ans) + " + ";
												outputnumber.setText(fullCalc);
												loading();
												break;
											}
											else if(precalc == false && cleared)
											{
												tracker = '?';
												updatenumber();
												break;
											}
											else
											{
												if((outputnumber.getText() != "0") && precalc)
													anstracker = true;
												fullCalc = num + " + ";
												outputnumber.setText(fullCalc);
												loading();	
												break;
											}
											
										case '-':
											if(precalc)
											{
												if((outputnumber.getText() != "0") && precalc)
													anstracker = true;
												fullCalc = String.valueOf(ans) + " - ";
												outputnumber.setText(fullCalc);
												loading();
												break;
											}
											
											else if(precalc == false && cleared)
											{
												tracker = '?';
												updatenumber();
												break;
											}
											
											else
											{
												if((outputnumber.getText() != "0") && precalc)
													anstracker = true;
												fullCalc = num + " - ";
												outputnumber.setText(fullCalc);
												loading();
												break;
											}
											
										case '*':
											if(precalc)
											{
												if((outputnumber.getText() != "0") && precalc)
													anstracker = true;
												fullCalc = String.valueOf(ans) + " * ";
												outputnumber.setText(fullCalc);
												loading();
												break;
											}
											
											else if(precalc == false && cleared)
											{
												tracker = '?';
												updatenumber();
												break;
											}
											
											else
											{
												if((outputnumber.getText() != "0") && precalc)
													anstracker = true;
												fullCalc = num + " * ";
												outputnumber.setText(fullCalc);
												loading();
												break;
											}
											
										case '/':
											if(precalc)
											{
												if((outputnumber.getText() != "0") && precalc)
													anstracker = true;
												fullCalc = String.valueOf(ans) + " / ";
												outputnumber.setText(fullCalc);
												loading();
												break;
											}
											
											else if(precalc == false && cleared)
											{
												tracker = '?';
												updatenumber();
												break;
											}
											
											else
											{
												if((outputnumber.getText() != "0") && precalc)
												{
													anstracker = true;
												}
												fullCalc = num + " / ";
												outputnumber.setText(fullCalc);
												loading();
												break;
											}
											
										case '=':
											if(precalc == false && cleared)
											{
												tracker = '?';
												updatenumber();
												break;
											}
											else
											{
												if(compute(number) == -1)
											    {
													updatenumber();

												}

												else if(operator == '/')
											    {
													precalc = true;
													fullCalc = fullCalc + num + " = ";
													outputnumber.setText(fullCalc + String.valueOf(divresult));
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

												/*else if(round.length() > 11)
												 {

												 roundedresult = result;
												 outputnumber.setText(String.valueOf(roundedresult));

												 result = 0;
												 roundedresult = 0;													result = 0;
												 num = "0";

												 break;


												 }*/
												else
											    {
													/*if(precalc)
													{
														
													}*/
													precalc = true;
													fullCalc = fullCalc + num + " = ";
													outputnumber.setText(fullCalc + String.valueOf(compute(number)));
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
						tracker = '@';
					}
					
				public void addComma()
				{
					int step = 0;
					String superComma = commaNum;
					char[] oldNum = superComma.toCharArray();
					char[] newNum = new char[16];
					newNum[4 - step] = oldNum[step];
					
					/*for(int i = 0; i == 4; i++)
					{
						System.arraycopy(oldNum, i, newNum,(4 - i), 1);
						//newNum[(newNum.length - (4 + step))] = ',';
						//System.arraycopy(oldNum,, newNum, , 1);
						//step += 4;
						//newNum[4 - i] = oldNum[i];
					}*/
					//newNum[3] = oldNum[0];
					//newNum[2] = oldNum[1];
					//newNum[1] = oldNum[2];
					//newNum[0] = oldNum[3];
					//step += 4;
					superComma = new String(newNum);
					commaNum = superComma;
					commaCounter ++;
					bigNum = true;
					comma = 0;
					set = set + 4;
					
				}
					
				public void del()
				    {
						
						if(num == "0" && function == '@')
							num = "";
						
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
					}
					
				
				public void clearOutput()
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
					}
					
				public void nextCalc()
				{
					num = "0";
					function = '@';
					tracker = '@';
					precalc = false;
				}
					
				public long compute(String input)
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