package com.johnnyalvesx.restapisongs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class SongRepository {
    private List<Song> list = new ArrayList<Song>();

    public List<Song> getAllSongs() {
	return list;
    }

    public Song getSongById(Integer id) {
	return null;
    }

    public void addSong(Song s) {

    }

    public void updateSong(Song s) {

    }

    public void removeSong(Song s) {

    }
}
