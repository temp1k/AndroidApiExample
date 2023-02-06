package com.example.api_example.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.api_example.GamePage;
import com.example.api_example.Models.Game;
import com.example.api_example.Models.Manga;
import com.example.api_example.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.GameViewHolder>{
    private Context context;
    private ArrayList<Game> games;

    public GameAdapter(Context context, ArrayList<Game> games) {
        this.context = context;
        this.games = games;
    }

    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.game_item, parent, false);
        return new GameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GameViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.gameTitle.setText(games.get(position).getGame_Name());
        Picasso.with(context.getApplicationContext())
                .load(games.get(position).getGame_Img())
                .placeholder(R.drawable.placeholder_error_foreground)
                .error(R.drawable.placeholder_error_foreground)
                .into(holder.gameImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(context, GamePage.class);

                intent.putExtra("idGame", games.get(position).getId_Game());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    public final static class GameViewHolder extends RecyclerView.ViewHolder {

        CardView gameBg;
        ImageView gameImage;
        TextView gameTitle, gameText;

        public GameViewHolder(@NonNull View itemView) {
            super(itemView);

            gameTitle = itemView.findViewById(R.id.name_game);
            gameImage = itemView.findViewById(R.id.imageGameItem);
        }
    }
}