package kr.hs.e_mirim.grace0106.gallerytest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Gallery gallery;
    ImageView imgMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gallery=(Gallery)findViewById(R.id.gallery_1);
        imgMain=(ImageView)findViewById(R.id.imgv_main);
        MyGalleryAdapter adapter = new MyGalleryAdapter(this);
        gallery.setAdapter(adapter);

    }

    public class MyGalleryAdapter extends BaseAdapter {
        Context context;
        int[] btsIDs = {R.drawable.bts01, R.drawable.bts02, R.drawable.bts03, R.drawable.bts04, R.drawable.bts05,
                R.drawable.bts06, R.drawable.bts07, R.drawable.bts08, R.drawable.bts09, R.drawable.bts10};

        public MyGalleryAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return btsIDs.length  ;
        }

        @Override
        public Object getItem(int position) {

            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imgV = new ImageView(context);
            imgV.setLayoutParams(new Gallery.LayoutParams(100, 150));
            imgV.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imgV.setPadding(5,5,5,5);
            imgV.setImageResource(btsIDs[position]);
            final int pos = position;
            imgV.setOnTouchListener(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    imgMain.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    imgMain.setImageResource(btsIDs[pos]);
                    return false;
                }
            });
            return imgV;
        }
    }
}
