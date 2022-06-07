package com.example.dictonary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.dictonary.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import ApiCall.Api;
import ApiCall.ApiInterface;
import Models.MainDetails;
import Models.Meanings;
import Models.RandomWords;
import Models.Variables;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    String searchedText;
    String speech;
    String audio;
    String definition;
    List<String> synonyms;
    List<String> antonyms;
    String Word;
    String phonetic;

    List<MainDetails> getMeanings = new ArrayList<>();
    List<Meanings> meaningsList;


    RandomWords randomlyWords = new RandomWords();

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_Dictonary);
        super.onCreate(savedInstanceState);

        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(getDrawable(R.color.skyBluish));

        String[] randomWords = randomlyWords.getRandomWords();
        Random random = new Random();
        int RandomInt = random.nextInt(randomWords.length);
        String randomly = randomWords[RandomInt];


        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        showMeaning(randomly);

        binding.searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchedText = newText;
                showMeaning(searchedText);
                return false;
            }
        });

        binding.swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                binding.swipeRefresh.setRefreshing(false);

                String[] randomWords = randomlyWords.getRandomWords();
                Random random = new Random();
                int RandomInt = random.nextInt(randomWords.length);
                String randomly = randomWords[RandomInt];

                showMeaning(randomly);
            }
        });

        binding.sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               MediaPlayer mediaPlayer = new MediaPlayer();
               mediaPlayer = MediaPlayer.create(MainActivity.this,Uri.parse(audio));
               try{
                   mediaPlayer.start();
               }catch (Exception e){
                   e.printStackTrace();
               }
            }
        });


    }

    private void showMeaning(String word) {
        ApiInterface apiInterface = Api.getRetrofit().create(ApiInterface.class);

        apiInterface.getMeanings(word).enqueue(new Callback<List<MainDetails>>() {

            @Override
            public void onResponse(@NonNull Call<List<MainDetails>> call, @NonNull Response<List<MainDetails>> response) {
                if(response.isSuccessful()){
                    assert response.body() != null;
                        try {
                            getMeanings = response.body();

//                            Word
                            Word = getMeanings.get(0).getWord();
//                            binding.searchedWord.setText(Word);

//                            Phonetic
                            phonetic = getMeanings.get(0).getPhonetic();
//                            binding.text.setText(phonetic);

//                            MeaningList
                            meaningsList = getMeanings.get(0).getMeaningsList();

//                            PartOfSpeech
                            speech = meaningsList.get(0).getPartOfSpeech();
//                            binding.speechWord.setText(speech);

//                            Definition
                            definition = getMeanings.get(0).
                                    getMeaningsList().
                                    get(0).
                                    getDefinitionsList().
                                    get(0).getDefinitions();
//                            binding.definedWord.setText(definition);

//                            Synonyms
                            synonyms = meaningsList.get(0).getSynonymsList();
                            binding.synonymsWords.setSelected(true);

//                            antonyms
                            antonyms = meaningsList.get(0).getAntonymsList();
                            binding.antonymsWords.setSelected(true);

                            audio = getMeanings.get(0).
                                    getAudio().
                                    get(0).getAudioUrl();

                            Variables variables = new Variables(speech,definition,synonyms,antonyms,Word,phonetic);
                            binding.setWords(variables);

                        }catch (IndexOutOfBoundsException e){
                            e.fillInStackTrace();
                        }
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<MainDetails>> call, @NonNull Throwable t) {
                Toast.makeText(MainActivity.this, "Turn on Internet", Toast.LENGTH_SHORT).show();
            }
        });
    }

}