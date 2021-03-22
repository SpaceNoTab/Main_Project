package com.example.aj.myn;


import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.widget.RelativeLayout.TRUE;

public class LeavesTaken extends AppCompatActivity {

    private ListView lvProduct;
    private CustomAdapter1 adapter1;
    private List<Dates> mDatelist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaves_taken);

        TextView sub = (TextView)findViewById(R.id.tv_sub);
        Bundle bundle = getIntent().getExtras();
        ImageView button = (ImageView) findViewById(R.id.forward);

        sub.setText(bundle.getString("subjectname"));

        lvProduct = (ListView)findViewById(R.id.ls_listView);

        mDatelist = new ArrayList<>();
        //Add sample data for list
        //We can get data from DB, webservice here
        mDatelist.add(new Dates("Computer Science"));
        mDatelist.add(new Dates("Physics"));
        mDatelist.add(new Dates("Chemistry"));
        mDatelist.add(new Dates("Computer Organisation"));
        mDatelist.add(new Dates("Artificial Intelligence"));
        mDatelist.add(new Dates("E-Commerce"));
        mDatelist.add(new Dates("Security in Computing"));
        mDatelist.add(new Dates("Digital Signal Processing"));
        mDatelist.add(new Dates("Object Oriented Programming"));
        mDatelist.add(new Dates("Web Development "));

        //Init adapter
        adapter1 = new CustomAdapter1(getApplicationContext(), mDatelist);
        lvProduct.setAdapter(adapter1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                // starting background task to update product
                Intent fp=new Intent(getApplicationContext(),DutyLeave.class);
                startActivity(fp);
            }
        });
    }


    public class CustomAdapter1 extends BaseAdapter {

        private Context mContext;
        private List<Dates> mDatelist;

        //Constructor

        public CustomAdapter1(Context mContext, List<Dates> mDatelist) {
            this.mContext = mContext;
            this.mDatelist = mDatelist;
        }

        @Override
        public int getCount() {
            return mDatelist.size();
        }

        @Override
        public Object getItem(int position) {
            return mDatelist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = View.inflate(mContext, R.layout.activity_leaves_taken1, null);
            TextView tvDate = (TextView)v.findViewById(R.id.tv_date);
            CheckBox checkBox =(CheckBox) v.findViewById(R.id.ch);
            //Set text for TextView
            tvDate.setText(mDatelist.get(position).getDate());
            checkBox.setVisibility(View.VISIBLE);




            return v;
        }

    }
}
