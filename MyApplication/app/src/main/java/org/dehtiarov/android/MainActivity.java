package org.dehtiarov.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Double> debtList = datasource.debtList;
        TableLayout table = (TableLayout) findViewById(R.id.myTableLayout);
        for(int i=0;i<debtList.size();i++)
        {
            TableRow row=new TableRow(this);
            double debt = debtList.get(i);
            double fee = feeList.get(i);
            TextView tvDebt=new TextView(this);
            tvDebt.setText(""+debt);
            TextView tvFee=new TextView(this);
            tvFee.setText(""+fee);
            row.addView(tvDebt);
            row.addView(tvFee);
            table.addView(row);
        }
    }
}
