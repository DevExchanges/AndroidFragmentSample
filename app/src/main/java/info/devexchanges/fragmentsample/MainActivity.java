package info.devexchanges.fragmentsample;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private View btnReplace;
    private View btnRemove;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    private final static String FRAGMENT_TAG = "fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRemove = findViewById(R.id.btn_remove);
        btnReplace = findViewById(R.id.btn_replace);

        btnReplace.setOnClickListener(onReplaceFragment());
        btnRemove.setOnClickListener(onRemoveFragment());
    }

    private View.OnClickListener onRemoveFragment() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //initial a FragmentManager instance
                fragmentManager = getSupportFragmentManager();

                //initial a FragmentTransaction
                fragmentTransaction = fragmentManager.beginTransaction();

                //find the Fragment by TAG
                SampleFragment f = (SampleFragment)fragmentManager.findFragmentByTag(FRAGMENT_TAG);

                //remove this Fragment
                fragmentTransaction.remove(f);

                //invoke command
                fragmentTransaction.commit();

            }
        };
    }

    private View.OnClickListener onReplaceFragment() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //initial a FragmentTransaction instance
                fragmentManager = getSupportFragmentManager();

                //initial a FragmentTransaction
                fragmentTransaction = fragmentManager.beginTransaction();

                //add to Transaction
                fragmentTransaction.add(R.id.container, new SampleFragment(), FRAGMENT_TAG);

                //replace Fragment to the container layout
                fragmentTransaction.replace(R.id.container, new SampleFragment(), FRAGMENT_TAG);

                //invoke this transaction
                fragmentTransaction.commit();
            }
        };
    }
}
