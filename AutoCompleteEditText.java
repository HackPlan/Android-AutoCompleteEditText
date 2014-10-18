package im.dacer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by Dacer on 5/23/14.
 * Show a drop-down list after input a symbol.
 */
public class AutoCompleteEditText extends AutoCompleteTextView {

    private ArrayAdapter<String> adapter;
    private String startAtSymbol = "#";

    public AutoCompleteEditText(Context context){
        this(context, null);
    }
    public AutoCompleteEditText(Context context, AttributeSet attrs){
        super(context,attrs);
        init();
    }
    public AutoCompleteEditText(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
        init();
    }

    private void init(){
        adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_dropdown_item_1line, new ArrayList<String>());
        setAdapter(adapter);
        setDropDownWidth(WindowManager.LayoutParams.WRAP_CONTENT);
    }

    /**
     *
     * @param symbol default is #
     */
    public void setStartAtSymbol(String symbol){
        startAtSymbol = symbol;
    }

    /**
     *
     * @param dataList The data must start with the symbol
     */
    public void setAutoCompleteList(String[] dataList){
        adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_dropdown_item_1line, dataList);
        setAdapter(adapter);
    }

    @Override
    public boolean enoughToFilter() {
        if(getText() != null){
            return getText().length() != 0;
        }
        return true;
    }

    @Override
    protected void performFiltering(CharSequence text, int keyCode){
        String beforeCursor = getText().toString().substring(0, getSelectionStart());
        Pattern pattern = Pattern.compile(getRegularExpression());
        Matcher matcher = pattern.matcher(beforeCursor);
        if (matcher.find()) {
            text = matcher.group(0);;
        }
        super.performFiltering(text, keyCode);
    }

    @Override
    protected void replaceText(CharSequence text){
        String beforeCursor = getText().toString().substring(0, getSelectionStart());
        String afterCursor = getText().toString().substring(getSelectionStart());

        Pattern pattern = Pattern.compile("#\\S*");
        Matcher matcher = pattern.matcher(beforeCursor);
        StringBuffer sb = new StringBuffer();
        int matcherStart = 0;
        while (matcher.find()) {
            int curPos = getSelectionStart();
            if(curPos > matcher.start() &&
                    curPos <= matcher.end()){
                matcherStart = matcher.start();
                matcher.appendReplacement(sb, text.toString()+" ");
            }
        }
        matcher.appendTail(sb);
        setText(sb.toString()+afterCursor);
        setSelection(matcherStart + text.length()+1);
    }


    private String getRegularExpression(){
        return startAtSymbol+"\\S*\\z";
    }
}
