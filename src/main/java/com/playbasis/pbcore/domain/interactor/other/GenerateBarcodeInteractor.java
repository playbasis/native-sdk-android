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
public class GenerateBarcodeInteractor extends BaseInteractor {

  protected String data;
  protected int width;
  protected int height;

  @Inject
  public GenerateBarcodeInteractor(PBThreadExecutor threadExecutor,
                                   PBPostExecutionThread postExecutionThread) {
    super(threadExecutor, postExecutionThread);
  }

  @Override
  protected Observable buildUseCaseObservable() {
    if (data == null || width <= 0 || height <= 0) {
      return Observable.error(new IllegalArgumentException());
    }

    return Observable.just(data).map(new Func1<String, Bitmap>() {
      @Override
      public Bitmap call(String s) {
        MultiFormatWriter writer = new MultiFormatWriter();
        BitMatrix result = null;
        try {
          result = writer.encode(data, BarcodeFormat.CODE_128, width, 1);

          int w = result.getWidth();
          int h = height;
          Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
          for (int x = 0; x < w; x++) {
            int color = result.get(x, 0) ? Color.BLACK : Color.WHITE;
            for (int y = 0; y < h; y++) {
              bitmap.setPixel(x, y, color);
            }
          }

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

  public void setHeight(int height) {
    this.height = height;
  }
}
