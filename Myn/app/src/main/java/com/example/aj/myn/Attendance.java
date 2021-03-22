package com.example.aj.myn;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Attendance extends AppCompatActivity {
    private ListView lvProduct;
    private CustomAdapter adapter;
    private List<Elements> mSubjectList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        lvProduct = (ListView)findViewById(R.id.listView);

        mSubjectList = new ArrayList<>();
        //Add sample data for list
        //We can get data from DB, webservice here
        mSubjectList.add(new Elements(1, "Computer Science", 75));
        mSubjectList.add(new Elements(3, "Physics", 50));
        mSubjectList.add(new Elements(4, "Chemistry", 80));
        mSubjectList.add(new Elements(5, "Computer Organisation", 50));
        mSubjectList.add(new Elements(6, "Artificial Intelligence", 70));
        mSubjectList.add(new Elements(7, "E-Commerce", 77));
        mSubjectList.add(new Elements(8, "Security in Computing", 90));
        mSubjectList.add(new Elements(9, "Digital Signal Processing", 45));
        mSubjectList.add(new Elements(10, "Object Oriented Programming", 99));
        mSubjectList.add(new Elements(11, "Web Development ", 100));

        //Init adapter
        adapter = new CustomAdapter(getApplicationContext(), mSubjectList);
        lvProduct.setAdapter(adapter);

        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Do something
                //Ex: display msg with product id get from view.getTag
               // Toast.makeText(getApplicationContext(), "Clicked product id =" + view.getTag(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Attendance.this,LeavesTaken.class);
                intent.putExtra("subjectname",(mSubjectList.get(position).getName()));
                startActivity(intent);

            }
        });
    }




    public class CustomAdapter extends BaseAdapter {

        private Context mContext;
        private List<Elements> mSubjectlist;

        //Constructor

        public CustomAdapter(Context mContext, List<Elements> mSubjectlist) {
            this.mContext = mContext;
            this.mSubjectlist = mSubjectlist;
        }

        @Override
        public int getCount() {
            return mSubjectlist.size();
        }

        @Override
        public Object getItem(int position) {
            return mSubjectlist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = View.inflate(mContext, R.layout.activity_attendance1, null);
            TextView tvName = (TextView)v.findViewById(R.id.textsubject);
            TextView tvPrice = (TextView)v.findViewById(R.id.textpercent);
            //Set text for TextView
            tvName.setText(mSubjectlist.get(position).getName());
            tvPrice.setText(String.valueOf(mSubjectlist.get(position).getPercentage()) );

            //Save product id to tag
              v.setTag(mSubjectlist.get(position).getId());


            return v;
        }

    }
}



