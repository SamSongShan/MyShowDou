package com.example.a11355.myshowdou.News.view;

import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bm.library.PhotoView;
import com.example.a11355.myshowdou.Base.BaseActivity;
import com.example.a11355.myshowdou.Base.BasePresenter;
import com.example.a11355.myshowdou.News.bean.NewsListEntity;
import com.example.a11355.myshowdou.R;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
//新闻图片

public class NewsPhotoActivity extends BaseActivity {

    @BindView(R.id.vp)
    ViewPager vp;
    List<PhotoView> photos = new ArrayList<>();
    private Toolbar toolbar;

    @Override
    protected int getViewResId() {
        return R.layout.activity_news_photo;
    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void init() {
        final NewsListEntity.DataBean data = getIntent().getParcelableExtra("data");

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle(data.getTitle());
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        vp.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return data.getImgextra().size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }

            @Override
            public Object instantiateItem(ViewGroup container, final int position) {
                final PhotoView view = new PhotoView(NewsPhotoActivity.this);
                view.enable();
                view.setScaleType(ImageView.ScaleType.FIT_CENTER);

                ImageRequest imageRequest = ImageRequestBuilder
                        .newBuilderWithSource( Uri.parse(data.getImgextra().get(position).getImgsrc()))
                        .setProgressiveRenderingEnabled(true)
                        .build();

                ImagePipeline imagePipeline = Fresco.getImagePipeline();
                DataSource<CloseableReference<CloseableImage>>
                        dataSource = imagePipeline.fetchDecodedImage(imageRequest,NewsPhotoActivity.this);

                dataSource.subscribe(new BaseBitmapDataSubscriber() {

                                         @Override
                                         public void onNewResultImpl(@Nullable Bitmap bitmap) {
                                             // You can use the bitmap in only limited ways
                                             // No need to do any cleanup.
                                             view.setImageBitmap(bitmap);


                                         }

                                         @Override
                                         public void onFailureImpl(DataSource dataSource) {
                                             // No cleanup required here.
                                         }
                                     },
                        CallerThreadExecutor.getInstance());


                container.addView(view);
                return view;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

}
