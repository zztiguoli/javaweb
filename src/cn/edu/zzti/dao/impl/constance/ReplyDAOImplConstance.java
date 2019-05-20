package cn.edu.zzti.dao.impl.constance;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.zzti.dao.ReplyDAO;
import cn.edu.zzti.dao.UserDAO;
import cn.edu.zzti.entity.Reply;
import cn.edu.zzti.entity.UserDO;

public class ReplyDAOImplConstance implements ReplyDAO{
	/**
	 * Map下的第一个Integer是帖子的id
	 * 第二Map的Integer是回复的id
	 */
	private static Map<Integer,Map<Integer,Reply>> replyList = new HashMap<Integer,Map<Integer,Reply>>();
	private static UserDAO userDAO = new UserDAOImplConstance();
	private static int maxId=0;//每插入一条数据，maxid+1，删除记录不用修改该值，该值持续增长，类似于数据库的自增长id
	static{
		replyList.put(1, new HashMap<Integer,Reply>());
		UserDO u = null;
		try {
			u = userDAO.getUserByName("admin1");
			for(int i=0;i<10;i++) {
				maxId++;
				Reply r = new Reply(1,
						"admin1对帖子1的回复"+i,
						new Date(new Date().getTime()+(i*100000))
						,u);
				r.setReplyId(maxId);
				replyList.get(1).put(maxId, r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Reply> getAll(int nodeId) {
		
		return new ArrayList<Reply>(replyList.get(nodeId).values());
	}

	@Override
	public void addReply(Reply reply) {
		maxId++;
		Map<Integer,Reply>map = replyList.get(reply.getNodeId());
		if(map==null) {
			replyList.put(reply.getNodeId(), new HashMap<Integer,Reply>());
		}
		replyList.get(reply.getNodeId()).put(maxId, reply);
	}

	@Override
	public void deleteReply(Reply r) {
		replyList.get(r.getNodeId()).remove(r.getReplyId());
	}

	@Override
	public void deleteReplyByNodeId(int nodeId) {
		replyList.get(nodeId);
	}

	@Override
	public Reply getReplyById(Reply r) {
		return replyList.get(r.getNodeId()).get(r.getReplyId());
	}
}
