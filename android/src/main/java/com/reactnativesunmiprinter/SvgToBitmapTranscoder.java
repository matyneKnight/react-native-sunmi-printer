package com.reactnativesunmiprinter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.PictureDrawable;
import android.util.Log;

import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;
import java.io.IOException;

public class SvgToBitmapTranscoder {
  static Bitmap renderToBitmap(String xmlData, int width, int height) throws IOException {
    try {
      SVG svg = SVG.getFromString(xmlData);
      Log.d("SvgToBitmapTr Error", "SvgToBitmapTranscoder: renderToBitmap: svg" + String.valueOf(svg));
      Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
      Log.d("SvgToBitmapTr Error", "SvgToBitmapTranscoder: renderToBitmap: bitmap level 1" + String.valueOf(bitmap));
      Canvas bmpCanvas = new Canvas();
      bmpCanvas.drawColor(Color.TRANSPARENT);
      svg.renderToCanvas(bmpCanvas);
      bmpCanvas.setBitmap(bitmap);
      Log.d("SvgToBitmapTr Error", "SvgToBitmapTranscoder: renderToBitmap: bitmap level 2" + String.valueOf(bitmap));
      return bitmap;
//      PictureDrawable drawable = new PictureDrawable(svg.renderToPicture());
//      return BitmapFactory.decodeResource(context.getResources(), drawable);
    } catch (SVGParseException ex) {
      throw new IOException("Cannot load SVG from stream", ex);
    }
  }
}
