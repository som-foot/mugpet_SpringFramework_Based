package com.spring.mugpet.controller.usedgoods;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.spring.mugpet.domain.MemberInfo;
import com.spring.mugpet.domain.Pet;
import com.spring.mugpet.domain.Reply;
import com.spring.mugpet.domain.UsedGoods;
import com.spring.mugpet.service.MemberServiceImpl;
import com.spring.mugpet.service.PetService;
import com.spring.mugpet.service.ReplyServiceImpl;
import com.spring.mugpet.service.UsedGoodsFormValidator;
import com.spring.mugpet.service.UsedGoodsServiceImpl;

@Controller
@RequestMapping(method=RequestMethod.GET)
@SessionAttributes("userSession")
public class UsedGoodsController {
	@Autowired
	private UsedGoodsServiceImpl goodsService;
	
	@Autowired
	private ReplyServiceImpl replyService;
	
	@Autowired
	private MemberServiceImpl memberService;
	
	@Autowired
	private PetService petService;
	
	@Autowired
	private UsedGoodsFormValidator goodsValidator;
	
	@RequestMapping("/usedGoods/view")
	public String viewUsedGoods(@RequestParam(value = "g_id") int g_id, @ModelAttribute("userSession") MemberInfo userSession, Model model) {
		//게시글 상세보기
		
		int spe_id = 1;
		String petName = null;
		
		UsedGoods goods = null;
		goods = goodsService.getUsedGoods(g_id);
		
		//해당 게시글에 작성된 댓글 목록 가져오기
		List<Reply> replyList = replyService.getUsedGoodsReplyList(g_id);
		ArrayList<String> rp_nicknameList = new ArrayList<String>();
		
		int u_id = goodsService.getU_IdByUsedGoods(g_id);
		String nickname = memberService.getNickNameByU_Id(u_id);
		
		//댓글을 작성한 사용자 닉네임 가져오기
		for(Reply reply : replyList) {
			int rp_id = reply.getRp_id();
			int rp_u_id = replyService.getU_IdByUsedGoodsReply(g_id, rp_id);
			String rp_nickname = memberService.getNickNameByU_Id(rp_u_id);
			rp_nicknameList.add(rp_nickname);
		}

		if(userSession.getU_id() != 0) {
			Pet pet = petService.getPetByU_id(userSession.getU_id());
			
			spe_id = pet.getSpe_id();
			System.out.println(">>>>>>spe_id : " + spe_id);
			petName = pet.getName();
			System.out.println(">>>>>>>petName : " + petName);
		}
		
		System.out.println("g_id: " + goods.getG_id());
		System.out.println("userSession의 u_id: " + userSession.getU_id());
		
		model.addAttribute("usedGoods", goods);
		model.addAttribute("replyList", replyList);
		model.addAttribute("nickname", nickname);
		model.addAttribute("rp_nicknameList", rp_nicknameList);
		model.addAttribute("userSession", userSession);
		model.addAttribute("petName", petName);
		model.addAttribute("spe", petService.getSpeName(spe_id));
		model.addAttribute("spe_id", spe_id);
		
		return "tiless/usedGoods/view";
	}
	
	@RequestMapping("/usedGoods/usedGoodsList")
	public String goodsList(Model model, @ModelAttribute("userSession") MemberInfo userSession) {
		//게시글 목록보기
		
		int spe_id = 1;
		String petName = null;
		List<UsedGoods> goodsList = goodsService.getUsedGoodsList();
		
		if(userSession.getU_id() != 0) {
			Pet pet = petService.getPetByU_id(userSession.getU_id());
			
			spe_id = pet.getSpe_id();
			System.out.println(">>>>>>spe_id : " + spe_id);
			petName = pet.getName();
			System.out.println(">>>>>>>petName : " + petName);
		
		}
		
		ArrayList<String> nicknameList = new ArrayList<String>();
		
		//게시글을 작성한 사용자 닉네임 가져오기
		for(UsedGoods goods : goodsList) {
			int g_id = goods.getG_id();
			int u_id = goodsService.getU_IdByUsedGoods(g_id);
			String nickname = memberService.getNickNameByU_Id(u_id);
			nicknameList.add(nickname);
		}
		
		for(UsedGoods goods : goodsList) {
			System.out.println(goods.getTitle());
			System.out.println(goods.getG_id());
		}
		
		model.addAttribute("goodsList", goodsList);
		model.addAttribute("petName", petName);
		model.addAttribute("spe", petService.getSpeName(spe_id));
		model.addAttribute("spe_id", spe_id);
		model.addAttribute("nicknameList", nicknameList);
		
		return "tiless/usedGoods/usedGoodsList";
	}
	
