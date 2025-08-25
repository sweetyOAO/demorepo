package org.example.backend.entity;


import java.time.OffsetDateTime;

public class Users {

  private String instanceId;
  private String id;
  private String aud;
  private String role;
  private String email;
  private String encryptedPassword;
  private java.sql.Timestamp emailConfirmedAt;
  private java.sql.Timestamp invitedAt;
  private String confirmationToken;
  private java.sql.Timestamp confirmationSentAt;
  private String recoveryToken;
  private java.sql.Timestamp recoverySentAt;
  private String emailChangeTokenNew;
  private String emailChange;
  private java.sql.Timestamp emailChangeSentAt;
  private java.sql.Timestamp lastSignInAt;
  private String rawAppMetaData;
  private String rawUserMetaData;
  private String isSuperAdmin;
  private OffsetDateTime createdAt;
  private java.sql.Timestamp updatedAt;
  private String phone;
  private java.sql.Timestamp phoneConfirmedAt;
  private String phoneChange;
  private String phoneChangeToken;
  private java.sql.Timestamp phoneChangeSentAt;
  private java.sql.Timestamp confirmedAt;
  private String emailChangeTokenCurrent;
  private long emailChangeConfirmStatus;
  private java.sql.Timestamp bannedUntil;
  private String reauthenticationToken;
  private java.sql.Timestamp reauthenticationSentAt;
  private String isSsoUser;
  private java.sql.Timestamp deletedAt;
  private String isAnonymous;


  public String getInstanceId() {
    return instanceId;
  }

  public void setInstanceId(String instanceId) {
    this.instanceId = instanceId;
  }


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getAud() {
    return aud;
  }

  public void setAud(String aud) {
    this.aud = aud;
  }


  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getEncryptedPassword() {
    return encryptedPassword;
  }

  public void setEncryptedPassword(String encryptedPassword) {
    this.encryptedPassword = encryptedPassword;
  }


  public java.sql.Timestamp getEmailConfirmedAt() {
    return emailConfirmedAt;
  }

  public void setEmailConfirmedAt(java.sql.Timestamp emailConfirmedAt) {
    this.emailConfirmedAt = emailConfirmedAt;
  }


  public java.sql.Timestamp getInvitedAt() {
    return invitedAt;
  }

  public void setInvitedAt(java.sql.Timestamp invitedAt) {
    this.invitedAt = invitedAt;
  }


  public String getConfirmationToken() {
    return confirmationToken;
  }

  public void setConfirmationToken(String confirmationToken) {
    this.confirmationToken = confirmationToken;
  }


  public java.sql.Timestamp getConfirmationSentAt() {
    return confirmationSentAt;
  }

  public void setConfirmationSentAt(java.sql.Timestamp confirmationSentAt) {
    this.confirmationSentAt = confirmationSentAt;
  }


  public String getRecoveryToken() {
    return recoveryToken;
  }

  public void setRecoveryToken(String recoveryToken) {
    this.recoveryToken = recoveryToken;
  }


  public java.sql.Timestamp getRecoverySentAt() {
    return recoverySentAt;
  }

  public void setRecoverySentAt(java.sql.Timestamp recoverySentAt) {
    this.recoverySentAt = recoverySentAt;
  }


  public String getEmailChangeTokenNew() {
    return emailChangeTokenNew;
  }

  public void setEmailChangeTokenNew(String emailChangeTokenNew) {
    this.emailChangeTokenNew = emailChangeTokenNew;
  }


  public String getEmailChange() {
    return emailChange;
  }

  public void setEmailChange(String emailChange) {
    this.emailChange = emailChange;
  }


  public java.sql.Timestamp getEmailChangeSentAt() {
    return emailChangeSentAt;
  }

  public void setEmailChangeSentAt(java.sql.Timestamp emailChangeSentAt) {
    this.emailChangeSentAt = emailChangeSentAt;
  }


