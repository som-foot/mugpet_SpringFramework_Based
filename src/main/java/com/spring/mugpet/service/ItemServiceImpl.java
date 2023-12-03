package com.spring.mugpet.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mugpet.dao.ItemDao;
import com.spring.mugpet.domain.Item;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemDao itemDao;

	public Item getItem(int item_id) {
		return itemDao.getItem(item_id);
	}
	
	@Override
	public List<Item> getFilterItemList(int spe_id, int category_id, String strAge, List<String> stuffs, List<String> features) {
		Map<String, Object> param = getFilterMap(spe_id, category_id, strAge, stuffs, features);
		return itemDao.getFilterItemList(param);
	}

	@Override
	public List<Item> orderByFiltering(int spe_id, int category_id, String strAge, List<String> stuffs,
			List<String> features, String stand, String od) {
		Map<String, Object> param = getFilterMap(spe_id, category_id, strAge, stuffs, features);
		param.put("stand", stand);
		param.put("od", od);
		return itemDao.orderByFiltering(param);
	}
	
	@Override
	public List<Item> orderByItem(int spe_id, int category_id, String stand, String od) {
		return itemDao.orderByItem(spe_id, category_id, stand, od);
	}

	public int getAgeId(String strAge) {
		int age;
		if (strAge.equals("퍼피/키튼")) {
			age = 1;
		} else if (strAge.equals("어덜트")) {
			age = 2;
		} else if (strAge.equals("시니어")) {
			age = 3;
		} else {
			age = 4;
		}
		return age;
	}
	
	@Override
	public String getOrderByName(String stand, String od) {
		String standard;
		if (stand.equals("itemName")) {
			standard = "이름순";
		} else {
			if (od.equals("ASC")) {
				standard = "가격낮은순";
			} else {
				standard = "가격높은순";
			}
		}
		return standard;
	}
	
	 public Map<String, Object> getFilterMap(int spe_id, int category_id, String strAge, List<String> stuffs, List<String> features) {
		 Map<String, Object> param = new HashMap<String, Object>(5);
			
		 int age = getAgeId(strAge);
			
		 param.put("spe_id", spe_id);
		 param.put("category_id", category_id);
		 param.put("age", age);
		 param.put("stuffList", stuffs);
		 param.put("featureList", features);
			
		 return param;
	 }

}
