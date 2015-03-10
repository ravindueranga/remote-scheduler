// PROJECT : RemoteQuartzScheduler
// CLASS : Stock.java
//
// ************************************************************************************************
//
// This copy of the Source Code is a property of Ravindu Eranga Abayawardena. No
// part of this file may be reproduced or distributed in any form or by any
// means without the written approval of Ravindu Eranga Abayawardena.
//
// *************************************************************************************************
//
// REVISIONS:
// Author : Ravindu Eranga Abayawardena
// Date : Feb 28, 2015
// Version : version 1.0
//
// *************************************************************************************************

package com.rqs.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Ravindu Eranga Abaywardena
 */
@Entity
@Table(name = "stock")
public class Stock implements Serializable {
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  @Id
  @Column(name = "stock_id")
  private int stockId;
  
  @Column(name = "stock_code")
  private String stockCode;
  
  @Column(name = "stock_name")
  private String stockName;
  
  /**
   * @return the stockId
   */
  public int getStockId() {
  
    return stockId;
  }
  
  /**
   * @param stockId the stockId to set
   */
  public void setStockId(int stockId) {
  
    this.stockId = stockId;
  }
  
  /**
   * @return the stockCode
   */
  public String getStockCode() {
  
    return stockCode;
  }
  
  /**
   * @param stockCode the stockCode to set
   */
  public void setStockCode(String stockCode) {
  
    this.stockCode = stockCode;
  }
  
  /**
   * @return the stockName
   */
  public String getStockName() {
  
    return stockName;
  }
  
  /**
   * @param stockName the stockName to set
   */
  public void setStockName(String stockName) {
  
    this.stockName = stockName;
  }
  
  /**
   * @return the serialversionuid
   */
  public static long getSerialversionuid() {
  
    return serialVersionUID;
  }
  
  
  
}
