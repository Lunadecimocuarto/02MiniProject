package com.model2.mvc.service.purchase;

import java.util.HashMap;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.purchase.vo.PurchaseVO;


public interface PurchaseService {

	public void addPurchase(PurchaseVO purchaseVO) throws Exception;
	
	public PurchaseVO getPurchase(int tranNo) throws Exception;
	
	public PurchaseVO getPurchase2(int ProdNo) throws Exception;
	
	public HashMap<String,Object> getPurchaseList(Search search,String buyerId) throws Exception;
	
	public HashMap<String,Object> getSaleList(Search search) throws Exception;
	
	public void updatePurcahse(PurchaseVO purchaseVO) throws Exception;
	
	public void updateTranCode(PurchaseVO purchaseVO) throws Exception;
	
}