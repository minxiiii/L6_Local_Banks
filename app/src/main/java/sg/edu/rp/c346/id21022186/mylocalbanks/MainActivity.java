package sg.edu.rp.c346.id21022186.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //variables
    TextView tvTranslatedText;
    Button btnposb;
    Button btnocbc;
    Button btnuob;
    String wordClicked = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // link

        btnposb = findViewById(R.id.POSB);
        btnocbc = findViewById(R.id.OCBC);
        btnuob = findViewById(R.id.UOB);


        tvTranslatedText = findViewById(R.id.EnglishSelection);
        tvTranslatedText = findViewById(R.id.ChineseSelection);
        registerForContextMenu(tvTranslatedText);

    }

    // translation
    @Override
    public boolean onOptionItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvTranslatedText.setText("DBS");
            tvTranslatedText.setText("OCBC");
            tvTranslatedText.setText("UOB");
            return true;

        } else if (id == R.id.ChineseSelection) {
            tvTranslatedText.setText("星展银行");
            tvTranslatedText.setText("华侨银行");
            tvTranslatedText.setText("大华银行");
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_main, menu);


        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        btnposb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                    //code for action
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                    startActivity(intent);

                } else if (item.getItemId() == 1) {
                    Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("18001111111"));
                    startActivity(intentCall);
                }
            }
        });

        btnocbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                    //code for action
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                    startActivity(intent);
                } else if (item.getItemId() == 1) {
                    Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("18003633333"));
                    startActivity(intentCall);
                }
            }
        });
        btnuob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                    //code for action
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                    startActivity(intent);
                } else if (item.getItemId() == 1) {
                    Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("18002222121"));
                    startActivity(intentCall);
                }
            }
        });
        return true;
    }
}



