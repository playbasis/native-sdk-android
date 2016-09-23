package com.playbasis.pbcore.domain.interactor.other;

import android.graphics.Bitmap;
import android.graphics.Color;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.BaseInteractor;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Tar on 9/23/16 AD.
 */
public class GenerateQRCodeInteractor extends BaseInteractor {

  protected String data;
  protected int width;

  @Inject
  public GenerateQRCodeInteractor(PBThreadExecutor threadExecutor,
                                  PBPostExecutionThread postExecutionThread) {
    super(threadExecutor, postExecutionThread);
  }

  @Override
  protected Observable buildUseCaseObservable() {
    if (data == null || width <= 0) {
      return Observable.error(new IllegalArgumentException());
    }

    return Observable.just(data).map(new Func1<String, Bitmap>() {
      @Override
      public Bitmap call(String s) {
        MultiFormatWriter writer = new MultiFormatWriter();
        try {
          BitMatrix result = writer.encode(data, BarcodeFormat.QR_CODE, width, width);

          int w = result.getWidth();
          int h = result.getHeight();
          int[] pixels = new int[w * h];
          for (int y = 0; y < h; y++) {
            int offset = y * w;
            for (int x = 0; x < w; x++) {
              pixels[offset + x] = result.get(x, y) ? Color.BLACK : Color.WHITE;
            }
          }

          Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
          bitmap.setPixels(pixels, 0, width, 0, 0, w, h);
          return bitmap;
        } catch (WriterException e) {
          e.printStackTrace();

          return null;
        }
      }
    });
  }

  public void setData(String data) {
    this.data = data;
  }

  public void setWidth(int width) {
    this.width = width;
  }
}
