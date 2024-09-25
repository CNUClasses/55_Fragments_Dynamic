package com.example.a55_fragments_dynamic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final String frag1String = "Fragment1_ID_STRING";
    boolean showButtons = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            //if app ust instantiated add frags, otherwise let android handle
            // start the fragment manager
            FragmentManager manager = getSupportFragmentManager();

            // we want a transaction
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.setReorderingAllowed(true);

            transaction.add(R.id.fragment_container1, new Fragment1(), frag1String);
            transaction.add(R.id.fragment_container2, new Fragment2());

            // either both or neither
            transaction.commit();
            manager.executePendingTransactions();
        }
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();

        // must use fragment manager, get a ref to named fragment (see onCreate())
        Fragment1 myFrag1 = (Fragment1) getSupportFragmentManager().findFragmentByTag(frag1String);

        // orig transaction could have failed OR fragment UI is not completely created
        if (myFrag1 != null) {
            View myView = myFrag1.getView();  //gets root view for fragments layout, the one returned by onCreateView
            if (myView != null) {
                TextView myTextView = (TextView) myView.findViewById(R.id.textView1);  //look for views hosted in the root view
                myTextView.setText("Direct Manipulation");
            }
        }

    }

    public void doChange2(View view) {
        showButtons = !showButtons;

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        if (showButtons)
            transaction.add(R.id.fragment_container2, new Fragment2Radio());
        else
            transaction.add(R.id.fragment_container2, new Fragment2());

        transaction.commit();
        manager.executePendingTransactions();
    }


}
