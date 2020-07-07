package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;

/**
 * Application Lifecycle Listener implementation class OnlineUserListener
 *
 */
public class OnlineUserListener implements ServletContextListener, HttpSessionAttributeListener {

    
    public OnlineUserListener() {
        // TODO Auto-generated constructor stub
    }
	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         
    }

	
	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
    	 // TODO 自动生成的方法存根
        ServletContext cx = event.getSession().getServletContext();//根据session对象获取当前容器的ServletContext对象
        Object objectlogincount = cx.getAttribute("logincount");//获取容器里面名字为logincount的对象
        String name = event.getName();
        
        if("username".equals(name)){//如果session增加的属性名字为is,表示成功登陆一个用户
            //System.out.println("登陆的用户名是:"+event.getValue());
            if(objectlogincount==null){//如果logincount为空,表示是第一个登陆
                cx.setAttribute("logincount", 1);
            }else{//表示已经有人登陆了
                int a = Integer.parseInt(objectlogincount.toString());//转换已经登陆的人数
                a++;
                cx.setAttribute("logincount", a);
            }
        }
        System.out.println("当前登陆的人数为:"+cx.getAttribute("logincount"));
        
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	
    }

    public void sessionDestroyed(HttpSessionEvent event)  { 
   	 	
   }


	
}
