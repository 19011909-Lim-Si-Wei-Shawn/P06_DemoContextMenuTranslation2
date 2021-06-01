package sg.edu.rp.c346.id19011909.democontextmenutranslation2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //Creating Variable,
    TextView tvTranslatedText;

    TextView tvTranslatedText2;

    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Linking Variable,
        tvTranslatedText = findViewById(R.id.textViewTranslatedText);

        tvTranslatedText2 = findViewById(R.id.textViewTranslatedText2);

        //Setting Action,
        registerForContextMenu(tvTranslatedText);
        registerForContextMenu(tvTranslatedText2);
    }

    //Displaying Dropdown List,
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        //Inflating Menu,
        getMenuInflater().inflate(R.menu.menu_main, menu);

        //Setting Selected Word,
        if(v == tvTranslatedText)
        {   wordClicked = "hello";      }

        else if(v == tvTranslatedText2)
        {   wordClicked = "bye";        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //Handling all Clicks on Action Bar Item,
        int id = item.getItemId();

        if(wordClicked.equalsIgnoreCase("hello")) {
            if (id == R.id.EnglishSelection) {
                tvTranslatedText.setText("Hello");
                return true;
            } else if (id == R.id.italianSelection) {
                tvTranslatedText.setText("Ciao");
                return true;
            } else {
                tvTranslatedText.setText("Error Translation");
            }
        }

        else if(wordClicked.equalsIgnoreCase("bye")) {
            if (id == R.id.EnglishSelection) {
                tvTranslatedText2.setText("Bye");
                return true;
            } else if (id == R.id.italianSelection) {
                tvTranslatedText2.setText("Addio");
                return true;
            } else {
                tvTranslatedText.setText("Error Translation");
            }
        }

        return super.onContextItemSelected(item);
    }


}