package cn.itcast.youku;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

    private ImageButton home;
	private ImageButton menu;
	private RelativeLayout level2;
	private RelativeLayout level3;
	
	private boolean isLevel2Show = true;
	private boolean isLevel3Show = true;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        home = (ImageButton) findViewById(R.id.home);
        menu = (ImageButton) findViewById(R.id.menu);
        
        level2 = (RelativeLayout) findViewById(R.id.level2);
        level3 = (RelativeLayout) findViewById(R.id.level3);
        
        menu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(isLevel3Show){
					//��ʾ--�� ����   3�������˵�
					MyAnimation.StartAnimationOUT(level3, 500, 0);
				} else {
					//����--�� ��ʾ   3�������˵�
					MyAnimation.StartAnimationIN(level3, 500);
				}
				
				isLevel3Show = !isLevel3Show;
			}
		});
        
        home.setOnClickListener(new OnClickListener() {
        	
        	@Override
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		if(!isLevel2Show){
        			//����--�� ��ʾ     2�������˵�
        			MyAnimation.StartAnimationIN(level2, 500);
        		} else {
        			//��ʾ--�� ���� 
        			if(isLevel3Show){
        				//��ʾ--�� ����  3�������˵�
        				//��ʾ--�� ����  2�������˵�
        				MyAnimation.StartAnimationOUT(level3, 500, 0);
        				MyAnimation.StartAnimationOUT(level2, 500, 500);
        				
        				isLevel3Show = !isLevel3Show;
        			} else {
        				//��ʾ--�� ����  2�������˵�
        				MyAnimation.StartAnimationOUT(level2, 500, 0);
        			}
        		}
        		
        		isLevel2Show = !isLevel2Show;
        	}
        });
        
    }

}
