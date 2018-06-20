package com.staker.word;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import cn.bmob.v3.*;
import cn.bmob.v3.listener.*;
import java.util.*;

public class First extends Activity
{
	Integer id;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.first);
Bmob.initialize(this,"BmobID");
		BmobQuery<Others> queryt=new BmobQuery<Others>();
		queryt.addWhereEqualTo("Name","idall");
		queryt.findObjects(this,new FindListener<Others>() {
				@Override
				public void onSuccess(List<Others> footBallers) {
					for (Others fb:footBallers)
					{
						id=fb.getId();
					}
				}
				@Override
				public void onError(int i, String s) {
					Toast.makeText(First.this, "查询失败"+s, Toast.LENGTH_SHORT).show();
				}
			});
		new Handler(). postDelayed(new Runnable()
			{
				@Override
				public void run()
				{
					if(id!=null){}
					Intent intent = new Intent(First.this,MainActivity.class); 
					intent.putExtra("id",id);
					//qdtt.this.overridePendingTransition(0, 0); 
					finish();
					startActivity(intent);
				}
			},500);
}
}
	
