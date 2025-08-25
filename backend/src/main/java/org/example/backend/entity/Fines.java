package org.example.backend.entity;


public class Fines {

  private String id;
  private String borrowRecordId;
  private String amount;
  private String reason;
  private String status;
  private java.sql.Timestamp createdAt;
  private java.sql.Timestamp paidAt;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getBorrowRecordId() {
    return borrowRecordId;
  }

  public void setBorrowRecordId(String borrowRecordId) {
    this.borrowRecordId = borrowRecordId;
  }


  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }


  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
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


  public java.sql.Timestamp getPaidAt() {
    return paidAt;
  }

  public void setPaidAt(java.sql.Timestamp paidAt) {
    this.paidAt = paidAt;
  }

}
