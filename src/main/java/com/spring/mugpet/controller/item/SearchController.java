package com.spring.mugpet.controller.item;

public class SearchController {
	
	//private ItemDao itemdDao;
	
	/* itemDao의 객체로 저장 => 교수님은 service에 dao 비슷한 인터페이스 구성함. 객체에 접근해 productlist 가져옴
	 * public void setItemDao(ItemDao itemDao) { this.itemDao = itemDao; }
	 */
	
	/*@RequestMapping("") 검색할 때 요청되는 url
	public ModelAndView handleRequest(HttpServletRequest request,
			@RequestParam(value="keyword", required=false) String keyword,
			@RequestParam(value="page", required=false) String page
			) throws Exception {
		if (keyword != null) {
			if (!StringUtils.hasLength(keyword)) {
				return new ModelAndView("Error", "message", "Please enter a keyword to search for, then press the search button.");
			}
			//PagedListHolder => 스프링 프레임워크
			PagedListHolder<Product> productList = new PagedListHolder<Product>(this.petStore.searchProductList(keyword.toLowerCase()));
			productList.setPageSize(4);
			request.getSession().setAttribute("SearchProductsController_productList", productList);
			return new ModelAndView("SearchProducts", "productList", productList);
		}
		else {
			@SuppressWarnings("unchecked")
			PagedListHolder<Product> productList = (PagedListHolder<Product>)request.getSession().getAttribute("SearchProductsController_productList");
			if (productList == null) {
				return new ModelAndView("Error", "message", "Your session has timed out. Please start over again.");
			}
			if ("next".equals(page)) {
				productList.nextPage();
			}
			else if ("previous".equals(page)) {
				productList.previousPage();
			}
			return new ModelAndView("SearchProducts", "productList", productList);
		}
	}
	*/
	
	//bussiness method
	/*submit O*/
}
