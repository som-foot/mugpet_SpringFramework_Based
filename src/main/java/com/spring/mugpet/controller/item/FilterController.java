package com.spring.mugpet.controller.item;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mugpet.controller.MainController;
import com.spring.mugpet.domain.Item;
import com.spring.mugpet.domain.MemberInfo;
import com.spring.mugpet.service.ItemService;

@Controller
@RequestMapping("/item")
@SessionAttributes({"userSession", "filtering"})
public class FilterController {

	@Autowired
	private ItemService itemService;
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@Autowired
	private MainController mainController;
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
	
	@Autowired
	private ItemController itemController;
	public void setItemController(ItemController itemController) {
		this.itemController = itemController;
	}
	
	@ModelAttribute("ageVal")
	protected List<String> referenceData1() throws Exception {
		List<String> ageVal = new ArrayList<String>();
		ageVal.add("퍼피/키튼");
		ageVal.add("어덜트");
		ageVal.add("시니어");
		ageVal.add("전연령");
		
		return ageVal;
	}
	
	@ModelAttribute("stuffVal")
	protected List<String> referenceData2() throws Exception {
		List<String> stuffVal = new ArrayList<String>();
		stuffVal.add("닭");
		stuffVal.add("소");
		stuffVal.add("오리");
		stuffVal.add("연어");
		stuffVal.add("기타");
		
		return stuffVal;
	}
	
	@ModelAttribute("featureVal")
	protected List<String> referenceData3() throws Exception {
		List<String> featureVal = new ArrayList<String>();
		featureVal.add("눈건강");
		featureVal.add("치석제거");
		featureVal.add("피부/털개선");
		featureVal.add("뼈/관절강화");
		featureVal.add("소화/장기능개선");
		featureVal.add("다이어트");
		
		return featureVal;
	}
	
	//필터창 띄우기
	@RequestMapping(value="/filter", method=RequestMethod.GET)
	public String viewFilter(@RequestParam("spe_id") int spe_id, 
							@RequestParam(value="category_id", defaultValue="0") int category_id,
							ModelMap model) {
		model.put("spe_id", spe_id);
		model.put("category_id", category_id);
		return "/item/filter";
	}
		
	//필터링 한 결과 출력
	@RequestMapping(value="/filter", method=RequestMethod.POST)
	public ModelAndView filterItem(@ModelAttribute("userSession") MemberInfo userSession,
									@ModelAttribute("filtering") FilterCommand filtering,
									@RequestParam("spe_id") int spe_id, @RequestParam("category_id") int category_id) throws Exception {
		
		List<Item> itemList = new ArrayList<Item>();
		itemList = itemService.getFilterItemList(spe_id, category_id, filtering.getAge(), filtering.getStuffs(), filtering.getFeatures());
		
		//category_id=0(메인에서 필터링 -> 메인view 출력)
		ModelAndView mav = new ModelAndView();
		if (category_id == 0) {
			mav = mainController.viewMain(userSession, spe_id, 1);
		} else {
			mav = itemController.viewItemListByCategory(userSession, spe_id, category_id, 1);
		}
		mav.addObject("itemList", itemList);
		mav.addObject("spe_id", spe_id);

		return mav;
	}
}
