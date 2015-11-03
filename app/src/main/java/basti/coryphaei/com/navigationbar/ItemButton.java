package basti.coryphaei.com.navigationbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Bowen on 2015-11-03.
 */
public class ItemButton extends LinearLayout {

    private ImageView img;
    private TextView tv;

    private boolean isSelected = false;
    private int noramalImageId,selectedImageId;
    private int normalFontColor,selectedFontColor;

    public ItemButton(Context context) {
        this(context,null);
    }

    public ItemButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ItemButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOrientation(VERTICAL);

        img = new ImageView(getContext());
        tv = new TextView(getContext());
    }

    public ItemButton createItem(int normalImgId,int selectedImageId,int normalFontColor,
                                 int selectedFontColor,String text){
        initAttr(normalImgId, selectedImageId, normalFontColor,
                selectedFontColor, text);

        addView(img);
        addView(tv);
        return this;
    }

    private void initAttr(int normalImgId, int selectedImageId, int normalFontColor, int selectedFontColor, String text) {

        this.noramalImageId = normalImgId;
        this.selectedImageId = selectedImageId;
        this.normalFontColor = normalFontColor;
        this.selectedFontColor = selectedFontColor;

        this.tv.setText(text);
        this.tv.setTextColor(getResources().getColor(normalFontColor));
        this.tv.setGravity(Gravity.CENTER_HORIZONTAL);

        this.img.setImageResource(normalImgId);
        this.img.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1));

        setGravity(Gravity.CENTER);
    }

    public ItemButton changeView(){

        isSelected = !isSelected;
        if (isSelected){
            this.img.setImageResource(this.selectedImageId);
            this.tv.setTextColor(getResources().getColor(selectedFontColor));
        }else {
            this.img.setImageResource(this.noramalImageId);
            this.tv.setTextColor(getResources().getColor(normalFontColor));
        }

        this.invalidate();



        return this;
    }

}
