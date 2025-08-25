package org.example.backend.entity;


public class Books {

  private String id;
  private String isbn;
  private String title;
  private String author;
  private String publisher;
  private long publishYear;
  private String genre;
  private String description;
  private long totalCopies;
  private long availableCopies;
  private String coverImageUrl;
  private String location;
  private java.sql.Timestamp createdAt;
  private java.sql.Timestamp updatedAt;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }


  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }


  public long getPublishYear() {
    return publishYear;
  }

  public void setPublishYear(long publishYear) {
    this.publishYear = publishYear;
  }


  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public long getTotalCopies() {
    return totalCopies;
  }

  public void setTotalCopies(long totalCopies) {
    this.totalCopies = totalCopies;
  }


  public long getAvailableCopies() {
    return availableCopies;
  }

  public void setAvailableCopies(long availableCopies) {
    this.availableCopies = availableCopies;
  }


  public String getCoverImageUrl() {
    return coverImageUrl;
  }

  public void setCoverImageUrl(String coverImageUrl) {
    this.coverImageUrl = coverImageUrl;
  }


  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }


  public java.sql.Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(java.sql.Timestamp createdAt) {
    this.createdAt = createdAt;
  }


  public java.sql.Timestamp getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(java.sql.Timestamp updatedAt) {
    this.updatedAt = updatedAt;
  }

}
