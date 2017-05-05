package com.YunPan.action.interceptor;

import java.util.Map;



import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author lenovo
 *
 */
public class AuthorityInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID=1L;
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> session=ActionContext.getContext().getSession();
		Object username = session.get("username");
		System.out.println("inter");
		if(username == null)
		{
			System.out.println("login");
			return "login"; 
		}
		else
		{
			return invocation.invoke();
		}
	}

}
