package com.shevinum.dao;

import com.shevinum.model.SavedPlaylists;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavedPlaylistsRepository extends JpaRepository<SavedPlaylists, Long> {
}
