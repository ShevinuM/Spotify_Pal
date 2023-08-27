package com.shevinum.dao;

import com.shevinum.model.SavedTrack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavedTrackRepository extends JpaRepository<SavedTrack, Long> {
}
