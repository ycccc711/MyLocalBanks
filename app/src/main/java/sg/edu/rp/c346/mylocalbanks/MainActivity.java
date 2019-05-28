package sg.edu.rp.c346.mylocalbanks;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnDBS;
    Button btnOCBC;
    Button btnUOB;

    String bank = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDBS = findViewById(R.id.btnDBS);
        btnOCBC = findViewById(R.id.btnOCBC);
        btnUOB = findViewById(R.id.btnUOB);

        registerForContextMenu(btnDBS);
        registerForContextMenu(btnOCBC);
        registerForContextMenu(btnUOB);

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");

        int id = v.getId();
        if(id == R.id.btnDBS){
            bank ="DBS";
        }
        if(id == R.id.btnOCBC){
            bank = "OCBC";
        }
        if(id == R.id.btnUOB){
            bank = "UOB";
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId() == 0){
            if(bank.equals("DBS")){
                Intent intentdbs = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.dbs.com.sg"));
                startActivity(intentdbs);
            }
            if(bank.equals("OCBC")){
                Intent intentocbc = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.ocbc.com"));
                startActivity( intentocbc);
            }
            if(bank.equals("UOB")){
                Intent intentuob = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.uob.com.sg"));
                startActivity( intentuob);
            }
        }else if(item.getItemId() == 1){
            if(bank.equals("DBS")){
                Intent calldbs = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+ "18001111111"));
                startActivity(calldbs);
            }
            if(bank.equals("OCBC")){
                Intent callocbc = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+ "18003633333"));
                startActivity(callocbc);
            }
            if(bank.equals("UOB")){
                Intent calluob = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+ "18002222121"));
                startActivity(calluob);
            }

        }

        return super.onContextItemSelected(item);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //R.menu_main = name of the menu resource file
        getMenuInflater().inflate(R.menu.bank_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            btnDBS.setText("DBS");
            btnOCBC.setText("OCBC");
            btnUOB.setText("UOB");
            return true;

        }else if(id == R.id.chineseSelection) {
            btnDBS.setText(getResources().getString(R.string.dbs));
            btnOCBC.setText(getResources().getString(R.string.ocbc));
            btnUOB.setText(getResources().getString(R.string.uob));
            return true;
        }


        return super.onOptionsItemSelected(item);
    }


}
