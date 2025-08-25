package org.example.backend.entity;


public class BorrowRecords {

  private String id;
  private String bookId;
  private String userId;
  private java.sql.Timestamp borrowedAt;
  private java.sql.Timestamp dueDate;
  private java.sql.Timestamp returnedAt;
  private long renewalCount;
  private String status;
  private java.sql.Timestamp createdAt;
  private java.sql.Timestamp updatedAt;


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


  public java.sql.Timestamp getBorrowedAt() {
    return borrowedAt;
  }

  public void setBorrowedAt(java.sql.Timestamp borrowedAt) {
    this.borrowedAt = borrowedAt;
  }


  public java.sql.Timestamp getDueDate() {
    return dueDate;
  }

  public void setDueDate(java.sql.Timestamp dueDate) {
    this.dueDate = dueDate;
  }


  public java.sql.Timestamp getReturnedAt() {
    return returnedAt;
  }

  public void setReturnedAt(java.sql.Timestamp returnedAt) {
    this.returnedAt = returnedAt;
  }


  public long getRenewalCount() {
    return renewalCount;
  }

  public void setRenewalCount(long renewalCount) {
    this.renewalCount = renewalCount;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
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
