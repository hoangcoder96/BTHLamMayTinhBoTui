package nhatto.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtInput;
    private TextView tvResult;

    private Button btnNumber1;
    private Button btnNumber2;
    private Button btnNumber3;
    private Button btnNumber4;
    private Button btnNumber5;
    private Button btnNumber6;
    private Button btnNumber7;
    private Button btnNumber8;
    private Button btnNumber9;
    private Button btnNumber0;

    private Button btnCong;
    private Button btnTru;
    private Button btnNhan;
    private Button btnChia;

    private Button btnPoint;
    private Button btnResult;
    private Button btnClear;
    private Button btnClearAll;
    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        setEvClickViews();
    }

    public void initWidget() {
        edtInput = (EditText) findViewById(R.id.edt_input);
        tvResult = (TextView) findViewById(R.id.tv_result);
        btnNumber1 = (Button) findViewById(R.id.btn_number1);
        btnNumber2 = (Button) findViewById(R.id.btn_number2);
        btnNumber3 = (Button) findViewById(R.id.btn_number3);
        btnNumber4 = (Button) findViewById(R.id.btn_number4);
        btnNumber5 = (Button) findViewById(R.id.btn_number5);
        btnNumber6 = (Button) findViewById(R.id.btn_number6);
        btnNumber7 = (Button) findViewById(R.id.btn_number7);
        btnNumber8 = (Button) findViewById(R.id.btn_number8);
        btnNumber9 = (Button) findViewById(R.id.btn_number9);
        btnNumber0 = (Button) findViewById(R.id.btn_number0);

        btnCong = (Button) findViewById(R.id.btn_cong);
        btnTru = (Button) findViewById(R.id.btn_tru);
        btnNhan = (Button) findViewById(R.id.btn_nhan);
        btnChia = (Button) findViewById(R.id.btn_chia);

        btnPoint = (Button) findViewById(R.id.btn_point);
        btnResult = (Button) findViewById(R.id.btn_result);
        btnClear = (Button) findViewById(R.id.btn_clear);
        btnClearAll = (Button) findViewById(R.id.btn_clearAll);
    }

    public void setEvClickViews() {
        btnNumber1.setOnClickListener(this);
        btnNumber2.setOnClickListener(this);
        btnNumber3.setOnClickListener(this);
        btnNumber4.setOnClickListener(this);
        btnNumber5.setOnClickListener(this);
        btnNumber6.setOnClickListener(this);
        btnNumber7.setOnClickListener(this);
        btnNumber8.setOnClickListener(this);
        btnNumber9.setOnClickListener(this);
        btnNumber0.setOnClickListener(this);

        btnCong.setOnClickListener(this);
        btnTru.setOnClickListener(this);
        btnNhan.setOnClickListener(this);
        btnChia.setOnClickListener(this);

        btnPoint.setOnClickListener(this);
        btnResult.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnClearAll.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_number1:
                //To Do
                edtInput.append("1");
                break;
            case R.id.btn_number2:
                //To Do
                edtInput.append("2");
                break;
            case R.id.btn_number3:
                //To Do
                edtInput.append("3");
                break;
            case R.id.btn_number4:
                //To Do
                edtInput.append("4");
                break;
            case R.id.btn_number5:
                //To Do
                edtInput.append("5");
                break;
            case R.id.btn_number6:
                //To Do
                edtInput.append("6");
                break;
            case R.id.btn_number7:
                //To Do
                edtInput.append("7");
                break;
            case R.id.btn_number8:
                //To Do
                edtInput.append("8");
                break;
            case R.id.btn_number9:
                //To Do
                edtInput.append("9");
                break;
            case R.id.btn_number0:
                //To Do
                edtInput.append("0");
                break;
            case R.id.btn_cong:
                //To Do
                edtInput.append("+");
                break;
            case R.id.btn_tru:
                //To Do
                edtInput.append("-");
                break;
            case R.id.btn_nhan:
                //To Do
                edtInput.append("*");
                break;
            case R.id.btn_chia:
                //To Do
                edtInput.append("/");
                break;
            case R.id.btn_point:
                //To Do
                edtInput.append(".");
                break;
            case R.id.btn_result:
                //To Do
                DecimalFormat df = new DecimalFormat("###.#######");
                double result = 0;
                addOperation(edtInput.getText().toString());
                addInput(edtInput.getText().toString());
                //Thuat toan tinh bieu thuc
                if (arrOperation.size() >= arrInput.size() || arrOperation.size()<1) {
                    tvResult.setText("Lỗi nhập liệu");
                } else {
                    for (int i = 0; i < (arrInput.size() - 1); i++) {
                        switch (arrOperation.get(i)) {
                            case "+":
                                if (i == 0) {
                                    result = arrInput.get(i) + arrInput.get(i + 1);
                                } else {
                                    result = result + arrInput.get(i + 1);
                                }
                                break;
                            case "-":
                                if (i == 0) {
                                    result = arrInput.get(i) - arrInput.get(i + 1);
                                } else {
                                    result = result - arrInput.get(i + 1);
                                }
                                break;
                            case "*":
                                if (i == 0) {
                                    result = arrInput.get(i) * arrInput.get(i + 1);
                                } else {
                                    result = result * arrInput.get(i + 1);
                                }
                                break;
                            case "/":
                                if (i == 0) {
                                    result = arrInput.get(i) / arrInput.get(i + 1);
                                } else {
                                    result = result / arrInput.get(i + 1);
                                }
                                break;
                            default:
                                break;
                        }
                    }
                    tvResult.setText(df.format(result) + "");
                }
//                Log.d(TAG, "onClick:" + result);



                break;
            case R.id.btn_clear:
                //cach1:Xoa ky tu cuoi cung
//                String numberAfterRemove = deleteANumber(edtInput.getText().toString());
//                edtInput.setText(numberAfterRemove);
                //cach2:
                BaseInputConnection textFieldInputConnection = new BaseInputConnection(edtInput, true);
                textFieldInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                break;
            case R.id.btn_clearAll:
                //To Do
                edtInput.setText("");
                break;
        }
    }

    //cach1:Xoa ky tu cuoi cung
//    public String deleteANumber(String number){
//        int lenght = number.length();
//        String tem = number.substring(0,lenght-1);
//        return tem;
//    }
    public ArrayList<String> arrOperation;
    public ArrayList<Double> arrInput;

    public int addOperation(String input) {
        arrOperation = new ArrayList<>();
        char[] cArray = input.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            switch (cArray[i]) {
                case '+':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '-':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '*':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '/':
                    arrOperation.add(cArray[i] + "");
                    break;
                default:
            }
        }
        return 0;
    }

    public void addInput(String sInput) {
        arrInput = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(sInput);
        while (matcher.find()) {
            arrInput.add(Double.valueOf(matcher.group(1)));
        }
    }
}
