package com.chuyuan.action;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chuyuan.dao.UserDao;
import com.chuyuan.entity.News;
import com.chuyuan.entity.Operation;
import com.chuyuan.entity.User;
import com.chuyuan.service.NewsService;
import com.chuyuan.service.OperaService;
import com.chuyuan.service.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;
/**
 * 新闻操作
 * @author viveza 17.5.8
 *
 */
public class NewAction extends ActionSupport implements ServletRequestAware{
	private static final long serialVersionUID = 1L;
	private News news;
	private String newID;
	private Operation opre;
	private String result;
	@Autowired
	private UserService userService;
	//json返回data类型声明
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest arg0) {
        this.request = arg0;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
	
	private ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("app*.xml");
	NewsService newsService = ctx.getBean(NewsService.class);
	public News getNews(){
		return news;
	}
	
	public void setNews(News news){
		this.news = news;
	}
	/*
	 * 根据ID查新闻返回json
	 */
	
	/**
	 * 增加新闻
	 * @param news
	 * @return SUCCESS
	 */
	@SuppressWarnings("serial")
	public String addNew(News news){
		newsService.insertNews(news);
		return SUCCESS;
	}
	
	/*
	 * 根据id删除新闻 wz 17.5.7
	 */
	@SuppressWarnings("serial")
	public String delete(){
		News n = newsService.findNewsById(Integer.parseInt(getNewID()));
		try {
			n.setTag(1);
			newsService.updateNews(n);;
			Map<String, String> map =new HashMap<String, String>();
			map.put("result", "success");
			JSONObject json = JSONObject.fromObject(map);//将map对象转换成json类型数据
            result = json.toString();
		} catch (Exception e) {
			System.out.println("没有找到news对象");
			return ERROR;
		}
		return SUCCESS;
	}
	
	/*
	 * 查找新闻，返回所有新闻列表 wz 17.5.7 
	 * 还未做处理
	 */
	
	public String findAllNews(){
		List<News> news = newsService.findNotDelNews();
		Map<String, List<News>> map = new HashMap<String, List<News>>();
		map.put("news", news);
		JSONObject json = JSONObject.fromObject(map);
		result = json.toString();
		System.out.println(result);
		return SUCCESS;
	}
	/*
	 * 修改新闻 wz 17.5.7
	 * 先调用findNewById(id)查找，再updateNew()提交修改
	 */
	public String updateNew(){
		try {
			News n = newsService.findNewsById(Integer.parseInt(newID));
			n.setNewTitle(title);
			n.setNewContent(content);
			n.setNewImage(image);
			n.setNewProvenance(prove);
			newsService.updateNews(n);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("result", "true");
			JSONObject json = JSONObject.fromObject(map);
			result = json.toString();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	/*
	 * 查找新闻 wz 17.5.7  
	 * user表和operation表没有键关联
	 */
//	public void addHits(Operation oper){
//		int hits = oper.getOperHits()+1;
//		oper.setOperHits(hits);
//		operaService.update(oper);
//	}
	
	@Autowired
	private OperaService operaService;;
	public String findNewById(){
//		System.out.println(getNewID());//查看是否获取到id
		News n = newsService.findNewsById(Integer.parseInt(getNewID()));
		Operation oper = n.getOperation();
		User u = oper.getUser();
		if(n != null){

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("newID", n.getNewID());
			map.put("newTitle", n.getNewTitle());
			map.put("newContent", n.getNewContent());
			map.put("newImage", n.getNewImage());
			map.put("newProvenance", n.getNewProvenance());
			map.put("operUser", u.getUserName());
			map.put("newHits", oper.getOperHits());
			map.put("operTime", oper.getOperTime());
			map.put("userId", u.getUserID());
//			map.put("userHeadPho", u.getHeadPho());  //用户头像
			map.put("nickname", u.getUserNickname());
			//点击量加一
			//Operation o = operaService.findOperaById(oper.getOperID());
//			int hits = oper.getOperHits()+1;
//			oper.setOperHits(hits);
//			System.out.println(oper);
//			operaService.update(oper);
			JSONObject json = JSONObject.fromObject(map);
			result = json.toString();
//			System.out.println(result);
//			addHits(oper);
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	/**
	 * 查找新闻返回4条响应给首页
	 */
	public String findNewToIndex(){
		List<News> news = newsService.findNewsToIndex();
		Map<String, List<News>> map = new HashMap<String, List<News>>();
		map.put("news", news);
		JSONObject json = JSONObject.fromObject(map);
		result = json.toString();
		System.out.println(result);
		return SUCCESS;
	}
	
	/*
	 * ajax添加新闻
	 */
	private String title;
	private String content;
	private String image;
	private String prove;
	private String userId;
	
	public String add(){
		try {
			Date operTime = new Date();
			News n = new News();
			Operation o = new Operation();
			User u = userService.findUserById(Integer.parseInt(userId));//前台提交用户名找到用户
			o.setOperTime(operTime);
			o.setUser(u);
			o.setOperHits(0);//点击量默认为0
			n.setNewContent(content);
			n.setNewImage(image);//新闻封面图片路径
			n.setNewProvenance(prove);//新闻出处
			n.setNewTitle(title);
			n.setOperation(o);
			newsService.insertNews(n);
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("result", "true");
            JSONObject json = JSONObject.fromObject(map);
            result = json.toString();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	public String getNewID() {
		return newID;
	}

	public void setNewID(String newID) {
		this.newID = newID;
	}
	public Operation getOpre() {
		return opre;
	}
	public void setOpre(Operation opre) {
		this.opre = opre;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getProve() {
		return prove;
	}
	public void setProve(String prove) {
		this.prove = prove;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
