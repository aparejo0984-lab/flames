package com.example.activity1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    char a[],b[],c[]={'x','F','L','A','M','E','S'};
    int l1,l2,l3,ctr=0,f;
    void mark(int s,char m)
    {
        for(int k=0;k!=l2;k++)
        {
            if(b[k]==m)
            {
                b[k]='x';
                a[s]='x';
                return;
            }
            if((m==' ')||(m=='.'))
                a[s]='x';
            if((b[k]==' ')||(b[k]=='.'))
                b[k]='x';
        }
    }

    void ret()
    {
        for(int k=1;k!=l3;k++)
        {
            if(c[k]!='x')
            {
                f=k;
                return;
            }
        }
    }
    void nret(int y)
    {
        int hb;
        hb=y+1;
        while(true)
        {
            if(hb>6)
                hb=1;
            if(c[hb]!='x')
            {
                f=hb;
                return;
            }
            hb++;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button B=(Button)findViewById(R.id.buttonCalculate);
        final TextView TV= (TextView)findViewById(R.id.textViewResult);
        final EditText ed1=(EditText)findViewById(R.id.textName1);
        final EditText ed2=(EditText)findViewById(R.id.textName2);

        B.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                MainActivity ob=new MainActivity();

                String person1 =ed1.getText().toString();
                String person2 =ed2.getText().toString();

                ob.a=person1.toCharArray();
                ob.l1=person1.length();
                ob.b=person2.toCharArray();
                ob.l2=person2.length();

                ob.l3=7;
                for(int i=0;i!=ob.l1;i++)
                    ob.mark(i,ob.a[i]);

                for(int i=0;i!=ob.l1;i++)
                    if(ob.a[i]!='x')
                        ob.ctr++;
                for(int i=0;i!=ob.l2;i++)
                    if(ob.b[i]!='x')
                        ob.ctr++;

                ob.ret();
                for(int i=1;i<=5;i++)
                {
                    int g=1,d;
                    for(d=1;g<ob.ctr;d++)
                    {
                        if(d>6)
                            d=1;
                        if(ob.c[d]!='x')
                        {
                            ob.nret(ob.f);
                            g++;
                            if(ob.f>6)
                                ob.ret();
                        }
                    }
                    ob.c[ob.f]='x';
                    ob.nret(ob.f);
                }

                char lo='F';
                for(int j=1;j!=ob.l3;j++)
                    if(ob.c[j]!='x')
                        lo=ob.c[j];
                switch(lo)
                {
                    case 'F':TV.setText("FRIEND");
                        break;
                    case 'L':TV.setText("LOVE");
                        break;
                    case 'A':TV.setText("AFFECTION");
                        break;
                    case 'M':TV.setText("MARRIAGE");
                        break;
                    case 'E':TV.setText("ENEMY");
                        break;
                    case 'S':TV.setText("SISTER");
                        break;
                }
            }
        });

    }
}