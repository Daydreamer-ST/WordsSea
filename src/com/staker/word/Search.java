package com.staker.word;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import cn.bmob.v3.*;
import cn.bmob.v3.listener.*;
import java.util.*;

public class Search extends Activity
{
	String bmobid;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.search);
		}
		public void ss(View v){
		EditText ssed=(EditText)findViewById(R.id.searched);
		String ssnr=ssed.getText().toString();
			BmobQuery<Word> query=new BmobQuery<Word>();
			query.addWhereEqualTo("Word",ssnr);
			query.findObjects(this,new FindListener<Word>() {
					@Override
					public void onSuccess(List<Word> footBallers) {
						for (Word fb:footBallers)
						{
							EditText content=(EditText)findViewById(R.id.words);
							EditText writer=(EditText)findViewById(R.id.translates);
							TextView stars=(TextView)findViewById(R.id.starss);
							EditText title=(EditText)findViewById(R.id.phrases);
							content.setText(fb.getWord());
							writer.setText(fb.getTranslate());
							title.setText(fb.getPhrase());
							bmobid=fb.getObjectId();
							if(fb.getStars().equals("1")){
								stars.setText("💛");
							}
							if(fb.getStars().equals("2")){
								stars.setText("💛💛");
							}
							if(fb.getStars().equals("3")){
								stars.setText("💛💛💛");
							}
						}
					}
					@Override
					public void onError(int i, String s) {
						Toast.makeText(Search.this, "查询失败"+s, Toast.LENGTH_SHORT).show();
					}
				});
				}
			public void ups(View v){
			TextView starstv=(TextView)findViewById(R.id.stars);
			String stars=starstv.getText().toString();
			if(stars.equals("💛")||stars.equals("💛💛")){
			if(stars.equals("💛")){
			Word wd=new Word();
			wd.setStars("2");
			starstv.setText("💛💛");
			wd.update(Search.this,bmobid,new UpdateListener() {
							@Override
							public void onSuccess()
							{
								Toast.makeText(Search.this,"成功", Toast.LENGTH_SHORT).show();
							}
							@Override
							public void onFailure(int p1, String p2)
							{
							Toast.makeText(Search.this,p2+"失败", Toast.LENGTH_SHORT).show();
							}
						});	
			}
			if(stars.equals("💛💛")){
			Word wd=new Word();
			wd.setStars("3");
					wd.update(Search.this,bmobid,new UpdateListener() {
							@Override
							public void onSuccess()
							{
								Toast.makeText(Search.this,"成功", Toast.LENGTH_SHORT).show();
							}
							@Override
							public void onFailure(int p1, String p2)
							{
								Toast.makeText(Search.this,p2+"失败", Toast.LENGTH_SHORT).show();
							}
						});	
			starstv.setText("💛💛💛");
			}
			}else{
			Toast.makeText(Search.this, "不能再加了！", Toast.LENGTH_SHORT).show();
			}
			}
			public void downs(View v){
				TextView starstv=(TextView)findViewById(R.id.stars);
				String stars=starstv.getText().toString();
				if(stars.equals("💛💛")||stars.equals("💛💛💛")){
					if(stars.equals("💛💛")){
						Word wd=new Word();
						wd.setStars("1");
						wd.update(Search.this,bmobid,new UpdateListener() {
								@Override
								public void onSuccess()
								{
									Toast.makeText(Search.this,"成功", Toast.LENGTH_SHORT).show();
								}
								@Override
								public void onFailure(int p1, String p2)
								{
									Toast.makeText(Search.this,p2+"失败", Toast.LENGTH_SHORT).show();
								}
							});	
						starstv.setText("💛");
					}
					if(stars.equals("💛💛💛")){
						Word wd=new Word();
						wd.setStars("2");
						wd.update(Search.this,bmobid,new UpdateListener() {
								@Override
								public void onSuccess()
								{
									Toast.makeText(Search.this,"成功", Toast.LENGTH_SHORT).show();
								}
								@Override
								public void onFailure(int p1, String p2)
								{
									Toast.makeText(Search.this,p2+"失败", Toast.LENGTH_SHORT).show();
								}
							});	
						starstv.setText("💛💛");
					}
				}else{
					Toast.makeText(Search.this, "不能再减了！", Toast.LENGTH_SHORT).show();
				}
			}
			public void save(View v){
				EditText word=(EditText)findViewById(R.id.words);
				EditText translate=(EditText)findViewById(R.id.translates);
				EditText phrase=(EditText)findViewById(R.id.phrases);
				String words=word.getText().toString();
				String translates=translate.getText().toString();
				String phrases=phrase.getText().toString();
						Word wd=new Word();
						wd.setWord(words);
						wd.setPhrase(phrases);
						wd.setTranslate(translates);
						wd.update(Search.this,bmobid,new UpdateListener() {
								@Override
								public void onSuccess()
								{
									Toast.makeText(Search.this,"成功", Toast.LENGTH_SHORT).show();
								}
								@Override
								public void onFailure(int p1, String p2)
								{
									Toast.makeText(Search.this,p2+"失败", Toast.LENGTH_SHORT).show();
								}
							});	
	}
}
