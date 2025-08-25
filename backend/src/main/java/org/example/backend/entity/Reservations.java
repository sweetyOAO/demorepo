package org.example.backend.entity;


public class Reservations {

  private String id;
  private String bookId;
  private String userId;
  private java.sql.Timestamp reservedAt;
  private String status;
  private java.sql.Timestamp expiresAt;
  private java.sql.Timestamp createdAt;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getBookId() {
    return bookId;
  }

  public void setBookId(String bookId) {
    this.bookId = bookId;
  }


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public java.sql.Timestamp getReservedAt() {
    return reservedAt;
  }

  public void setReservedAt(java.sql.Timestamp reservedAt) {
    this.reservedAt = reservedAt;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  public java.sql.Timestamp getExpiresAt() {
    return expiresAt;
  }

  public void setExpiresAt(java.sql.Timestamp expiresAt) {
    this.expiresAt = expiresAt;
  }


  public java.sql.Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(java.sql.Timestamp createdAt) {
    this.createdAt = createdAt;
  }

}
