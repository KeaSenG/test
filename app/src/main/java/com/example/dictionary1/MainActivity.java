package com.example.dictionary1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements UsersAdapter.SelectedUser {

    Toolbar toolbar;
    RecyclerView recyclerView;

    List<UserModel> userModelList = new ArrayList<>();

    String[] names = {"កម្ដៅ"
            ,"កម្ដៅម៉ាស"
            ,"កម្ទេចកំណ"
            ,"កម្មន្ត"
            ,"កម្លាំងអន្តរម៉ូលេគុល"
            ,"ករនេ"
            ,"កាចុង"
            ,"កាតាលីករ"
            ,"កាម៉ែតូភីត"
            ,"កាលសម័យ"
            ,"កាឡាក់ស៊ី"
            ,"កុម្មុយតាទ័រ"
            ,"កូទីឡេដុង"
            ,"កោសិកា "
            ,"ក្រាភិច"
            ,"ក្លរ៉ូប្លាស"
            ,"កំណក"
            ,"កំណជាញើស"
            ,"កាំរស្មីស្វាយអ៊ុយត្រា"
            ,"ខួរឆ្អឹង"
            ,"ខ្យល់ជំនោរទ្វីប"
            ,"ខ្យល់ជំនោរសមុទ្រ"
            ,"ខ្សែវ័ណ្ឌអេក្វាទ័រ"
            ,"គីទីន"
            ,"គីស"
            ,"គុយទីគុល"
            ,"គុយទីន"
            ,"គ្លីកូសែន"
            ,"គ្លុយស៊ីត"
            ,"ចរន្តឆ្លាស់"
            ,"ច្បាប់ទី១ញូតុន"
            ,"ច្បាប់ទី២ញូតុន"
            ,"ច្បាប់ទី3ញូតុន"
            ,"ចំណុចកំណុំ"
            ,"ចំណាំងបែរនៃពន្លឺ"
            ,"ចំណាំងផ្លាតនៃពន្លឺ"
            ,"ជាលិកា"
            ,"ជាលិកាសន្ធាន"
            ,"ជ័រធ្យូងថ្ម"
            ,"ដង្ហើមកោសិកា"
            ,"ដង់ស៊ីតេ"
            ,"ដីបាស"
            ,"ដីល្អ"
            ,"ដីអាស៊ីត"
            ,"ដែនគំហើញ"
            ,"ដំបង"
            ,"ឋបនីយជីវមណ្ឌល"
            ,"តារាវិទ្យា"
            ,"តេឡេទស្សន៍"
            ,"ត្រង់ស្វូ"
            ,"ថលជលិក"
            ,"ថាមពលប៉ូតង់ស្យែល"
            ,"ថាមពលស៊ីនេទិច"
            ,"ទម្រង់អេឡិចត្រូនិច"
            ,"ទែម៉ូឌីណាមិច"
            ,"ធរណីវិទ្យាឬ ភូគព្តសាស្ត្រ"
            ,"ធាតុកោសិកា"
            ,"ធ្យូង"
            ,"និរន្តរភាព"
            ,"បរាសិត"
            ,"បរិស្ថាន"
            ,"ប៉ូលីមែ"
            ,"ប៉ែលីគុល"
            ,"ប្រដាប់របត់ឈាមទោល"
            ,"ប្រដាប់របត់ឈាមទ្វេ"
            ,"ប្រដាប់របត់ឈាមបិទ"
            ,"ប្រព័ន្ធខ្នាតអន្តរជាតិ"
            ,"បំណិតប្រភាគ"
            ,"ផូស៊ីល"
            ,"ផូស៊ីលឥន្ធនៈ"
            ,"ផូសីល"
            ,"ភ្នាសស៊ីតូប្លាស"
            ,"មណ្ឌលជីវៈ"
            ,"មណ្ឌលអាកាស"
            ,"ម៉ាក្រូម៉ូលេគុល"
            ,"ម៉ូទ័រ"
            ,"ម៉ូលេគុល"
            ,"មាត្រដ្ឋានសីតុណ្ហភាព"
            ,"មីក្រូសារពាង្គកាយ"
            ,"មេតាប៉ូលី"
            ,"រូបធាតុ"
            ,"រំពុះ"
            ,"រំហួត"
            ,"ល្បឿន"
            ,"លំនាំហេប៊ើ"
            ,"វ៉ាឡង់"
            ,"វ៉ិចទ័រល្បឿន"
            ,"វិសមរូប"
            ,"វីរុស"
            ,"សត្វថេរកម្ដៅ"
            ,"សត្វទ្វេភេទ"
            ,"សត្វអថេរកម្ដៅ"
            ,"សន្ទនីយ"
            ,"សមាសធាតុ"
            ,"សម្ព័ន្ធកូវ៉ាឡង់"
            ,"សម្ព័ន្ធគីមី"
            ,"សម្ភារៈតំណពូជ"
            ,"សម្មតិកម្ម"
            ,"សម័យ"
            ,"សរសៃរចំណង"
            ,"សរសៃរពួរ"
            ,"សាគរវិទ្យា"
            ,"សាច់ដុំវាវបី"
            ,"សាច់ដុំវាវពីរ"
            ,"សិលាឃ្លាំង"
            ,"សីតុណ្ហភាព"
            ,"សឺមីកុងឌុចទ័រ"
            ,"សូលេណូអ៊ីត"
            ,"ស្តូម៉ាត"
            ,"ស្ប៉"
            ,"ស្រទាប់អូសូន"
            ,"អង់ទីប្យូទិច"
            ,"ឧតុភូតវិទ្យា"
            ,"អានុភាព"
            ,"ឥន្ធនៈផូស៊ីល"
            ,"ឧបករណ៍ចរន្តឆ្លាស់"
            ,"អាល់ទែណាទ័រ"
            ,"អុកស៊ីត"
            ,"អ៊ីដ្រូកាបួ"
            ,"អ៊ីយ៉ុងកុំផ្លិច"
            ,"អេឡិចត្រុង"
            ,"អេឡិចត្រុងវ៉ាឡង់"


    };



    UsersAdapter usersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        toolbar = findViewById(R.id.toolbar);

        this.setSupportActionBar(toolbar);
        this.getSupportActionBar().setTitle("");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        for(String s:names){
            UserModel userModel = new UserModel(s);

            userModelList.add(userModel);
        }
        usersAdapter = new UsersAdapter(userModelList,this);

        recyclerView.setAdapter(usersAdapter);

    }

    @Override
    public void selectedUser(UserModel userModel) {

        startActivity(new Intent(MainActivity.this, SelectedUserActivity.class).putExtra("data",userModel));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem menuItem = menu.findItem(R.id.search_view);

        SearchView searchView =(SearchView) menuItem.getActionView();

        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                usersAdapter.getFilter().filter(newText);
                return true;
            }
        });

        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.search_view){
            return  true;
        }

        return super.onOptionsItemSelected(item);
    }


}