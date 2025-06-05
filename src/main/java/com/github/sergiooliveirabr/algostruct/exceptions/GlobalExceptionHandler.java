package com.github.sergiooliveirabr.algostruct.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmptyListException.class)
    public String handleEmptyListException(EmptyListException ex,
                                           Model model,
                                           HttpServletRequest request) {

        model.addAttribute("errorMessage", ex.getMessage());

        String referer = request.getHeader("referer");
        String requestURI = request.getRequestURI();

        System.out.println("This is referer: " + referer);
        System.out.println("This is the URI: " + requestURI);

        if (referer != null && !referer.isEmpty()) {
            return "redirect:" + referer;
        }
        return "error";
    }
}
