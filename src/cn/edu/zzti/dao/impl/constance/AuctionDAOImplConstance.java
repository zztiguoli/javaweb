package cn.edu.zzti.dao.impl.constance;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.zzti.dao.AuctionDAO;
import cn.edu.zzti.entity.AuctionDO;

public class AuctionDAOImplConstance implements AuctionDAO{
	private static Map<String,AuctionDO> auctionList = new HashMap<String,AuctionDO>();

	static{
		for(int i=0;i<20;i++){
			AuctionDO auc = new AuctionDO("商品"+i,"description"+i,100+(int)(Math.random()*100));
			auctionList.put("商品"+i,auc);
		}
	}
	@Override
	public AuctionDO getAuction(String id) {
		return auctionList.get(id);
	}

	@Override
	public void addAuction(AuctionDO auc) {
		auctionList.put(auc.getId(),auc);
	}

	@Override
	public List<AuctionDO> getAll() {
		return new ArrayList<AuctionDO>(auctionList.values());
	}

	@Override
	public void deleteAuction(String id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAuction(AuctionDO auc) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
