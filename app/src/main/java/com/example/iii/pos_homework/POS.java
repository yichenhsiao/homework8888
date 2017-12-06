package com.example.iii.pos_homework;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class POS extends AppCompatActivity {
    String Meals []={"國寶咖啡(80元)","義式拿鐵(60元)","美式咖啡(50元)"};
    int Meals_Price[]={80,60,50};
    String Meals2="";
    int Meals_Price2;
    String MealsList="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pos);
        InitialComponent();

    }
    private View.OnClickListener btn_chose_click=new View.OnClickListener() {
        public DialogInterface.OnClickListener btn_chose_click=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("餐點："+Meals[which]);
                Meals2=Meals[which];
                Meals_Price2=Meals_Price[which];
            }
        };
        @Override
        public void onClick(View v) {
            AlertDialog.Builder builder=new AlertDialog.Builder(POS.this);
            builder.setTitle("請選擇");
            builder.setItems(Meals,btn_chose_click);
            Dialog message = builder.create();
            message.show();
        }

    };
    View.OnClickListener btn_chectout_click=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int a=Integer.parseInt(et1.getText().toString());
            MealsList+="餐點："+Meals2+"       "+"數量:"+a+"       "+"小計:"+Meals_Price2*a+"\n";
            list.setText(MealsList);

        }
    };

    private void InitialComponent() {
        btn_chose=(Button)findViewById(R.id.btn_chose);
        btn_chose.setOnClickListener(btn_chose_click);

        tv1=(TextView)findViewById(R.id.tv1);
        et1=(EditText)findViewById(R.id.et1);

        btn_chectout=(Button)findViewById(R.id.btn_chectout);

        btn_chectout.setOnClickListener(btn_chectout_click);
        list=(TextView)findViewById(R.id.list);
    }



    Button btn_chose;
    TextView tv1;
    EditText et1;
    Button btn_chectout;
    TextView list;


}
