package com.github.sergiooliveirabr.algostruct.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmptyListException.class)
    public String handleEmptyListException(EmptyListException ex,
                                           RedirectAttributes redirectAttributes,
                                           HttpServletRequest request) {

        redirectAttributes.addFlashAttribute("errorMessage", ex.getMessage());

        String referer = request.getHeader("referer");
        String requestURI = request.getRequestURI();

        System.out.println("This is referer: " + referer);
        System.out.println("This is the URI: " + requestURI);

        if (referer != null && !referer.isEmpty()) {
            return "redirect:" + referer;
        }
        return "error";
    }

    @ExceptionHandler(InvalidIndexException.class)
    public String handleInvalidIndexException(InvalidIndexException ex,
                                              RedirectAttributes redirectAttributes,
                                              HttpServletRequest request) {

        redirectAttributes.addFlashAttribute("errorMessage", ex.getMessage());

        String referer = request.getHeader("referer");

        if (referer != null && !referer.isEmpty()) {
            return "redirect:" + referer;
        }
        return "error";
    }
}
