package com.reactnativesunmiprinter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.PictureDrawable;

import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;
import java.io.IOException;

public class SvgToBitmapTranscoder {
  static Bitmap renderToBitmap(String xmlData, int width, int height) throws IOException {
    try {
      SVG svg = SVG.getFromString(xmlData);
      Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
      Canvas bmpCanvas = new Canvas();
      svg.renderToCanvas(bmpCanvas);
      bmpCanvas.setBitmap(bitmap);
      return bitmap;
//      PictureDrawable drawable = new PictureDrawable(svg.renderToPicture());
//      return BitmapFactory.decodeResource(context.getResources(), drawable);
    } catch (SVGParseException ex) {
      throw new IOException("Cannot load SVG from stream", ex);
    }
  }
}
