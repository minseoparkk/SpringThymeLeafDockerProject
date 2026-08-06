package com.sist.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.entity.Chef;
import com.sist.web.entity.Recipe;
import com.sist.web.service.RecipeService;

import lombok.RequiredArgsConstructor;
/*
 *    요청 ==== DispatcherServlet ===== @Controller
 *                |                         | 
 *                ---------------------------
 *                  | 연동 (필요한 데이터나 내장객체 => 매개변수)
 */
@Controller
@RequiredArgsConstructor // 생성자 + @Autowired 
// 사용하는 경우에는 반드시 lombok이 있어야 된다 
public class RecipeController {
   private final RecipeService rService;
   
   /*
    *   매개변수 
    *    @RequestParam : 단일 값 받는 경우 
    *         getParameter()
    *    @ModelAttribute : 커맨드 객체 => VO단위로 받는 경우 
    *    @RequestBody : => @RestController 
    *         자바스크립트 ====== 전송 
    *                          |
    *                          VO
    *         JSON === VO로 변환 
    *    => Model : 전송 객체 => request
    *    => RedirectAttributes : sendRedirect => 값을 전송
    *    => HttpSession 
    *       HttpServletRequest / HttpServletResponse
    *            |                   |
    *            ---------------------
    *              | Cookie
    *    => Princpal : 보안 =>  security : session 대처
    *    
    *    @RequestParam(value="page",required = false)
    *         => null 값허용
    *         => 검색 / 페이지
    *    상세보기 => int no  
    *    
    *    1. Repository / Mapper => 데이터베이스만 연동 
    *          => 재료
    *    2. Service  => 조립 (Repository / Mapper => 받은 값)
    *          => 주방
    *    3. Controller => 조립된 데이터만 받아서 HTML 전송 
    *          => 서빙
    */
   
   @GetMapping("/main/main")
   public String main_main(@RequestParam(value="page",required = false) String page,Model model)
   {
	   if(page==null)
		   page="1";
	   List<Recipe> list=rService.recipeListData(Integer.parseInt(page));
	   int[] pages=rService.getPageData(Integer.parseInt(page),12);
	   model.addAttribute("pages", pages);
	   model.addAttribute("list", list);
	   // <th:block th:include="${main_html}"></th:block>
	   // templates/main/home.html
	   model.addAttribute("main_html", "main/home");
	   return "main/main";
   }
   @GetMapping("/recipe/chef_list")
   public String recipe_chef(@RequestParam(value="page",required = false) String page,Model model)
   {
	   if(page==null)
		   page="1";
	   List<Chef> list=rService.chefListData(Integer.parseInt(page));
	   int[] pages=rService.getPageData(Integer.parseInt(page),20);
	   model.addAttribute("pages", pages);
	   model.addAttribute("list", list);
	   // <th:block th:include="${main_html}"></th:block>
	   // templates/main/home.html
	   model.addAttribute("main_html", "recipe/chef");
	   return "main/main";
   }
}