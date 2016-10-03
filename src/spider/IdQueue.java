package spider;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author InJavaWeTrust
 *
 */
public class IdQueue {

	/**
	 * 已访问的id队列
	 */
	private static Set<String> visitedid = new HashSet<String>();
	/**
	 * 待访问的 id队列
	 */
	private static Queue<String> unVisitedid = new PriorityQueue<String>();
	/**
	 * 获得待访问id队列
	 * @return
	 */
	public static Queue<String> getUnVisitedid() {
		return unVisitedid;
	}
	/**
	 * 添加到访问过的id队列中
	 * @param id
	 */
	public static void addVisitedid(String id) {
//		id="http://pg.njupt.edu.cn/"+id;
		visitedid.add(id);
	}
	/**
	 * 移除访问过的id
	 * @param id
	 */
	public static void removeVisitedid(String id) {
//		id="http://pg.njupt.edu.cn/"+id;
		visitedid.remove(id);
	}
	/**
	 * 未访问的id出队列
	 * @return
	 */
	public static Object unVisitedidDeQueue() {
		return unVisitedid.poll();
	}
	/**
	 * 添加到待访问的 id队列，保证每个id只被访问一次
	 * @param id
	 */
	public static void addUnvisitedid(String id) {
//		id="http://pg.njupt.edu.cn/"+id;
		if (id != null && !id.trim().equals("") //&& !visitedid.contains(id)
				//&& !unVisitedid.contains(id)
				)
			unVisitedid.add(id);
	}
	/**
	 * 获得已经访问的id数目
	 * @return
	 */
	public static int getVisitedidNum() {
		return visitedid.size();
	}
	/**
	 * 判断未访问的id队列中是否为空
	 * @return true-空;false-非空
	 */
	public static boolean unVisitedidsEmpty() {
		return unVisitedid.isEmpty();
	}

}

