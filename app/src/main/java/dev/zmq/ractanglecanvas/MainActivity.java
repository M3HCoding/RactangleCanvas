package dev.zmq.ractanglecanvas;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.os.Bundle;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Color;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends Activity
{
private Button mButton;
private RelativeLayout mReletiveLayout;
private TextView mTextView;
private ImageView mImageView;
private Context mContext;
private Resources mResources;
private  Button reset;


    @Override
    protected void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mResources=getResources();
        mContext=getApplicationContext();

        mImageView=(ImageView) findViewById(R.id.iv);
        mButton=(Button) findViewById(R.id.btn);
        reset=(Button) findViewById(R.id.reset);
        mReletiveLayout=(RelativeLayout) findViewById(R.id.rl);

        mButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Bitmap bitmap = Bitmap.createBitmap(
                        500,
                        300,
                        Bitmap.Config.ARGB_8888);

                Canvas canvas = new Canvas(bitmap);
                canvas.drawColor(Color.RED);

                Paint paint = new Paint();
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(Color.YELLOW);
                paint.setTextAlign(Paint.Align.CENTER);
                paint.setTextSize(15);
                paint.setAntiAlias(true);
                int padding = 50;
                Rect ractangle = new Rect(
                        padding,
                        padding,
                        canvas.getWidth() - padding,
                        canvas.getHeight() - padding);

            canvas.drawRect(ractangle,paint);
            mImageView.setImageBitmap(bitmap);
        }
        });

        reset.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mImageView.setImageBitmap(null);
                mImageView.setImageDrawable(null);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                mImageView.invalidate();
                mImageView.setImageBitmap(null);
            }
        });


       /*
        mImageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                mTextView.setText("");

            }

        });
      */
    }
}
