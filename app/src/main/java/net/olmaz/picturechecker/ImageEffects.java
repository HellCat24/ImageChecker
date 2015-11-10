package net.olmaz.picturechecker;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by omazhukin on 10/29/2015.
 */
public class ImageEffects {

    public static void turnToBlackWhite(ImageView imageView) {
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);
        ColorMatrixColorFilter cf = new ColorMatrixColorFilter(matrix);
        imageView.setColorFilter(cf);
    }

    public static void restoreImage(ImageView imageView) {
        imageView.setColorFilter(null);
    }

    public static void mirrorImageHorizontal(ImageView imageView) {
        Bitmap bmp = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        Matrix matrix = new Matrix();
        matrix.preScale(-1.0f, 1.0f);
        Bitmap mirroredBitmap = Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(), bmp.getHeight(), matrix, false);
        imageView.setImageBitmap(mirroredBitmap);
    }

    public static void mirrorImageVertical(ImageView imageView) {
        Bitmap bmp = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        Matrix matrix = new Matrix();
        matrix.preScale(1.0f, -1.0f);
        Bitmap mirroredBitmap = Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(), bmp.getHeight(), matrix, false);
        imageView.setImageBitmap(mirroredBitmap);
    }


    public static void zoomOut(ImageView imageView) {
        Bitmap bmp = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        Bitmap scaled = Bitmap.createScaledBitmap(bmp, 100, bmp.getHeight() * 100 / bmp.getWidth(), true);
        imageView.setImageBitmap(scaled);
    }

    public static void zoomIn(ImageView imageView) {
        Bitmap bmp = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        Matrix matrix = new Matrix();
        matrix.setScale(1f, 1f);
        Bitmap mirroredBitmap = Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(), bmp.getHeight(), matrix, false);
        imageView.setImageBitmap(mirroredBitmap);
    }
}
