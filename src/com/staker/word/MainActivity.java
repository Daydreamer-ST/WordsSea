package com.staker.word;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import cn.bmob.v3.*;
import cn.bmob.v3.listener.*;
import java.util.*;

public class MainActivity extends Activity
{
	String bmobid;
	Integer id;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.main);
		Bmob.initialize(this,"BmobID");
		Intent intent =getIntent();
		id=intent.getIntExtra("id",0);
		int random=(int)(Math.random()*id);
		BmobQuery<Word> query=new BmobQuery<Word>();
        query.addWhereEqualTo("id",String.valueOf(random));
        query.findObjects(this,new FindListener<Word>() {
				@Override
				public void onSuccess(List<Word> footBallers) {
					for (Word fb:footBallers)
					{
						TextView content=(TextView)findViewById(R.id.word);
						TextView writer=(TextView)findViewById(R.id.translate);
						TextView stars=(TextView)findViewById(R.id.stars);
						TextView title=(TextView)findViewById(R.id.phrase);
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
					Toast.makeText(MainActivity.this, "查询失败"+s, Toast.LENGTH_SHORT).show();
				}
			});
	
			}
			public void up(View v){
			TextView starstv=(TextView)findViewById(R.id.stars);
			String stars=starstv.getText().toString();
			if(stars.equals("💛")||stars.equals("💛💛")){
			if(stars.equals("💛")){
			Word wd=new Word();
			wd.setStars("2");
			starstv.setText("💛💛");
			wd.update(MainActivity.this,bmobid,new UpdateListener() {
							@Override
							public void onSuccess()
							{
								Toast.makeText(MainActivity.this,"成功", Toast.LENGTH_SHORT).show();
							}
							@Override
							public void onFailure(int p1, String p2)
							{
							Toast.makeText(MainActivity.this,p2+"失败", Toast.LENGTH_SHORT).show();
							}
						});	
			}
			if(stars.equals("💛💛")){
			Word wd=new Word();
			wd.setStars("3");
					wd.update(MainActivity.this,bmobid,new UpdateListener() {
							@Override
							public void onSuccess()
							{
								Toast.makeText(MainActivity.this,"成功", Toast.LENGTH_SHORT).show();
							}
							@Override
							public void onFailure(int p1, String p2)
							{
								Toast.makeText(MainActivity.this,p2+"失败", Toast.LENGTH_SHORT).show();
							}
						});	
			starstv.setText("💛💛💛");
			}
			}else{
			Toast.makeText(MainActivity.this, "不能再加了！", Toast.LENGTH_SHORT).show();
			}
			}
			public void down(View v){
				TextView starstv=(TextView)findViewById(R.id.stars);
				String stars=starstv.getText().toString();
				if(stars.equals("💛💛")||stars.equals("💛💛💛")){
					if(stars.equals("💛💛")){
						Word wd=new Word();
						wd.setStars("1");
						wd.update(MainActivity.this,bmobid,new UpdateListener() {
								@Override
								public void onSuccess()
								{
									Toast.makeText(MainActivity.this,"成功", Toast.LENGTH_SHORT).show();
								}
								@Override
								public void onFailure(int p1, String p2)
								{
									Toast.makeText(MainActivity.this,p2+"失败", Toast.LENGTH_SHORT).show();
								}
							});	
						starstv.setText("💛");
					}
					if(stars.equals("💛💛💛")){
						Word wd=new Word();
						wd.setStars("2");
						wd.update(MainActivity.this,bmobid,new UpdateListener() {
								@Override
								public void onSuccess()
								{
									Toast.makeText(MainActivity.this,"成功", Toast.LENGTH_SHORT).show();
								}
								@Override
								public void onFailure(int p1, String p2)
								{
									Toast.makeText(MainActivity.this,p2+"失败", Toast.LENGTH_SHORT).show();
								}
							});	
						starstv.setText("💛💛");
					}
				}else{
					Toast.makeText(MainActivity.this, "不能再减了！", Toast.LENGTH_SHORT).show();
				}
			}
			public void next(View v){
				int randoms=(int)(Math.random()*id);
				BmobQuery<Word> query=new BmobQuery<Word>();
				query.addWhereEqualTo("id",String.valueOf(randoms));
				query.findObjects(this,new FindListener<Word>() {
						@Override
						public void onSuccess(List<Word> footBallers) {
							for (Word fb:footBallers)
							{
								TextView content=(TextView)findViewById(R.id.word);
								TextView writer=(TextView)findViewById(R.id.translate);
								TextView stars=(TextView)findViewById(R.id.stars);
								TextView title=(TextView)findViewById(R.id.phrase);
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
							Toast.makeText(MainActivity.this, "查询失败"+s, Toast.LENGTH_SHORT).show();
						}
					});
			}
			public void create(View v){
				Intent intent =new Intent(MainActivity.this,create.class);
				intent.putExtra("id",id);
				startActivity(intent);
			}
			public void sort(View v){
				Intent intent =new Intent(MainActivity.this,sort.class);
				startActivity(intent);
			}
			public void search(View v){
				Intent intent =new Intent(MainActivity.this,Search.class);
				startActivity(intent);
			
    }
}
