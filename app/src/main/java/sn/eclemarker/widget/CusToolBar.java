package sn.eclemarker.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import sn.eclemarker.R;

/**自定义toolbar实现搜索功能
 * Created by acer on 2016/2/20.
 */
public class CusToolBar extends Toolbar {

    private TextView tvTitle;
    private EditText etSearch;
    private ImageView ibSearch;
    private ImageButton ibReturn;
    private LayoutInflater layoutInflater;
    private boolean isShowTitle = true;
    View toolbar_view;
    public CusToolBar(Context context) {
      this(context,null);
    }

    public CusToolBar(Context context,  AttributeSet attrs) {
       this(context,attrs, 0);
    }

    public CusToolBar(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
        if (attrs != null) {
            final TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs,
                    R.styleable.CusToolBar, defStyleAttr, 0);
//            因为这一个语法浪费了多次实践，基础知识必须牢记，然后灵活运用
            if (isShowTitle)
            isShowTitle = a.getBoolean(R.styleable.CusToolBar_isShowTitle,false);
            if (!isShowTitle) {
                setEtSearchVis();
                hidleTitleVis();
                hidleIbSearchVis();
            }
            a.recycle();
        }

        initListener();

    }

    private void initView() {
        if (toolbar_view == null) {
            layoutInflater = LayoutInflater.from(getContext());
            View toolbar_view = layoutInflater.inflate(R.layout.toolbar_showlayout, null);
            etSearch = (EditText) toolbar_view.findViewById(R.id.etSearch);
            tvTitle = (TextView) toolbar_view.findViewById(R.id.tvTitle);
            ibSearch = (ImageView) toolbar_view.findViewById(R.id.ibadd);
            ibReturn = (ImageButton) toolbar_view.findViewById(R.id.ibreturn);
            setTitle(R.string.search_title);
            setTitleVis();
            setIbSearchVis();
            //添加view，在另一个view上添加view
            LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL);
            addView(toolbar_view,lp);
        }

    }


    private void initListener() {
        ibSearch.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isShowTitle) {
                    isShowTitle = false;
                    setEtSearchVis();
                    hidleTitleVis();
                    hidleIbSearchVis();
                }
            }
        });
    }


    @Override
    public void setTitle(@StringRes int resId) {
        setTitle(getContext().getString(resId));
    }

    @Override
    public void setTitle(CharSequence title) {
        if (!TextUtils.isEmpty(title)) {
            if (tvTitle != null) {
                tvTitle.setText(title);
            }
        }
    }


    private void setTitleVis() {
        if (tvTitle != null) {
            if (tvTitle.getVisibility() != VISIBLE) {
                tvTitle.setVisibility(VISIBLE);
            }
        }
    }

    private void setEtSearchVis() {
        if (etSearch != null) {
            if (etSearch.getVisibility() != VISIBLE) {
                etSearch.setVisibility(VISIBLE);
            }
        }
    }

    private void setIbSearchVis() {
        if (ibSearch != null) {
            if (ibSearch.getVisibility() != VISIBLE) {
                ibSearch.setVisibility(VISIBLE);
            }
        }
    }

    private void hidleTitleVis() {
        if (tvTitle != null) {
            if (tvTitle.getVisibility() == VISIBLE) {
                tvTitle.setVisibility(GONE);
            }
        }
    }

    private void hidleEtSearchVis() {
        if (etSearch != null) {
            if (etSearch.getVisibility() == VISIBLE) {
                etSearch.setVisibility(GONE);
            }
        }
    }

    private void hidleIbSearchVis() {
        if (ibSearch != null) {
            if (ibSearch.getVisibility() == VISIBLE) {
                ibSearch.setVisibility(GONE);
            }
        }
    }

}
