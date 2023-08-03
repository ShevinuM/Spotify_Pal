package com.shevinum.service;

import com.shevinum.dao.SavedTrackRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;


class SavedTrackServiceTest {

    @Mock
    private SavedTrackRepository savedTrackRepository;
    private SavedTrackService underTest;

    @BeforeEach
    void setUp() {
        underTest = new SavedTrackService(savedTrackRepository);
    }

    @Test
    void updateSongs() {

    }
}