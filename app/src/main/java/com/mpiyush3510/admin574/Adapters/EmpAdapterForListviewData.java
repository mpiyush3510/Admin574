package com.mpiyush3510.admin574.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textview.MaterialTextView;
import com.mpiyush3510.admin574.R;
import com.mpiyush3510.admin574.Views.ExportData;

import de.hdodenhof.circleimageview.CircleImageView;

public class EmpAdapterForListviewData extends BaseAdapter {
     Context context;
     int[] EmpUserImg;
     String[] EmpUserName;
     String[] EmpUserMail;
     String[] EmpUserPhone;
     String[] EmpUserDesignation;
     LayoutInflater inflater;

    public EmpAdapterForListviewData(Context context, int[] empUserImg, String[] empUserName, String[] empUserMail, String[] empUserPhone, String[] empUserDesignation) {
        this.context = context;
        EmpUserImg = empUserImg;
        EmpUserName = empUserName;
        EmpUserMail = empUserMail;
        EmpUserPhone = empUserPhone;
        EmpUserDesignation = empUserDesignation;
        inflater=LayoutInflater.from(context);
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public int[] getEmpUserImg() {
        return EmpUserImg;
    }

    public void setEmpUserImg(int[] empUserImg) {
        EmpUserImg = empUserImg;
    }

    public String[] getEmpUserName() {
        return EmpUserName;
    }

    public void setEmpUserName(String[] empUserName) {
        EmpUserName = empUserName;
    }

    public String[] getEmpUserMail() {
        return EmpUserMail;
    }

    public void setEmpUserMail(String[] empUserMail) {
        EmpUserMail = empUserMail;
    }

    public String[] getEmpUserPhone() {
        return EmpUserPhone;
    }

    public void setEmpUserPhone(String[] empUserPhone) {
        EmpUserPhone = empUserPhone;
    }

    public String[] getEmpUserDesignation() {
        return EmpUserDesignation;
    }

    public void setEmpUserDesignation(String[] empUserDesignation) {
        EmpUserDesignation = empUserDesignation;
    }

    @Override
    public int getCount() {
        return EmpUserName.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=inflater.inflate(R.layout.emp_list,parent,false);
        ImageView img=convertView.findViewById(R.id.EmpImg);
        MaterialTextView name=convertView.findViewById(R.id.EmpName);
        MaterialTextView mail=convertView.findViewById(R.id.EmpMail);
        MaterialTextView phone=convertView.findViewById(R.id.EmpPhoneNo);
        MaterialTextView designation=convertView.findViewById(R.id.EmpDesignation);

        img.setImageResource(EmpUserImg[position]);
        name.setText(EmpUserName[position]);
        mail.setText(EmpUserMail[position]);
        phone.setText(EmpUserPhone[position]);
        designation.setText(EmpUserDesignation[position]);

        convertView.findViewById(R.id.ViewUser).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(EmpAdapterForListviewData.this.getContext(), ExportData.class);
                intent.putExtra("img",EmpUserImg[position]);
                intent.putExtra("name",EmpUserName[position]);
                intent.putExtra("mail",EmpUserMail[position]);
                intent.putExtra("phone",EmpUserPhone[position]);
                intent.putExtra("designation",EmpUserDesignation[position]);
                view.getContext().startActivity(intent);
            }
        });
        return convertView;
    }
}
