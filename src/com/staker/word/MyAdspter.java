package com.staker.word;
import android.widget.*;
import java.util.*;
import android.content.*;
import android.view.*;

	public class MyAdspter extends BaseAdapter { 

		private List<Map<String, Object>> data; 
		private LayoutInflater layoutInflater; 
		private Context context; 
		public MyAdspter(Context context,List<Map<String, Object>> data){ 
			this.context=context; 
			this.data=data; 
			this.layoutInflater=LayoutInflater.from(context); 
		} 
		public final class Item{ 
			public TextView word; 
		    public TextView phrase; 
			public TextView translate; 
		} 
		@Override
		public int getCount() { 
			return data.size(); 
		} 
		@Override
		public Object getItem(int position) { 
			return data.get(position); 
		} 
		@Override
		public long getItemId(int position) { 
			return position; 
		} 

		@Override
		public View getView(int position, View convertView, ViewGroup parent) { 
			Item item=null; 
			if(convertView==null){ 
				item=new Item();  
				convertView=layoutInflater.inflate(R.layout.list, null); 
				item.word=(TextView)convertView.findViewById(R.id.listword); 
				item.translate=(TextView)convertView.findViewById(R.id.listtranslate); 
				item.phrase=(TextView)convertView.findViewById(R.id.listphrase);  
				convertView.setTag(item); 
			}else{ 
				item=(Item)convertView.getTag(); 
			}  
			item.word.setText((String)data.get(position).get("word")); 
			item.translate.setText((String)data.get(position).get("translate")); 
			item.phrase.setText((String)data.get(position).get("phrase")); 
			return convertView; 
		} 

	} 
