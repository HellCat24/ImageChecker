package net.olmaz.picturechecker;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;

/**
 * Created by omazhukin on 10/13/2015.
 */
public abstract class BaseToolBarActivity extends BaseActivity{

    //@Bind(R.id.toolbar)
    protected Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
    }
}
