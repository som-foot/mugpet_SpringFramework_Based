package com.spring.mugpet.service;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.mugpet.controller.member.ModifyMemberInfoForm;
import com.spring.mugpet.dao.MemberDao;
import com.spring.mugpet.domain.MemberInfo;

@Service
public class MemberServiceImpl implements MemberService{

	
	@Autowired
	private MemberDao memberDao;
	private final String CURR_IMAGE_REPO_PATH = "C:\\mugpet\\imgTest";
	File dir = new File("C:\\\\mugpet/");
	

	@Override
	public void creatAccount(MemberInfo account,MultipartFile file) throws Exception{
		if(!dir.exists()) {
			dir.mkdir();
		}
		String imgFileName = file.getOriginalFilename();
		
		System.out.println(imgFileName);
		
		UUID uuid = UUID.randomUUID();
		
	
		String saveFileName = uuid + "_" + imgFileName;
		account.setImageUrl(saveFileName);
		File saveImgfile = new File(CURR_IMAGE_REPO_PATH + saveFileName); 
		
		System.out.println(saveFileName);
		file.transferTo(saveImgfile);
		
		memberDao.insertAccount(account);
		
	}

	@Override
	public void updateAccount(ModifyMemberInfoForm modifyForm) {
		
		memberDao.updateAccount(modifyForm.getAccount());
		
	}

	@Override
	public MemberInfo checkAccount(String email, String pwd) {

		return null;
	}

	@Override
	public void creatAccountWithoutImgFile(MemberInfo account) throws Exception {
		account.setImageUrl("person.png");
		memberDao.insertAccount(account);
		
	}

	@Override
	public MemberInfo login(String email, String pwd) {
		return memberDao.getMemberInfoByEmailandPwd(email,pwd);
	}
	
	@Override
	public void updatePoints(int point, String email, String pwd) {
		memberDao.updatePoints(point, email, pwd);
	}
	
	//Community, UsedGoods에서 사용
	@Override
	public String getNickNameByU_Id(int u_id) {
		return memberDao.getNickNameByU_Id(u_id);
	}

	@Override
	public String isCheckDuplicatedEmail(String email) {
		return memberDao.isCheckDuplicatedEmail(email);
	}

	@Override
	public String isCheckDuplicatedNickname(String nickname) {
		return memberDao.isCheckDuplicatedNickname(nickname);
	}
	@Override
	public String isCheckDuplicatedPhoneNum(String phoneNum) {
		return memberDao.isCheckDuplicatedPhoneNum(phoneNum);
	}
}

