package it.xonne.customfontattributes.ui.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import it.xonne.customfontattributes.R;

/**
 * Created by xonne on 16/10/15.
 */
public class CustomTextView extends TextView {

    // --- TYPE FACE ---//
    private Typeface fontNormal;
    private Typeface fontBold;

    // --- FONT VALUES ---//
    private final static int FONT_NORMAL = 0;
    private final static int FONT_BOLD = 1;

    public CustomTextView(Context context) {
        super(context);

        // --- Instantiate Fontface --- //
        fontNormal = Typeface.createFromAsset(context.getAssets(), "fonts/Trebuchet MS.ttf");
        fontBold = Typeface.createFromAsset(context.getAssets(), "fonts/Trebuchet MS Bold.ttf");
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        // --- Instantiate Fontface --- //
        fontNormal = Typeface.createFromAsset(context.getAssets(), "fonts/Trebuchet MS.ttf");
        fontBold = Typeface.createFromAsset(context.getAssets(), "fonts/Trebuchet MS Bold.ttf");

        parseAttributes(context, attrs); //I'll explain this method later
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);


        // --- Instantiate Fontface --- //
        fontNormal = Typeface.createFromAsset(context.getAssets(), "fonts/Trebuchet MS.ttf");
        fontBold = Typeface.createFromAsset(context.getAssets(), "fonts/Trebuchet MS Bold.ttf");

        parseAttributes(context, attrs); //I'll explain this method later
    }


    private void parseAttributes(Context context, AttributeSet attrs) {
        TypedArray values = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView);

        //The value 0 is a default, but shouldn't ever be used since the attr is an enum
        int typeface = values.getInt(R.styleable.CustomTextView_typeface, 0);

        switch(typeface) {
            case FONT_NORMAL: default:
                //You can instantiate your typeface anywhere, I would suggest as a
                //singleton somewhere to avoid unnecessary copies
                setTypeface(fontNormal);
                break;
            case FONT_BOLD:
                setTypeface(fontBold);
                break;
        }

        values.recycle();
    }

}
