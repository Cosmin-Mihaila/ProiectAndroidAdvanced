package proiect.android.proiectandroidadvanced;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomView extends View {
    private Paint paint = new Paint();
    public CustomView(Context context) {
        super(context);
        init(null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(@Nullable AttributeSet attributeSet){
        paint.setColor(Color.BLUE);
    }

    @Override
    public void onDraw(Canvas canvas){
        Rect rect = new Rect();
        rect.left = 300;
        rect.top = 100;
        rect.bottom = 200;
        rect.right = 100;


        canvas.drawRect(rect, paint);
    }

    public void changeColor(){
        if(paint.getColor() == Color.BLUE){
            paint.setColor(Color.RED);
        }
        else{
            paint.setColor(Color.BLUE);
        }

        postInvalidate();
    }
}
