// PROJECT : RemoteQuartzScheduler
// CLASS : StockBo.java
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

package com.rqs.service;

import com.rqs.model.Stock;

/**
 * 
 * @author Ravindu Eranga Abaywardena
 */
public interface StockService {
  
  void save(Stock stock);
  
  void update(Stock stock);
  
  void delete(Stock stock);
  
}
