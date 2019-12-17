package com.example.calculator;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * 数字
     */
    private Button num0;
    private Button num1;
    private Button num2;
    private Button num3;
    private Button num4;
    private Button num5;
    private Button num6;
    private Button num7;
    private Button num8;
    private Button num9;
    /**
     * 运算符
     */
    private Button plus_btn;
    private Button subtract_btn;
    private Button multiply_btn;
    private Button divide_btn;
    private Button equal_btn;
    /**
     * 其他
     */
    private Button o_btn;
    private Button b_btn;
    private Button sqrt_btn;
    private Button sin_btn;
    private Button cos_btn;
    private Button tan_btn;
    private Button ex_btn;
    private Button x2_btn;
    private Button xy_btn;
    private Button ln_btn;
    private Button log_btn;
    private Button x1_btn;
    private Button factorial_btn;
    private Button pi_btn;
    private Button e_btn;
    private Button dot_btn;
    private Button percent_btn;
    private Button delete_btn;
    private Button ac_btn;
    /**
     * 结果
     */
    private EditText mResultText;
    /**
     * 已经输入的字符
     */
    private String existedText = "";
    /**
     * 是否计算过
     */
    private boolean isCounted = false;
    /**
     * 以负号开头，且运算符不是是减号
     * 例如：-21×2
     */
    private boolean startWithOperator = false;
    /**
     * 以负号开头，且运算符是减号
     * 例如：-21-2
     */
    private boolean startWithSubtract = false;
    /**
     * 不以负号开头，且包含运算符
     * 例如：21-2
     */
    private boolean noStartWithOperator = false;

    /**
     * 使用java正则表达式去掉多余的.与0
     *
     * @param s 传入的字符串
     * @return 修改之后的字符串
     */
    public static String subZeroAndDot(String s) {
        if (s.indexOf(".") > 0) {
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return s;
    }


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int a=getResources().getConfiguration().orientation;
        initView(a);
        initEvent(a);

    }

    /**
     * 初始化控件
     */
    private void initView(int a) {
        /**
         * 数字
         */
        num0 = (Button) findViewById(R.id.num_zero);
        num1 = (Button) findViewById(R.id.num_one);
        num2 = (Button) findViewById(R.id.num_two);
        num3 = (Button) findViewById(R.id.num_three);
        num4 = (Button) findViewById(R.id.num_four);
        num5 = (Button) findViewById(R.id.num_five);
        num6 = (Button) findViewById(R.id.num_six);
        num7 = (Button) findViewById(R.id.num_seven);
        num8 = (Button) findViewById(R.id.num_eight);
        num9 = (Button) findViewById(R.id.num_nine);
        /**
         * 运算符
         */
        plus_btn = (Button) findViewById(R.id.plus_btn);
        subtract_btn = (Button) findViewById(R.id.subtract_btn);
        multiply_btn = (Button) findViewById(R.id.multiply_btn);
        divide_btn = (Button) findViewById(R.id.divide_btn);
        equal_btn = (Button) findViewById(R.id.equal_btn);
        /**
         * 其他
         */

            if (a==2) {
                o_btn = (Button) findViewById(R.id.o_btn);
                b_btn = (Button) findViewById(R.id.b_btn);
                sqrt_btn = (Button) findViewById(R.id.sqrt_btn);
                sin_btn = (Button) findViewById(R.id.sin_btn);
                cos_btn = (Button) findViewById(R.id.cos_btn);
                tan_btn = (Button) findViewById(R.id.tan_btn);
                ex_btn = (Button) findViewById(R.id.ex_btn);
                x2_btn = (Button) findViewById(R.id.x2_btn);
                xy_btn = (Button) findViewById(R.id.xy_btn);
                ln_btn = (Button) findViewById(R.id.ln_btn);
                log_btn = (Button) findViewById(R.id.log_btn);
                x1_btn = (Button) findViewById(R.id.x1_btn);
                factorial_btn = (Button) findViewById(R.id.factorial_btn);
                pi_btn = (Button) findViewById(R.id.pi_btn);
                e_btn = (Button) findViewById(R.id.e_btn);
            }
        dot_btn = (Button) findViewById(R.id.dot_btn);
        percent_btn = (Button) findViewById(R.id.percent_btn);
        delete_btn = (Button) findViewById(R.id.delete_btn);
        ac_btn = (Button) findViewById(R.id.ac_btn);
        /**
         * 结果
         */
        mResultText = (EditText) findViewById(R.id.result_text);
        /**
         * 已经输入的字符
         */
        existedText = mResultText.getText().toString();

    }

    /**
     * 初始化事件
     */
    private void initEvent(int a) {
        num0.setOnClickListener(this);
        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);
        num4.setOnClickListener(this);
        num5.setOnClickListener(this);
        num6.setOnClickListener(this);
        num7.setOnClickListener(this);
        num8.setOnClickListener(this);
        num9.setOnClickListener(this);

        plus_btn.setOnClickListener(this);
        subtract_btn.setOnClickListener(this);
        multiply_btn.setOnClickListener(this);
        divide_btn.setOnClickListener(this);
        equal_btn.setOnClickListener(this);
        if(a == 2){
            o_btn.setOnClickListener(this);
            b_btn.setOnClickListener(this);
            sqrt_btn.setOnClickListener(this);
            sin_btn.setOnClickListener(this);
            cos_btn.setOnClickListener(this);
            tan_btn.setOnClickListener(this);
            ex_btn.setOnClickListener(this);
            x2_btn.setOnClickListener(this);
            xy_btn.setOnClickListener(this);
            ln_btn.setOnClickListener(this);
            log_btn.setOnClickListener(this);
            x1_btn.setOnClickListener(this);
            factorial_btn.setOnClickListener(this);
            e_btn.setOnClickListener(this);
            pi_btn.setOnClickListener(this);
        }


        dot_btn.setOnClickListener(this);
        percent_btn.setOnClickListener(this);
        delete_btn.setOnClickListener(this);
        ac_btn.setOnClickListener(this);
    }

    /**
     * 点击事件
     *
     * @param v 点击的控件
     */
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            /**
             * 数字
             */
            case R.id.num_zero:
                existedText = isOverRange(existedText, "0");
                break;
            case R.id.num_one:
                existedText = isOverRange(existedText, "1");
                break;
            case R.id.num_two:
                existedText = isOverRange(existedText, "2");
                break;
            case R.id.num_three:
                existedText = isOverRange(existedText, "3");
                break;
            case R.id.num_four:
                existedText = isOverRange(existedText, "4");
                break;
            case R.id.num_five:
                existedText = isOverRange(existedText, "5");
                break;
            case R.id.num_six:
                existedText = isOverRange(existedText, "6");
                break;
            case R.id.num_seven:
                existedText = isOverRange(existedText, "7");
                break;
            case R.id.num_eight:
                existedText = isOverRange(existedText, "8");
                break;
            case R.id.num_nine:
                existedText = isOverRange(existedText, "9");
                break;

            /**
             * 运算符
             */
            case R.id.plus_btn:

                if (!existedText.contains("e")) {

                    if (judgeExpression()) {
                        existedText = getResult();
                        if (existedText.equals("error")) {

                        } else {
                            existedText += "+";
                        }
                    } else {

                        if (isCounted) {
                            isCounted = false;
                        }

                        if ((existedText.substring(existedText.length() - 1)).equals("-")) {
                            existedText = existedText.replace("-", "+");
                        } else if ((existedText.substring(existedText.length() - 1)).equals("×")) {
                            existedText = existedText.replace("×", "+");
                        } else if ((existedText.substring(existedText.length() - 1)).equals("÷")) {
                            existedText = existedText.replace("÷", "+");
                        } else if (!(existedText.substring(existedText.length() - 1)).equals("+")) {
                            existedText += "+";
                        }
                    }
                } else {
                    existedText = "0";
                }

                break;
            case R.id.subtract_btn:

                if (!existedText.contains("e")) {
                    if (judgeExpression()) {
                        existedText = getResult();
                        if (existedText.equals("error")) {

                        } else {
                            existedText += "-";
                        }
                    } else {

                        if (isCounted) {
                            isCounted = false;
                        }

                        if ((existedText.substring(existedText.length() - 1)).equals("+")) {
//                    Log.d("Anonymous", "onClick: " + "进入减法方法");
                            existedText = existedText.replace("+", "-");
                        } else if ((existedText.substring(existedText.length() - 1)).equals("×")) {
                            existedText = existedText.replace("×", "-");
                        } else if ((existedText.substring(existedText.length() - 1)).equals("÷")) {
                            existedText = existedText.replace("÷", "-");
                        } else if (!(existedText.substring(existedText.length() - 1)).equals("-")) {
                            existedText += "-";
                        }
                    }
                } else {
                    existedText = "0";
                }
                break;
            case R.id.multiply_btn:

                if (!existedText.contains("e")) {
                    if (judgeExpression()) {
                        existedText = getResult();
                        if (existedText.equals("error")) {

                        } else {
                            existedText += "×";
                        }

                    } else {

                        if (isCounted) {
                            isCounted = false;
                        }

                        if ((existedText.substring(existedText.length() - 1)).equals("+")) {
                            existedText = existedText.replace("+", "×");
                        } else if ((existedText.substring(existedText.length() - 1)).equals("-")) {
                            existedText = existedText.replace("-", "×");
                        } else if ((existedText.substring(existedText.length() - 1)).equals("÷")) {
                            existedText = existedText.replace("÷", "×");
                        } else if (!(existedText.substring(existedText.length() - 1)).equals("×")) {
                            existedText += "×";
                        }
                    }
                } else {
                    existedText = "0";
                }
                break;
            case R.id.xy_btn:

                if (!existedText.contains("e")) {
                    if (judgeExpression()) {
                        existedText = getResult();
                        if (existedText.equals("error")) {

                        } else {
                            existedText += "^";
                        }

                    } else {

                        if (isCounted) {
                            isCounted = false;
                        }

                        if ((existedText.substring(existedText.length() - 1)).equals("+")) {
                            existedText = existedText.replace("+", "^");
                        } else if ((existedText.substring(existedText.length() - 1)).equals("-")) {
                            existedText = existedText.replace("-", "^");
                        } else if ((existedText.substring(existedText.length() - 1)).equals("÷")) {
                            existedText = existedText.replace("÷", "^");
                        } else if (!(existedText.substring(existedText.length() - 1)).equals("^")) {
                            existedText += "^";
                        }
                    }
                } else {
                    existedText = "0";
                }
                break;
            case R.id.divide_btn:

                if (!existedText.contains("e")) {
                    if (judgeExpression()) {
                        existedText = getResult();
                        if (existedText.equals("error")) {

                        } else {
                            existedText += "÷";
                        }

                    } else {

                        if (isCounted) {
                            isCounted = false;
                        }

                        if ((existedText.substring(existedText.length() - 1)).equals("+")) {
                            existedText = existedText.replace("+", "÷");
                        } else if ((existedText.substring(existedText.length() - 1)).equals("-")) {
                            existedText = existedText.replace("-", "÷");
                        } else if ((existedText.substring(existedText.length() - 1)).equals("×")) {
                            existedText = existedText.replace("×", "÷");
                        } else if (!(existedText.substring(existedText.length() - 1)).equals("÷")) {
                            existedText += "÷";
                        }
                    }
                } else {
                    existedText = "0";
                }
                break;
            case R.id.equal_btn:
                existedText = getResult();
                isCounted = true;
                break;
            /**
             * 其他
             */
            case R.id.dot_btn:

                if (!isCounted) {

                    if (existedText.contains("+") || existedText.contains("-") ||
                            existedText.contains("×") || existedText.contains("÷")) {

                        String param1 = null;
                        String param2 = null;

                        if (existedText.contains("+")) {
                            param1 = existedText.substring(0, existedText.indexOf("+"));
                            param2 = existedText.substring(existedText.indexOf("+") + 1);
                        } else if (existedText.contains("-")) {
                            param1 = existedText.substring(0, existedText.indexOf("-"));
                            param2 = existedText.substring(existedText.indexOf("-") + 1);
                        } else if (existedText.contains("×")) {
                            param1 = existedText.substring(0, existedText.indexOf("×"));
                            param2 = existedText.substring(existedText.indexOf("×") + 1);
                        } else if (existedText.contains("÷")) {
                            param1 = existedText.substring(0, existedText.indexOf("÷"));
                            param2 = existedText.substring(existedText.indexOf("÷") + 1);
                        }
                        Log.d("Anonymous param1", param1);
                        Log.d("Anonymous param2", param2);

                        boolean isContainedDot = param2.contains(".");
                        if (param2.length() >= 9) {

                        } else if (!isContainedDot) {
                            if (param2.equals("")) {
                                existedText += "0.";
                            } else {
                                existedText += ".";
                            }
                        } else {
                            return;
                        }
                    } else {
                        boolean isContainedDot = existedText.contains(".");
                        if (existedText.length() >= 9) {

                        } else if (!isContainedDot) {
                            existedText += ".";
                        } else {
                            return;
                        }
                    }
                    isCounted = false;

                } else {
                    existedText = "0.";
                    isCounted = false;
                }


                break;
            case R.id.percent_btn:

                if (existedText.equals("error")) {

                } else {

                    getCondition();

                    if (startWithOperator || startWithSubtract || noStartWithOperator) {

                    } else {
                        if (existedText.equals("0")) {
                            return;
                        } else {
                            double temp = Double.parseDouble(existedText);
                            temp = temp / 100;
                            existedText = String.valueOf(temp);
                        }
                    }
                }
                break;
            case R.id.sqrt_btn:

                if (existedText.equals("error")) {

                } else {

                    getCondition();

                    if (startWithOperator || startWithSubtract || noStartWithOperator) {

                    } else {
                        if (existedText.equals("0")) {
                            return;
                        } else {
                            double temp = Double.parseDouble(existedText);
                            temp = Math.sqrt(temp);
                            existedText = String.valueOf(temp);
                        }
                    }
                }
                break;
            case R.id.o_btn:

                if (existedText.equals("error")) {

                } else {

                    getCondition();

                    if (startWithOperator || startWithSubtract || noStartWithOperator) {

                    } else {
                        if (existedText.equals("0")) {
                            return;
                        } else {
                            Integer temp = Integer.valueOf(existedText);

                            existedText = Integer.toOctalString(temp);
                           ;
                        }
                    }
                }
                break;
            case R.id.b_btn:

                if (existedText.equals("error")) {

                } else {

                    getCondition();

                    if (startWithOperator || startWithSubtract || noStartWithOperator) {

                    } else {
                        if (existedText.equals("0")) {
                            return;
                        } else {
                            Integer temp = Integer.valueOf(existedText);

                            existedText = Integer.toBinaryString(temp);

                        }
                    }
                }
                break;
            case R.id.sin_btn:

                if (existedText.equals("error")) {

                } else {

                    getCondition();

                    if (startWithOperator || startWithSubtract || noStartWithOperator) {

                    } else {

                            double temp = Double.parseDouble(existedText);

                            temp =Math.sin(temp*2*Math.PI/360);
                            existedText = String.valueOf(temp);

                    }
                }
                break;
            case R.id.cos_btn:

                if (existedText.equals("error")) {

                } else {

                    getCondition();

                    if (startWithOperator || startWithSubtract || noStartWithOperator) {

                    } else {

                            double temp = Double.parseDouble(existedText);

                            temp =Math.cos(temp*2*Math.PI/360);
                            existedText = String.valueOf(temp);

                    }
                }
                break;
            case R.id.tan_btn:

                if (existedText.equals("error")) {

                } else {

                    getCondition();

                    if (startWithOperator || startWithSubtract || noStartWithOperator) {

                    } else {
                        if (existedText.equals("90")) {
                            existedText=("error");

                        } else {
                            double temp = Double.parseDouble(existedText);

                            temp =Math.tan(temp*2*Math.PI/360);
                            existedText = String.valueOf(temp);
                        }
                    }
                }
                break;
            case R.id.ex_btn:

                if (existedText.equals("error")) {

                } else {

                    getCondition();

                    if (startWithOperator || startWithSubtract || noStartWithOperator) {

                    } else {

                            double temp = Double.parseDouble(existedText);
                            temp =Math.exp(temp);
                            existedText = String.valueOf(temp);

                    }
                }
                break;
            case R.id.x2_btn:

                if (existedText.equals("error")) {

                } else {

                    getCondition();

                    if (startWithOperator || startWithSubtract || noStartWithOperator) {

                    } else {

                        double temp = Double.parseDouble(existedText);
                        temp =Math.pow(temp,2);
                        existedText = String.valueOf(temp);

                    }
                }
                break;
            case R.id.ln_btn:

                if (existedText.equals("error")) {

                } else {

                    getCondition();

                    if (startWithOperator || startWithSubtract || noStartWithOperator) {

                    } else {

                        double temp = Double.parseDouble(existedText);
                        temp =Math.log10(temp);
                        existedText = String.valueOf(temp);

                    }
                }
                break;
            case R.id.log_btn:

                if (existedText.equals("error")) {

                } else {

                    getCondition();

                    if (startWithOperator || startWithSubtract || noStartWithOperator) {

                    } else {

                        double temp = Double.parseDouble(existedText);
                        temp =Math.log(temp);
                        existedText = String.valueOf(temp);

                    }
                }
                break;
            case R.id.x1_btn:

                if (existedText.equals("error")) {

                } else {

                    getCondition();

                    if (startWithOperator || startWithSubtract || noStartWithOperator) {

                    } else {
                        if (existedText.equals("0")) {
                            existedText=("error");
                        } else {
                            double temp = Double.parseDouble(existedText);
                            temp = 1/temp;
                            existedText = String.valueOf(temp);
                        }
                    }
                }
                break;
            case R.id.factorial_btn:

                if (existedText.equals("error")) {

                } else {

                    getCondition();

                    if (startWithOperator || startWithSubtract || noStartWithOperator) {

                    } else {

                        double temp = Double.parseDouble(existedText);
                        double b=1;
                        for(int f=1;f<=temp;f++){
                            b=b*f;
                        }
                        existedText = String.valueOf(b);

                    }
                }
                break;
            case R.id.pi_btn:

                if (existedText.equals("error")) {

                } else {

                    getCondition();

                    if (startWithOperator || startWithSubtract || noStartWithOperator) {

                    } else {

                        double temp = Double.parseDouble(existedText);

                        temp=Math.PI;

                        existedText = String.valueOf(temp);

                    }
                }
                break;
            case R.id.e_btn:

                if (existedText.equals("error")) {

                } else {

                    getCondition();

                    if (startWithOperator || startWithSubtract || noStartWithOperator) {

                    } else {

                        double temp = Double.parseDouble(existedText);

                        temp=Math.E;

                        existedText = String.valueOf(temp);

                    }
                }
                break;






            case R.id.delete_btn:

                if (existedText.equals("error")) {
                    existedText = "0";
                } else if (existedText.length() > 0) {
                    if (existedText.length() == 1) {
                        existedText = "0";
                    } else {
                        existedText = existedText.substring(0, existedText.length() - 1);
                    }
                }
                break;
            case R.id.ac_btn:
                existedText = "0";
                break;

        }

        /**
         * 设置显示
         */
        mResultText.setText(existedText);
    }

    /**
     * 进行运算，得到结果
     *
     * @return 返回结果
     */
    private String getResult() {

        /**
         * 结果
         */
        String tempResult = null;
        /**
         * 两个String类型的参数
         */
        String param1 = null;
        String param2 = null;
        /**
         * 转换后的两个double类型的参数
         */
        double arg1 = 0;
        double arg2 = 0;
        double result = 0;

        getCondition();

        /**
         * 如果有运算符，则进行运算
         * 没有运算符，则把已经存在的数据再传出去
         */
        if (startWithOperator || noStartWithOperator || startWithSubtract) {

            if (existedText.contains("+")) {
                /**
                 * 先获取两个参数
                 */
                param1 = existedText.substring(0, existedText.indexOf("+"));
                param2 = existedText.substring(existedText.indexOf("+") + 1);
                /**
                 * 如果第二个参数为空，则还是显示当前字符
                 */
                if (param2.equals("")) {
                    tempResult = existedText;
                } else {
                    /**
                     * 转换String为Double
                     * 计算后再转换成String类型
                     * 进行正则表达式处理
                     */
                    arg1 = Double.parseDouble(param1);
                    arg2 = Double.parseDouble(param2);
                    result = arg1 + arg2;
                    tempResult = String.format("%f", result);
                    tempResult = subZeroAndDot(tempResult);
                }


            } else if (existedText.contains("×")) {

                param1 = existedText.substring(0, existedText.indexOf("×"));
                param2 = existedText.substring(existedText.indexOf("×") + 1);

                if (param2.equals("")) {
                    tempResult = existedText;
                } else {
                    arg1 = Double.parseDouble(param1);
                    arg2 = Double.parseDouble(param2);
                    result = arg1 * arg2;
                    tempResult = String.format("%f", result);
                    tempResult = subZeroAndDot(tempResult);
                }

            } else if (existedText.contains("÷")) {

                param1 = existedText.substring(0, existedText.indexOf("÷"));
                param2 = existedText.substring(existedText.indexOf("÷") + 1);

                if (param2.equals("0")) {
                    tempResult = "error";
                } else if (param2.equals("")) {
                    tempResult = existedText;
                } else {
                    arg1 = Double.parseDouble(param1);
                    arg2 = Double.parseDouble(param2);
                    result = arg1 / arg2;
                    tempResult = String.format("%f", result);
                    tempResult = subZeroAndDot(tempResult);
                }

            } else if (existedText.contains("-")) {

                /**
                 * 这里是以最后一个 - 号为分隔去取出两个参数
                 * 进到这个方法，必须满足有运算公式
                 * 而又避免了第一个参数是负数的情况
                 */
                param1 = existedText.substring(0, existedText.lastIndexOf("-"));
                param2 = existedText.substring(existedText.lastIndexOf("-") + 1);

                if (param2.equals("")) {
                    tempResult = existedText;
                } else {
                    arg1 = Double.parseDouble(param1);
                    arg2 = Double.parseDouble(param2);
                    result = arg1 - arg2;
                    tempResult = String.format("%f", result);
                    tempResult = subZeroAndDot(tempResult);
                }

            }else if (existedText.contains("^")) {

                /**
                 * 这里是以最后一个 ^号为分隔去取出两个参数
                 * 进到这个方法，必须满足有运算公式
                 * 而又避免了第一个参数是负数的情况
                 */
                param1 = existedText.substring(0, existedText.lastIndexOf("^"));
                param2 = existedText.substring(existedText.lastIndexOf("^") + 1);
                Log.d("Main", "getResult: ajlksjda");
                if (param2.equals("")) {
                    tempResult = existedText;
                } else {
                    arg1 = Double.parseDouble(param1);
                    arg2 = Double.parseDouble(param2);
                    result = Math.pow(arg1,arg2);
                    tempResult = String.format("%f", result);
                    tempResult = subZeroAndDot(tempResult);

                }

            }
            /**
             * 如果数据长度大于等于10位，进行科学计数
             *
             * 如果有小数点，再判断小数点前是否有十个数字，有则进行科学计数
             */
            if (tempResult.length() >= 10) {
                tempResult = String.format("%e", Double.parseDouble(tempResult));
            } else if (tempResult.contains(".")) {
                if (tempResult.substring(0, tempResult.indexOf(".")).length() >= 10) {
                    tempResult = String.format("%e", Double.parseDouble(tempResult));
                }
            }
        } else {
            tempResult = existedText;

        }

        return tempResult;
    }



    private String isOverRange(String existedText, String s) {
        /**
         * 判断是否计算过
         */
        if (!isCounted) {
            /**
             * 判断是否是科学计数
             * 是 文本置零
             */
            if (existedText.contains("e")) {
                existedText = "0";
            }
            /**
             * 判断是否只有一个 0
             * 是 文本清空
             */
            if (existedText.equals("0")) {
                existedText = "";
            }
             /**
             * 判断是否有运算符
             * 是 判断第二个数字
             * 否 判断整个字符串
             */
            if (existedText.contains("+") || existedText.contains("-") ||
                    existedText.contains("×") || existedText.contains("÷")) {
                /**
                 * 包括运算符时 两个数字 判断第二个数字
                 * 两个参数
                 */
                String param2 = null;
                if (existedText.contains("+")) {
                    param2 = existedText.substring(existedText.indexOf("+") + 1);
                } else if (existedText.contains("-")) {
                    param2 = existedText.substring(existedText.indexOf("-") + 1);
                } else if (existedText.contains("×")) {
                    param2 = existedText.substring(existedText.indexOf("×") + 1);
                } else if (existedText.contains("÷")) {
                    param2 = existedText.substring(existedText.indexOf("÷") + 1);
                }

//            Log.d("Anonymous param1",param1);
//            Log.d("Anonymous param2",param2);
                if (existedText.substring(existedText.length() - 1).equals("+") ||
                        existedText.substring(existedText.length() - 1).equals("-") ||
                        existedText.substring(existedText.length() - 1).equals("×") ||
                        existedText.substring(existedText.length() - 1).equals("÷")) {
                    existedText += s;
                } else {
                    if (param2.contains(".")) {
                        if (param2.length() >= 10) {

                        } else {
                            existedText += s;
                        }
                    } else {
                        if (param2.length() >= 9) {

                        } else {
                            existedText += s;
                        }
                    }
                }
            } else {
                /**
                 * 不包括运算符时 一个数字
                 */
                if (existedText.contains(".")) {
                    if (existedText.length() >= 10) {

                    } else {
                        existedText += s;
                    }
                } else {
                    if (existedText.length() >= 9) {

                    } else {
                        existedText += s;
                    }
                }
            }

            isCounted = false;

        } else {

            existedText = s;
            isCounted = false;

        }


        return existedText;
    }

    /**
     * 判断表达式
     * <p>
     * 为了按等号是否进行运算
     * 以及出现两个运算符（第一个参数如果为负数的符号不计）先进行运算再添加运算符
     */

    private boolean judgeExpression() {

        getCondition();

        String tempParam2 = null;

        if (startWithOperator || noStartWithOperator || startWithSubtract) {


                if (existedText.contains("+")) {
                    /**
                     * 先获取第二个参数
                     */
                    tempParam2 = existedText.substring(existedText.indexOf("+") + 1);
                    /**
                     * 如果第二个参数为空，表达式不成立
                     */
                    if (tempParam2.equals("")) {
                        return false;
                    } else {
                        return true;
                    }
                } else if (existedText.contains("×")) {

                    tempParam2 = existedText.substring(existedText.indexOf("×") + 1);

                    if (tempParam2.equals("")) {
                        return false;
                    } else {
                        return true;
                    }

                } else if (existedText.contains("÷")) {

                    tempParam2 = existedText.substring(existedText.indexOf("÷") + 1);

                    if (tempParam2.equals("")) {
                        return false;
                    } else {
                        return true;
                    }

                } else if (existedText.contains("-")) {

                    /**
                     * 这里是以最后一个 - 号为分隔去取出两个参数
                     * 进到这个方法，必须满足有运算公式
                     * 而又避免了第一个参数是负数的情况
                     */
                    tempParam2 = existedText.substring(existedText.lastIndexOf("-") + 1);

                    if (tempParam2.equals("")) {
                        return false;
                    } else {
                        return true;
                    }

                    }

                 }


        return false;
    }

    /**
     * 取得判断条件
     */
    private void getCondition() {
        /**
         * 以负号开头，且运算符不是是减号
         * 例如：-21×2
         */
        startWithOperator = existedText.startsWith("-") && (existedText.contains("+") ||
                existedText.contains("×") || existedText.contains("÷"));
        /**
         * 以负号开头，且运算符是减号
         * 例如：-21-2
         */
        startWithSubtract = existedText.startsWith("-") && (existedText.lastIndexOf("-") != 0);
        /**
         * 不以负号开头，且包含运算符
         * 例如：21-2
         */
        noStartWithOperator = !existedText.startsWith("-") && (existedText.contains("+") ||
                existedText.contains("-") || existedText.contains("×") || existedText.contains("÷")
                ||existedText.contains("^")||existedText.contains("("))||existedText.contains(")");

    }

}
