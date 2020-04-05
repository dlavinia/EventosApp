package com.primeirospring.vscode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * IndexController
 */

 @Controller
public class IndexController {

   @RequestMapping("/") 
   public String index(){
       return "index";
   }
}