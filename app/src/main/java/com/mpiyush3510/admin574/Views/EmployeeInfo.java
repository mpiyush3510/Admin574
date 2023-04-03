package com.mpiyush3510.admin574.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mpiyush3510.admin574.Adapters.EmpAdapterForListviewData;
import com.mpiyush3510.admin574.R;
import com.mpiyush3510.admin574.databinding.ActivityEmployeeInfoBinding;

public class EmployeeInfo extends AppCompatActivity {
ActivityEmployeeInfoBinding binding;
int[] EmpUserImg={R.drawable.ajay_frag,R.drawable.ajith_frag,R.drawable.anamika_saini,
        R.drawable.anju,R.drawable.arpit_frag,R.drawable.dharmendra_frag,R.drawable.hitixa_patel,R.drawable.mayank_frag,
        R.drawable.nikhil_frag,R.drawable.nimi_jagid,R.drawable.noor_jahan,R.drawable.piyush_frag,R.drawable.rajat_frag,
        R.drawable.saima_khanjpg,R.drawable.sheetal_sinha,R.drawable.umesh_frag
};
String[] EmpUserName={"Mr.Ajay Mali","Mr.Ajith Sahji","Ms.Anamika Saini","Ms.Anju Parmar","Mr.Arpit Kakdiya",
        "Mr.Dharmendra","Ms.Hitixa Rathod","Mr.Mayank","Mr.Nikhil Mishra","Ms.Nimi Jagid","Ms.Noor Jahan",
        "Mr.Piyush Makwana","Mr.Rajat Kevat","Ms.Saima Khan","Ms.Sheetal Sinha","Mr.Umesh Mishra"};

String[] EmpUserEmail={
        "ajaymali@cw.org", "ajith_sahji@cw.org", "anamika@cw.org", "anju@cw.org", "ark@cw.org",
        "dharmendra@cw.org", "hitixa@cw.org", "mayank@cw.org", "nikhil_mishra@cw.org", "nimi@cw.org",
        "noor@cw.org", "mpiyush3510@cw.org", "rdx@cw.org", "saima@cw.org", "sheetal@cw.org", "umesh@cw.org"
};

String[] EmpUserPhoneNo={
        "+91 87575 75855","+91 85754 44876","+91 90675 66646","+91 80978 87879","+91 75757 80980",
        "+91 90708 08080","+91 80879 80877","+91 87798 80987","+91 89708 09877","+91 80767 88779 ",
        "+91 80776 78907","+91 87979 90987","+91 80798 80876","+91 70708 79679","+91 70098 89807","+91 78766 58877"
};
String[] EmpUserDesignation={
        "Chief Operation Officer(Coo)","Chief Executive Officer(Ceo)","Director","Chief Compliance Officer","President",
        "Chief Financial Officer","Chief Technology Officer","Vice-President","Human Resource Director","Employee","Watchmen",
        "Administrator","Student","Developer","Software Engineer","Database Admin"
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityEmployeeInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        PassDataInListView();
    }

    private void PassDataInListView(){
        EmpAdapterForListviewData empAdapterForListviewData=new EmpAdapterForListviewData(this,EmpUserImg,EmpUserName,EmpUserEmail,EmpUserPhoneNo,EmpUserDesignation);
        binding.EmpList.setAdapter(empAdapterForListviewData);
    }
}