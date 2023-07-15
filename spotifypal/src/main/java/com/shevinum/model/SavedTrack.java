package com.shevinum.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.OffsetDateTime;

@Entity(name = "SavedTrack")
public class SavedTrack {

    @Id
    @SequenceGenerator(
            name = "savedTrack_sequence",
            sequenceName = "savedTrack_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = jakarta.persistence.GenerationType.SEQUENCE,
            generator = "savedTrack_sequence"
    )
    @Column (
            name = "table_id",
            updatable = false
    )
    private Long table_id;
    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;
    @Column(
            name = "uri",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String uri;
    @Column(
            name = "artist_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String artist_name;
    @Column(
            name = "artist_uri",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String artist_uri;
    @Column(
            name = "added_at",
            nullable = false,
            columnDefinition = "TIMESTAMP"
    )
    private Timestamp added_at;
    @Column(
            name = "id",
            nullable = false,
            columnDefinition = "TEXT",
            unique = true
    )
    private String id;
    @Column(
            name = "danceability",
            nullable = false,
            columnDefinition = "FLOAT"
    )
    private Float danceability;
    @Column(
            name = "duration",
            nullable = false,
            columnDefinition = "INTEGER"
    )
    private Integer duration;
    @Column(
            name = "energy",
            nullable = false,
            columnDefinition = "FLOAT"
    )
    private Float energy;
    @Column(
            name = "key",
            nullable = false,
            columnDefinition = "INTEGER"
    )
    private Integer key;
    @Column(
            name = "mode",
            nullable = false,
            columnDefinition = "INTEGER"
    )
    private Integer mode;
    @Column(
            name = "tempo",
            nullable = false,
            columnDefinition = "FLOAT"
    )
    private Float tempo;
    @Column(
            name = "valence",
            nullable = false,
            columnDefinition = "FLOAT"
    )
    private Float valence;

    public SavedTrack(Long table_id, String name, String uri, String artist_name, String artist_uri, String added_at, String id, Float danceability, Integer duration, Float energy, Integer key, Integer mode, Float tempo, Float valence) {
        this.table_id = table_id;
        this.name = name;
        this.uri = uri;
        this.artist_name = artist_name;
        this.artist_uri = artist_uri;
        setAdded_at(added_at);
        this.id = id;
        this.danceability = danceability;
        this.duration = duration;
        this.energy = energy;
        this.key = key;
        this.mode = mode;
        this.tempo = tempo;
        this.valence = valence;
    }

    public SavedTrack() {

    }

    public Long getTable_id() {
        return table_id;
    }

    public String getName() {
        return name;
    }

    public String getUri() {
        return uri;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public String getArtist_uri() {
        return artist_uri;
    }

    public Timestamp getAdded_at() {
        return added_at;
    }

    public String getId() {
        return id;
    }

    public Float getDanceability() {
        return danceability;
    }

    public Integer getDuration() {
        return duration;
    }

    public Float getEnergy() {
        return energy;
    }

    public Integer getKey() {
        return key;
    }

    public Integer getMode() {
        return mode;
    }

    public Float getTempo() {
        return tempo;
    }

    public Float getValence() {
        return valence;
    }

    public void setTable_id(Long index) {
        this.table_id = index;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public void setArtist_uri(String artist_uri) {
        this.artist_uri = artist_uri;
    }

    public void setAdded_at(String added_at) {
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(added_at);
        Timestamp timestamp = Timestamp.from(offsetDateTime.toInstant());
        this.added_at = timestamp;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDanceability(Float danceability) {
        this.danceability = danceability;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setEnergy(Float energy) {
        this.energy = energy;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public void setMode(Integer mode) {
        this.mode = mode;
    }

    public void setTempo(Float tempo) {
        this.tempo = tempo;
    }

    public void setValence(Float valence) {
        this.valence = valence;
    }

    @Override
    public String toString() {
        return "SavedTrack{" +
                "index=" + table_id +
                ", name='" + name + '\'' +
                ", uri='" + uri + '\'' +
                ", artist_name='" + artist_name + '\'' +
                ", artist_uri='" + artist_uri + '\'' +
                ", added_at=" + added_at +
                ", id='" + id + '\'' +
                ", danceability=" + danceability +
                ", duration=" + duration +
                ", energy=" + energy +
                ", key=" + key +
                ", mode=" + mode +
                ", tempo=" + tempo +
                ", valence=" + valence +
                '}';
    }
}
