// PROJECT : RemoteQuartzScheduler
// CLASS : StockDaoImpl.java
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

package com.rqs.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rqs.dao.StockDao;
import com.rqs.model.Stock;

/**
 * 
 * @author Ravindu Eranga Abaywardena
 */
@Repository("stockDao")
@Transactional
public class StockDaoImpl implements StockDao {
  
  @Autowired
  private SessionFactory sessionFactory;
  
  /*
   * (non-Javadoc)
   * 
   * @see com.rqs.dao.StockDao#getSession()
   */
  public Session getSession() {
  
    return sessionFactory.getCurrentSession();
  }
  
  /*
   * (non-Javadoc)
   * 
   * @see com.rqs.dao.StockDao#save(com.rqs.model.Stock)
   */
  public void save(Stock stock) {
  
    getSession().persist(stock);
    
  }
  
  /*
   * (non-Javadoc)
   * 
   * @see com.rqs.dao.StockDao#update(com.rqs.model.Stock)
   */
  public void update(Stock stock) {
  
    getSession().update(stock);
    
  }
  
  /*
   * (non-Javadoc)
   * 
   * @see com.rqs.dao.StockDao#delete(com.rqs.model.Stock)
   */
  public void delete(Stock stock) {
  
    getSession().delete(stock);
    
  }
  
}
