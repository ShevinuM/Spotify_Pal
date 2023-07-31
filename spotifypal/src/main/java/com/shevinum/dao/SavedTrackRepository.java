package com.shevinum.dao;

import com.shevinum.model.SavedTrack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavedTrackRepository extends JpaRepository<SavedTrack, Long> {
}