  public java.sql.Timestamp getLastSignInAt() {
    return lastSignInAt;
  }

  public void setLastSignInAt(java.sql.Timestamp lastSignInAt) {
    this.lastSignInAt = lastSignInAt;
  }


  public String getRawAppMetaData() {
    return rawAppMetaData;
  }

  public void setRawAppMetaData(String rawAppMetaData) {
    this.rawAppMetaData = rawAppMetaData;
  }


  public String getRawUserMetaData() {
    return rawUserMetaData;
  }

  public void setRawUserMetaData(String rawUserMetaData) {
    this.rawUserMetaData = rawUserMetaData;
  }


  public String getIsSuperAdmin() {
    return isSuperAdmin;
  }

  public void setIsSuperAdmin(String isSuperAdmin) {
    this.isSuperAdmin = isSuperAdmin;
  }


  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }


  public java.sql.Timestamp getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(java.sql.Timestamp updatedAt) {
    this.updatedAt = updatedAt;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public java.sql.Timestamp getPhoneConfirmedAt() {
    return phoneConfirmedAt;
  }

  public void setPhoneConfirmedAt(java.sql.Timestamp phoneConfirmedAt) {
    this.phoneConfirmedAt = phoneConfirmedAt;
  }


  public String getPhoneChange() {
    return phoneChange;
  }

  public void setPhoneChange(String phoneChange) {
    this.phoneChange = phoneChange;
  }


  public String getPhoneChangeToken() {
    return phoneChangeToken;
  }

  public void setPhoneChangeToken(String phoneChangeToken) {
    this.phoneChangeToken = phoneChangeToken;
  }


  public java.sql.Timestamp getPhoneChangeSentAt() {
    return phoneChangeSentAt;
  }

  public void setPhoneChangeSentAt(java.sql.Timestamp phoneChangeSentAt) {
    this.phoneChangeSentAt = phoneChangeSentAt;
  }


  public java.sql.Timestamp getConfirmedAt() {
    return confirmedAt;
  }

  public void setConfirmedAt(java.sql.Timestamp confirmedAt) {
    this.confirmedAt = confirmedAt;
  }


  public String getEmailChangeTokenCurrent() {
    return emailChangeTokenCurrent;
  }

  public void setEmailChangeTokenCurrent(String emailChangeTokenCurrent) {
    this.emailChangeTokenCurrent = emailChangeTokenCurrent;
  }


  public long getEmailChangeConfirmStatus() {
    return emailChangeConfirmStatus;
  }

  public void setEmailChangeConfirmStatus(long emailChangeConfirmStatus) {
    this.emailChangeConfirmStatus = emailChangeConfirmStatus;
  }


  public java.sql.Timestamp getBannedUntil() {
    return bannedUntil;
  }

  public void setBannedUntil(java.sql.Timestamp bannedUntil) {
    this.bannedUntil = bannedUntil;
  }


  public String getReauthenticationToken() {
    return reauthenticationToken;
  }

  public void setReauthenticationToken(String reauthenticationToken) {
    this.reauthenticationToken = reauthenticationToken;
  }


  public java.sql.Timestamp getReauthenticationSentAt() {
    return reauthenticationSentAt;
  }

  public void setReauthenticationSentAt(java.sql.Timestamp reauthenticationSentAt) {
    this.reauthenticationSentAt = reauthenticationSentAt;
  }


  public String getIsSsoUser() {
    return isSsoUser;
  }

  public void setIsSsoUser(String isSsoUser) {
    this.isSsoUser = isSsoUser;
  }


  public java.sql.Timestamp getDeletedAt() {
    return deletedAt;
  }

  public void setDeletedAt(java.sql.Timestamp deletedAt) {
    this.deletedAt = deletedAt;
  }


  public String getIsAnonymous() {
    return isAnonymous;
  }

  public void setIsAnonymous(String isAnonymous) {
    this.isAnonymous = isAnonymous;
  }

}
