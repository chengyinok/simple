package com.study.exception;

import com.study.dto.ErrorInfo;
import com.study.dto.ResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
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
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseVo defaultErrorHandler(HttpServletRequest request, Exception e) {
        logger.info("自定义异常处理-Exception");
        ResponseVo responseVo = new ResponseVo();
        responseVo.setSuccessful(false);
        responseVo.setMessage(e.getMessage());
        responseVo.setUrl(request.getRequestURL().toString());
        return responseVo;
    }

    /**
     * 统一异常处理
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler({ StudyException.class })
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseVo jsonErrorHandler(HttpServletRequest request, StudyException e) {
        logger.info("自定义异常处理-StudyException");
        ResponseVo responseVo = new ResponseVo();
        responseVo.setSuccessful(false);
        responseVo.setMessage(e.getMessage());
        responseVo.setUrl(request.getRequestURL().toString());
        return responseVo;
    }
}
