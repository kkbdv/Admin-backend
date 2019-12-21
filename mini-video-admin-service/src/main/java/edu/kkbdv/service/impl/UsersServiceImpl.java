package edu.kkbdv.service.impl;

import java.io.File;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.kkbdv.mapper.UsersMapper;
import edu.kkbdv.pojo.Users;
import edu.kkbdv.pojo.UsersExample;
import edu.kkbdv.pojo.UsersExample.Criteria;
import edu.kkbdv.service.UsersService;
import edu.kkbdv.utils.PagedResult;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersMapper userMapper;
	
	@Override
	public PagedResult queryUsers(Users user, Integer page, Integer pageSize) {

		String username = "";
		String nickname = "";
		if (user != null) {
			username = user.getUsername();
			nickname = user.getNickname();
		}
		
		PageHelper.startPage(page, pageSize);

		UsersExample userExample = new UsersExample();
		Criteria userCriteria = userExample.createCriteria();
		if (StringUtils.isNotBlank(username)) {
			userCriteria.andUsernameLike("%" + username + "%");
		}
		if (StringUtils.isNotBlank(nickname)) {
			userCriteria.andNicknameLike("%" + nickname + "%");
		}

		List<Users> userList = userMapper.selectByExample(userExample);

		PageInfo<Users> pageList = new PageInfo<Users>(userList);

		PagedResult grid = new PagedResult();
		grid.setTotal(pageList.getPages());
		grid.setRows(userList);
		grid.setPage(page);
		grid.setRecords(pageList.getTotal());

		return grid;
	}

	@Override
	@Transactional
	public void delUser(String id) {
		delPic(id);
		userMapper.deleteByPrimaryKey(id);

	}

	private void delPic(String id){
		//查出id对应的对象
		Users users = userMapper.selectByPrimaryKey(id);
		//通过对象建立file
		if(users.getFaceImage()==null){ //判断是否有值,无则跳过删除
			return;
		}
		String localFile = "G:/kkbdv_dev";
		File file = new File(localFile+users.getFaceImage());
		//删除
		if(file.exists()){
			file.delete();
		}
	}
}
