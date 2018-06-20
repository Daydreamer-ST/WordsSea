package com.staker.word;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import cn.bmob.v3.*;
import cn.bmob.v3.listener.*;
import java.util.*;

public class sort extends Activity
{
	List<Map<String, Object>> listt;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.sort);
		listt=new ArrayList<Map<String,Object>>();
		}
		public void easy(View v){
		listt.clear();
		TextView tv=(TextView)findViewById(R.id.sorttv);
		tv.setVisibility(View.GONE);
		ListView lv=(ListView)findViewById(R.id.sortlist);
		lv.setVisibility(View.VISIBLE);
			BmobQuery<Word> query = new BmobQuery<Word>();
			query.addWhereEqualTo("Stars","1");
			query.setLimit(3000);
			query.findObjects(this,new FindListener<Word>() {
					@Override
					public void onSuccess(List<Word> footBallers) {
						for (Word fb:footBallers)
						{
							Map<String, Object> map=new HashMap<String, Object>(); 
							map.put("word",fb.getWord()); 
							map.put("translate",fb.getTranslate()); 
							map.put("phrase",fb.getPhrase()); 
							listt.add(map); 
						}
						ListView listView=(ListView)findViewById(R.id.sortlist); 
						List<Map<String, Object>> list=listt; 
						listView.setAdapter(new MyAdspter(sort.this,list)); 
						return ; 
					}
					@Override
					public void onError(int i, String s) {
						Toast.makeText(sort.this, "查询失败"+s, Toast.LENGTH_SHORT).show();
					}
				});
		}
		public void medium(View v){
			listt.clear();
			TextView tv=(TextView)findViewById(R.id.sorttv);
			tv.setVisibility(View.GONE);
			ListView lv=(ListView)findViewById(R.id.sortlist);
			lv.setVisibility(View.VISIBLE);
			BmobQuery<Word> query = new BmobQuery<Word>();
			query.addWhereEqualTo("Stars","2");
			query.setLimit(3000);
			query.findObjects(this,new FindListener<Word>() {
					@Override
					public void onSuccess(List<Word> footBallers) {
						for (Word fb:footBallers)
						{
							Map<String, Object> map=new HashMap<String, Object>(); 
							map.put("word",fb.getWord()); 
							map.put("translate",fb.getTranslate()); 
							map.put("phrase",fb.getPhrase()); 
							listt.add(map); 
						}
						ListView listView=(ListView)findViewById(R.id.sortlist); 
						List<Map<String, Object>> list=listt; 
						listView.setAdapter(new MyAdspter(sort.this,list)); 
						return ; 
					}
					@Override
					public void onError(int i, String s) {
						Toast.makeText(sort.this, "查询失败"+s, Toast.LENGTH_SHORT).show();
					}
				});
		}
		public void difficult(View v){
			listt.clear();
			TextView tv=(TextView)findViewById(R.id.sorttv);
			tv.setVisibility(View.GONE);
			ListView lv=(ListView)findViewById(R.id.sortlist);
			lv.setVisibility(View.VISIBLE);
			BmobQuery<Word> query = new BmobQuery<Word>();
			query.addWhereEqualTo("Stars","3");
			query.setLimit(3000);
			query.findObjects(this,new FindListener<Word>() {
					@Override
					public void onSuccess(List<Word> footBallers) {
						for (Word fb:footBallers)
						{
							Map<String, Object> map=new HashMap<String, Object>(); 
							map.put("word",fb.getWord()); 
							map.put("translate",fb.getTranslate()); 
							map.put("phrase",fb.getPhrase()); 
							listt.add(map); 
						}
						ListView listView=(ListView)findViewById(R.id.sortlist); 
						List<Map<String, Object>> list=listt; 
						listView.setAdapter(new MyAdspter(sort.this,list)); 
						return ; 
					}
					@Override
					public void onError(int i, String s) {
						Toast.makeText(sort.this, "查询失败"+s, Toast.LENGTH_SHORT).show();
					}
				});
			
	}
}
