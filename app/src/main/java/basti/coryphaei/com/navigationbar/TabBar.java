package basti.coryphaei.com.navigationbar;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * TabBar实现
 * Created by Bowen on 2015-11-03.
 */
public class TabBar extends LinearLayout {

    private TabbarClickListener mClickListener;
    private int itemCount = 0;
    private int selectIndex = 0;

    public TabBar(Context context) {
        this(context, null);
    }

    public TabBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TabBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        
        init();
    }

    private void init() {
        setOrientation(HORIZONTAL);
        this.setPadding(0, 30, 0, 0);
    }

    public TabBar addItem(int normalImgId,int selectedImageId,int normalFontColor,
                          int selectedFontColor, String text) {

        ItemButton view = new ItemButton(getContext()).createItem(normalImgId,selectedImageId,
                normalFontColor,selectedFontColor,text);

        itemCount++;

        final int index = itemCount-1;

        view.setLayoutParams(new LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,1));
        addView(view);


        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("index",index+"");
                if(index != selectIndex){
                    //首先把选中的置为未选中状态
                    ((ItemButton)getChildAt(selectIndex)).changeView();
                    //把要选的置为选中状态
                    selectIndex = index;
                    ((ItemButton)getChildAt(selectIndex)).changeView();
                    if (mClickListener!=null){
                        mClickListener.onClick(selectIndex);
                    }
                }
            }
        });

        //默认第一个按钮选中
        if (index == 0){
            Log.i("index",index+"");
            ((ItemButton)getChildAt(index)).changeView();
        }

        return this;
    }

    public void setOnItemClickListener(TabbarClickListener clickListener){
        this.mClickListener = clickListener;
    }
}
