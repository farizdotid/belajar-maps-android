package meridianid.farizdotid.belajarmaps.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import meridianid.farizdotid.belajarmaps.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private Button button_mapsstatic, button_mapsdynamic, button_mapsdirection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
    }

    private void initComponents(){
        button_mapsstatic = (Button) findViewById(R.id.button_mapsstatic);
        button_mapsstatic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MapsStaticActivity.class);
            }
        });

        button_mapsdynamic = (Button) findViewById(R.id.button_mapsdynamic);
        button_mapsdynamic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MapsDynamicActivity.class);
            }
        });
    }

    private void startActivity(Class classTujuan){
        startActivity(new Intent(MainActivity.this, classTujuan));
    }
}
