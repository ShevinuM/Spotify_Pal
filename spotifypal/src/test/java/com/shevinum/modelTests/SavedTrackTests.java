package com.shevinum.modelTests;

import com.shevinum.model.SavedTrack;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.assertj.core.api.Assertions.assertThat;

public class SavedTrackTests {
    SavedTrack savedTrack = new SavedTrack();

    @Test
    void testSetAdded_at() {
        // given
        String added_at = "2023-07-19T00:00:00+00:00";
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(added_at);
        Timestamp expectedTimestamp = Timestamp.from(offsetDateTime.toInstant());

        // when
        savedTrack.setAdded_at(added_at);
        Timestamp result = savedTrack.getAdded_at();

        //then
        assertThat(result).isEqualTo(expectedTimestamp);
    }

    @Test
    void testSetAdded_atWithCurrentTimestamp() {
        //given
        SavedTrack savedTrack = new SavedTrack();
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        OffsetDateTime offsetDateTime = currentTimestamp.toInstant().atOffset(ZoneOffset.UTC);
        String timestampString = offsetDateTime.toString();

        //when
        savedTrack.setAdded_at(timestampString);
        Timestamp result = savedTrack.getAdded_at();

        //then
        assertThat(result).isEqualTo(currentTimestamp);
    }

}
