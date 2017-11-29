package com.study.exception;

import com.study.dto.ErrorInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class BizExcepiton {
    private static final Logger logger =  LoggerFactory.getLogger(BizExcepiton.class);

    /**
     * 统一异常处理
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler({ Exception.class })
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) {
        logger.info("自定义异常处理-Exception");
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", request.getRequestURL());
        mav.setViewName("error/error");
        return mav;
    }

    /**
     * 统一异常处理
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler({ StudyException.class })
    @ResponseStatus(HttpStatus.OK)
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest request, StudyException e) {
        logger.info("自定义异常处理-StudyException");
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage(e.getMessage());
        r.setCode(ErrorInfo.ERROR);
        r.setData("Some Data");
        r.setUrl(request.getRequestURL().toString());
        return r;
    }
}