	@RequestMapping("/myPage/myUsedGoodsList")
	public String getMemberUsedGoodsList(Model model, @ModelAttribute("userSession") MemberInfo userSession) {
		//본인이 쓴 게시글 목록 보기
		int u_id = userSession.getU_id();
		List<UsedGoods> myGoodsList = goodsService.getMemberUsedGoodsList(u_id);
		String nickname = memberService.getNickNameByU_Id(u_id);
		
		int spe_id = 1;
		String petName = null;
		
		if(userSession.getU_id() != 0) {
			Pet pet = petService.getPetByU_id(userSession.getU_id());
			
			spe_id = pet.getSpe_id();
			System.out.println(">>>>>>spe_id : " + spe_id);
			petName = pet.getName();
			System.out.println(">>>>>>>petName : " + petName);
		
		}
		
		model.addAttribute("myGoodsList", myGoodsList);
		model.addAttribute("nickname", nickname);
		model.addAttribute("petName", petName);
		model.addAttribute("spe", petService.getSpeName(spe_id));
		model.addAttribute("spe_id", spe_id);
		
		return "tile/myPage/myUsedGoodsList";
	}
	
	//해당 게시글에 작성된 모든 댓글을 삭제 후 게시글 삭제
	@RequestMapping("/usedGoods/delete")
	public String deleteGoods(@RequestParam(value = "g_id") int g_id) {
		//게시글 삭제
		replyService.deleteGoodsAllReply(g_id);
		goodsService.deleteUsedGoods(g_id);
		
		//게시글 목록 view로 이동
		return "redirect:/usedGoods/usedGoodsList";
	}
	
	@RequestMapping(value = "/usedGoods/updateForm", method = RequestMethod.GET)
	public String updateForm(Model model, @RequestParam("g_id") int g_id) {
		//게시글 수정 폼으로 이동
		UsedGoods goods = null;
		goods = goodsService.getUsedGoods(g_id);
		
		model.addAttribute("usedGoods", goods);
		
		return "/usedGoods/updateForm";
	}
	
	@RequestMapping(value = "/usedGoods/update", method = RequestMethod.POST)
	public String updateSubmit(@Validated NewUsedGoodsCommand goodsCommand, BindingResult result, HttpServletRequest request,
								@RequestPart(value="imgFile", required=false) MultipartFile file, Model model, @ModelAttribute("userSession") MemberInfo userSession) throws Exception{
		goodsValidator.validate(goodsCommand, result);
		
		if(result.hasErrors()) {
			UsedGoods goods = goodsService.getUsedGoods(goodsCommand.getG_id());
			model.addAttribute("usedGoods", goods);
			
			return "/usedGoods/updateForm";
		}
		
		//게시글 수정 폼
		goodsCommand.setU_id(userSession.getU_id());
		
		if(file != null) {
			goodsService.updateUsedGoods(goodsCommand, file);
		}
		else{
			goodsService.updateUsedGoodsWithoutImgFile(goodsCommand);
		}
		
		//에러 확인
		showErrors(result);
		
		//수정한 게시글 상세보기로 이동
		return "redirect:/usedGoods/view?g_id=" + goodsCommand.getG_id();
	}
	
	@RequestMapping(value = "/usedGoods/writeForm", method = RequestMethod.GET)
	public String form(@ModelAttribute("userSession") MemberInfo userSession) {
		//게시글 작성 폼으로 이동
		return "/usedGoods/writeForm";
	}
	
	@RequestMapping(value = "/usedGoods/write", method = RequestMethod.POST)
	public String submit(@Validated NewUsedGoodsCommand goodsCommand, BindingResult result, HttpServletRequest request,
							@RequestPart(value="imgFile", required=false) MultipartFile file, @ModelAttribute("userSession") MemberInfo userSession) throws Exception {
		goodsValidator.validate(goodsCommand, result);
		
		if(result.hasErrors()) {
			return "/usedGoods/writeForm";
		}
		
		//게시글 작성
		goodsCommand.setU_id(userSession.getU_id());
		
		if(file != null) {
			goodsService.insertUsedGoods(goodsCommand, file);
		}else {
			goodsService.insertUsedGoodsWithoutImgFile(goodsCommand);
		}
		
		//에러 확인
		showErrors(result);
		
		//작성한 게시글 상세보기로 이동
		return "redirect:/usedGoods/view?g_id=" + goodsCommand.getG_id();
	}
	
	@RequestMapping(value = "/usedGoods/likes")
	public String updateGoodsLikesCnt(@RequestParam("g_id") int g_id, Model model) {
		//좋아요 수
		goodsService.updateGoodsLikesCnt(g_id, 1);
		
		//기존 view로 이동
		return "redirect:/usedGoods/view?g_id=" + g_id;
	}
	
	public void showErrors(Errors errors) {
		if(errors.hasErrors()) {
			System.out.println("에러 개수: " + errors.getErrorCount());
			System.out.println("\t[filed]\t[code]");
			List<FieldError> errList = errors.getFieldErrors();
			
			for(FieldError err : errList) {
				System.out.println("\t " + err.getField() + "\t|" + err.getCode());
			}
		}else {
			System.out.println("에러 없음");
		}
	}
}
