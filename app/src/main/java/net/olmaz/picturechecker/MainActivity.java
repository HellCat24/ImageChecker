package net.olmaz.picturechecker;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.commit451.nativestackblur.NativeStackBlur;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import net.i2p.android.ext.floatingactionbutton.FloatingActionButton;
import net.i2p.android.ext.floatingactionbutton.FloatingActionsMenu;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Bind(R.id.img_picture_image)
    protected ImageView mPictureImage;

    @Bind(R.id.btn_mirror_h)
    protected FloatingActionButton dark;
    @Bind(R.id.btn_mirror_v)
    protected FloatingActionButton bright;
    @Bind(R.id.btn_zoom)
    protected FloatingActionButton zoomOut;
    @Bind(R.id.btn_black_and_white)
    protected FloatingActionButton blackAndWhite;
    @Bind(R.id.btn_blur)
    protected FloatingActionButton blur;

    private Bitmap mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageEffects.mirrorImageHorizontal(mPictureImage);
            }
        });
        bright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageEffects.mirrorImageVertical(mPictureImage);
            }
        });
        zoomOut.setOnClickListener(new View.OnClickListener() {

            boolean isZoom;

            @Override
            public void onClick(View view) {
                if (!isZoom) {
                    isZoom = true;
                    ImageEffects.zoomOut(mPictureImage);
                } else {
                    isZoom = false;
                    showImage();
                }
            }
        });
        blackAndWhite.setOnClickListener(new View.OnClickListener() {

            boolean isBlackAndWhite;

            @Override
            public void onClick(View view) {
                if (isBlackAndWhite) {
                    isBlackAndWhite = false;
                    ImageEffects.restoreImage(mPictureImage);
                } else {
                    isBlackAndWhite = true;
                    ImageEffects.turnToBlackWhite(mPictureImage);
                }
            }
        });
        blur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = ((BitmapDrawable) mPictureImage.getDrawable()).getBitmap();
                Bitmap bm = NativeStackBlur.process(bitmap, 5);
                mPictureImage.setImageBitmap(bm);
            }
        });
        showImage();
    }

    private void showImage() {
        Picasso.with(this).load(R.drawable.test_image).fit().centerInside().into(mPictureImage);
    }

    @OnClick(R.id.multiple_actions)
    protected void onAddPhoto() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

}
