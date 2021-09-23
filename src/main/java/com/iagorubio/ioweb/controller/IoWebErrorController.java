package com.iagorubio.ioweb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IoWebErrorController implements ErrorController {
    private static final Logger logger = LoggerFactory.getLogger(IoWebErrorController.class);

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        // get error status
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        int statusCode = Integer.parseInt(status.toString());
        logger.error(String.format("Path %s produced error %d", request.getPathInfo(), statusCode));

        if (statusCode == HttpStatus.NOT_FOUND.value()) {
            return "404";
        } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            return "500";
        } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
            return "403";
        }

        // display generic error
        return "error";
    }
}
