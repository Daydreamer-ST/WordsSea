package com.staker.word;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import cn.bmob.v3.*;
import cn.bmob.v3.listener.*;
import com.staker.word.*;
import java.util.*;

public class create extends Activity
{
	Integer id;
	Integer idd;
	Integer times;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.create);
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
					Toast.makeText(create.this, "查询失败"+s, Toast.LENGTH_SHORT).show();
				}
			});
		//Intent intent =getIntent();
		times=0;
		//id=intent.getIntExtra("id",0);
	}
	public void createe(View v){
		Button send=(Button) findViewById(R.id.send);
		send.setEnabled(false);
		new Handler(). postDelayed(new Runnable()
			{
				@Override
				public void run()
				{
					Button send=(Button) findViewById(R.id.send);
					send.setEnabled(true);
				}
			},500);
		EditText wordc=(EditText)findViewById(R.id.wordc);
		EditText translatec=(EditText)findViewById(R.id.translatec);
		EditText phrasec=(EditText)findViewById(R.id.phrasec);
		TextView starsc=(TextView)findViewById(R.id.starsc);
		String word=wordc.getText().toString();
		String translate=translatec.getText().toString();
		String phrase=phrasec.getText().toString();
		String stars=starsc.getText().toString();
		if(stars.equals("1")||stars.equals("2")||stars.equals("3")){
		Word wd=new Word();
		wd.setWord(word);
		wd.setTranslate(translate);
		wd.setPhrase(phrase);
		wd.setStars(stars);
		idd=times+id;
		wd.setId(String.valueOf(idd));
		//这里有小问题，每次进入应用只能进入一次更改空间
		wd.save(create.this,new SaveListener(){
				@Override
				public void onSuccess(){
					times=times+1;
					Toast.makeText(getApplicationContext(), "成功",
								   Toast.LENGTH_SHORT).show();
				}
				@Override
				public void onFailure(int i,String s){
					Toast.makeText(getApplicationContext(), "失败",
								   Toast.LENGTH_SHORT).show();
				}
			});
			Others ot=new Others();
			ot.setId(idd+1);
			ot.update(create.this,"ecCxMMMY",new UpdateListener() {
					@Override
					public void onSuccess()
					{}
					@Override
					public void onFailure(int p1, String p2)
					{}
				});	
			}else{
				Toast.makeText(getApplicationContext(), "难度输入错误",
							   Toast.LENGTH_SHORT).show();
			}
	}
}
