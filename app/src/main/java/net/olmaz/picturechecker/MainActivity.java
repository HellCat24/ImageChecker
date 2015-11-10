package net.olmaz.picturechecker;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import net.i2p.android.ext.floatingactionbutton.FloatingActionButton;
import net.i2p.android.ext.floatingactionbutton.FloatingActionsMenu;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    static final int REQUEST_TAKE_PHOTO = 1;

    @Bind(R.id.img_picture_image)
    protected ImageView mPictureImage;

    @Bind(R.id.blur_seek_bar)
    protected DiscreteSeekBar mBlurSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FloatingActionsMenu fab = (FloatingActionsMenu) findViewById(R.id.multiple_actions);

        final FloatingActionButton dark = (FloatingActionButton) findViewById(R.id.btn_mirror_h);
        dark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageEffects.mirrorImageHorizontal(mPictureImage);
            }
        });

        final FloatingActionButton bright = (FloatingActionButton) findViewById(R.id.btn_mirror_v);
        bright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageEffects.mirrorImageVertical(mPictureImage);
            }
        });

        final FloatingActionButton zoomOut = (FloatingActionButton) findViewById(R.id.btn_zoom);
        zoomOut.setOnClickListener(new View.OnClickListener() {

            boolean isZoom;

            @Override
            public void onClick(View view) {
                if (!isZoom) {
                    isZoom = true;
                    ImageEffects.zoomOut(mPictureImage);
                } else {
                    isZoom = false;
                    Picasso.with(MainActivity.this).load(R.drawable.test_image).fit().into(mPictureImage);
                }
            }
        });

        final FloatingActionButton zoomIn = (FloatingActionButton) findViewById(R.id.btn_black_and_white);
        zoomIn.setOnClickListener(new View.OnClickListener() {

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

        mBlurSeekBar.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
