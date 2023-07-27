package com.shevinum.model;

import jakarta.persistence.*;

@Entity(name="SavedPlaylists")
public class SavedPlaylists {

    @Id
    @SequenceGenerator(
            name = "savedPlaylist_sequence",
            sequenceName = "savedPlaylist_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = jakarta.persistence.GenerationType.SEQUENCE,
            generator = "savedPlaylist_sequence"
    )
    @Column(
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
            name = "id",
            nullable = false,
            columnDefinition = "TEXT",
            unique = true
    )
    private String id;

    @Column(
            name = "owners_id",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String owners_id;

    @Column(
            name = "uri",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String uri;

    public SavedPlaylists(String name, String id, String owners_id, String uri) {
        this.name = name;
        this.id = id;
        this.owners_id = owners_id;
        this.uri = uri;
    }

    public SavedPlaylists() {

    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getOwners_id() {
        return owners_id;
    }

    public String getUri() {
        return uri;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOwners_id(String owners_id) {
        this.owners_id = owners_id;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return "SavedPlaylists{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", owners_id='" + owners_id + '\'' +
                ", uri='" + uri + '\'' +
                '}';
    }
}
