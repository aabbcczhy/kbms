package com.fjnu.kbms.error;

import com.fjnu.kbms.response.Response;
//import com.sun.media.jfxmedia.logging.Logger;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Object handlerException(HttpServletRequest request, Exception e) {
		Response commonReturnType = new Response();
		commonReturnType.setStatus("fail");
		Map<String,Object> responseData = new HashMap<>();
		if(e instanceof BusinessException){
			BusinessException businessException = (BusinessException)e;
			responseData.put("errorCode", businessException.getErrorCode());
			responseData.put("errorMessage", businessException.getErrorMessage());
		}else {
			responseData.put("errorCode", EmError.UNKNOWN_ERROR.getErrorCode());
			responseData.put("errorMessage", EmError.UNKNOWN_ERROR.getErrorMessage());
		}
		commonReturnType.setData(responseData);
		return commonReturnType;
	}

	@ExceptionHandler(AuthorizationException.class)
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView handlerAuthorizationException() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("403");
		return modelAndView;
	}

}
