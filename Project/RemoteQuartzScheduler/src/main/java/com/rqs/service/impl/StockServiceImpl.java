//PROJECT    : RemoteQuartzScheduler 
//CLASS      : StockServiceImpl.java
//
//************************************************************************************************
//
// This copy of the Source Code is a property of Ravindu Eranga Abayawardena. No 
// part of this file may be reproduced or distributed in any form or by any
// means without the written approval of Ravindu Eranga Abayawardena. 
// 
//*************************************************************************************************
// 
// REVISIONS: 
//    Author          : Ravindu Eranga Abayawardena   
//    Date            : Mar 1, 2015      
//    Version          : version 1.0
//
//*************************************************************************************************

package com.rqs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rqs.dao.StockDao;
import com.rqs.model.Stock;
import com.rqs.service.StockService;

/**
 * 
 * @author Ravindu Eranga Abaywardena
 */
@Service("stockService")
@Transactional
public class StockServiceImpl implements StockService {
  
  @Autowired
  private StockDao dao;

  /* (non-Javadoc)
   * @see com.rqs.service.StockService#save(com.rqs.model.Stock)
   */
  public void save(Stock stock) {
  
    dao.save(stock);
    
  }

  /* (non-Javadoc)
   * @see com.rqs.service.StockService#update(com.rqs.model.Stock)
   */
  public void update(Stock stock) {
  
    dao.update(stock);
    
  }

  /* (non-Javadoc)
   * @see com.rqs.service.StockService#delete(com.rqs.model.Stock)
   */
  public void delete(Stock stock) {
  
    dao.delete(stock);
    
  }
 
  
}
